import javax.swing.*;
import java.awt.*;

public class MemoryPalaceLoginObsidianStyle {

    public static void main(String[] args) {
        // Run the UI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Memory Palace Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(40, 44, 52));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Fira Mono", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.LIGHT_GRAY);

        JTextField usernameField = new JTextField(20);
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(usernameLabel.getFont());
        passwordLabel.setForeground(Color.LIGHT_GRAY);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(usernameField.getBorder());
        passwordField.setEchoChar('*');

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(74, 81, 90));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(null);

        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        loginPanel.add(usernameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        loginPanel.add(usernameField, c);

        c.gridy = 1;
        loginPanel.add(passwordLabel, c);

        c.gridy = 2;
        loginPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets.bottom = 20;
        loginPanel.add(loginButton, c);

        frame.add(loginPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
