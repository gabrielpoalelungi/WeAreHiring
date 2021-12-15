import javax.management.Notification;
import java.util.ArrayList;

public abstract class Department {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Job> jobs = new ArrayList<>();

    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void add(Job job) {
        jobs.add(job);
        Notification n = new Notification("Job nou", job.getCompany(), 1, "Compania " +
                job.getCompany() + " a adaugat un job nou: " + job.getName() + "!");
        job.getCompany().notifyAllObservers(n);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
