// This program will calculate the gross pay for each of the employees, and ask the user to
// input the hours worked and the rate per hour.
// Written by Deborah Barndt

package hw6;

//Import class net
import java.net.*;

//Import class JOptionPane
import javax.swing.JOptionPane;

//Import class JButton
import javax.swing.JButton;

//Import class JTextArea
import javax.swing.JTextArea;

//Import class swing
import javax.swing.*;

//Import class Color
import java.awt.Color;

//Import class UIManager
import javax.swing.UIManager;

//Import class event
import java.awt.event.*;

//Import class DecimalFormat
import java.text.DecimalFormat;

public class GrossPay 
{
	public static void main(String[] args) throws Exception
	{
		String hours,			// hours string entered by the user
			   wage,			// wage string entered by the user
			   entry;			// variable to continue entries
		
		int hoursworked,		// the user's hours string converted to an integer
			employee = 0,		// number of employees
			overtime;			// number of overtime hours
			
		double totalpay,		// total amount of pay the employee will get
			   rate;			// the usere's wage string converted to an integer
		
		boolean cont = true;	// boolean variable to continue inputing information
		
		JButton btnCancel;		// cancel button in the first dialog box
		
		//Print 2 decimal places for total amount of pay
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		// Create a Text Area
		JTextArea myTextArea = new JTextArea(11, 20);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.yellow);
		UI.put ("Panel.background", Color.yellow);
		
		// Text Area headers for columns
		myTextArea.append("Employee\t Wage\t Total Hours\t Total Pay\n");
		
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
			
		// While Loop to determine the total pay for each employee per hours worked
		while (cont == true)
		{
			//Prompt the user to enter the amount of hours they worked
			hours = JOptionPane.showInputDialog("Enter employee hours worked: ");
											
			//Prompt the user to enter their rate per hour 
			wage = JOptionPane.showInputDialog("Enter employee rate per hour: ");
						
			// Convert the String into type int
			hoursworked = Integer.parseInt(hours);
					
			// Convert the String into type double
			rate = Double.parseDouble(wage);
			
			employee++;
			
			// Calculate employee total pay, show hours worked, and wages
			if (hoursworked <= 40)
				myTextArea.append(employee + "\t" + mydf.format(rate) + "\t" + hoursworked + 
						"\t" + mydf.format(totalpay = hoursworked * rate) + "\n");
			else
			{
				overtime = hoursworked - 40;
				myTextArea.append(employee + "\t" + mydf.format(rate) + "\t" + hoursworked + 
						"\t" + mydf.format(totalpay = overtime * (1.5 * rate) + 40 * rate) + "\n");
			}
			
			// Boolean if/else statement to continue or quit loop
			if (cont == true)
			{
				// Prompt the user to continue to enter employees or quit
				entry = JOptionPane.showInputDialog("Enter another employee? true = yes false = no");
				
				// Convert the String into type boolean
				cont = Boolean.parseBoolean(entry);	
			}
			else if (cont == false)
			{
				break;
			}
		}
		
		// Results of the While Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("https://padgettjax.com/wp-content/uploads/2014/08/payroll_icon-e1407173040481.png"));
				
		JOptionPane.showMessageDialog(null, myTextArea, "Gross Pay", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
