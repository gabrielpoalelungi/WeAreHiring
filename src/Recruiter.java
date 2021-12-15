public class Recruiter extends Employee{
    private Double rating = 5.0;

    public Recruiter(Resume resume, Company company, int salary) {
        super(resume, company, salary);
    }

    public void updateRating() {
        this.rating += 0.1;
    }

    public Double getRating() {
        return rating;
    }

    public int evaluate(Job job, User user){
        int score = (int)((double) this.rating * user.getTotalScore());
        Request newRequest = new Request(job, user, this, (double)score);
        job.getCompany().getManager().addToRequestList(newRequest);
        updateRating();
        return score;
    }

    public String toString() {
        String result = "";
        result += "Recruiter " + this.getResume().getInformation().getFirstName() + " " +
                this.getResume().getInformation().getLastName() + "\n" + "Salary: " + this.getSalary() + "\n";
        return result + "\n";
    }
}
