package hw1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Eggs 
{
	public static void main(String args[])
	{
		// Create a Scanner Project
		Scanner getValue = new Scanner(System.in);
		
		int numD;
		int numS;
		int total;
		double totalP;
				
		//Prompt the user to enter number of eggs
		System.out.print("A dozen eggs are $3.25 each. How many would you like to purchase? ");
		numD = getValue.nextInt();
		
		System.out.print("Individual eggs are $.45 each. How many would you like to purchase? ");
		numS = getValue.nextInt();
		
		//Compute the sum of total eggs and total price of the eggs
		total = numD * 12 + numS;
		totalP = (numD * 3.25) + (numS * .45);
		
		//Print 2 decimal places for total price of eggs
		DecimalFormat mydf = new DecimalFormat("0.00");
					
		//Display the result
		System.out.println("You ordered " + total + " eggs. ");
		System.out.println("That's " + numD + " dozen at $3.25 per dozen, and " + numS + " loose eggs at $.45 cents each for a total of $" + (mydf.format(totalP)) + ". ");
	}
}
