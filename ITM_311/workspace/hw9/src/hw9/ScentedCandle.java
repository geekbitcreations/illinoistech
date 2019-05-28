// This program will get the scent of the candles, and override the parent's
// setHeight() method to set the price of a ScentedCandle object at $3 per
// inch. The results will then be displayed.
// Written by Deborah Barndt

package hw9;

public class ScentedCandle extends Candle
{
	String Scent;	// value of the scent of the candle
	
	Double Price;	// value of the price of a scented candle
	
	// This constructor has no parameter
	public ScentedCandle()
	{
		this.Scent = "";
		Price = 0.00;
	}
	
	// Setter to retrieve the value of Scent
	public void setScent(String Scent)
	{
		this.Scent = Scent;
	}
	
	// Setter to retrieve the value of Height
	public void setHeight(Double Height)
	{
		this.Height = Height;
		this.Price = 3.00 * this.Height;
	}
	
	// Getter to retrieve the value of Scent
	public String getScent()
	{
		return this.Scent;
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
