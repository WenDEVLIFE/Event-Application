/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author Administrator
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import UI.dashboard;
import static UI.dashboard.eventdb;
import static UI.dashboard.eventlabels5;
import static UI.dashboard.eventlabels7;
import static UI.dashboard.eventname;
import static UI.dashboard.jTabbedPane1;
import static UI.dashboard.meow;
import static UI.dashboard.username;
import static event_criteria_system.Login.myDB_PASSWORD;
import static event_criteria_system.Login.myDB_username;
import static event_criteria_system.Login.mydb_url;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ButtonColumn1 extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JTable jTable5;
    private Action action1;
    private JButton renderButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    // Specify the column where you want the button
    private int buttonColumn;

    public ButtonColumn1(JTable jTable5, Action action, int buttonColumn) {
        this.jTable5 = jTable5;
        this.action1 = action;
        this.buttonColumn = buttonColumn;

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
        
        TableColumnModel columnModel = jTable5.getColumnModel();
        columnModel.getColumn(buttonColumn).setCellRenderer((TableCellRenderer) this);
        columnModel.getColumn(buttonColumn).setCellEditor((TableCellEditor) this);
        renderButton.addActionListener(this); // Add action listener to the button
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == buttonColumn) {
            renderButton.setText("Delete");
            return renderButton;
        } else {
            renderButton.setText(""); // Empty text for other columns
            return null;
        }
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
     public void actionPerformed(ActionEvent e) {
    int row = jTable5.convertRowIndexToModel(jTable5.getEditingRow());
    System.out.println("Action performed for row: " + row);

    fireEditingStopped();
    ActionEvent event = new ActionEvent(jTable5, ActionEvent.ACTION_PERFORMED, "" + row);

    // Call your custom action1
    action1.actionPerformed(event);

    // Add the logic to delete the corresponding row from the participant table
    int Score= (int) jTable5.getModel().getValueAt(row, 0); // Assuming participant ID is in the first column
      int participant= (int) jTable5.getModel().getValueAt(row, 0); // Assuming participant ID is in the first column
    System.out.println("Deleting participant with ID: " + Score + " participant" + participant);
        try {
            deleteTeamAndParticipants(Score , participant);
        } catch (SQLException ex) {
            Logger.getLogger(ButtonColumn1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ButtonColumn1.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    // Add a method to delete a participant from the database
   private void deleteTeamAndParticipants(int Score, int participant) throws SQLException, ClassNotFoundException {
        ImageIcon icon = new ImageIcon("src/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png");
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,  icon);
         if (dialogResult == JOptionPane.YES_OPTION) {
    try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        // Delete from team_table
        String teamQuery = "DELETE FROM score_table WHERE ScoreID = ?";
        try (PreparedStatement teamPstmt = con.prepareStatement(teamQuery)) {
            teamPstmt.setInt(1, Score);
            teamPstmt.executeUpdate();
        }

        // Delete from Participant_table
        String participantQuery = "DELETE FROM participants_table WHERE ParticipantID = ?";
        try (PreparedStatement participantPstmt = con.prepareStatement(participantQuery)) {
            participantPstmt.setInt(1, participant);
            participantPstmt.executeUpdate();
        }
        
  
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         }
         ImageIcon icon1 = new ImageIcon("src/pictures/check.png");
JOptionPane.showMessageDialog(null, "Succesfully Delete", "Message", JOptionPane.INFORMATION_MESSAGE,icon1);
  eventlabels7.setText("Event Name:"+eventname);
meow.dispose();
meow =  new dashboard(username);
                meow.setVisible(true);
                  jTabbedPane1.setSelectedIndex(3);
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
    public Component getTableCellEditorComponent(JTable Jtable3, Object value, boolean isSelected, int row, int column) {
        if (column == buttonColumn) {
            renderButton.setText("Button");
            editorValue = value;
            isButtonColumnEditor = true;
            return renderButton;
        } else {
            return null;
        }
    }
}