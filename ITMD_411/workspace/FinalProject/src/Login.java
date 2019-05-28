import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Deborah Barndt & Kenneth Yan
 * 11-22-16
 * Login.java
 * IT
 * This program will ask the user to enter their username and password in order to
 * access the ticket system.
 * Written by Deborah Barndt. */

public class Login 
{
	    private JFrame mainFrame;		// the main frame of the GUI
	    private JLabel headerLabel;		// the header label of the GUI
	    private JLabel statusLabel;		// the status label of the GUI
	    private JPanel controlPanel;	// the control panel of the GUI
	    
	    public Login()
	    {
	        prepareGUI();
	    }
	    
	    public static void main(String[] args)
	    {
	        Login login = new Login();
	        login.showTextField();
	    }
	    
	    private void prepareGUI()
	    {
	        mainFrame = new JFrame("Geekbit Tech Support Login");
	        mainFrame.setSize(400, 400);
	        mainFrame.setLayout(new GridLayout(3, 1));
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
	        headerLabel.setText("Welcome to the Geekbit Tech Support.");
	        
	        JLabel  nameLabel= new JLabel("Username: ", JLabel.RIGHT);
	        JLabel  passwordLabel = new JLabel("Password: ", JLabel.RIGHT);
	        final JTextField userText = new JTextField(6);
	        final JPasswordField passwordText = new JPasswordField(6);
	        
	        // Create a login button
	        JButton loginButton = new JButton("Login");
	        
	        // Create an event for the login button
	        loginButton.addActionListener(new ActionListener() 
	        {
	        	
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) 
	            {
	                
	                /*check for correct password/username
	                 *include a desired 'hardcoded' username /password to verify against
	                 *user input values for both username & password fields
	                 *give popup message if either username or password is incorrect
	                 */
	            	if (userText.getText().equals("mister") && 
	            			 passwordText.getText().equals("jim"))
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
			
	        
	        controlPanel.add(nameLabel);
	        controlPanel.add(userText);
	        controlPanel.add(passwordLabel);       
	        controlPanel.add(passwordText);
	        controlPanel.add(loginButton);
	        mainFrame.setVisible(true);  
	   }
}
