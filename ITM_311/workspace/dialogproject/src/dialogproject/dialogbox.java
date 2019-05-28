// This program will take two integers from the user,
// then display the sum, product, difference, and quotient of the
// two numbers.
// Written by Deborah Barndt

package dialogproject;

// Import class JOptionPane
import javax.swing.JOptionPane;

public class dialogbox 
{
	public static void main(String args[])
	{
		String firstNumber,  	// first string entered by the user
			   secondNumber, 	// second string entered by the user
			   doingMath;		// results string that will be displayed in the dialog box
		
		int num1,				// first number to add
			num2,				// second number to add
			sum,				// sum of num1 and num2
			product,			// product of num1 and num1
			difference,			// difference of num1 and num2
			quotient;			// quotient of num1 and num2
		
		// Read in first number from user as a string
		firstNumber = JOptionPane.showInputDialog("Enter first integer");
		
		// Read in second number from user as a string
		secondNumber = JOptionPane.showInputDialog("Enter second integer");
		
		// Convert the numbers from type String to type int
		num1 = Integer.parseInt( firstNumber );
		num2 = Integer.parseInt( secondNumber );
		
		//Compute the sum, product, difference, and quotient of the two numbers
		sum = num1 + num2;
		product = num1 * num2;
		difference = num1 - num2;
		quotient = num1 / num2;
		
		// Initialize doingMath variable to an empty string
		doingMath = "";
		doingMath = "The sum of " + num1 + " and " + num2 + " = " + sum + "\n";
		doingMath = doingMath + "The product of " + num1 + " and " + num2 + " = " + product + "\n";
		doingMath = doingMath + "The difference between " + num1 + " and " + num2 + " = " + difference + "\n";
		doingMath = doingMath + "The quotient of " + num1 + " and " + num2 + " = " + quotient + "\n";
		
		// Display the results of the string
		JOptionPane.showMessageDialog(null, doingMath, "Results", JOptionPane.INFORMATION_MESSAGE);
	}
}