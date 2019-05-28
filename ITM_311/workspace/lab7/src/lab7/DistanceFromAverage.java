// This program will have the user enter any number of double values
// up to 20, the program will exit if the user enters 99999, display
// an error message if the user quits without entering any numbers,
// and then it will display each entered value and its distance from
// the average.
// Written by Deborah Barndt

package lab7;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class DistanceFromAverage 
{
	public static void main(String[] args) throws Exception
	{
		String typeNum;		// value entered by the user
		
		int x = 0,			// length of the array
			i;				// the number of values in the array
		
		double numvalue,	// the value entered by the user converted
			   avg,			// the average of the values entered by the user
			   distance,	// the distance between the average and the value entered by user
			   totalsum = 0;	// the sum of the values
		
		JButton btnCancel;	// cancel button in the first dialog box
		
		// Create an Array
		double[] num = new double [20];
		
		//Print 2 decimal places for distance
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea(21, 15);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.black);
		UI.put ("Panel.background", Color.black);
		
		// Text Area headers for columns
		outputArea.append("Value\t Distance\n");
		
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
		
		// For Loop to determine the amount of data inputed by the user
		for (i = 0; i < 20; i++)
		{
			//Prompt the user to enter a value or 99999 to quit
			typeNum = JOptionPane.showInputDialog("Enter a number: (Enter 99999 to quit) ");
			
			try
			{
				numvalue = Double.parseDouble(typeNum);
			}
			
			catch (NumberFormatException ignore)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input", 
						"Failure", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			// Convert type String into type double
			numvalue = Double.parseDouble(typeNum);
						
			// Determine if the user wants to quit or fails to enter a value
			if (numvalue == 99999)
				break;
						
			else
			{
				x = x + 1;
				num[i] = numvalue;
				totalsum = totalsum + num[i];
			}
		}
		
		// For Loop to calculate the sum, the average, and the distance from the average
		for (i = 0; i < x; i++)
		{
			
			avg = totalsum / x;
			distance = avg - num[i];
			
			// Results of the array to be put inside text area
			outputArea.append(num[i] + "\t" + mydf.format(distance) + "\n");
		}
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("https://cdn0.iconfinder.com/data/icons/20-flat-icons/128/calculator.png"));
		
		JOptionPane.showMessageDialog(null, outputArea, 
				"Distance from the Average", JOptionPane.INFORMATION_MESSAGE, icon);		
	}

}
