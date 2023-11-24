/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import UI.dashboard;
import static UI.dashboard.meow;
import static UI.dashboard.username;
import static UI.dashboard.jTabbedPane1;

/**
 *
 * @author Administrator
 */
public class delete_event {
    private final int eventID;

    public delete_event(int eventID) {
        this.eventID = eventID;
    }

    public void deleteEventFromDatabase() {
        try {
            // Establish a database connection
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "")) {
                // Create a statement and execute a DELETE query
                String deleteQuery = "DELETE FROM pwc_event_table WHERE Event_ID = ?";
                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                    deleteStatement.setInt(1, eventID);  // No need to parse to int
                    int rowsDeleted = deleteStatement.executeUpdate();

                    if (rowsDeleted > 0) {
                        System.out.println("Event with ID " + eventID + " deleted from the database.");
                        
                        meow.dispose();
                        meow =  new dashboard(username);
                meow.setVisible(true);
                 jTabbedPane1.setSelectedIndex(3);
                    } else {
                        System.out.println("Event deletion failed. No rows deleted.");
                        
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting event from the database: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
