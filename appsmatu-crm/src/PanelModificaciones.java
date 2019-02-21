
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableCell;


public class PanelModificaciones extends JPanel {
	private JTable table;
	private  DefaultTableModel tableModel;


	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	/**
	 * Create the panel.
	 */
	public PanelModificaciones() {
		setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 835, 575);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane);
		
		table = new JTable();
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		    
		    	final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		    	if(!isSelected){
		        c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
		    	}
		        return c;
		    }
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(0, 0, 845, 565);
		scrollPane.setViewportView(table);
	}
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void llenarTabla(ResultSet rs, JTable table) throws SQLException{
		BaseDatos.getBBDD().conectar();
        tableModel = new DefaultTableModel();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        
        Object[] row = new Object[columnCount];

        while (rs.next()){
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            tableModel.addRow(row);
        }
        setTableModel(tableModel);
        table.setModel(tableModel);
        table.setName(rs.getMetaData().getTableName(1));
        BaseDatos.getBBDD().desconectar();
    }


}
