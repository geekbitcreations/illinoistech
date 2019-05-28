/**
 * Deborah Barndt & Kenneth Yan
 * 11-22-16
 * Tickets.java
 * Final Project
 * This program will hold the ticket system menu in order to create, look up, delete,
 * and modify a ticket.
 * Written by Deborah Barndt & Kenneth Yan. */

package IT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// Proj implements one listener and can trigger action off menu item clicked with one action performed event handler
@SuppressWarnings("serial")
public class ticketsGUI extends JFrame implements ActionListener 
{
	// Class level member vars
	private JFrame mainFrame;
	
	// Include main menu objects
	private	JMenu file = new JMenu("File");
	private	JMenu tickets = new JMenu("Tickets");
	JScrollPane sp = null;
	// Include sub menu item objects
	
	JMenuItem ItemNew;
    JMenuItem ItemExit;
    JMenuItem ItemOpenTicket;
    JMenuItem ItemViewTicket;
    JMenuItem ItemViewAllTicket;
    JMenuItem ItemCloseTicket;
    JMenuItem ItemUpdateTicket;
	JMenuItem ItemDeleteTicket;
	
    // Include more items below
	
	public ticketsGUI() 
	{
		createTicketTable();
	//	createUserTable();
	//	createContactInfoTable();
		createMenu();
	    prepareGUI();
	    test();
	}
	
	
	private void createTicketTable()
	{	
		// Vars. for SQL Query create
		  final String createTicketTable = "CREATE TABLE kyanticket"
		  		+ "(ticket_id INT AUTO_INCREMENT PRIMARY KEY, "
		  		+ "ticket_name VARCHAR(30), "
		  		+ "ticket_description VARCHAR(200),"
		  		+ "ticket_status VARCHAR(255),"
		  		+ "ticket_priority VARCHAR(255));";
		  Connection connect = null;
		  Statement statement = null;
				  
		try 
		{
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
		      
			// Setup the connection with the DB
		    connect = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
		    		+ "user=fp411&password=411");
	 	      
		    // Create the table
		    statement = connect.createStatement();
		      
		    statement.executeUpdate(createTicketTable);
		    System.out.println("Created table in given database...");

		    //end create table
		    //close connection/statement object  
		    statement.close();
		    connect.close();
		} 
		
