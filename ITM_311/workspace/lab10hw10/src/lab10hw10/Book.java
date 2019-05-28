// This program will get the book's title and price, then return the title
// and price to display the results given.
// Written by Deborah Barndt

package lab10hw10;

import javax.swing.JTextArea;

public abstract class Book 
{
	String Title;	// title of the book
	
	Double Price;	// price of the book
	
	// Create a Text Area
	JTextArea outputArea = new JTextArea (15, 25);
	
	// This constructor has no parameter
	public void Book()
	{
		Title = "";
		Price = 0.00;
	}
	
	// This constructor has parameters
	public Book(String T, double P)
	{
		Title = T;
		Price = P;
	}
	
	// Setter to retrieve the value of Title
	public void setTitle(String T)
	{
		this.Title = T;
	}
	
	// Abstract Setter to retrieve the value of price
	public abstract void setPrice();
		
	// Getter to retrieve the value of Title
	public String getTitle()
	{
		return this.Title;
	}
	
	// Getter to retrieve the value of Price
	public double getPrice()
	{
		return this.Price;
	}

}
