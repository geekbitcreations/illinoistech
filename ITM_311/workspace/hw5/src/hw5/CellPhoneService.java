// This program will take information from the user on their cell phone service,
// and return a recommendation on the best plan for the user using the values given. 
// Written by Deborah Barndt

package hw5;

//Import class JOptionPane
import javax.swing.JOptionPane;

//Import class event
import java.awt.event.*;

//Import class JButton
import javax.swing.JButton;

public class CellPhoneService 
{

	public static void main(String[] args) 
	{
		String minute,		// minutes used string entered by the user
			   message,		// messages sent string entered by the user
			   data,		// data used string entered by the user
			   bestPlan;	// results of the string that will be displayed to user
		
		int minuteuse,		// the user's minutes used string converted to an integer
			messagesent,	// the user's messages sent string converted to an integer
			datause;		// the user's data used string converted to an integer
		
		JButton btnCancel;	// cancel button in the first dialog box
		
		// Create a Button project
		btnCancel = new JButton("Cancel");
		
		// Create an event to activate the cancel button
		btnCancel.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
		
		//Prompt the user to enter the amount of talk minutes they use
		minute = JOptionPane.showInputDialog("Enter the amount of talk minutes you use: ");
								
		//Prompt the user to enter the amount of text messages they send
		message = JOptionPane.showInputDialog("Enter the amount of text messages you send: ");
		
		//Prompt the user to enter the the amount of data they use
		data = JOptionPane.showInputDialog("Enter the amount of gigabytes of data you use: ");
		
		// Convert the String in to type int
		minuteuse = Integer.parseInt(minute);
		messagesent = Integer.parseInt(message);
		datause = Integer.parseInt(data);
		
		if (minuteuse < 500 && datause == 0 && messagesent == 0)
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan A at $49 per month. " + "\n";
									
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (minuteuse < 500 && messagesent > 0 && datause == 0)
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan B for $55 per month. " + "\n";
									
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (minuteuse >= 500 && messagesent < 100 && datause == 0)
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan C for up to " + "\n";
			bestPlan = bestPlan + "100 text messages at $61 per month. " + "\n";
						
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (minuteuse >= 500 && messagesent >= 100  && datause == 0)
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan D for a 100 " + "\n";
			bestPlan = bestPlan + "text messages or more at $70 per month. " + "\n";
			
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (datause < 2)
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan E for " + "\n";
			bestPlan = bestPlan + "up to 2 gb of data at $79 per month. " + "\n";
									
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			// Initialize bestPlan variable to an empty string
			bestPlan = "";
			bestPlan = "You entered that you use " + minuteuse + " minutes, " + "\n";
			bestPlan = bestPlan + messagesent + " text messages, and " + 
						datause + " gb of data per month. " + "\n";
			bestPlan = bestPlan + "The best plan for you is Plan F for " + "\n";
			bestPlan = bestPlan + "2 gb or more of data at $87 per month." + "\n";
						
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bestPlan, "Recommended Cell Phone Plan", 
											JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
