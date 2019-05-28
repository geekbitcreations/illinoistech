// This program will test the class Candle and subclass ScentedCandle, 
// and will call the methods inside class Candle and subclass ScentedCandle.
// Then the results will be displayed inside a dialog box.
// Written by Deborah Barndt

package hw9;

import java.awt.Color;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class DemoCandles 
{

	public static void main(String[] args) throws Exception
	{
		//Print 2 decimal places for distance
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (5, 40);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.pink);
		UI.put ("Panel.background", Color.pink);
		
		// Constructors for each of the candle objects
		Candle candle1 = new Candle();
		Candle candle2 = new Candle();
		ScentedCandle candle3 = new ScentedCandle();
		ScentedCandle candle4 = new ScentedCandle();
						
		// Methods being called for the candle objects
		candle1.setColor("green");
		candle1.setHeight(2.25);
				
		candle2.setColor("blue");
		candle2.setHeight(3.50);
						 
		candle3.setColor("purple");
		candle3.setScent("lavender");
		candle3.setHeight(4.75);
				
		candle4.setColor("pink");
		candle4.setScent("rose");
		candle4.setHeight(3.25);
					 
		// Results to be displayed inside a text area
		outputArea.append("The " + candle1.getColor() + " candle is " 
				+ candle1.getHeight() + " inches tall, and costs $" 
				+ mydf.format(candle1.getPrice()) + "." + "\n");
		outputArea.append("The " + candle1.getColor() + " candle is " 
				+ candle2.getHeight() + " inches tall, and costs $" 
				+ mydf.format(candle2.getPrice()) + "." + "\n");
		outputArea.append("The " + candle3.getColor() + " candle is " 
				+ candle3.getScent() + " scented and is " 
				+ candle3.getHeight() + " inches tall, and costs $" 
				+ mydf.format(candle3.getPrice()) + "." + "\n");
		outputArea.append("The " + candle4.getColor() + " candle is " 
				+ candle3.getScent() + " scented and is " 
				+ candle4.getHeight() + " inches tall, and costs $" 
				+ mydf.format(candle4.getPrice()) + "." + "\n");
		
		// Results displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL
			("https://cdn2.iconfinder.com/data/icons/wedding-3/48/candle-128.png"));
				
		JOptionPane.showMessageDialog(null, outputArea, 
			"Candle Purchase Information", JOptionPane.INFORMATION_MESSAGE, 
			icon);
		
	}

}
