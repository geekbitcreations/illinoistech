// This program will get the price of a non-fiction book, and 
// return the price.
// Written by Deborah Barndt

package lab10hw10;

import java.text.DecimalFormat;

public class NonFiction extends Book
{
	double Price;	// price of a non-fiction book
	
	//Print 2 decimal places for distance
	DecimalFormat mydf = new DecimalFormat("0.00");
	
	// This constructor has parameters
	public NonFiction(String T, double P) 
	{
		super(T, P);
		Price = P;
	}
	
	// Method to override the super
	@Override
	public void setPrice() 
	{
		this.Price = 37.99;	
	}
	
	// Getter to retrieve the value of Price
	public double getPrice()
	{
		return this.Price;
	}
	
	// Method to display the results
	public String toString()
	{
		return ("Non-Fiction \nTitle: " + super.getTitle() + "\n" 
			+ "Price: $" + mydf.format(getPrice()));
	}
}
