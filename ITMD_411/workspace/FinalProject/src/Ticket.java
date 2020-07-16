import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * Deborah Barndt
 * 11-22-16
 * Ticket.java
 * Final Project
 * This program will hold the information for the tickets.
 * Written by Deborah Barndt. */

public class Ticket extends Menu
{

	public Ticket() 
	{
		// TODO Auto-generated constructor stub
	}

	private String description,	// the ticket description
		   		   assignee;	// person assigned to the ticket
	
	private int id,				// the ticket number
			  	user,			// the user in the ticket system
			  	priority;		// the ticket priority setting
	
	private boolean active;		// whether the ticket is active or not
	
	@SuppressWarnings("unused")
	private final DefaultTableModel ticketTable = new DefaultTableModel();
	public static DefaultTableModel buildTableModel(ResultSet result) throws SQLException 
	{

		ResultSetMetaData metaData = result.getMetaData();

		// Create the names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		
			for (int column = 1; column <= columnCount; column++) 
			{
				columnNames.add(metaData.getColumnName(column));
			}

		// Insert the data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	
		while (result.next()) 
		{
			Vector<Object> vector = new Vector<Object>();
		        
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
			{
				vector.add(result.getObject(columnIndex));
			}
		        
			data.add(vector);
		}

		// Display the data and columns names for the table
		return new DefaultTableModel(data, columnNames);  

	}
	
}