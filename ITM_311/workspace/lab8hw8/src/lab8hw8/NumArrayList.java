// This program will ask the user for 10 numbers and load them into Java
// ArrayList, sort the array in ascending order and display all the values,
// the smallest value, the largest value, the sum, and the average.
// Written by Deborah Barndt

package lab8hw8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class NumArrayList 
{
	public static void main(String[] args) throws Exception
	{
		String randomNum;		// input entered by the user
		
		int sum = 0,			// sum of the values 
			value,				// the value entered by the user converted
			i,					// the number of values in the array
			minimum = 0,		// the smallest value
			maximum = 0;		// the largest value
		
		double avg = 0;			// the average of the values
		
		final int limit = 10; 	// number of values in the array
		
		JButton btnCancel;	// cancel button in the first dialog box
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (11, 22);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.black);
		UI.put ("Panel.background", Color.black);
		
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
				
		// Create an ArrayList of 10 numbers
		ArrayList<Integer> numbers = new ArrayList<>();
		
		//Print 2 decimal places for distance
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		//For loop to get the values from the user
		for (int x = 0; x < limit; x++)
		{
			// Prompt the user to enter 10 values in put in ArrayList
			randomNum = JOptionPane.showInputDialog("Enter an integer: ");
						
			// Convert String to type Int
			value = Integer.parseInt(randomNum);
			numbers.add(value);
			Collections.sort(numbers);
			
			// Minimum and maximum values in the array
			minimum = Collections.min(numbers);
			maximum = Collections.max(numbers);
			
			for (i = 0; i < numbers.size(); i++)
			{
				// Sum of the values
				sum = numbers.stream().mapToInt(Integer :: intValue).sum();
				
				// Average of the values
				avg = (double) sum / numbers.size();
			}
			
		}
		
		// Results of the array to be put in a Text Area
		outputArea.append("Sorted Number Array in ascending order: \n"
				+ numbers + "\n\n");
		outputArea.append("The smallest value in the array is " + minimum 
				+ "." + "\n\n");
		outputArea.append("The largest value in the array is " + maximum 
				+ "." + "\n\n");
		outputArea.append("The sum of the values is " + sum + "." + "\n\n");
		outputArea.append("The average of the values is " 
				+ mydf.format(avg) + ".");
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL
				("http://images.clipartlogo.com/files/ss/thumb/114/114709141/halloween-icon-devil_small.jpg"));
		
		JOptionPane.showMessageDialog(null, outputArea, "Array List", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
