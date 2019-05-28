/**
 * Deborah Barndt
 * 10-31-16
 * LoanProcessing.java
 * Lab 4
 * This program will act as a driver file to call the database CRUD methods and create
 * some resulting output.
 * Written by Deborah Barndt. */

package bankofiit;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoanProcessing extends BankRecords
{

	private static final int EXIT_ON_CLOSE = 0;

	public LoanProcessing() 
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws MalformedURLException 
	{
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", new ColorUIResource(36, 154, 32));
		
		// Change the color of the panel background of the dialog box
		UIManager.put ("Panel.background", new ColorUIResource(138, 201, 136));
		
		// Change the color of the scroll bar background of the dialog box
		UIManager.put ("ScrollBar.background", new ColorUIResource(138, 201, 136));
		
		// Change the color of the text area background of the dialog box
		UIManager.put ("TextArea.background", new ColorUIResource(138, 201, 136));
		
		// Change the color of the table headers background of the dialog box
		UIManager.put ("TableHeader.background", new ColorUIResource(36, 154, 32));
		
		// Change the color of the table background of the dialog box
		UIManager.put ("Table.background", new ColorUIResource(138, 201, 136));
	
		// Change the font in the dialog box
		UIManager.put ("OptionPane.messageFont", new FontUIResource(new Font("Rockwell", Font.PLAIN, 14)));	
		
		// Change the font in the dialog box
		UIManager.put ("TextArea.font", new FontUIResource(new Font("Rockwell", Font.PLAIN, 14)));
		
		// Change the font in the button
		UIManager.put("OptionPane.buttonFont", new Font("Rockwell", Font.BOLD, 14));
		
		// Change the font in the dialog box
		UIManager.put ("OptionPane.messageFont", new FontUIResource(new Font("Rockwell", Font.PLAIN, 14)));
		
		// Change the font in the table
		UIManager.put("TableHeader.font", new Font("Rockwell", Font.BOLD, 14));
		
		// Change the font in the table box
		UIManager.put ("Table.font", new FontUIResource(new Font("Rockwell", Font.PLAIN, 14)));
		
		// Instantiate a Dao object.
		Dao dao = new Dao();
		
		// Create objects for BankRecords.
		BankRecords client = new BankRecords();
		
		// Call readData method.
		client.readData();
		
		// Call createTable method.
		dao.createTable();
		
		// Call insertRecords method.
		dao.insertRecords(clientInfo);
		
		// Call retrieveRecords method.
		//dao.retrieveRecords();
		
		// Call LoanTable.
		new LoanTable();
	}
		
}


