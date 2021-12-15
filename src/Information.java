import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.TreeMap;

public class Information {
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birth_date;
    private TreeMap<String, String> languages = new TreeMap<>();

    public Information() {
        lastName = "";
        firstName = "";
        email = "";
        phone = "";
        birth_date = null;
        gender = "";
    }

    public Information(String firstName, String lastName,String gender, String email, String phone,
                       LocalDate birth_date) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.birth_date = birth_date;
        this.gender = gender;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public TreeMap<String, String> getLanguages() {
        return languages;
    }

    public String toString() {
        String result;
        result = "First name: " + firstName + "; Last Name: " + lastName + " ; Date of birth: " +
                birth_date.toString() + "; Languages: " + languages.toString();
        return result;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(int year, int month, int day) {
        this.birth_date = LocalDate.of(year, month, day);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void addLanguage(String language, String level) {
        languages.put(language, level);
    }

    public boolean removeLanguage(String language, String level) {
        return languages.remove(language, level);
    }
}