/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
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

    public static void main(String[] args) throws SQLException {
        CreateEventFunction c = new CreateEventFunction(tableName, event, loc, selectedString_month, selectedString_day, selectedString_year,  selectedString_participants);
        c.createTable();
    }
    
   public void createTable() throws SQLException {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        String alldate = selectedString_month + "/" + selectedString_day + "/" + selectedString_year;

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
        insertStatement.setString(6,    selectedString_participants);

        // Execute the prepared statement.
        int rowsAffected = insertStatement.executeUpdate();

        // If the event was successfully added to the database, display a success message.
        if (rowsAffected == 1) {
            JOptionPane.showMessageDialog(null, "Event added successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add event.");
        }
    }
}

  
}    
    
    
    
    
    
        
    
    
    
    
 
