/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;
import UI.dashboard;
import static UI.dashboard.jTabbedPane1;
import static UI.dashboard.meow;
import static UI.dashboard.username;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEventFunction {
    public static String tableName, eventtype, event, loc, selectedString_month, selectedString_day, selectedString_year, selectedString_participants;
    String url = "jdbc:mysql://localhost:3306/eventsystem_db"; // Change to your database URL
    String username = "root";
    String password = "";

    public CreateEventFunction(String tableName, String event, String loc, String selectedString_month, String selectedString_day, String selectedString_year ,  String selectedString_participants) {
        CreateEventFunction.tableName = tableName;
        CreateEventFunction.event = event;
        CreateEventFunction.loc = loc;
        CreateEventFunction.selectedString_month = selectedString_month;
        CreateEventFunction.selectedString_day = selectedString_day;
        CreateEventFunction.selectedString_year = selectedString_year;
        CreateEventFunction.selectedString_participants = selectedString_participants;
       
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CreateEventFunction c = new CreateEventFunction(tableName, event, loc, selectedString_month, selectedString_day, selectedString_year,  selectedString_participants);
        c.createTable();
    }
    
     public void createTable() throws SQLException, ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String alldate = selectedString_month + "/" + selectedString_day + "/" + selectedString_year;

            // Check if the event name already exists in the database.
            if (isEventNameExists(connection, tableName)) {
                JOptionPane.showMessageDialog(null, "Event name already exists. Choose a different name.");
                return; // Exit the method if the event name exists.
            }

            // Get the maximum ID value from the event table.
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(Event_ID) FROM pwc_event_table");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            // Increment the highest ID value by 1 to get the new ID value.
            int newId = highestId + 1;

            // Create a prepared statement to insert a new event into the database.
            String insertSQL = "INSERT INTO pwc_event_table (Event_ID, Event_Name, Event_Date, Event_Type, Location, Max_Participants) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement.
            insertStatement.setInt(1, newId);
            insertStatement.setString(2, tableName);
            insertStatement.setString(3, alldate);
            insertStatement.setString(4, event);
            insertStatement.setString(5, loc);
            insertStatement.setString(6, selectedString_participants);

            // Execute the prepared statement.
            int rowsAffected = insertStatement.executeUpdate();

            // If the event was successfully added to the database, display a success message.
            if (rowsAffected == 1) {
                         ImageIcon icon1 = new ImageIcon("src/pictures/check.png");
JOptionPane.showMessageDialog(null, "Succesfully added the event", "Message", JOptionPane.INFORMATION_MESSAGE,icon1);
                 meow.dispose();
meow =  new dashboard(username);
                meow.setVisible(true);
                   jTabbedPane1.setSelectedIndex(3);
            } else {
                        ImageIcon icon1 = new ImageIcon("src/pictures/check.png");
JOptionPane.showMessageDialog(null, "Failed to add the event", "Message", JOptionPane.ERROR_MESSAGE,icon1);
            }
        }
    
}
 private boolean isEventNameExists(Connection connection, String eventName) throws SQLException {
        String query = "SELECT COUNT(*) FROM pwc_event_table WHERE Event_Name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, eventName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if the count is greater than 0 (event name exists)
            }
        }
        return false;
    }
}
  
    
    
    
    
    
    
        
    
    
    
    
 
