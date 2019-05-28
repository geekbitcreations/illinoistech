import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Deborah Barndt
 * 11-22-16
 * Menu.java
 * Final Project
 * This program will hold the ticket system menu in order to create, look up, delete,
 * and modify a ticket.
 * Written by Deborah Barndt. */

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener 
{
	List<List<String>> userInfo = new ArrayList<List<String>>();
	List<List<String>> ticketInfo = new ArrayList<List<String>>();
	
	private JFrame mainFrame;
		
	// Create the main menu items
	private	JMenu file = new JMenu("File");
	private	JMenu tickets = new JMenu("Tickets");
	JScrollPane sp = null;
		
	// Create the sub menu items
	JMenuItem ItemNew;
	JMenuItem ItemExit;
	JMenuItem ItemOpenTicket;
	JMenuItem ItemViewTicket;
	JMenuItem ItemDeleteTicket;
	JMenuItem ItemUpdateTicket;
	JMenuItem ItemCloseTicket;
	private java.sql.Statement statement;
	private ResultSet result;
	private java.sql.Statement userstatement;
	private ResultSet users;
		
	public Menu() 
	{
		createTable();
		createMenu();
		prepareGUI();
	}
		
	private void createTable()
	{	
		// SQL Query create the table
		final String createTable = "CREATE TABLE dbarnticket"
			+ "(ticket_id INT AUTO_INCREMENT PRIMARY KEY, "
			+ "ticket_name VARCHAR(30), "
			+ "ticket_description VARCHAR(200))";
			
		Connection connect = null;
		Statement statement = null;
					  
		try 
		{
			// Load the MySQL driver and each database has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			    
			// Setup the connection with the database
			connect = (Connection) DriverManager.getConnection
				("jdbc:mysql://www.papademas.net/tickets?" + "user=fp411&password=411");
		 	      
			// Create a table
			statement = (Statement) connect.createStatement();
			      
			statement.executeUpdate(createTable);
			System.out.println("Created table in given database...");

			statement.close();
			connect.close();
		} 
			
		catch (Exception e) 
		{
			System.out.println(e.getMessage());  
		}  
	}
		
	private void createMenu()
	{
		// Set up mnemonics for main menu items that are triggered by alt keys
		file.setMnemonic('F');
		
		// Initialize the sub menu items
		ItemNew = new JMenuItem("New");
		ItemNew.setMnemonic('N');
		file.add(ItemNew);
		
		ItemExit = new JMenuItem("Exit");
		ItemExit.setMnemonic('X');
		file.add(ItemExit);
		
		ItemOpenTicket = new JMenuItem("Add Ticket");
		ItemOpenTicket.setMnemonic('A');
		tickets.add(ItemOpenTicket);
		
		ItemViewTicket = new JMenuItem("View Ticket");
		ItemViewTicket.setMnemonic('V');
		tickets.add(ItemViewTicket);
		
		ItemDeleteTicket = new JMenuItem("Delete Ticket");
		ItemDeleteTicket.setMnemonic('D');
		tickets.add(ItemDeleteTicket);
		
		ItemUpdateTicket = new JMenuItem("Update Ticket");
		ItemUpdateTicket.setMnemonic('U');
		tickets.add(ItemUpdateTicket);
		
		ItemCloseTicket = new JMenuItem("Close Ticket");
		ItemCloseTicket.setMnemonic('C');
		tickets.add(ItemCloseTicket);
			
		// Add listeners for each menu item 
		ItemExit.addActionListener(this);
		ItemOpenTicket.addActionListener(this);
		ItemViewTicket.addActionListener(this);
		ItemDeleteTicket.addActionListener(this);
		ItemUpdateTicket.addActionListener(this);
		ItemCloseTicket.addActionListener(this);
	}
	 
	private void prepareGUI()
	{ 
		// Initialize frame object
		mainFrame = new JFrame("Geekbit Help Desk");
	    
		// Create a menu bar
		JMenuBar bar = new JMenuBar();
		bar.add(file); 
		bar.add(tickets);
		
		// Add a menu bar to the frame
	    mainFrame.setJMenuBar(bar); 
	   
	    mainFrame.setSize(400,400);
		mainFrame.setVisible(true);
	}
	
	private void addTicket(Object ticket)
	{
		try 
		{
            System.out.println("Number of tickets? " + (total()+1));
            String insert ="INSERT INTO dbarnticket "
                    + "(ID,USER,DATE,PROBLEM,STATUS) "
                    + "VALUES "
                    
                + "(" + (total(anchor, null) +1) +",'"
                    + ticket.user +"','"
                    + ticket.date +"',' "
                    + ticket.problem +"',' "
                    + ticket.notes +"','"
                    + "NEW" +"')";
           
            System.out.println(insert);
            
          statement.executeUpdate(insert);
    
           result = statement.executeQuery("SELECT * FROM dbarnticket");
           total(ticket, statement);
        } 
		
		catch (Exception e) 
		{
            System.out.println("SQL problem " + e);
        }
       
		tickets.add((JMenuItem) ticket);
	}

	private void addUser(Object user, String username, String password)
	{
		try 
		{
            String insert ="INSERT INTO dbarnticket (NAME, USERNAME, PASSWORD) VALUES "
            	+ "('"+ user.id +"','"
            	+ user.username +"','"
                + user.password +"')";
           
            System.out.println(insert);
            
            userstatement.executeUpdate(insert);

            users = statement.executeQuery("SELECT * FROM dbarnticket");
            
            total(user, statement);
        } 
		
		catch (Exception e) 
		{
            System.out.println("SQL problem dbuser Adduser()" + e);
        }
	}
	
	private void switchUser()
	{
		
	}
	
	private void viewTicket()
	{
		String p = " ";
		   
		try 
		{
		    result = statement.executeQuery             
		         ("SELECT * FROM dbarnticket ORDER BY ID");
		          p = loopDBInfo(result);
		} 
		
		catch (Exception e) 
		{
			System.out.println("SQL problem " + e);
		} 
		
		//return p;
	}
	
	private void updateTicket()
	{
		
	}
	
	private void deleteTicket()
	{
		
	}
	
	private void closeTicket()
	{
	
	}
	
	  public int total(Object result, java.sql.Statement statement)
	  {
		  int rows = 0;
	       
		  try 
	      {
	    	  result = statement.executeQuery             
	    	  ("SELECT * FROM dbarnticket");
	          
	    	  while (((ResultSet) result).next()) 
	    	  {
	    		  rows++;
	    	  }
	    	  
	    	  System.out.println("There are "+ rows + " record in the table"); 
	        
	      } 
		  
		  catch (Exception e) {}
	    
		  return rows;
	  }
	
	public String loopDBInfo(ResultSet rs)
	{
		String p = "";
	        
		try
		{
	        while (rs.next()) 
	        {
	        	int id_col = result.getInt("ID");
	        	String username = result.getString("USER");
	        	String status = result.getString("STATUS");
	        	String prob = result.getString("PROBLEM");
	         	          
	        	p = p + (id_col + " " + username + " " + status + " "+ prob + "\n");        
	        }
	    } 
		
		catch (Exception e) 
		{
	        System.out.println("SQL problem " + e);
	    } 
		
		return p;
	}
	  
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Add a coding to trigger each sub menu action 
		if(e.getSource() == ItemExit)
		{
	         System.exit(0);
	    }
		
		else if(e.getSource() == ItemOpenTicket)
		{

			 try 
			 {
				 
				// Add the ticket information
				String ticketName = JOptionPane.showInputDialog(null,"Enter your name: ");
				String ticketDesc = JOptionPane.showInputDialog(null,"Enter a ticket description: ");
				 
				Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				Connection ticketConn = (Connection) DriverManager.getConnection
						("jdbc:mysql://www.papademas.net/tickets?" + "user=fp411&password=411");
		            
		        Statement statement = (Statement) ticketConn.createStatement();
		            
		        int result = statement.executeUpdate
		        		("Insert into dbarnticket(ticket_name, ticket_description) values('"+ticketName+"','"+ticketDesc+"')");
		            
		        if (result != 0) 
		        {
					System.out.println("A ticket was created successfully.");
				} 
		        
		        else 
		        {
					System.out.println("A ticket cannot be created.");
				}
			 
		        // Display a message to show the user the ticket id of the ticket created
			    JOptionPane.showMessageDialog(null,"Ticket id: created"); 
			 } 
			       
			 catch (SQLException ex) 
			 {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			    
			 } 
			 
			 catch (InstantiationException e1) 
			 {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 } 
			 
			 catch (IllegalAccessException e1) 
			 {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 } 
			 
			 catch (ClassNotFoundException e1) 
			 {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 }
	     }
		
		 else if(e.getSource() == ItemViewTicket)
		 {
			// Retrieve the ticket information
			try 
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				Connection ticketConn = (Connection) DriverManager.getConnection
						("jdbc:mysql://www.papademas.net/tickets?" + "user=fp411&password=411");
		            
		        Statement statement = (Statement) ticketConn.createStatement();
		            
		        ResultSet results = statement.executeQuery("SELECT * FROM dbarnticket");
		            
		        // Use JTable built in functionality to build a table model and display the table model
		        JTable ticketTable = new JTable(Ticket.buildTableModel(results));
		           
		        ticketTable.setBounds(30,40,200,300);
		        sp=new JScrollPane(ticketTable);
		        mainFrame.add(sp);
		        mainFrame.setVisible(true); 
		        statement.close();
			    ticketConn.close();  
		            
			} 
			
			catch (InstantiationException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			catch (IllegalAccessException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			catch (ClassNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 } 	
	}

	public void main(String args[])
	{
		new Menu();
	}

}
