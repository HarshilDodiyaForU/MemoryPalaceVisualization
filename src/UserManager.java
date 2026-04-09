import org.mindrot.jbcrypt.BCrypt;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    private static final Map<String, String> userCredentials = new HashMap<>();

    public static void registerUser(String username, String password) {
        // Hash the password using BCrypt's hashpw method
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        // Store the username and hashed password in a data structure (e.g., database)
        userCredentials.put(username, hashedPassword);
    }

    public static boolean authenticateUser(String username, String password) {
        // Retrieve the hashed password for the given username
        String hashedPassword = userCredentials.get(username);
        // Check if the hashed password matches the input password using BCrypt's checkpw method
        return hashedPassword != null && BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Register a new user (this is just for demonstration)
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        registerUser(newUsername, newPassword);

        // Authenticate a user
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Authentication successful. Welcome, " + username + "!");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }

        // Close the Scanner object to prevent resource leak
        scanner.close();
    }
}
