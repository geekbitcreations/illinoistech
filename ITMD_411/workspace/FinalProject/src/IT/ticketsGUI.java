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

/*proj implements one listener and can trigger action off menu item clicked
 * with one action performed event handler!
 */
@SuppressWarnings("serial")
public class ticketsGUI extends JFrame implements ActionListener {

	//needed class level member vars
	private JFrame mainFrame;
	
	//incl main menu objects
	private	JMenu file = new JMenu("File");
	private	JMenu tickets = new JMenu("Tickets");
	JScrollPane sp = null;
	//incl sub menu item objects
	
	JMenuItem ItemNew;
    JMenuItem ItemExit;
    JMenuItem ItemOpenTicket;
    JMenuItem ItemViewTicket;
    JMenuItem ItemCloseTicket;
    JMenuItem ItemUpdateTicket;
	JMenuItem ItemViewaTicket;
    //include more items below
	
	public ticketsGUI() {
		createTable();
		createMenu();
	    prepareGUI();
	}
	
	private void createTable()
	{	
		// vars. for SQL Query create
		  final String createTable = "CREATE TABLE kyanticket(ticket_id INT AUTO_INCREMENT PRIMARY KEY, ticket_name VARCHAR(30), ticket_description VARCHAR(200))";
		  Connection connect = null;
		  Statement statement = null;
				  
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
		              + "user=fp411&password=411");
	 	      
		      //create table
		    
		      statement = connect.createStatement();
		      
		      statement.executeUpdate(createTable);
		      System.out.println("Created table in given database...");

			//end create table
		    //close connection/statement object  
		     statement.close();
		     connect.close();
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());  
		    }  

		
	}
	// The Top tabs
private void createMenu()
{
	//set up mnemonics for main menu items (triggered by alt keys)
	file.setMnemonic('F');
	
	//initialize up sub menu items
	ItemNew = new JMenuItem("New");
	ItemNew.setMnemonic('N');
	file.add(ItemNew);
	
	ItemExit = new JMenuItem("Exit");
	ItemExit.setMnemonic('x');
	file.add(ItemExit);
	
	ItemOpenTicket = new JMenuItem("Open Ticket");
	ItemOpenTicket.setMnemonic('x');
	tickets.add(ItemOpenTicket);
	
	ItemViewTicket = new JMenuItem("View All Ticket");
	ItemViewTicket.setMnemonic('x');
	tickets.add(ItemViewTicket);
	
	ItemViewaTicket = new JMenuItem("View A Ticket");
	ItemViewaTicket.setMnemonic('x');
	tickets.add(ItemViewaTicket);
	
	ItemCloseTicket = new JMenuItem("Close Ticket");
	ItemCloseTicket.setMnemonic('x');
	tickets.add(ItemCloseTicket);
	
	ItemUpdateTicket = new JMenuItem("Update Ticket");
	ItemUpdateTicket.setMnemonic('x');
	tickets.add(ItemUpdateTicket);

	//incl more sub menu items below
	
	//add listeners for each desired menu item 
	ItemExit.addActionListener(this);
	ItemOpenTicket.addActionListener(this);
	ItemViewTicket.addActionListener(this);
	ItemViewaTicket.addActionListener(this);
	ItemCloseTicket.addActionListener(this);
	ItemUpdateTicket.addActionListener(this);
	
	//add more listeners for any additional sub menu items
}
 
