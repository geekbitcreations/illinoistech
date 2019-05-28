// This program will inherit class building, and will store the number of 
// fire extinguishers and telephones in the rooms. It will use get methods 
// for the two fields, and then display the results.
// Written by Deborah Barndt

package test2;

public class Office extends Building
{
	String toString;	// results to be displayed
	
	int FireExt;		// value of the number of fire extinguishers
	int Telephones;		// value of the number of telephones

	// This constructor has no parameter
	public Office(int Floors, int Rooms, int Feet)
	{
		super.setFloors(Floors);
		super.setRooms(Rooms);
		super.setFeet(Feet);
		FireExt = 0;
		Telephones = 0;
	}
	
	// This constructor has parameters
	public Office(int Floors, int Rooms, int Feet, int Fi, 
		int Te)
	{
		super.setFloors(Floors);
		super.setRooms(Rooms);
		super.setFeet(Feet);
		FireExt = Fi;
		Telephones = Te;
	}

	// Setter to retrieve the value of FireExt
	public void setFireExt(int FireExt)
	{
		this.FireExt = FireExt;
	}

	// Setter to retrieve the value of Telephones
	public void setTelephones(int Telephones)
	{
		this.Telephones = Telephones;
	}
	
	// Getter to retrieve the value of FireExt
	public int getFireExt()
	{
		return this.FireExt;
	}

	// Getter to retrieve the value of Telephones
	public int getTelephones()
	{
		return this.Telephones;
	}
	
	// Method to display the results
	@Override
	public String toString()
	{
		return ("Floors: " + super.getFloors() + " | Rooms: " 
			+ super.getRooms() + " | Square Feet: " + super.getFeet() 
			+ " | Fire Extinguishers: " + getFireExt() + " | Telephones: " 
			+ getTelephones());
	}
}
