import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {

    private static final Map<String, String> userCredentials = new HashMap<>();

    static {
        // Hardcoded user credentials (in a real-world scenario, these would be retrieved from a database)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public static boolean authenticateUser(String username, String password) {
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Authentication successful. Welcome, " + username + "!");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
}
