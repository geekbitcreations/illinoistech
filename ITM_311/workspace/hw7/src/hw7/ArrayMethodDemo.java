// This program will call five methods that will display all the integers,
// all the integers in reverse order, the sum of the integers, all the values
// less than a limiting argument, and all the values that are higher than the
// calculated average value.
// Written by Deborah Barndt

package hw7;

import java.awt.Color;
import java.net.URL;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ArrayMethodDemo 
{
	static String pickNum;		// number entered by the user
	
	static int totalsum = 0,	// the sum of the values
			   i,				// the number of values in the array
			   x = 0,			// length of the array
			   someNum;			// the value entered by the user converted
	
	static double avg = 0;		// the average of the values entered by the user
	
	// Create an array with 10 elements
	static int[] demo = {2, 3, 4, 5, 10, 14, 19, 20, 33, 82};
	
	// Create a Text Area
	static JTextArea outputArea1 = new JTextArea(3,20);
	static JTextArea outputArea2 = new JTextArea(3,20);
	static JTextArea outputArea3 = new JTextArea(2,20);
	static JTextArea outputArea4 = new JTextArea(4,20);
	static JTextArea outputArea5 = new JTextArea(4,20);
	
	// Method to display all the integers
	public static void allNumbers() throws Exception
	{
		// Text Area headers for columns
		outputArea1.append("All the numbers in the array are\n");
		
		for (int i = 0; i < 10; i++)
		{
			// Results of the array to be put inside text area
			outputArea1.append(demo[i] + " ");
		}	
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://findicons.com/files/icons/2198/dark_glass/128/package_games_arcade.png"));
		
		JOptionPane.showMessageDialog(null, outputArea1, "All Numbers", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	// Method to display all integers in reverse order
	public static void reverseOrder() throws Exception
	{
		// Text Area headers for columns
		outputArea2.append("All the numbers in reverse order are\n");
		
		for (int i = 9; i >= 0; i--)
		{
			// Results of the array to be put inside text area
			outputArea2.append(demo[i] + " ");
		}	
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://findicons.com/files/icons/2198/dark_glass/128/package_games_arcade.png"));
		
		JOptionPane.showMessageDialog(null, outputArea2, "Reverse Order", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	// Method to display the sum of the integers
	public static void sumNumbers() throws Exception
	{
		// Text Area headers for columns
		outputArea3.append("The sum of the integers is ");
			
		for (int i = 0; i < 1; i++)
		{
			int totalsum = IntStream.of(demo).sum();
			
			// Results of the array to be put inside text area
			outputArea3.append(totalsum + ".");
		}	
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://findicons.com/files/icons/2198/dark_glass/128/package_games_arcade.png"));
		
		JOptionPane.showMessageDialog(null, outputArea3, "Sum of the Values", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	// Method to display all values less than the limiting argument
	public static void lowNumbers() throws Exception
	{
		//Prompt the user to enter a value or quit
		pickNum = JOptionPane.showInputDialog("Enter a number between 1-90: ");
		
		// Convert type String into type int
		someNum = Integer.parseInt(pickNum);
		
		// Text Area headers for columns
		outputArea4.append("The limiter given is " + someNum + "." 
				+ "\n" + "Numbers less than the limiter are:" + "\n");
		
		for (int i = 0; i < demo.length; i++ )
		{
			if (demo[i] < someNum)
			{
				// Results of the array to be put inside text area
				outputArea4.append(demo[i] + " ");
			}
		}	
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://findicons.com/files/icons/2198/dark_glass/128/package_games_arcade.png"));
		
		JOptionPane.showMessageDialog(null, outputArea4, "Values less than the Limiter Given", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	// Method to display all values higher than the average
	public static void highNumbers() throws Exception
	{
		for (i = 0; i < demo.length; i++)
		{
			totalsum = totalsum + demo[i];
		}
		
		double avg = (double) totalsum / demo.length;
		
		// Text Area headers for columns
		outputArea5.append("The average of the numbers is " + avg
			+ "." + "\n" + "Numbers higher than the average: " + "\n");
					
		for (i = 0; i < (demo.length); i++)
		{
			if (demo[i] > avg)
			{
				// Results of the array to be put inside text area
				outputArea5.append(demo[i] + " ");
			}	
		}	
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://findicons.com/files/icons/2198/dark_glass/128/package_games_arcade.png"));
		
		JOptionPane.showMessageDialog(null, outputArea5, "Values higher than the Average", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
}
