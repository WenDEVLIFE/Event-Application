/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JTable jTable5;
    private Action action;
    private JButton renderButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    public ButtonColumn(JTable table, Action action, int column) {
        this.jTable5 = table;
        this.action = action;

        renderButton = new JButton();

        TableColumnModel columnModel = table.getColumnModel();
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
        int row = jTable5.convertRowIndexToModel(jTable5.getEditingRow());
        fireEditingStopped();
        ActionEvent event = new ActionEvent(jTable5, ActionEvent.ACTION_PERFORMED, "" + row);
        action.actionPerformed(event);
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