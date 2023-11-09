/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_criteria_system;

import static event_criteria_system.Login.myDB_PASSWORD;
import static event_criteria_system.Login.myDB_username;
import static event_criteria_system.Login.mydb_url;
import java.awt.Color;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import menu.dashboard;
import static menu.dashboard.meow;
/**
 *
 * @author Administrator
 */public class database_user_verification {
     // store the data from the main
private final String username;
private final String password;

// to receive the value from the main jframe
      public static Login user;
 
    public database_user_verification(String username, String password,Login user) {
           this.username = username; // Initialize the username instance variable
    this.password = password; // Initialize the password instance variable
    this.user = user;  // Initialize the user jframe instance variable
    }
     
    public void login_authentication(String username, String password) {
        Connection con = null;
        try {
            checkMySQLServerStatus(); // Check if MySQL is online before attempting to authenticate

            // Connect to the database.
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");

            // SQL command
            String sql = "SELECT username, password, salt FROM user WHERE username = ?";

            // SQL function
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // User found
                        String storedHashedPassword = resultSet.getString("password");
                        byte[] storedSalt = resultSet.getBytes("salt");

                        // Verify the entered password
                        if (password.isEmpty()) {
                            // Password is empty, show an error message
                            displayErrorMessage("Password is required");
                        } else if (validatePassword(password, storedSalt, storedHashedPassword)) {
                            displayWelcomeMessage(username);
                            // Authentication successful, do not dispose the dashboard frame
                        } else {
                            // Incorrect username or password
                            displayErrorMessage("Incorrect username or password");
                        }
                    } else {
                        // User not found
                        displayErrorMessage("User not found");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database connection errors
        } finally {
            // Close the database connection in the finally block
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle the exception if needed
                }
            }
        }
    
}
      public  void checkMySQLServerStatus() throws SQLException {
        try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
            // Connection successful, MySQL is online.
        } catch (SQLException e) {
            // Connection failed, MySQL is offline. You can log the error or handle it as needed.
            throw e;
        }
    }

private void displayErrorMessage(String message) {
    ImageIcon imageIcon1 = new ImageIcon("src//pictures//attention.png");
    JOptionPane.showMessageDialog(null, message, "Login Message", JOptionPane.PLAIN_MESSAGE, imageIcon1);
    System.out.println("Authentication failed: " + message);
}

private void displayWelcomeMessage(String username) {
    JPanel panel = new JPanel();
    Color customColor = new Color(255, 255, 240, 128); // RGBA: White with 50% transparency (0-255 range)

// Set the background color of the panel
panel.setBackground(customColor);
    ImageIcon imageIcon = new ImageIcon("src/pictures/pwclogo.jpg");
    int width = 64; // Set your desired width
    int height = 64; // Set your desired height
    Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    // Create a label with an ImageIcon and text
    JLabel label = new JLabel("Welcome, " + username, scaledIcon, JLabel.CENTER);

    // Add the label to the custom panel
    panel.add(label);

    // Create a JOptionPane with the custom panel as the message component
    JOptionPane.showMessageDialog(null, panel, "Login Message", JOptionPane.PLAIN_MESSAGE);

    System.out.println("Authentication successful!");
    user.dispose();
    meow = new dashboard(username);
    meow.setVisible(true);
}

public boolean validatePassword(String enteredPassword, byte[] storedSalt, String storedHashedPassword) {
    try {
        // Hash the entered password with the stored salt and compare with stored hash
        String computedHashedPassword = hashPassword(enteredPassword, storedSalt);
        return storedHashedPassword.equals(computedHashedPassword);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        e.printStackTrace();
        return false;
    }
}

private String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 10000;
    int keyLength = 256;

    KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);

    try {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedPassword = factory.generateSecret(keySpec).getEncoded();

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedPassword) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        throw e;
    }
}
}
