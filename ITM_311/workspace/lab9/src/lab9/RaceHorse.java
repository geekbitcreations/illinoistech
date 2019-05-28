// This program will get the number of races in which the horse has 
// competed, and then display the results.
// Written by Deborah Barndt

package lab9;

public class RaceHorse extends Horse
{
	int Races;	// the number of races in which the horse has competed
	
	// This constructor has no parameter
	public RaceHorse()
	{
		Races = 0;
	}
	
	// Setter to retrieve the value of Races
	public void setRaces(int Races)
	{
		this.Races = Races;
	}
	
	// Getter to retrieve the value of Races
	public int getRaces()
	{
		return this.Races;
	}
}
