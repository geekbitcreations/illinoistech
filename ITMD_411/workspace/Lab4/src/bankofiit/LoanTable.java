/**
 * Deborah Barndt
 * 10-31-16
 * LoanTable.java
 * Lab 4
 * This program will build the java table to hold the data.
 * Written by Deborah Barndt. */

package bankofiit;

import java.awt.BorderLayout;
import java.awt.Container;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class LoanTable extends JFrame
{
	public LoanTable() throws MalformedURLException 
	{
		try 
		{
			// The JDBC driver name and the database URL.  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connect = (Connection) DriverManager.getConnection
            		("jdbc:mysql://www.papademas.net/411labs?" + "user=db411&password=411");
            Statement stmnt = (Statement) connect.createStatement();
    	 
            // Add a vector object.
    	    Vector<Vector<Object>> loandata = new Vector<Vector<Object>>();
            Vector<String> column = new Vector<String>();
    	
            try 
            {
            	stmnt = (Statement) connect.createStatement();
            	Dao dao = new Dao();
            	ResultSet result = dao.retrieveRecords();
            	ResultSetMetaData metaData = (ResultSetMetaData) result.getMetaData();
            	int columns = metaData.getColumnCount();
    	   
            	// Get the column names from the table.
            	String cols = "ID, INCOME, PEP";
            	    	 
            	for (int i = 1; i <= columns ; i++) 
            	{
            		cols = metaData.getColumnName(i);
            		column.add(cols);
            	}
    	    
            	// Get the row data from the table.
    	        while (result.next()) 
            	{
            		Vector<Object> rows = new Vector<Object>(columns);
    	          
            		for (int i = 1; i <= columns; i++) 
            		{
            			rows.addElement(result.getObject(i));
            		} 
    	       
            		loandata.addElement(rows);
            	}
    	        //result.close();
            } 
            
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
            
            // Create a table
            JTable loantable = new JTable(loandata, column);
            
            // Create a scroll bar
            JScrollPane myscrollPane = new JScrollPane(loantable);
            getContentPane().add(myscrollPane);

            // Create a panel
            JPanel mybuttonPanel = new JPanel();
            getContentPane().add(mybuttonPanel, BorderLayout.SOUTH );
        
            // Create a frame window
            JFrame loanframe = new JFrame("Bank of IIT Loan Analysis Report");
            loanframe.setSize(700, 200);
            loanframe.add(new JScrollPane(loantable));
            loanframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loanframe.pack();
            loanframe.setVisible(true);

		}
        
		catch (InstantiationException e) 
		{
            System.err.println("There is an error in instantiation!");
        }
        
        catch (ClassNotFoundException e) 
		{
            System.err.println("The class is not found!");
        }
        
        catch (IllegalAccessException e) 
		{
            System.err.println("Access is denied!");
        }
     
        catch (SQLException e) 
		{
            System.err.println("SQL Error! Please try again. " + e.getMessage() );
        } 
	}

	private Container getContentPane(BankRecords[] clientInfo) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		new LoanTable();

	}
}
