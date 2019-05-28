// This program will inherit class building, and will store the number of 
// bedrooms and bathrooms. It will use get methods for the two fields, and 
// then display the results.
// Written by Deborah Barndt

package test2;

public class House extends Building
{
	String toString;	// results to be displayed
	
	int Bedrooms;		// value of the number of bedrooms
	int Baths;			// value of the number of bathrooms
	
	// This constructor has no parameter
	public House(int Floors, int Rooms, int Feet)
	{
		super.setFloors(Floors);
		super.setRooms(Rooms);
		super.setFeet(Feet);
		Bedrooms = 0;
		Baths = 0;
	}
	
	// This constructor has parameters
	public House(int B, int Ba)
	{
		super.setFloors(Floors);
		super.setRooms(Rooms);
		super.setFeet(Feet);
		Bedrooms = B;
		Baths = Ba;
	}
	
	// Setter to retrieve the value of Bedrooms
	public void setBedrooms(int Bedrooms)
	{
		this.Bedrooms = Bedrooms;
	}
	
	// Setter to retrieve the value of Baths
	public void setBaths(int Baths)
	{
		this.Baths = Baths;
	}
		
	// Getter to retrieve the value of Bedrooms
	public int getBedrooms()
	{
		return this.Bedrooms;
	}
	
	// Getter to retrieve the value of Baths
	public int getBaths()
	{
		return this.Baths;
	}
	
	// Method to display the results
	@Override
	public String toString()
	{
		return ("Floors: " + super.getFloors() + " | Rooms: " 
			+ super.getRooms() + " | Square Feet: " + super.getFeet() 
			+ " | Bedrooms: " + getBedrooms() + " | Baths: " + getBaths());
	}
}
