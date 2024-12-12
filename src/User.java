import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String cpr;
    private String phoneNumber;
    private String password;
    private Date dateOfBirth;
    private String location;

    public User(String firstName, String lastName, String cpr, String phoneNumber,
            String password, Date dateOfBirth, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpr = cpr;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}