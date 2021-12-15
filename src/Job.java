import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

public class Job {
    private String name;
    private Company company;
    private boolean available;
    private Constraint<Integer> graduationYearRule;
    private Constraint<Integer> yearsExperienceRule;
    private Constraint<Double> gpaRule;
    private int neededCandidates;
    private int salary;

    public Job(String name, Company company, boolean available, Constraint<Integer> graduationYearRule,
               Constraint<Integer> yearsExperienceRule, Constraint<Double> gpaRule,
               int neededCandidates, int salary) {
        this.name = name;
        this.company = company;
        this.available = available;
        this.graduationYearRule = graduationYearRule;
        this.yearsExperienceRule = yearsExperienceRule;
        this.gpaRule = gpaRule;
        this.neededCandidates = neededCandidates;
        this.salary = salary;
    }

    public String toString() {
        return this.getName() + " at " + this.getCompany().getName();
    }
    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public boolean getAvailability() {
        return available;
    }

    public void setAvailability(boolean newAvailable) {
        this.available = newAvailable;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNeededCandidates() {
        return neededCandidates;
    }

    public void decreaseNeededCandidates() {
        this.neededCandidates -= 1;
    }

    public void setGraduationYearRule(Constraint<Integer> newGradYear) {
        this.graduationYearRule = newGradYear;
    }

    public void setYearsExperienceRule(Constraint<Integer> yearsExperienceRule) {
        this.yearsExperienceRule = yearsExperienceRule;
    }

    public void setGpaRule(Constraint<Double> gpaRule) {
        this.gpaRule = gpaRule;
    }

    public void apply(User user) {
        LinkedList<Recruiter> recruiters = company.getRecruiters();
        Recruiter bestRecruiter = company.getRecruiter(user);
        System.out.println("Recruiter " + bestRecruiter.getResume().getInformation().getFirstName() + " " +
                bestRecruiter.getResume().getInformation().getLastName() + " has evaluated " +
                user.getResume().getInformation().getFirstName() + " " +
                user.getResume().getInformation().getLastName() + "!");
        bestRecruiter.evaluate(this, user);
    }

    public boolean meetsRequirments(User user) {
        if(graduationYearRule.isValueBetween(user.getGraduationYear()) == false)
            return false;
        if(yearsExperienceRule.isValueBetween(user.getResume().getYearsExperience()) == false)
            return false;
        if(gpaRule.isValueBetween(user.meanGPA()) == false)
            return false;
        return true;
    }
}