private void prepareGUI()
{ 
	//initialize frame object
	mainFrame = new JFrame("Main");
    //create jmenu bar
	JMenuBar bar = new JMenuBar();
	bar.add(file);  //set menu orders
	bar.add(tickets);
	 //add menu bar component to frame
    mainFrame.setJMenuBar(bar); 
   
    mainFrame.setSize(400,400);
	mainFrame.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	//add desired coding to trigger each sub menu action as examples shown below
	// Exit program
	 if(e.getSource() == ItemExit){
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
	            
	            
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 }
*/
	 // Open ticket
	 else if(e.getSource() == ItemOpenTicket){

		 try {
			 
			//add a ticket information
			 String ticketName=
				 JOptionPane.showInputDialog(null,"Enter your name");
			 String ticketDesc=
					 JOptionPane.showInputDialog(null,"Enter a ticket description");
			 
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            int result = statement.executeUpdate("Insert into kyanticket(ticket_name, ticket_description) values('"+ticketName+"','"+ticketDesc+"')");
	            
	            if (result != 0) {
					System.out.println("Ticket Created Successfully!!!");
				} else {
					System.out.println("Ticket cannot be Created!!!");
				}
		 
		        JOptionPane.showMessageDialog(null,"Ticket id: created"); //******fill in with id value newly created in table!******
		    } 
		       catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
		       } catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     }
	 
	 //view a ticket
	 else if(e.getSource() == ItemViewaTicket){
			//retrieve ticket information
			 //ticketsJDBC dobj = new ticketsJDBC();
			 try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            String see= JOptionPane.showInputDialog(null,"What Ticket Would You Like to See?");
	            ResultSet results = statement.executeQuery("SELECT * FROM kyanticket WHERE ticket_id = '" + see +"' ;");
	            
	            // Use JTable built in functionality to build a table model and display the table model
	            //off a resultset!!!
	            JTable jt = new JTable(ticketsJTable.buildTableModel(results));
	           
	            jt.setBounds(30,40,200,300);
	            sp=new JScrollPane(jt);
	            mainFrame.add(sp);
	            mainFrame.setVisible(true); //repaint frame on screen
	            statement.close();
		        dbConn.close();   //close connections!!!
	            	            

			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	     } 	
	 // delete a ticket 
		 else if(e.getSource() == ItemCloseTicket)
	 {
		 try
		 {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            Statement statement = dbConn.createStatement();

	            String ID= JOptionPane.showInputDialog(null,"What is the Unwanted data's ID number?");
	            String results = "DELETE FROM kyanticket WHERE ticket_id = '"+ ID +"';";
			    statement.executeUpdate(results);
			    
			//	System.out.println("Ticket Removed Successfully!!!");
				JOptionPane.showMessageDialog(null, "Ticket number "+ ID +" has been Removed Successfully!!!");

			 
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 }
	 // edit a ticket
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

		            String results = "UPDATE kyanticket SET ticket_name = '" + ud1 +"' ," + "ticket_description = '" + ud2 +"' WHERE ticket_id = '" + ud +"';";
				    statement.executeUpdate(results);
		            
				    
		        //    String results = "UPDATE kyanticket SET ticket_name = Replace(ticket_name, '" + ud1 + "'" + " " , ";
				//    statement.executeUpdate(results);       
		          
					System.out.println("Ticket Updated Successfully!!!");

				 
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		 }
	 // view all tickets
	 else if(e.getSource() == ItemViewTicket){
			//retrieve ticket information
			 //ticketsJDBC dobj = new ticketsJDBC();
			 try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?"
	                                                               + "user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            ResultSet results = statement.executeQuery("SELECT * FROM kyanticket");
	            
	            // Use JTable built in functionality to build a table model and display the table model
	            //off a resultset!!!
	            JTable jt = new JTable(ticketsJTable.buildTableModel(results));
	           
	            jt.setBounds(30,40,200,300);
	            sp=new JScrollPane(jt);
	            mainFrame.add(sp);
	            mainFrame.setVisible(true); //repaint frame on screen
	            statement.close();
		        dbConn.close();   //close connections!!!
	            
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	     } 
}

public class test extends JFrame 
{
	// add 5 tickets
	// 2 high priority
	//  delete a ticket 
	// update a description to 'WH WIFI PROBLEM’

	
}

public static void main(String args[])
{
	new ticketsGUI();
}

}

// what to send 
// ticket creation 
// all ticket veiw
// closed ticket notify
// WH WIFI PROBLEM’ adn description 
// ticket delete request 

// total time tickets existed
// ratio of closed to open tickets 
// tickets open wtih high priority 

// JAR executable file 

//Include also in your Word Doc file an opening description 
//summarizing your application, its uses, functionality and
//any basic design principles 
//that make your application code worthy!


