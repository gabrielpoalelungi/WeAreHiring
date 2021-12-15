import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Resume {
    private Information information;
    private TreeSet<Education> eduBackgnd = new TreeSet<>();
    private TreeSet<Experience> expBackgnd = new TreeSet<>();

    public Resume() {
        information = null;
    }

    public Resume(ResumeBuilder builder) {
        this.information = builder.information;
        this.eduBackgnd = builder.eduBackgnd;
        this.expBackgnd = builder.expBackgnd;
    }

    public Information getInformation() {
        return information;
    }

    public TreeSet<Education> getEduBackgnd() {
        return eduBackgnd;
    }

    public TreeSet<Experience> getExpBackgnd() {
        return expBackgnd;
    }

    public void setInformation(Information newInformation) {
        this.information = newInformation;
    }

    public void addToEduBackground(Education newEducation) {
        eduBackgnd.add(newEducation);
    }

    public void addToExpBackground(Experience newExperience) {
        expBackgnd.add(newExperience);
    }

    public boolean removeFromEduBackground(Education eduToBeRemoved) {
        return eduBackgnd.remove(eduToBeRemoved);
    }
    public boolean removeFromExpBackground(Experience expToBeRemoved) {
        return expBackgnd.remove(expToBeRemoved);
    }

    public String toString() {
        return information.toString() + "\n" + eduBackgnd.toString() + "\n" + expBackgnd.toString();
    }

    public int getYearsExperience() {
        Iterator<Experience> itExp = this.getExpBackgnd().iterator();
        int totalYears = 0;
        while(itExp.hasNext()) {
            Experience currentExp = itExp.next();
            LocalDate end;
            if(currentExp.getEnd() == null) {
                end = LocalDate.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
                        LocalDateTime.now().getDayOfMonth());
            }
            else end = currentExp.getEnd();
            Period intervalPeriod = Period.between(currentExp.getBegin(), end);
            if (intervalPeriod.getMonths() >= 3) {
                totalYears +=1;
            }
            totalYears += intervalPeriod.getYears();
        }
        return totalYears;
    }

    public static class ResumeBuilder {
        private Information information;
        private TreeSet<Education> eduBackgnd = new TreeSet<>();
        private TreeSet<Experience> expBackgnd = new TreeSet<>();

        public ResumeBuilder information(Information information) {
            this.information = information;
            return this;
        }

        public ResumeBuilder addEduBackgnd(Education newEducation) {
            this.eduBackgnd.add(newEducation);
            return this;
        }

        public ResumeBuilder addExpBackgnd(Experience newExp) {
            this.expBackgnd.add(newExp);
            return this;
        }

        public Resume build() throws ResumeIncompleteException{
            if(this.eduBackgnd.isEmpty() == false && this.information != null)
                return new Resume(this);
            else
                throw new ResumeIncompleteException("Resume incomplete! Add information and at least one Education object");
        }
    }
}