import javax.management.Notification;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class User extends Consumer implements Observer{
    private LinkedList<String> companies_interested_in;

    public User() {
        companies_interested_in = new LinkedList<>();
    }
    public User(LinkedList<String> companies_interested_in) {

        this.companies_interested_in = companies_interested_in;
    }

    public User(Resume resume, LinkedList<String> companies_interested_in) {
        super(resume);
        this.companies_interested_in = companies_interested_in;
    }

    public User(Resume resume) {
        super(resume);
        this.companies_interested_in = new LinkedList<>();
    }

    public List<String> getCompaniesInterestedIn() {
        return companies_interested_in;
    }

    public void addCompany(String company) {
        companies_interested_in.add(company);
    }

    public void removeCompany(String company) {
        companies_interested_in.remove(company);
    }

    public Employee convert() {
        Resume resume = this.getResume();
        LinkedList<Consumer> friends = this.getFriends();
        Employee newEmployee = new Employee();
        newEmployee.setFriends(friends);
        newEmployee.setResume(resume);

        return newEmployee;
    }

    public Double getTotalScore() {
        Resume userResume = this.getResume();
        Iterator<Education> it2 = userResume.getEduBackgnd().iterator();
        int totalYears = userResume.getYearsExperience();
        Double allGPA = 0.0;

        while(it2.hasNext()) {
            allGPA += it2.next().getGPA();
        }
        allGPA = allGPA / userResume.getEduBackgnd().size();
        return totalYears * 1.5 + allGPA;
    }

    public String toString() {
        String result = "";
        result += "User: " + this.getResume().getInformation().getFirstName() + " " + this.getResume().getInformation().getLastName() + "\n";
        return result + "Companies interested in: " + companies_interested_in + "\n" +"\n";
    }

    @Override
    public void update(Notification notification) {
        System.out.println(this.getResume().getInformation().getFirstName() + " " + this.getResume().getInformation().getLastName() + ": " + notification.getMessage());
    }
}
