package IT;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Deborah Barndt & Kenneth Yan
 * 11-22-16
 * Login.java
 * IT
 * This program will ask the user to enter their username and password in order to
 * access the ticket system.
 * Written by Deborah Barndt & Kenneth Yan. */

public class Login extends Tickets
{
		private JFrame mainFrame;		// the main frame of the GUI
	    private JLabel headerLabel;		// the header label of the GUI
	    private JLabel statusLabel;		// the status label of the GUI
	    private JPanel controlPanel;	// the control panel of the GUI
	    
	    public Login() throws MalformedURLException
	    {
	        prepareLoginGUI();
	    }
	    
	    public static void main(String[] args) throws MalformedURLException
	    {
	    	// Change the color of the background of the dialog box
	    	UIManager UI = new UIManager();
	    	UI.put ("OptionPane.background", new ColorUIResource(118, 122, 152));
	    						
	    	// Change the color of the panel background of the dialog box
	    	UIManager.put ("Panel.background", new ColorUIResource(241, 235, 228));
	    						
	    	// Change the color of the scroll bar background of the dialog box
	    	UIManager.put ("ScrollBar.background", new ColorUIResource(241, 235, 228));
	    						
	    	// Change the color of the text area background of the dialog box
	    	UIManager.put ("TextArea.background", new ColorUIResource(241, 235, 228));
	    						
	    	// Change the color of the table headers background of the dialog box
	    	UIManager.put ("TableHeader.background", new ColorUIResource(118, 122, 152));
	    						
	    	// Change the color of the table background of the dialog box
	    	UIManager.put ("Table.background", new ColorUIResource(241, 235, 228));
	    					
	    	// Change the font in the dialog box
	    	UIManager.put ("OptionPane.messageFont", new FontUIResource(new Font("Coda", Font.PLAIN, 14)));	
	    						
	    	// Change the font in the dialog box
	    	UIManager.put ("TextArea.font", new FontUIResource(new Font("Coda", Font.PLAIN, 14)));
	    						
	    	// Change the font in the button
	    	UIManager.put("OptionPane.buttonFont", new Font("Coda", Font.BOLD, 14));
	    						
	    	// Change the font in the dialog box
	    	UIManager.put ("OptionPane.messageFont", new FontUIResource(new Font("Coda", Font.PLAIN, 14)));
	    						
	    	// Change the font in the table
	    	UIManager.put("TableHeader.font", new Font("Coda", Font.BOLD, 14));
	    						
	    	// Change the font in the table box
	    	UIManager.put ("Table.font", new FontUIResource(new Font("Coda", Font.PLAIN, 14)));
	    				
	    	// Change the font in the label
	    	UIManager.put ("Label.font", new FontUIResource(new Font("Coda", Font.PLAIN, 14)));
	    				
	    	// Change the font in the table box
	    	UIManager.put ("Button.font", new FontUIResource(new Font("Coda", Font.BOLD, 14)));
	    	
	    	Login login = new Login();
	        login.showTextField();
	    }
	    
	    private void prepareLoginGUI()
	    {
	        try
	        {
	        	String host = "com.mysql.jdbc.Driver";
	        	String uName = "fb411";
	        	String uPass = "411";
	        	
	        	Connection con = (Connection) DriverManager.getConnection(host, uName, uPass);
	        	
	        	Statement stmt = (Statement) con.createStatement();
	        	String SQL = "SELECT * FROM dbarn_kyan_login";
	        	ResultSet rs = stmt.executeQuery(SQL);
	        	
	        	rs.next();
	        	String user = rs.getString("User");
	        	String pass = rs.getString("Password");   
	        	
	        	
	        }
	        
	        catch (SQLException err)
	        {
	        	System.out.println(err.getMessage());
	        }
	    	
	    	mainFrame = new JFrame("Geekbit IT Help Desk Login");
	        mainFrame.setSize(400, 400);
	        mainFrame.setLayout(new GridLayout(4, 1));
	        mainFrame.addWindowListener(new WindowAdapter() 
	        {
	            public void windowClosing(WindowEvent wE)
	            {
	                System.exit(0);
	            }
	        });
	        
	        headerLabel = new JLabel("", JLabel.CENTER);
	        statusLabel = new JLabel("",JLabel.CENTER);
	        
	        statusLabel.setSize(350,100);
	        
	        controlPanel = new JPanel();
	        controlPanel.setLayout(new FlowLayout());
	        
	        mainFrame.add(headerLabel);
	        mainFrame.add(controlPanel);
	        mainFrame.add(statusLabel);
	        mainFrame.setVisible(true);
	    }
	    
	    private void showTextField()
	    {
	        headerLabel.setText("Welcome to the Geekbit IT Help Desk.");
	        	        
	        JLabel  nameLabel= new JLabel("Username: ", JLabel.RIGHT);
	        JLabel  passwordLabel = new JLabel(" Password: ", JLabel.RIGHT);
	        final JTextField userText = new JTextField(20);
	        final JPasswordField passwordText = new JPasswordField(20);
	        
	        // Create a login button
	        JButton loginButton = new JButton("Login");
	         
	        // Create a Button project
			JButton btnCancel = new JButton("Cancel");
			
			// Create an event to activate the cancel button
			btnCancel.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	                System.exit(0);
	            }
	        });
	        
			// Create an event for the login button
	        loginButton.addActionListener(new ActionListener() 
	        {
	        	
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) 
	            {
	                
	                /*Check for correct password/username
	                 *include a desired 'hardcoded' username /password to verify against
	                 *user input values for both username & password fields
	                 *give popup message if either username or password is incorrect
	                 */
	            	if (userText.getText().equals("jpapa") && 
	            			 passwordText.getText().equals("thegodfather"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("kyan") && 
	            			 passwordText.getText().equals("javarocks"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("dbarndt") && 
	            			 passwordText.getText().equals("designguru"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("mengland") && 
	            			 passwordText.getText().equals("techsavy"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("lmchugh") && 
	            			 passwordText.getText().equals("networking"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("jjerger") && 
	            			 passwordText.getText().equals("serverboss"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else if (userText.getText().equals("lfitzpatrick") && 
	            			 passwordText.getText().equals("winteriscoming"))
	            	{
	            		
	            	    // Close the login window
	            		mainFrame.dispose();
	            		//open up Records file upon successful login
	                  //  new JTableEx();
	            		
	            	}
	            	
	            	else
	            	{
	            		// Display an error to enter the correct username and password.
	            		String message = "Enter correct username\n and/or password";
	            		JOptionPane.showMessageDialog(null, message);
	            	}
	            }
	        });
			
	               
	        controlPanel.add(nameLabel);
	        controlPanel.add(userText);
	        controlPanel.add(passwordLabel);       
	        controlPanel.add(passwordText);
	        controlPanel.add(loginButton);
	        controlPanel.add(btnCancel);
	        mainFrame.setVisible(true);  
	   }
}
