package IT;

/**
 * Deborah Barndt & Kenneth Yan
 * 11-22-16
 * ticketsJTable.java
 * IT
 * This program will hold the ticket system table.
 * Written by Deborah Barndt & Kenneth Yan. */

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ticketsJTable
{
	@SuppressWarnings("unused")
	private final DefaultTableModel tableModel = new DefaultTableModel();
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException 
	{
		ResultSetMetaData metaData = rs.getMetaData();

		// Names of columns
		Vector<String> columnNames = new Vector<String>();
		
		int columnCount = metaData.getColumnCount();
		    
		for (int column = 1; column <= columnCount; column++) 
		{
			columnNames.add(metaData.getColumnName(column));
		}

		// Data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		while (rs.next()) 
		{
			Vector<Object> vector = new Vector<Object>();
		        
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
			{
				vector.add(rs.getObject(columnIndex));
		    }
		    
			data.add(vector);
		}
		
		// Return data/column names for JTable
		return new DefaultTableModel(data, columnNames);  

	}
  
}