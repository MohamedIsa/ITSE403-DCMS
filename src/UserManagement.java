import java.util.ArrayList;
import java.util.Date;

public class UserManagement {
    private static ArrayList<User> users = new ArrayList<>();

    public static boolean signUp(String firstName, String lastName, String cpr,
            String phoneNumber, String password,
            Date dateOfBirth, String location) {

        if (findUserByCpr(cpr) != null) {
            System.out.println("User already exists!");
            return false;
        }

        User newUser = new User(firstName, lastName, cpr, phoneNumber,
                password, dateOfBirth, location);
        users.add(newUser);
        System.out.println("User registered successfully!");
        return true;
    }

    public static boolean login(String cpr, String password) {
        User user = findUserByCpr(cpr);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid credentials!");
        return false;
    }

    private static User findUserByCpr(String cpr) {
        for (User user : users) {
            if (user.getCpr().equals(cpr)) {
                return user;
            }
        }
        return null;
    }
}