		catch (Exception e) 
		{
		    System.out.println(e.getMessage());  
		}  
	}
	
	private void createUserTable()
	{	
		// vars. for SQL Query create
		  final String createUserTable = "CREATE TABLE dbarn_kyan_login"
		  		+ "(ticket_user VARCHAR(255), "
		  		+ "ticket_password VARCHAR(60));" ;
		  Connection connect = null;
		  Statement statement = null;
				  
		  String adduser = "Insert into dbarn_kyan_login(ticket_user, ticket_password) VALUES"
          		+ "('jpapa', 'thegodfather'), "
          		+ "('kyan', 'javarocks'), "
          		+ "('dbarndt', 'designguru'), "
          		+ "('mengland', 'techsavy'), "
          		+ "('lmchugh', 'networking'), "
          		+ "('jjerger', 'serverboss');";
		  
		  String encrypt = "SELECT HASHBYTES('SHA1', ticket_password) FROM dbarn_kyan_login;"
		  
		try 
		{
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
		      
			// Setup the connection with the DB
		    connect = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
		    		+ "user=fp411&password=411");
	 	      
		    // Create the table
		    statement = connect.createStatement();
		      
		    statement.executeUpdate(createUserTable);
		    statement.executeUpdate(adduser);
		    System.out.println("Created table in given database...");

		    //end create table
		    //close connection/statement object  
		    statement.close();
		    connect.close();
		} 
		
		catch (Exception e) 
		{
		    System.out.println(e.getMessage());  
		}  
	}
	
	private void createContactInfoTable()
	{	
		// vars. for SQL Query create
		  final String createContactInfoTable = "CREATE TABLE dbarn_kyan_user"
		  		+ "(ticket_email VARCHAR(255), "
		  		+ "ticket_firstname VARCHAR(255), "
		  		+ "ticket_lastname VARCHAR(255), "
		  		+ "ticket_phonenum VARCHAR(200));" ;
		  Connection connect = null;
		  Statement statement = null;
				  
		  String adduser = "Insert into dbarn_kyan_user(ticket_email, ticket_firstname, ticket_lastname, ticket_phonenum) VALUES"
          		+ "('jpapa@gmail.com', 'James' , 'Papademas' , '312-112-6595'), "
          		+ "('kyan@gmail.com', 'Kenneth' , 'Yan' , '312-546-8756'), "
          		+ "('dbarndt@gmail.com', 'Deborah' , 'Barndt' , '312-584-7856'), "
          		+ "('mengland@gmail.com', 'Madeleine' , 'England' , '312-867-5309'), "
          		+ "('lmchugh@gmail.com', 'Louis' , 'McHugh' , '312-346-5789'), "
          		+ "('jjerger@gmail.com', 'James' , 'Jerger' , '312-582-6435');";
		  
		try 
		{
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
		      
			// Setup the connection with the DB
		    connect = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
		    		+ "user=fp411&password=411");
	 	      
		    // Create the table
		    statement = connect.createStatement();
		      
		    statement.executeUpdate(createContactInfoTable);
		    statement.executeUpdate(adduser);
		    System.out.println("Created table in given database...");

		    //end create table
		    //close connection/statement object  
		    statement.close();
		    connect.close();
		} 
		
		catch (Exception e) 
		{
		    System.out.println(e.getMessage());  
		}  
	}
	
	// Column names
	private void createMenu()
	{
		// Set up mnemonics for main menu items (triggered by alt keys)
		file.setMnemonic('F');
	
		// Initialize the sub menu items
		ItemNew = new JMenuItem("New");
		ItemNew.setMnemonic('N');
		file.add(ItemNew);
	
		ItemExit = new JMenuItem("Exit");
		ItemExit.setMnemonic('X');
		file.add(ItemExit);
	
		ItemOpenTicket = new JMenuItem("Open Ticket");
		ItemOpenTicket.setMnemonic('O');
		tickets.add(ItemOpenTicket);
		
		ItemViewTicket = new JMenuItem("View Ticket");
		ItemViewTicket.setMnemonic('V');
		tickets.add(ItemViewTicket);
		
		ItemDeleteTicket = new JMenuItem("Delete Ticket");
		ItemDeleteTicket.setMnemonic('D');
		tickets.add(ItemDeleteTicket);
		
		ItemViewAllTicket = new JMenuItem("View All Tickets");
		ItemViewAllTicket.setMnemonic('V');
		tickets.add(ItemViewAllTicket);
			
		ItemUpdateTicket = new JMenuItem("Update Ticket");
		ItemUpdateTicket.setMnemonic('U');
		tickets.add(ItemUpdateTicket);
		
		ItemCloseTicket = new JMenuItem("Close Ticket");
		ItemCloseTicket.setMnemonic('C');
		tickets.add(ItemCloseTicket);
		// Include more sub menu items below
	
		//add listeners for each desired menu item 
		ItemExit.addActionListener(this);
		ItemOpenTicket.addActionListener(this);
		ItemViewTicket.addActionListener(this);
		ItemViewAllTicket.addActionListener(this);
		ItemCloseTicket.addActionListener(this);
		ItemUpdateTicket.addActionListener(this);
		ItemDeleteTicket.addActionListener(this);
	
		// Add more listeners for any additional sub menu items
	}
 
	private void prepareGUI()
	{ 
		// Initialize the frame object
		mainFrame = new JFrame("Main");
    
		// Create the jmenu bar
		JMenuBar bar = new JMenuBar();
	
		// Set menu orders
		bar.add(file);  
		bar.add(tickets);
	
		// Add menu bar component to frame
		mainFrame.setJMenuBar(bar); 
   
		mainFrame.setSize(400,400);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		// Add desired coding to trigger each sub menu action as examples shown below
		// Exit program
		if(e.getSource() == ItemExit)
		{
			System.exit(0);
		}
	 
		// New ticket
		/* else if(e.getSource() == ItemNew)
	 	{
		 	try
		 	{
			 	Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            Statement statement = dbConn.createStatement();
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
		 
		}*/
		 
		// Open ticket
		else if(e.getSource() == ItemOpenTicket)
		{

			try 
			{
			 	//add a ticket information
				String ticketName = JOptionPane.showInputDialog(null,"Enter your Subject: ");
				String ticketDesc = JOptionPane.showInputDialog(null,"Enter the ticket Description: ");
				String ticketpriority = JOptionPane.showInputDialog(null,"Enter the ticket priority (High, Medium, Low):");

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            int result = statement.executeUpdate("Insert into dbarn_kyan_ticket(ticket_name, ticket_description, ticket_priority) "
	            		+ "values('"+ ticketName +"','"+ ticketDesc +"', '" + ticketpriority + "')");
	            
	            if (result != 0) 
	            {
					System.out.println("Ticket Created Successfully!!!");
				} 
	            
	            else 
				{
					System.out.println("Ticket cannot be Created!!!");
				}
	            
	            // Fill in with id value newly created in table
		        JOptionPane.showMessageDialog(null,"Ticket id: created"); 
		        dbConn.close();   //close connections!!!

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
		
		// View a ticket
		else if(e.getSource() == ItemViewTicket)
		{
			//retrieve ticket information
			//ticketsJDBC dobj = new ticketsJDBC();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            String see= JOptionPane.showInputDialog(null,"What Ticket Would You Like to See?");
	            ResultSet results = statement.executeQuery("SELECT * FROM dbarn_kyan_ticket WHERE ticket_id = '" + see +"' ;");
	            
	            // Use JTable built in functionality to build a table model and display the table model
	            //off a resultset!!!
	            JTable jt = new JTable(ticketsJTable.buildTableModel(results));
	           
	            jt.setBounds(30,40,200,300);
	            sp=new JScrollPane(jt);
	            mainFrame.add(sp);
	            mainFrame.setVisible(true); //repaint frame on screen
	            statement.close();
		        dbConn.close();   //close connections!!!
	            	            

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
	 
		// Close a ticket 
		else if(e.getSource() == ItemCloseTicket)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            Statement statement = dbConn.createStatement();

	            String ID= JOptionPane.showInputDialog(null,"What Ticket is to be closed?");
	            String results = "UPDATE dbarn_kyan_ticket SET ticket_status = 'CLOSED'" +
	            				"WHERE ticket_id = '" + ID + "';";
			    statement.executeUpdate(results);
			    
			    // System.out.println("Ticket Removed Successfully!!!");
				JOptionPane.showMessageDialog(null, "Ticket number "+ ID +" has been Closed Successfully!!!");

		        dbConn.close();   //close connections!!!

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
	 
		// Delete a ticket 
		else if(e.getSource() == ItemDeleteTicket)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
						
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
			                                                               + "user=fp411&password=411");
			    Statement statement = dbConn.createStatement();

	            String ID = JOptionPane.showInputDialog(null, "What Ticket Number would you like to Delete?");

	           // String result1 = JOptionPane.showInputDialog(null,"Are you sure that you want to delete ticket NUMBER " + ID + " ? " + "\n" + "(YES, NO)");
	            
	            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
	            {
	                // yes option
				    String results = "DELETE FROM dbarn_kyan_ticket WHERE ticket_id  = '" + ID + "';";
				    statement.executeUpdate(results);
					
				    // System.out.println("Ticket Removed Successfully!!!");
				    JOptionPane.showMessageDialog(null, "Ticket number "+ ID +" has been Removed Successfully!!!");
	            } 
	            
	            else 
	            {
	                // no option
            		JOptionPane.showMessageDialog(null, "Ticket number "+ ID +" has NOT been Removed Successfully!!!");

	            }
	            
					    
		        dbConn.close();   //close connections!!!
 
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
		
		// Update a ticket
		else if (e.getSource() == ItemUpdateTicket)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
		                                                               + "user=fp411&password=411");
		        Statement statement = dbConn.createStatement();

		        String ud= JOptionPane.showInputDialog(null, "What Ticket ID number would you like to Edit?" );
		        String ud1= JOptionPane.showInputDialog(null, "What is the New Name?" );
		        String ud2= JOptionPane.showInputDialog(null, "What is the New Description?" );
		        String ud3= JOptionPane.showInputDialog(null, "What is the new Status of the ticket? (Closed, Open)" );


		        String results = "UPDATE dbarn_kyan_ticket SET ticket_name = '" + ud1 +"' ," 
		        		+ "ticket_description = '" + ud2 +"', ticket_status = '" + ud3 + "' WHERE ticket_id = '" + ud +"';";
				statement.executeUpdate(results);
		            
				    
		        //String results = "UPDATE kyanticket SET ticket_name = Replace(ticket_name, '" + ud1 + "'" + " " , ";
				//statement.executeUpdate(results);       
		          
				System.out.println("Ticket Updated Successfully!!!");

		        dbConn.close();   //close connections!!!
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
	 
		// View all tickets
		else if(e.getSource() == ItemViewAllTicket)
		{
			//retrieve ticket information
			//ticketsJDBC dobj = new ticketsJDBC();
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            ResultSet results = statement.executeQuery("SELECT * FROM dbarn_kyan_ticket");
	            
	            // Use JTable built in functionality to build a table model and display the table model
	            //off a resultset!!!
	            JTable jt = new JTable(ticketsJTable.buildTableModel(results));
	           
	            jt.setBounds(30,40,200,300);
	            sp=new JScrollPane(jt);
	            mainFrame.add(sp);
	            mainFrame.setVisible(true); //repaint frame on screen
	            statement.close();
		        dbConn.close();   //close connections!!!
	            
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

	// Populate the kyanticket table 5 entries
	public void test() 
	{
		try 
		{
			
			// Delete a ticket 
			// Update a description to 'WH WIFI PROBLEM’
		 	//add a ticket information

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
                                                               + "user=fp411&password=411");
            Statement statement = dbConn.createStatement();
            
			// Add 5 tickets
			// 2 high priority
            String results = "INSERT INTO dbarn_kyan_ticket (ticket_name, ticket_description, ticket_status, ticket_priority) VALUES"
            					+ "('Internet', 'Internet down', 'open', 'high')," 
            					+ "('Blackboard', 'Can not access blackborad on ipad', 'open', 'med')," 
            					+ "('I am lost', 'Can not find room 411', 'closed', 'low')," 
            					+ "('Hungry', 'I want pizza', 'closed', 'low')," 
            					+ "('Email', 'Can not access hawk email', 'open', 'high');" ;

            
            
		    statement.executeUpdate(results);
		    
		    
            // Fill in with id value newly created in table
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
	

	public static void main(String args[])
	{
		new ticketsGUI();
		System.out.println("Ratio of open to closed:" + "" );
		System.out.println("High priority tickets:" + "" );
		System.out.println("Duration of tickets open:" + "" );
	}

}

// What to send 
// Ticket creation 
// All ticket veiw
// Closed ticket notify
// WH WIFI PROBLEM’ and description 
// Ticket delete request 

// Total time tickets existed
// Ratio of closed to open tickets 
// Tickets open with high priority 

// JAR executable file 

// Include also in your Word Doc file an opening description 
// Summarizing your application, its uses, functionality and
// any basic design principles 
// that make your application code worthy!


