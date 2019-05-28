// This program will get the price of a fiction book, and return the price.
// Written by Deborah Barndt

package lab10hw10;

import java.text.DecimalFormat;

public class Fiction extends Book
{
	double Price;	// price of a fiction book	
	
	//Print 2 decimal places for distance
	DecimalFormat mydf = new DecimalFormat("0.00");
	
	// This constructor has parameters
	public Fiction(String T, double P) 
	{
		super(T, P);
		Price = P;
	}
	
	// Method to override the super
	@Override
	public void setPrice() 
	{
		this.Price = 24.99;		
	}

	// Getter to retrieve the value of Price
	public double getPrice()
	{
		return this.Price;
	}
	
	// Method to display the results
	public String toString()
	{
		return ("Fiction \nTitle: " + super.getTitle() + "\n" 
			+ "Price: $" + mydf.format(getPrice()));
	}
}
