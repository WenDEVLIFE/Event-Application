/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_criteria_system;

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
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */public class database_user_verification extends Login {
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

private void displayErrorMessage(String message) {
    ImageIcon imageIcon1 = new ImageIcon("src//pictures//attention.png");
    JOptionPane.showMessageDialog(null, message, "Login Message", JOptionPane.PLAIN_MESSAGE, imageIcon1);
    System.out.println("Authentication failed: " + message);
}

private void displayWelcomeMessage(String username) {
    ImageIcon imageIcon = new ImageIcon("src//pictures//cloudy-day.png");
    JOptionPane.showMessageDialog(null, "Welcome, " + username, "Login Message", JOptionPane.PLAIN_MESSAGE, imageIcon);
    System.out.println("Authentication successful!");
    String activity = "Login";
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
