import java.time.LocalDate;

public class Experience implements Comparable{
    private LocalDate begin;
    private LocalDate end;
    private String position;
    private Company company;
    private String department;

    public Experience() {
        begin = null;
        end = null;
        position = "";
        company = null;
        department = null;
    }

    public Experience(Company company, String position, String department, int yearBegin, int monthBegin,
                      int dayBegin) {
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = null;
        this.position = position;
        this.company = company;
        this.department = department;
    }

    public Experience(Company company, String position, int yearBegin, int monthBegin,
                      int dayBegin) {
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = null;
        this.position = position;
        this.company = company;
        this.department = "";
    }

    public Experience(Company company, String position, String department, int yearBegin, int monthBegin,
                      int dayBegin, int yearEnd, int monthEnd, int dayEnd) throws InvalidDatesException {
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = LocalDate.of(yearEnd, monthEnd, dayEnd);
        this.position = position;
        this.company = company;
        this.department = department;
        if(begin.compareTo(end) > 0) {
            throw new InvalidDatesException("BeginDate is after EndDate!");
        }
    }

    public Experience(Company company, String position, int yearBegin, int monthBegin,
                      int dayBegin, int yearEnd, int monthEnd, int dayEnd) throws InvalidDatesException {
        begin = LocalDate.of(yearBegin, monthBegin, dayBegin);
        end = LocalDate.of(yearEnd, monthEnd, dayEnd);
        this.position = position;
        this.company = company;
        this.department = "";
        if(begin.compareTo(end) > 0) {
            throw new InvalidDatesException("BeginDate is after EndDate!");
        }
    }
    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getPosition() {
        return position;
    }

    public Company getCompany() {
        return company;
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

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    public void setCompany(Company newCompany) {
        this.company = newCompany;
    }

    public String toString() {
        String result;
        result = "Company: " + company.getName() + "; Position: " + position + "; Department: " + department +
                " ; Begin Date: ";
        if(begin != null) {
            result = result + begin.toString();
        }
        if(end != null) {
            result = result + " ; End Date: " + end.toString();
        }
        else {
            result = result + " ; End Date: still employed!";
        }
        return result + "\n";
    }

    public int compareTo(Object o) {
        Experience otherExp = (Experience) o;
        int comp = 0;
        if (end != null && otherExp.end != null) {
            comp = otherExp.end.compareTo(end);
        }
        else {
            String companyName = company.getName();
            String otherCompanyName = otherExp.company.getName();
            comp = companyName.compareTo(otherCompanyName);

            if (comp == 0) {
                comp = begin.compareTo(otherExp.begin);
            }
        }

        return comp;
    }
}
