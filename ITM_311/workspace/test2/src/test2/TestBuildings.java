// This program will test the class Building and subclasses House and 
// Office, and will call the methods inside superclass and the subclasses. 
// Then the  results will be displayed inside a dialog box.
// Written by Deborah Barndt

package test2;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class TestBuildings
	{
		public static void main(String[] args) throws Exception
		{
			// Create a Text Area
			JTextArea outputArea = new JTextArea (25, 52);
						
			// Change the color of the background of the dialog box
			UIManager UI = new UIManager();
			UI.put ("OptionPane.background", Color.blue);
			UI.put ("Panel.background", Color.blue);
			
			// Constructors for each of the building objects
			Building building1 = new Building(1, 10, 6000);
			Building building2 = new Building();
			
			outputArea.append("Building constructed  " 
				+ building1.toString() + "\n");
			outputArea.append("Building constructed  " 
				+ building2.toString() + "\n\n");
			
			// Constructors for each of the house objects
			House house1 = new House(1, 5, 3000);
			House house2 = new House(2, 2);
			House house3 = new House(0, 0);
			
			// Change house properties
			house2.setFloors(1);
			house2.setRooms(4);
			house3.setFloors(1);
			house3.setRooms(4);
						
			outputArea.append("Building constructed  " + house1.toString() 
				+ "\n");
			outputArea.append("House constructed  " + house1.toString() 
				+ "\n\n");
			outputArea.append("Building constructed  " + house3.toString() 
				+ "\n");
			outputArea.append("House constructed  " + house2.toString() 
				+ "\n\n");
			
			// Constructors for each of the office objects
			Office office1 = new Office(1, 2, 15000);
			Office office2 = new Office(2, 6, 15000, 6, 30);
			Office office3 = new Office(2, 6, 15000);
			
			outputArea.append("Building constructed  " + office1.toString() 
				+ "\n");
			outputArea.append("Office constructed  " + office1.toString() 
				+ "\n\n");
			outputArea.append("Building constructed  " + office3.toString() 
				+ "\n");
			outputArea.append("Office constructed  " + office2.toString() 
				+ "\n\n");
	
			//change building properties
			building2.setFloors(3);
			building2.setRooms(12);
			building2.setFeet(20000);
			
			outputArea.append("Building 2: \n" + building2.toString() 
			+ "\n\n");
	
			//change house properties
			house1.setBedrooms(3);
			house1.setBaths(3);
			house2.setFloors(2);
			house2.setRooms(10);
			house2.setFeet(4200);
			
			outputArea.append("House 1: \n" + house1.toString() + "\n\n");
			outputArea.append("House 2: \n" + house2.toString() + "\n\n");
	
			//change office properties
			office1.setFireExt(4);
			office1.setTelephones(50);
			
			outputArea.append("Office 1: \n" + office1.toString() 
			+ "\n");
			
			// Results displayed in a dialog box
			final ImageIcon icon = new ImageIcon(new URL
				("http://b.dryicons.com/images/icon_sets/architecture_blueprint_icons_set/png/128x128/building.png"));
			
			JOptionPane.showMessageDialog(null, outputArea, 
				"Building Specifications", JOptionPane.INFORMATION_MESSAGE,
				icon);
	
		} 
	} 
