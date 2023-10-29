/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static menu.registration_user.username;
/**
 *
 * @author Administrator
 */
public class UserExist extends dashboard {
    
    public static String mydb_url = "jdbc:mysql://localhost:3306/eventsystem_db";
    public static String myDB_username = "root";  // Database username
    public static  String myDB_PASSWORD = "";  // Define your database password here
    
    public boolean doesUsernameExist(String username) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        String selectSQL = "SELECT COUNT(*) FROM user WHERE username = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectSQL)) {
            selectStatement.setString(1, username);

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
    }
    return false;
}
    public void user_identification() {
    try {
        // Check if the username already exists in the database.
        if (doesUsernameExist(username)) {
            JOptionPane.showMessageDialog(null, "The user already exists.");
          User.setText("");
            Pass.setText("");
            confirmpass.setText("");
             dispose();
             dashboard meow =  new dashboard();
             meow.setVisible(true);
        } else {
            try {
                
                registration_user.create();
                
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "An error occurred while checking the username.");
    }
}
}