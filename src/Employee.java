public class Employee extends Consumer{
    private Company company;
    private int salary;

    public Employee() {
        company = null;
        salary = 0;
    }

    public Employee(Resume resume, Company company, int salary) {
        super(resume);
        this.company = company;
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public void setCompany(Company newCompany) {
        this.company = newCompany;
    }

    public String toString() {
        String result = "";
        result += "Employee: " + this.getResume().getInformation().getFirstName() + " " +
                this.getResume().getInformation().getLastName() + "\n" + "Salary: " + this.getSalary() + "\n";
        return result + "\n";
    }
}
