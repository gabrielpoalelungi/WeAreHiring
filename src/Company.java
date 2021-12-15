import javax.management.Notification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Company implements Subject{
    private String name;
    private Manager manager;
    private LinkedList<Department> departments;
    private LinkedList<Recruiter> recruiters;
    LinkedList<User> observers = new LinkedList<>();

    public Company(String name) {
        this.name = name;
        this.manager = null;
        departments = new LinkedList<Department>();
        recruiters = new LinkedList<Recruiter>();
    }
    public Company(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        departments = new LinkedList<Department>();
        recruiters = new LinkedList<Recruiter>();
    }

    public Company(String name, Manager manager, LinkedList<Department> departments,
                   LinkedList<Recruiter> recruiters) {
        this.name = name;
        this.manager = manager;
        this.departments = departments;
        this.recruiters = recruiters;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public LinkedList<Recruiter> getRecruiters() {
        return recruiters;
    }

    public LinkedList<Department> getDepartments() {
        return departments;
    }
    public void add(Department department) {
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        department.add(employee);
    }

    public void remove(Employee employee) {
        Iterator<Department> it = departments.iterator();
        while(it.hasNext()) {
            Department currentDepartment = it.next();
            if(currentDepartment.getEmployees().contains(employee)) {
                currentDepartment.remove(employee);
            }
        }
    }

    public void remove(Department department) {
        departments.remove(department);
    }

    public void remove(Recruiter recruiter) {
        recruiters.remove(recruiter);
    }

    public void move(Department source, Department destination) {
        destination.getEmployees().addAll(source.getEmployees());
        remove(source);
    }

    public void move(Employee employee, Department newDepartment) {
        Iterator<Department> it = departments.iterator();
        while(it.hasNext()) {
            Department currentDep = it.next();
            if(currentDep.getEmployees().contains(employee)) {
                currentDep.getEmployees().remove(employee);
                newDepartment.add(employee);
            }
        }
    }

    public boolean contains(Department department) {
        return departments.contains(department);
    }

    public boolean contains(Employee employee) {
        Iterator<Department> it = departments.iterator();
        while(it.hasNext()) {
            if(it.next().getEmployees().contains(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        return recruiters.contains(recruiter);
    }

    public Recruiter getRecruiter(User user) {
        int max = user.getDegreeInFriendship(recruiters.get(0));
        Recruiter bestRecruiter = recruiters.get(0);
        Iterator<Recruiter> it = recruiters.iterator();
        while(it.hasNext()) {
            Recruiter currentRecruiter = it.next();
            int grade = user.getDegreeInFriendship(currentRecruiter);
            if(grade > max) {
                max = grade;
                bestRecruiter = currentRecruiter;
            }
            else if (grade == max && currentRecruiter.getRating() > bestRecruiter.getRating()) {
                bestRecruiter = currentRecruiter;
            }
        }
        return bestRecruiter;
    }

    public ArrayList<Job> getJobs() {
        ArrayList<Job> jobList = new ArrayList<>();
        Iterator<Department> it = departments.iterator();
        while(it.hasNext()) {
            ArrayList<Job> currentJobList = it.next().getJobs();
            Iterator<Job> itJob = currentJobList.iterator();
            while(itJob.hasNext()) {
                Job currentJob = itJob.next();
                if (currentJob.getAvailability() == true) {
                    jobList.add(currentJob);
                }
            }
        }
        return jobList;
    }

    public String toString() {
        return this.getName();
    }

    public void addObserver(User user) {
        observers.add(user);
    }

    public void removeObserver(User c) {
        observers.remove(c);
    }

    public void notifyAllObservers(Notification notification) {
        for(User observer : observers) {
            observer.update(notification);
        }
    }
}
