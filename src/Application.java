import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application{
    private ArrayList<Company> companies;
    private ArrayList<User> users;
    private static Application application_instance = null;

    public Application() {
        companies = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static Application getInstance() {
        if (application_instance == null)
            application_instance = new Application();
        return application_instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Company> getCompanies() {
        return (ArrayList<Company>) companies;
    }

    public Company getCompany(String name){
        Iterator<Company> it = companies.iterator();
        while(it.hasNext()) {
            Company company = it.next();
            if(company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }

    public void add(Company company){
        companies.add(company);
    }

    public void add(User user){
        users.add(user);
    }

    public boolean remove(Company company){
        if (companies.contains(company)) {
            companies.remove(company);
            return true;
        }
        return false;
    }

    public boolean remove(User user){
        if (users.contains(user)) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public ArrayList<Job> getJobs(List<String> companies){
        ArrayList<Job> prefferedJobs = new ArrayList<>();
        Iterator<Company> it = this.companies.iterator();
        while(it.hasNext()) {
            Company currentCompany = it.next();
            if (companies.contains(currentCompany.getName())){
                prefferedJobs.addAll(currentCompany.getJobs());
            }
        }
        return prefferedJobs;
    }
}
