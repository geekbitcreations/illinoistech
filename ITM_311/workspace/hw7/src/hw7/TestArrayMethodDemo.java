// This program will test the class ArrayMethodDemo and call the
// five methods inside class ArrayMethodDemo.
// Written by Deborah Barndt

package hw7;

import java.awt.Color;

import javax.swing.UIManager;

public class TestArrayMethodDemo 
{

	public static void main(String[] args) throws Exception
	{
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.black);
		UI.put ("Panel.background", Color.black);
		
		ArrayMethodDemo evilArray = new ArrayMethodDemo();
		
		evilArray.allNumbers();
		evilArray.reverseOrder();
		evilArray.sumNumbers();
		evilArray.lowNumbers();
		evilArray.highNumbers();
	}

}
