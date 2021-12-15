import javax.management.Notification;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Manager extends Employee{
     private LinkedList<Request> request_list;

     public Manager() {
          super();
          request_list = new LinkedList<>();
     }
     public Manager(Resume resume, Company company, int salary) {
          super(resume, company, salary);
          request_list = new LinkedList<>();
     }

     public LinkedList<Request> getRequest_list() {
          return request_list;
     }

     public void setRequest_list(LinkedList<Request> request_list) {
          this.request_list = request_list;
     }

     public void addToRequestList(Request newRequest) {
          request_list.add(newRequest);
     }

     public boolean removeRequestList(Request request) {
          return request_list.remove(request);
     }
     public void process(Job job){
          Collections.sort(request_list);
          Iterator<Request> it = request_list.iterator();
          while(job.getNeededCandidates() != 0) {
               if(it.hasNext()) {
                    Request currentRequest = it.next();
                    if (currentRequest.getKey().equals(job)) {
                         User employeeToBe = (User) currentRequest.getValue1();
                         if (job.meetsRequirments(employeeToBe) == true) {
                              if (Application.getInstance().getUsers().contains(employeeToBe)) {
                                   Employee newEmployee = employeeToBe.convert();
                                   newEmployee.setSalary(job.getSalary());
                                   job.getCompany().removeObserver(employeeToBe);
                                   System.out.println("User " + newEmployee.getResume().getInformation().getFirstName() +
                                           " " + newEmployee.getResume().getInformation().getLastName() +
                                           " has been employed!");
                                   Application.getInstance().remove(employeeToBe);
                                   Iterator<Department> itDepartment = job.getCompany().getDepartments().iterator();
                                   while (itDepartment.hasNext()) {
                                        Department currentDepartment = itDepartment.next();
                                        if (currentDepartment.getJobs().contains(job)) {
                                             currentDepartment.add(newEmployee);
                                             request_list.remove(currentRequest);
                                             job.decreaseNeededCandidates();
                                             break;
                                        }
                                   }
                              }
                         }
                         else {
                              Notification n = new Notification("You have been rejected!", job.getCompany(),
                                      1, "Company " + job.getCompany() + " didn't employ you on the" +
                                      "job of " + job.getName() + "!");
                              employeeToBe.update(n);
                         }
                    }
               } else {
                    System.out.println("No one has been hired!");
                    return;
               }
          }
          if (job.getNeededCandidates() == 0) {
               job.setAvailability(false);
               Notification n = new Notification("Closed Job", job.getCompany(), 1,
                       "Company " + job.getCompany() + " has closed the " + job.getName() + "!");
               job.getCompany().notifyAllObservers(n);
          }
          Iterator<Request> it2 = request_list.iterator();
          while(it2.hasNext()) {
               Request currentRequest = it2.next();
               if (currentRequest.getKey().equals(job)) {
                    request_list.remove(currentRequest);
               }
          }
     }
}
