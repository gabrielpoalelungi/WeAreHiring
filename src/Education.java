import java.time.LocalDate;

public class Education implements Comparable{
    private LocalDate begin;
    private LocalDate end;
    private String institution;
    private String level;
    private Double GPA;

    public Education() {
        begin = null;
        end = null;
        institution = "";
        level = "";
        GPA = 0.0;
    }

    public Education(String institution, int yearBegin, int monthBegin, int dayBegin,
                     int yearEnd, int monthEnd, int dayEnd, String level, Double GPA) throws InvalidDatesException{
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = LocalDate.of(yearEnd, monthEnd, dayEnd);
        this.institution = institution;
        this.level = level;
        this.GPA = GPA;
        if(begin.compareTo(end) > 0) {
            throw new InvalidDatesException("BeginDate is after EndDate!");
        }
    }

    public Education(String institution, int yearBegin, int monthBegin, int dayBegin,
                     String level, Double GPA) {
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = null;
        this.institution = institution;
        this.level = level;
        this.GPA = GPA;
    }
    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getInstitution() {
        return institution;
    }

    public String getLevel() {
        return level;
    }

    public Double getGPA() {
        return GPA;
    }
    public void setBegin(int year, int month, int day) {
        this.begin = LocalDate.of(year, month, day);
    }

    public void setEnd(int year, int month, int day) throws InvalidDatesException{
        LocalDate ld = LocalDate.of(year, month, day);
        if (begin.compareTo(ld) > 0) {
            throw new InvalidDatesException("BeginDate is after EndDate!");
        }
        else{
            this.end = ld;
        }
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public String toString() {
        String result;
        result = "Institution: " + institution + " ; Begin Date: ";
        if(begin != null) {
            result = result + begin.toString();
        }
        if(end != null) {
           result = result + " ; End Date: " + end.toString();
        }
        else result = result + " ;End Date: still stuDYING!";
        result = result + " Level: " + level + "; GPA: " + GPA + "\n";
        return result;
    }

    public int compareTo(Object o) {
        Education otherEdu = (Education) o;
        int comp = 0;
        if (end != null && otherEdu.end != null) {
            int cmp = end.compareTo(otherEdu.end);
            if (cmp > 0) {
                comp = otherEdu.end.compareTo(end);
            }
            else
                if (cmp == 0) {
                    comp = otherEdu.GPA.compareTo(GPA);
                }
        }
        else {
            comp = begin.compareTo(otherEdu.begin);
        }
        return comp;
    }
}
