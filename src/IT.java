import java.util.Iterator;

public class IT extends Department{
    public double getTotalSalaryBudget() {
        double total = 0;
        Iterator<Employee> it = this.getEmployees().iterator();
        while(it.hasNext()) {
            total += it.next().getSalary();
        }
        return total;
    }
}
