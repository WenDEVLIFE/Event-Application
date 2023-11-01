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
import static menu.dashboard.Pass;
import static menu.dashboard.User;
import static menu.dashboard.confirmpass;
import static menu.dashboard.confirmpassword1;
import static menu.dashboard.password1;
import static menu.dashboard.username1;

public class registration_user {
 private  static String username1;
 private static String password1;
 private static String confirmpass;
private  static String selectedItemString;

  
 public static String mydb_url = "jdbc:mysql://localhost:3306/eventsystem_db";
    public static String myDB_username = "root";  // Database username
    public static  String myDB_PASSWORD = "";  // Define your database password here
    
    public static javax.swing.JPasswordField Pass;
    public static javax.swing.JTextField User;
    public static javax.swing.JTextField confirmpassword1;
  
    public static javax.swing.JComboBox<String> jComboBox1;
   
    public static javax.swing.JTabbedPane jTabbedPane1;
  
    
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // You can adjust the salt size as needed
        random.nextBytes(salt);
        return salt;
    }

    // MD5 function
    private static String hashPassword(String password1, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 10000; // Number of iterations
        int keyLength = 256; // Key length in bits

        PBEKeySpec spec = new PBEKeySpec(password1.toCharArray(), salt, iterations, keyLength);
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
    
   
    public registration_user (String username1, String password1, String selectedItemString) {
              this.username1 = username1; // Initialize the username instance variable
    this.password1 = password1; // Initialize the password instance variable
                  this.selectedItemString= selectedItemString; // Initialize the username instance variable
        
    }
  // Move the create() method outside of the main() method.
 public static void create(String username1, String password1, String selectedItemString) throws NoSuchAlgorithmException, InvalidKeySpecException, ClassNotFoundException {
        
   

    // Generate a random salt for each user.
    byte[] salt = generateSalt();

    // Hash the password using PBKDF2.
    String hashedPassword = hashPassword(password1, salt);

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
        insertStatement.setString(2, username1);
        insertStatement.setString(3, hashedPassword);
        insertStatement.setBytes(4, salt);
        insertStatement.setString(5, selectedItemString);

        // Execute the prepared statement.
        int rowsAffected = insertStatement.executeUpdate();

        // If the user was successfully added to the database, display a success message and clear the text fields.
        if (rowsAffected == 1) {
            JOptionPane.showMessageDialog(null, "Sign up success.");
         

      
    // Set the selected index to the default tab.
     
           
       
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add user.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 
    public static void main(String[] args) {
        try {
            
            create(username1, password1, selectedItemString);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
            Logger.getLogger(registration_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // to open a new frame you need this code

   
}
