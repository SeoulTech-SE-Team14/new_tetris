package view.abstractComponent.table;

import java.awt.*;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ScoreBoardTableRenderer extends DefaultTableCellRenderer {

    private String timestamp;

    public ScoreBoardTableRenderer(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        if (! table.isRowSelected(row)) { 
            if(table.getValueAt(row, 3).toString().equals(timestamp)) {
                c.setBackground(Color.GRAY); 
                return c;
            }else {
                c.setBackground(Color.BLACK);
            }
        }

        return c;
    }
    
}
