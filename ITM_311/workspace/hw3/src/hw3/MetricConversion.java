// This program will input and integer from the user, pass the value to two methods,
// and then convert the value from inches to centimeters and convert the value from
// gallons to liters.
// Written by Deborah Barndt

package hw3;

// Import class JOptionPane
import javax.swing.JOptionPane;

// Import class event
import java.awt.event.*;

// Import class JButton
import javax.swing.JButton;

public class MetricConversion 
{
	
	public static void main (String args[])
	{
		String metricValue;		// integer entered by the user as a string
		
		int num1;				// string entered by user converted to an integer
		
		JButton btnCancel;		// cancel button in the first dialog box
		
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
		
		// Prompt the user to enter a value for inches
		metricValue = JOptionPane.showInputDialog("Enter an integer: ");
		
		// Convert the numbers from type String to type int
		num1 = Integer.parseInt( metricValue );
		
		// Identify the modules
		Inches(num1);
		Gallons(num1);
	}
	
	// Print the product of the value of the integer in centimeters
	public static void Inches(int num1)
	{
		String convertCent;		// results string that will be displayed in the dialog box
		
		// Initialize convertCent variable to an empty string
		convertCent = "";
		convertCent = "You entered the number " + num1 + " to be converted," + "\n";
		convertCent = convertCent + num1 + " inches equals " + num1 * 2.54 + " centimeters."+ "\n";
		
		// Display the results of the string
		JOptionPane.showMessageDialog(null, convertCent, "Metric Conversion: Inches to Centimeters", 
										JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Print the product of the value of the integer in liters
	public static void Gallons(int num1)
	{
		String convertLiter;	// results string that will be displayed in the dialog box
			
		// Initialize convertCent variable to an empty string
		convertLiter = "";
		convertLiter = "You entered the number " + num1 + " to be converted," + "\n";
		convertLiter = convertLiter + num1 + " gallons equals " + num1 * 3.7854 + " liters."+ "\n";
			
		// Display the results of the string
		JOptionPane.showMessageDialog(null, convertLiter, "Metric Conversion: Gallons to Liters", 
										JOptionPane.INFORMATION_MESSAGE);
	}
}

