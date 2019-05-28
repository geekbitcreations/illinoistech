/**
 * Deborah Barndt
 * 10-31-16
 * Dao.java
 * Lab 4
 * This program will allow for CRUD database connectivity and operations. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Dao extends BankRecords
{

	private static final int EXIT_ON_CLOSE = 0;

	public Dao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	// The JDBC driver name and the database URL.
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://www.papademas.net:3306/411labs";
	
	// Credentials for the database.
	final String USER = "db411";
	final String PASSWORD = "411";
	
	Connection connect = null;
	Statement stmnt = null;
	
	// Create a table of the database when called.
	public void createTable() throws MalformedURLException
	{
		String pep,		// value of whether the client is a politically exposed person
			   id;			// the clients' id number
		
		double income;	// the amount of income the client has
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (10, 15);
		
		try
		{
			// Register the JDBC driver.
		    Class.forName("com.mysql.jdbc.Driver");

		    // Open a connection to the database.
		    outputArea.append(" Connecting to the selected database.... " + "\n");
		    connect = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		    outputArea.append(" Connected to the database successfully.... " + "\n");
		      
		    // Execute a query to the database.
		    outputArea.append(" Creating a table in the given database.... " + "\n");
		    stmnt = (Statement) connect.createStatement();
		      
		    String sql = "CREATE TABLE d_barn_tab " 
		    		+ "(ID VARCHAR(8), " 
		            + " INCOME numeric(8, 2), " 
		            + " PEP VARCHAR(3), " 
		            + " PRIMARY KEY ( id ))"; 

		    stmnt.executeUpdate(sql);
		      
		    outputArea.append(" Created a table in the given database.... " + "\n");
		}
		
		// Handle the errors for JDBC.
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		// Handle the errors for Class.forName.
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Add a finally block used to close resources.
		finally
		{
		    try
		    {
		    	if(stmnt != null)
		        {
		    		connect.close();
		        }
		    }
		      
		    // Do nothing
		    catch(SQLException se)
		    {
		    }
		      		      
		    try
		    {
		        if(connect != null)
		        {
		        	connect.close();
		        }
		    }
		      
		    catch(SQLException se)
		    {
		        se.printStackTrace();
		    }

		}
		   
		outputArea.append(" Goodbye! \n\n");
		
		// Program time stamp
		outputArea.append("\n" + " Current date: " + timeStamp + "  " + "\n Programmed by Deborah Barndt \n");
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://cdn2.iconfinder.com/data/icons/new-year-resolutions/64/resolutions-16-128.png"));
		
		// Display with results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Loan Analysis Report", 
				JOptionPane.INFORMATION_MESSAGE, icon);
		
	}
	
	
	// Insert the records into the database.
	public void insertRecords(BankRecords[] clientInfo) throws MalformedURLException 
	{
		// Create a Text Area
		JTextArea outputArea = new JTextArea (10, 15);
		
		try
		{
			// Register the JDBC driver.
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection to the database.
			outputArea.append(" Connecting to a selected database... " + "\n");
		    connect = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		      
		    outputArea.append(" Connected to the database successfully.... " + "\n");
		      
		    // Execute a query to the database.
		    outputArea.append(" Inserting records into the table.... " + "\n");
		    stmnt = (Statement) connect.createStatement();
		      
		    for (int i = 0; i < clientInfo.length; i++)
		    {
		    	String sql = "INSERT INTO d_barn_tab " +
		    			"VALUES ('" + clientInfo[i].getId() + "' ," +
		                " '" + clientInfo[i].getIncome() + "' ," +
		                " '" + clientInfo[i].getPep() + "')";
		    	stmnt.executeUpdate(sql);
		    }
		      
		    outputArea.append(" Inserted records into the table.... " + "\n");
		}
		
		//Handle the errors for JDBC.
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		 
		// Handle the errors for Class.forName.
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		 
		// Add a finally block used to close resources.
		finally
		{
			try
		    {
				if(stmnt != null)
		    	{
					connect.close();
		    	}
		    }
		      
		    // Do nothing
		    catch(SQLException se)
		    {
		    }
		      
		    try
		    {
		    	if(connect != null)
		    	{
		    		connect.close();
		    	}
		    }
		      
		    catch(SQLException se)
		    {
		        se.printStackTrace();
		    }
		}
		   
		outputArea.append(" Goodbye! \n\n");
		
		// Program time stamp
		outputArea.append("\n" + " Current date: " + timeStamp + "  " + "\n Programmed by Deborah Barndt \n");
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://cdn2.iconfinder.com/data/icons/new-year-resolutions/64/resolutions-16-128.png"));
		
		// Display with results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Loan Analysis Report", 
				JOptionPane.INFORMATION_MESSAGE, icon);
		
		// Create a prepared statement.
		//PreparedStatement stmnt = (PreparedStatement) connect.prepareStatement("Select * from jpapa_tab"
				//+ " where id > ? and income > ? and pep=?");
	}
	
	// Retrieve the records from the database and return a result set.
	public ResultSet retrieveRecords() throws MalformedURLException
	{
		// Create a Text Area
		//JTextArea outputArea = new JTextArea (300, 600);
		JTextArea outputArea = new JTextArea (8, 10);
		ResultSet result = null;
		//Print 2 decimal places for distance
		DecimalFormat mydf = new DecimalFormat("#,##0.00");
		
		// Add a Scroll Pane
		//JScrollPane scrollPane = new JScrollPane(outputArea);
		
		// Set dimensions of scrollPane
		//scrollPane.setPreferredSize(new Dimension(300, 600));
		//outputArea.setLineWrap(true);  
		//outputArea.setWrapStyleWord(true);
		
		try
		{
			// Register the JDBC driver.
		    Class.forName("com.mysql.jdbc.Driver");
		    
		    // Open a connection to the database.
			outputArea.append(" Connecting to a selected database... " + "\n");
		    connect = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		    
		    outputArea.append(" Connected to the database successfully.... " + "\n");
		      
		    // Execute a query to the database.
		    outputArea.append(" Creating a statement... " + "\n");
		    stmnt = (Statement) connect.createStatement();

		    // Sort the data for pep in descending order.
		    String sql = "SELECT ID, INCOME, PEP FROM d_barn_tab ORDER BY pep DESC ";
		    result = stmnt.executeQuery(sql);
	   		    
		    // Add column headers
		    //outputArea.append(" ID\tINCOME\tPEP\n\n");

		    // Extract the data from the result set.
		    /*while(result.next())
		    {
		    	//Retrieve the data by column name
		        String id  = result.getString("id");
		        double income = result.getDouble("income");
		        String pep = result.getString("pep");
		      		        
		        //Display the values in a table.
		        outputArea.append(" " + id);
		        outputArea.append("\t" + mydf.format(income));
		        outputArea.append("\t" + pep + "\n");
		    }
   
		    //result.close();*/
		}
		
		// Handle the errors for JDBC.
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		// Handle the errors for Class.forName.
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		
		// Add a finally block used to close resources.
		/*finally
		{
			try
			{
				if(stmnt != null)
				{
					connect.close();
				}
			}
				      
			// Do nothing
			catch(SQLException se)
			{
			}
				      
			try
			{
				if(connect != null)
				{
				   connect.close();
				}
			}
				      
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}*/	
		outputArea.append(" Goodbye! \n\n"); 
		
		// Program time stamp
		outputArea.append("\n" + " Current date: " + timeStamp + "  " + "\n Programmed by Deborah Barndt ");
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://cdn2.iconfinder.com/data/icons/new-year-resolutions/64/resolutions-16-128.png"));
		
		// Display with results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea/*scrollPane*/, "Bank of IIT Loan Analysis Report", 
				JOptionPane.INFORMATION_MESSAGE, icon);
		
		return result;
	}
}
