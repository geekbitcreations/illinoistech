// This program will get the name, color, and birth year of the horses 
// and then display the results.
// Written by Deborah Barndt

package lab9;

public class Horse 
{
	String Name,	// value of the horse's name
		   Color;	// value of the horse's color
	
	int BirthYear; 	// value of the horse's birth year
	
	// This constructor has no parameter
	public Horse()
	{
		this.Name = "";
		this.Color = "";
		BirthYear = 0;
	}
	
	// Setter to retrieve the value of Name
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	// Setter to retrieve the value of Color
	public void setColor(String Color)
	{
		this.Color = Color;
	}
	
	// Setter to retrieve the value of BirthYear
	public void setBirthYear(int BirthYear)
	{
		this.BirthYear = BirthYear;
	}
	
	// Getter to retrieve the value of Name
	public String getName()
	{
		return this.Name;
	}
	
	// Getter to retrieve the value of Color
	public String getColor()
	{
		return this.Color;
	}
	
	// Getter to retrieve the value of BirthYear
	public int getBirthYear()
	{
		return this.BirthYear;
	}
	
}
