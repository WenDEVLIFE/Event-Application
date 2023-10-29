/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author Administrator
 */
import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;

public class registration_user extends UserExist{
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // You can adjust the salt size as needed
        random.nextBytes(salt);
        return salt;
    }

    // MD5 function
    private static String hashPassword(String password2, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 10000; // Number of iterations
        int keyLength = 256; // Key length in bits

        PBEKeySpec spec = new PBEKeySpec(password2.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedNewPassword = factory.generateSecret(spec).getEncoded();

        return bytesToHex(hashedNewPassword);
    }

    // Byte to Hex conversion
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte aByte : bytes) {
            hexString.append(String.format("%02x", aByte));
        }
        return hexString.toString();
    }
    
    public static void refresh(){

     // Clear the text fields.
            User.setText("");
            Pass.setText("");
            confirmpass.setText("");
     
    }
  // Move the create() method outside of the main() method.
 public static void create() throws NoSuchAlgorithmException, InvalidKeySpecException, ClassNotFoundException {
        
    Object selectedItem2 = jComboBox1.getSelectedItem();
    String selectedItemString = (String) selectedItem2;

    password = new String(Pass.getPassword());

    // Generate a random salt for each user.
    byte[] salt = generateSalt();

    // Hash the password using PBKDF2.
    String hashedPassword = hashPassword(password, salt);

    // Create a connection to the database.
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {

        // Get the maximum ID value from the user table.
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM user");
        int highestId = 0;
        if (resultSet.next()) {
            highestId = resultSet.getInt(1);
        }

        // Increment the highest ID value by 1 to get the new ID value.
        int newId = highestId + 1;

        // Create a prepared statement to insert a new user into the database.
        String insertSQL = "INSERT INTO user (id, username, password, salt, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

        // Set the values for the prepared statement.
        insertStatement.setInt(1, newId);
        insertStatement.setString(2, username);
        insertStatement.setString(3, hashedPassword);
        insertStatement.setBytes(4, salt);
        insertStatement.setString(5, selectedItemString);

        // Execute the prepared statement.
        int rowsAffected = insertStatement.executeUpdate();

        // If the user was successfully added to the database, display a success message and clear the text fields.
        if (rowsAffected == 1) {
            JOptionPane.showMessageDialog(null, "Sign up success.");
              
           
                    
     

        } else {
            JOptionPane.showMessageDialog(null, "Failed to add user.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 
    public static void main(String[] args) {
        try {
            
            create();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
            Logger.getLogger(registration_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
