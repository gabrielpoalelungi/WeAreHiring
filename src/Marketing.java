import java.util.Iterator;

public class Marketing extends Department{
    public double getTotalSalaryBudget() {
        double total = 0;
        Iterator<Employee> it = this.getEmployees().iterator();
        while(it.hasNext()) {
            Employee employee = it.next();
            if (employee.getSalary() > 5000) {
                total += employee.getSalary() * 1.1;
            }
            else if(employee.getSalary() < 3000) {
                total += employee.getSalary();
            }
            else
                total += employee.getSalary() * 1.16;
        }
        return total;
    }
}
