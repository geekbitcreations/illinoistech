// This program will calculate the user's BMI and return a message
// letting the user know if they are optimal, underweight, or overweight.
// Written by Deborah Barndt

//Import class JOptionPane
import javax.swing.JOptionPane;

//Import class DecimalFormat
import java.text.DecimalFormat;

public class BodyMassIndex 
{
	public static void main(String[] args)
	{
		String weigh,		// the weight string entered by the user
			   heigh,		// the height string entered by the user
			   bmiresult;	// results of the string that will be displayed
		
		int weight;			// the integer weight of the user
					
		double heightinch,	// the user's height converted to inches
		       height,		// the height of the user in feet
		       bmi;			// the body mass index of the user
		
		//Prompt the user to enter their weight
		weigh = JOptionPane.showInputDialog("Enter your weight: ");
						
		//Prompt the user to enter their height
		heigh = JOptionPane.showInputDialog("Enter your height: ");
		
		// Convert the String in to type int
		weight = Integer.parseInt(weigh);
		height = Double.parseDouble(heigh);
		
		// Convert the height from feet to inches
		heightinch = (height * 12);
					
		// Calculate the user's BMI
		bmi = weight * 703 / (heightinch * heightinch);
		
		if (bmi < 18.5)
		{
			//Print 2 decimal places for total cost of order and profit
			DecimalFormat mydf = new DecimalFormat("0.00");
			
			// Initialize bmiresult variable to an empty string
			bmiresult = "";
			bmiresult = "Your calculated BMI is: " + (mydf.format(bmi)) + "\n";
			bmiresult = bmiresult + "Based on your BMI you are underweight." + "\n";
			
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bmiresult, "Body Mass Index", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (bmi > 25)
		{
			//Print 2 decimal places for total cost of order and profit
			DecimalFormat mydf = new DecimalFormat("0.00");
			
			// Initialize bmiresult variable to an empty string
			bmiresult = "";
			bmiresult = "Your calculated BMI is: " + (mydf.format(bmi)) + "\n";
			bmiresult = bmiresult + "Based on your BMI you are overweight." + "\n";
			
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bmiresult, "Body Mass Index", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			//Print 2 decimal places for total cost of order and profit
			DecimalFormat mydf = new DecimalFormat("0.00");
			
			// Initialize bmiresult variable to an empty string
			bmiresult = "";
			bmiresult = "Your calculated BMI is: " + (mydf.format(bmi)) + "\n";
			bmiresult = bmiresult + "Based on your BMI you are at an optimal weight." + "\n";
			
			// Display the results of the string
			JOptionPane.showMessageDialog(null, bmiresult, "Body Mass Index", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
