// This program will store the number of floors a building has, the number
// of rooms, and its total square footage. It will use get methods for all
// three fields, and then display the results.
// Written by Deborah Barndt

package test2;

public class Building 
{
	String toString;	// results to be displayed
	
	int Floors;			// value of the number of floors
	int	Rooms;			// value of the number of rooms
	int	Feet;			// value of the amount of footage
	
	// This constructor has no parameter
	public Building()
	{
		Floors = 0;
		Rooms = 0;
		Feet = 0;
	}
	
	// This constructor has parameters
	public Building(int F, int R, int Fe)
	{
		Floors = F;
		Rooms = R;
		Feet = Fe;
	}
	
	// Setter to retrieve the value of Floors
	public void setFloors(int Floors)
	{
		this.Floors = Floors;
	}
	
	// Setter to retrieve the value of Rooms
	public void setRooms(int Rooms)
	{
		this.Rooms = Rooms;
	}
	
	// Setter to retrieve the value of Feet
	public void setFeet(int Feet)
	{
		this.Feet = Feet;
	}
	
	// Getter to retrieve the value of Floors
	public int getFloors()
	{
		return this.Floors;
	}
	
	// Getter to retrieve the value of Rooms
	public int getRooms()
	{
		return this.Rooms;
	}
		
	// Getter to retrieve the value of Feet
	public int getFeet()
	{
		return this.Feet;
	}

	// Method to display the results
	public String toString()
	{
		return ("Floors: " + getFloors() + " | Rooms: " + getRooms()
			+ " | Square Feet: " + getFeet());
	}
}
