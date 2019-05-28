// This program will get the color, height, and price of the candles and
// use get methods for all three fields. It will determine the price of 
// the candles once the height is set, and then display the results.
// Written by Deborah Barndt

package hw9;

public class Candle 
{
	String Color;		// value of the candle's color

	Double Height,		// the height of the candle
	       Price;		// the price of the candle
	
	// This constructor has no parameter
	public Candle()
	{
		this.Color = "";
		Height = 0.00;
		Price = 0.00;
	}
	
	// Setter to retrieve the value of Color
	public void setColor(String Color)
	{
		this.Color = Color;
	}
		
	// Setter to retrieve the value of Height
	public void setHeight(Double Height)
	{
		this.Height = Height;
		this.Price = 2.00 * this.Height;
	}
		
	// Getter to retrieve the value of Color
	public String getColor()
	{
		return this.Color;
	}
		
	// Getter to retrieve the value of Height
	public Double getHeight()
	{
		return this.Height;
	}
	
	// Getter to retrieve the value of Price
	public Double getPrice()
	{
		return this.Price;
	}
}
