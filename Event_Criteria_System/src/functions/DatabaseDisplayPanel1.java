/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatabaseDisplayPanel1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    static int width = 1080;
    static int height = 200;

    public DatabaseDisplayPanel1() {
        super();

        // Create a panel for the header
        JPanel headerPanel = new JPanel(new GridLayout(1, 8)); // Adjust the column count
        headerPanel.setBackground(new Color(54, 64, 83));

        JLabel eventIdLabel = new JLabel("Event_ID");
        eventIdLabel.setForeground(Color.WHITE);
        eventIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(eventIdLabel);

        JLabel eventNameLabel = new JLabel("Event Name");
        eventNameLabel.setForeground(Color.WHITE);
        eventNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(eventNameLabel);

        JLabel eventDateLabel = new JLabel("Event Date");
        eventDateLabel.setForeground(Color.WHITE);
        eventDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(eventDateLabel);

        JLabel eventTypeLabel = new JLabel("Event Type");
        eventTypeLabel.setForeground(Color.WHITE);
        eventTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(eventTypeLabel);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setForeground(Color.WHITE);
        locationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(locationLabel);

        JLabel maxParticipantsLabel = new JLabel("Max Participants");
        maxParticipantsLabel.setForeground(Color.WHITE);
        maxParticipantsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(maxParticipantsLabel);

        JLabel deleteLabel = new JLabel("Delete");
        deleteLabel.setForeground(Color.WHITE);
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(deleteLabel);

        JLabel openLabel = new JLabel("Open");
        openLabel.setForeground(Color.WHITE);
        openLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(openLabel);

        setLayout(new BorderLayout()); // Use BorderLayout to allow vertical scrolling
        add(headerPanel, BorderLayout.NORTH);

        // Connect to the database.
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");
            statement = connection.createStatement();

            // Query the database for the values.
            resultSet = statement.executeQuery("SELECT Event_ID, Event_Name, Event_Date, Event_Type, Location, Max_Participants FROM pwc_event_table");

            // Create a JPanel to hold the rows
            JPanel rowsPanel = new JPanel();
            rowsPanel.setLayout(new BoxLayout(rowsPanel, BoxLayout.Y_AXIS));
            rowsPanel.setBackground(new Color(54, 64, 83));

            // Display the values in the JPanel.
            while (resultSet.next()) { // Display all rows from the database
                int eventId = resultSet.getInt("Event_ID");
                String eventName = resultSet.getString("Event_Name");
                String eventDate = resultSet.getString("Event_Date");
                String eventType = resultSet.getString("Event_Type");
                String location = resultSet.getString("Location");
                int maxParticipants = resultSet.getInt("Max_Participants");

                var rowPanel = new JPanel(new GridLayout(1, 2)); // Adjust the column count
                rowPanel.setBackground(new Color(54, 64, 83));

                // Adjusted sizes for labels
                JLabel eventIdLabelForRow = new JLabel(String.valueOf(eventId));
                eventIdLabelForRow.setForeground(Color.WHITE);
                eventIdLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                eventIdLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(eventIdLabelForRow);

                JLabel nameLabelForRow = new JLabel(eventName);
                nameLabelForRow.setForeground(Color.WHITE);
                nameLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                nameLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(nameLabelForRow);

                JLabel dateLabelForRow = new JLabel(eventDate);
                dateLabelForRow.setForeground(Color.WHITE);
                dateLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                dateLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(dateLabelForRow);

                JLabel typeLabelForRow = new JLabel(eventType);
                typeLabelForRow.setForeground(Color.WHITE);
                typeLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                typeLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(typeLabelForRow);

                JLabel locationLabelForRow = new JLabel(location);
                locationLabelForRow.setForeground(Color.WHITE);
                locationLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                locationLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(locationLabelForRow);

                JLabel participantsLabelForRow = new JLabel(String.valueOf(maxParticipants));
                participantsLabelForRow.setForeground(Color.WHITE);
                participantsLabelForRow.setFont(new Font("Arial", Font.PLAIN, 14));
                participantsLabelForRow.setPreferredSize(new Dimension(20, 30)); // Adjust width and height as needed
                rowPanel.add(participantsLabelForRow);

                // Adjusted size for Delete button
                JButton deleteButton = new JButton("Delete");
                deleteButton.setForeground(Color.WHITE);
                deleteButton.setBackground(new Color(128, 0, 0));
                deleteButton.setPreferredSize(new Dimension(80, 50)); // Adjust width and height as needed
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Do you want to delete this event?",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null
                        );

                        if (response == JOptionPane.YES_OPTION) {
                            System.out.println("User clicked 'Yes'");
                            // Perform the action for 'Yes'
                            deleteEvent(eventId); // Call the delete method
                            rowPanel.setVisible(false); // Hide the row after deletion
                        } else if (response == JOptionPane.NO_OPTION) {
                            // Perform the action for 'No' or just close the dialog
                        } else {
                            System.out.println("User closed the dialog or clicked the close button");
                            // Handle other cases (e.g., dialog close button or Esc key)
                        }
                    }
                });
                rowPanel.add(deleteButton);

                // Adjusted size for Open button
                JButton openButton = new JButton("Open");
                openButton.setForeground(Color.WHITE);
                openButton.setBackground(new Color(0, 128, 255));
                openButton.setPreferredSize(new Dimension(80, 50));
                openButton.addActionListener(e -> {
                    // Implement the action when the "Open" button is clicked
                    // For example, you can open a detailed view of the event
                    // You can use eventId or other data to identify the selected event
                });
                rowPanel.add(openButton);

                rowsPanel.add(rowPanel);
            }

            // Wrap the rowsPanel in a JScrollPane and allow vertical scrolling
            JScrollPane scrollPane = new JScrollPane(rowsPanel);
            scrollPane.setPreferredSize (new Dimension(width, height));
            add(scrollPane, BorderLayout.WEST);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteEvent(int eventId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pwc_event_table WHERE Event_ID = ?");
            preparedStatement.setInt(1, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}