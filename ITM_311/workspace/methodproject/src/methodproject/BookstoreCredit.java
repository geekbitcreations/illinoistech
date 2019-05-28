// This program will prompt the user for their name and grade point average,
// then it will calculate the bookstore credit they have earned based on their
// grade point average. The program will then display a message with the
// student's name, grade point average, and the bookstore credit.
// Written by Deborah Barndt

package methodproject;

//Import class JOptionPane
import javax.swing.JOptionPane;

//Import class Scanner
import java.util.Scanner;

//Import class DecimalFormat
import java.text.DecimalFormat;

public class BookstoreCredit 
{
	public static void main (String args[])
	{
		// Create a Scanner Project
		Scanner bc = new Scanner(System.in);
	
		String studentName,
			   grades;
			   	
		double gpa;
	
		//Prompt the user to enter their name
		studentName = JOptionPane.showInputDialog("Enter your first name: ");
				
		//Prompt the user to enter their GPA
		grades = JOptionPane.showInputDialog("Enter your GPA: ");
		
		// Convert grades into a double
		gpa = Double.parseDouble(grades);
			
		// Identify the module
		Credit(studentName, gpa);
	}
	
	// Calculate the user's bookstore credit
	public static void Credit(String studentName, double gpa)
	{
		String storeCredit;
		
		//Print 2 decimal places for total cost of order and profit
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		// Initialize storeCredit variable to an empty string
		storeCredit = "";
		storeCredit = "Hello " + studentName + "." + "\n";
		storeCredit = storeCredit + "Based on your GPA of " + gpa + ", " + "\n";
		storeCredit = storeCredit + "you will receive a store credit of $" + (mydf.format(gpa * 10)) + " at the bookstore." + "\n";
		
		// Display the results of the string
		JOptionPane.showMessageDialog(null, storeCredit, "Bookstore Credit Available", JOptionPane.INFORMATION_MESSAGE);
	}
}
