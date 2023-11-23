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



import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ButtonColumn1 extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JTable jTable3;
    private Action action1;
    private JButton renderButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    // Specify the column where you want the button
    private int buttonColumn;

    public ButtonColumn1(JTable jTable3, Action action, int buttonColumn) {
        this.jTable3 = jTable3;
        this.action1 = action;
        this.buttonColumn = buttonColumn;

        renderButton = new JButton();

        TableColumnModel columnModel = jTable3.getColumnModel();
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
        int row = jTable3.convertRowIndexToModel(jTable3.getEditingRow());
        fireEditingStopped();
        ActionEvent event = new ActionEvent(jTable3, ActionEvent.ACTION_PERFORMED, "" + row);
        action1.actionPerformed(event);
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