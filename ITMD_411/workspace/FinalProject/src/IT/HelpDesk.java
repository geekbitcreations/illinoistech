package IT;
import java.sql.*;

public class HelpDesk 
{
	// GUI for 
	// create a ticket
	// close a ticket
	// View a ticket
	// update a ticket
	// delete a ticket
		// input 5 dif tickets 
		// starter ticket
		// 2 high priority tickets 
		
		// view tickets created
		// close a ticket
			// Ticket #@@ has been closed
		// update 
		// delete a ticket
			// confirmation code
				// sure you  want delete?

	//set up connection to Sql database
    final String driver = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql://www.papademas.net:3306/tickets";
    final static String username = "fp411";
    final static String password = "411";
    static Connection con = null;
    static Statement sta = null;
    
 static void createTable() throws Exception 
	{
		 try
		 {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to a selected database...");
		      con = DriverManager.getConnection("jdbc:mysql://www.papademas.net:3306/tickets","fp411","411");
		      System.out.println("Connected database successfully...");
		      sta = con.createStatement();
		      String sql = "CREATE TABLE k_yan_Login ( " +
		                   " UserName VARCHAR(255), " + 
		                   " Password VARCHAR(255) );" 
		                   ;
		                   
		      String sql1 = "CREATE TABLE k_yan_TroubleTicket ( " +
		                   " TicketNum VARCHAR(255)," +
		                   " TicketDetail VARCHAR(255) ); " 
		                   ;
		                   
		      String sql2 = "CREATE TABLE k_yan_UserDetail ( " +
		                   " Name VARCHAR(255), " +
		                   " Address VARCHAR(225) ); " 
		                   ;		       
		      sta.executeUpdate(sql);
		      sta.executeUpdate(sql1);
		      sta.executeUpdate(sql2);
		      System.out.println("Created table in given database...");
		   }
		 	catch(SQLException se)
		 		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		 		}
		 	catch(Exception e)
		 	{
		      //Handle errors 
		      e.printStackTrace();
		 	}
				finally
				{
		      //finally block used to close resources
					try
					{
						if(sta!=null)
						con.close();
					}
						catch(SQLException se)
						{
							// do nothing
						}
					try
					{
						if(con!=null)
						con.close();
					}
						catch(SQLException se)
						{
							se.printStackTrace();
						}//end finally try
		   }
		   System.out.println("Goodbye!");
	}
}
