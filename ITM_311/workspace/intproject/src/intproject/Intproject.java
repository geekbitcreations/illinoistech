package intproject;

import java.util.Scanner;

public class Intproject 
{
	public static void main(String args[])
	{
		// Create a Scanner Project
		Scanner getValue = new Scanner(System.in);
		
		int n1;
		int n2;
		int sum;
		int product;
		int difference;
		
		//Prompt the user to enter an integer
		System.out.print("Enter first integer number: ");
		n1 = getValue.nextInt();
		
		System.out.print("Enter second integer number: ");
		n2 = getValue.nextInt();
		
		//Compute the sum, product, and difference
		sum = n1 + n2;
		product = n1 * n2;
		difference = n1 - n2;
		
		//Display the result
		System.out.println("The sum of " + n1 + " and " + n2 + " = " + sum);
		System.out.println("The product of " + n1 + " and " + n2 + " = " + product);
		System.out.println("The difference between " + n1 + " and " + n2 + " = " + difference);
	}
}