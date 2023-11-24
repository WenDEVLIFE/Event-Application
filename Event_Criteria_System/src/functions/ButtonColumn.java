/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import UI.dashboard;
import static UI.dashboard.eventlabels;
import static UI.dashboard.eventname;
import static UI.dashboard.jTabbedPane1;
import static UI.dashboard.meow;
import static UI.dashboard.username;
import static event_criteria_system.Login.myDB_PASSWORD;
import static event_criteria_system.Login.myDB_username;
import static event_criteria_system.Login.mydb_url;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JTable jTable3;
    private Action action;
    private JButton renderButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    public ButtonColumn(JTable jtable3, Action action, int column) {
        this.jTable3 = jtable3;
        this.action = action;

        renderButton = new JButton();
    renderButton.setBackground(Color.RED);
        renderButton.setBackground(new Color(128, 0, 0)); // Set background color to maroon
         renderButton.setForeground(Color.WHITE); // Set foreground color
        renderButton.setFont(new Font("Verdana", Font.BOLD, 16)); // Set font
        
             // Set icon and resize the icon image
        ImageIcon icon = new ImageIcon("src/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png");
        // Resize the icon image to 20x20 pixels
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH));
        renderButton.setIcon(resizedIcon);
        
        TableColumnModel columnModel = jtable3.getColumnModel();
        columnModel.getColumn(column).setCellRenderer((TableCellRenderer) this);
        columnModel.getColumn(column).setCellEditor((TableCellEditor) this);
        renderButton.addActionListener(this); // Add action listener to the button
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderButton.setText("Delete"); // Set the text for the button
        return renderButton;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
     public void actionPerformed(ActionEvent e) {
    int row = jTable3.convertRowIndexToModel(jTable3.getEditingRow());
    System.out.println("Action performed for row: " + row);

    fireEditingStopped();
    ActionEvent event = new ActionEvent(jTable3, ActionEvent.ACTION_PERFORMED, "" + row);

    // Call your custom action1
    action.actionPerformed(event);

    // Add the logic to delete the corresponding row from the participant table
    int participantid = (int) jTable3.getModel().getValueAt(row, 0); // Assuming participant ID is in the first column
    System.out.println("Deleting participant with ID: " + participantid);
        try {
            deleteTeamAndParticipants(participantid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    // Add a method to delete a participant from the database
   private void deleteTeamAndParticipants(int participantid) throws ClassNotFoundException {
         ImageIcon icon = new ImageIcon("src/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png");
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,  icon);
         if (dialogResult == JOptionPane.YES_OPTION) {
    try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        // Delete from team_table
        String teamQuery = "DELETE FROM participants_table WHERE ParticipantID = ?";
        try (PreparedStatement teamPstmt = con.prepareStatement(teamQuery)) {
            teamPstmt.setInt(1, participantid);
            teamPstmt.executeUpdate();
        }
ImageIcon icon1 = new ImageIcon("src/pictures/check.png");
JOptionPane.showMessageDialog(null, "Succesfully Delete", "Message", JOptionPane.INFORMATION_MESSAGE,icon1);
          eventlabels.setText("Event Name:"+eventname);
meow.dispose();
meow =  new dashboard(username);
       meow.setVisible(true);
       jTabbedPane1.setSelectedIndex(3);
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }}


    


// Update your deleteAction
Action deleteAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle delete button click action
        int row = jTable3.convertRowIndexToModel(jTable3.getEditingRow());

        // Add your custom logic here
        System.out.println("Delete action for row: " + row);
    }
};
    }

    @Override
    public boolean stopCellEditing() {
        isButtonColumnEditor = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        renderButton.setText("Button"); // Set the text for the button
        editorValue = value;
        isButtonColumnEditor = true;
        return renderButton;
    }
}