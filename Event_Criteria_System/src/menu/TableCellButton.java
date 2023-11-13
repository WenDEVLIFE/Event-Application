/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static menu.dashboard.jTabbedPane1;

/**
 *
 * @author Administrator
 */
   public class TableCellButton extends DefaultCellEditor {

    public TableCellButton(JCheckBox checkBox, JTable jTable2, DefaultTableModel tableModel) {
        super(checkBox);
        // Initialize your button, set properties, and add an ActionListener
        JButton editButton = new JButton();
        editButton.setOpaque(true);
        editButton.addActionListener((ActionEvent e) -> fireEditingStopped());

        // Set up your rendering component
        ButtonRenderer1 buttonRenderer = new ButtonRenderer1();
        buttonRenderer.setButton(editButton);

        // Set up your editing component
        ButtonEditor1 buttonEditor = new ButtonEditor1(checkBox, jTable2, tableModel);
        buttonEditor.setButton(editButton);

        // Set the renderer and editor for the cell
        jTable2.getColumnModel().getColumn(tableModel.getColumnCount() - 2).setCellRenderer(buttonRenderer);
        jTable2.getColumnModel().getColumn(tableModel.getColumnCount() - 2).setCellEditor(buttonEditor);
    }
}

class ButtonRenderer1 extends DefaultTableCellRenderer {
    private JButton button;

    public void setButton(JButton button) {
        this.button = button;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }

        setText((value == null) ? "" : value.toString());
        return button;
    }
}

class ButtonEditor1 extends DefaultCellEditor {
    private JButton editButton;
    private String label;
    private boolean isPushed;
    private final JTable jTable2;
    private final DefaultTableModel tableModel;

    public ButtonEditor1(JCheckBox checkBox, JTable jTable2, DefaultTableModel tableModel) {
        super(checkBox);
        editButton = new JButton();
        editButton.setOpaque(true);
        editButton.addActionListener((ActionEvent e) -> fireEditingStopped());
        this.jTable2 = jTable2;
        this.tableModel = tableModel;
    }

    public void setButton(JButton button) {
        this.editButton = button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jTable2, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        editButton.setText(label);
        isPushed = true;
        return editButton;
    }

    @Override
   public Object getCellEditorValue() {
    if (isPushed) {
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow >= 0 && selectedRow < tableModel.getRowCount()) {
            Object eventIDObject = tableModel.getValueAt(selectedRow, 0);
            Object buttonLabelObject = tableModel.getValueAt(selectedRow, tableModel.getColumnCount() - 2);

            if (eventIDObject instanceof Integer && buttonLabelObject != null) {
                int eventID = (int) eventIDObject;
                String buttonLabel = buttonLabelObject.toString();

                // Stop cell editing before performing any actions
                stopCellEditing();

               if ("Delete".equals(buttonLabel)) {
    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirmResult == JOptionPane.YES_OPTION) {
        // Handle delete button click
        System.out.println("Delete button clicked for Event ID: " + eventID);
        delete_event e = new delete_event(eventID);
        e.deleteEventFromDatabase();

        // Remove the row from the model
        tableModel.removeRow(selectedRow);

        // Notify the table of the model change
        tableModel.fireTableRowsDeleted(selectedRow, selectedRow);
    }

                } else if ("Open".equals(buttonLabel)) {
                    // Handle open button click
                    System.out.println("Open button clicked for Event ID: " + eventID);
                             jTabbedPane1.setSelectedIndex(1);
                }
            }
        }
    }
    isPushed = false;
    return label;
   }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

}
