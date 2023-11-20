import java.util.ArrayList;

public class User {
    String username;
    String password;
    public static ArrayList<User> users = new ArrayList<User>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("User created successfully. You can now choose to log in.");
    }
}
