// This program will test the class Horse and subclass RaceHorse and 
// will call the methods inside class Horse and subclass RaceHorse.
// Written by Deborah Barndt

package lab9;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class DemoHorses 
{
	// The following statement will create two object horses
	public static void main(String[] args) throws Exception
	{
		// Create a Text Area
		JTextArea outputArea = new JTextArea (4, 22);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.darkGray);
		UI.put ("Panel.background", Color.darkGray);
		
		// Constructors for each of the horse objects
		Horse horse1 = new Horse();
		RaceHorse horse2 = new RaceHorse();
		
		// Methods being called for the horse objects
		horse1.setName("Old Paint");
		horse1.setColor("brown");
		horse1.setBirthYear(2009);
		 
		horse2.setName("Champion");
		horse2.setColor("black");
		horse2.setBirthYear(2011);
		horse2.setRaces(4);
		
		// Results to be displayed inside a text area
		outputArea.append(horse1.getName() + " is " + horse1.getColor() 
			+ " and was born in " + horse1.getBirthYear() + "." + "\n");
		outputArea.append(horse2.getName() + " is " + horse2.getColor() 
			+ " and was born in " + horse2.getBirthYear() + "." + "\n");
		outputArea.append(horse2.getName() + " has been in " 
			+ horse2.getRaces() + " races.");
		
		// Results displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL
				("https://cdn2.iconfinder.com/data/icons/sport-ii/94/10-64.png"));
		
		JOptionPane.showMessageDialog(null, outputArea, "Horse Race Information", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}

}
