import java.time.Period;
import java.util.Iterator;

public class Finance extends Department{
    public double getTotalSalaryBudget() {
        double total = 0;
        Iterator<Employee> it = this.getEmployees().iterator();
        while(it.hasNext()) {
            Employee employee = it.next();
            int totalYears = employee.getResume().getYearsExperience();
            if (totalYears < 1) {
                total += employee.getSalary() * 1.1;
            }
            else
                total += employee.getSalary() * 1.16;
        }
        return total;
    }
}
