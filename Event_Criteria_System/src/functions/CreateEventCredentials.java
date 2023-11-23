/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class CreateEventCredentials {
    private final String event;
    private final String firstn;
    private final String lastn;
    private final String email;
    private final String phone;
    private final String team_type;
    private final int score;

    public CreateEventCredentials(String event, String firstn, String lastn, String email, String phone, String team_type, int score) {
        this.event = event;
        this.firstn = firstn;
        this.lastn = lastn;
        this.email = email;
        this.phone = phone;
        this.team_type = team_type;
        this.score = score;
    }

    public void create() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");

            // Get the eventID based on the provided event name
            int eventID = getEventID(connection, event);

            // Check if the eventID is valid
            if (eventID != -1) {
                
                // Get the maximum ID value from the participantID table.
                int participantID = getMaxId(connection, "participants_table", "ParticipantID") + 1;
                int teamid = getMaxId(connection, "team_table", "Team_ID") + 1;
                int playerid = getMaxId(connection, "team_table", "CaptainDorPLayer_ID") + 1;
                int scoreid = getMaxId(connection, "Score_table", "Scoreid") + 1;

                // Insert into participants_table
                insertIntoTable(connection, "participants_table", participantID, firstn, lastn, email, phone, teamid, eventID);

                // Insert into team_table
                insertIntoTable(connection, "team_table", teamid, team_type, playerid,eventID);

                // Insert into score_table
                insertIntoTable(connection, "score_table", scoreid, eventID, participantID, score);

                // Close the connection
                connection.close();

                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Event not found for the provided name: " + event);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get the event id from the database
    private int getEventID(Connection connection, String eventName) throws SQLException {
        // Use a parameterized query to prevent SQL injection and perform case-insensitive comparison
        String selectEventIdStatement = "SELECT Event_ID FROM pwc_event_table WHERE LOWER(Event_Name) = LOWER(?)";

        try (PreparedStatement selectEventIdPreparedStatement = connection.prepareStatement(selectEventIdStatement)) {
            selectEventIdPreparedStatement.setString(1, eventName); // Set the parameter without changing case

            try (ResultSet resultSet = selectEventIdPreparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Event_ID");
                } else {
                    return -1; // Indicates that the event was not found
                }
            }
        }
    }

    // Generic method to get the maximum ID from a table
    private int getMaxId(Connection connection, String tableName, String columnName) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(" + columnName + ") FROM " + tableName);

        int highestId = 0;
        if (resultSet.next()) {
            highestId = resultSet.getInt(1);
        }

        return highestId;
    }

    // Generic method to insert into a table
    private void insertIntoTable(Connection connection, String tableName, Object... values) throws SQLException {
        StringBuilder insertStatement = new StringBuilder("INSERT INTO " + tableName + " VALUES (?");
        for (int i = 1; i < values.length; i++) {
            insertStatement.append(", ?");
        }
        insertStatement.append(")");

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertStatement.toString())) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.executeUpdate();
        }
    }
}

