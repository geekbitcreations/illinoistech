// This program will test class Book, Fiction, and NonFiction. Then it will
// create a fiction and non-fiction book, and display the results.
// Written by Deborah Barndt

package lab10hw10;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class UseBook 
{

	public static void main(String[] args) throws Exception
	{
		// Create a Text Area
		JTextArea outputArea = new JTextArea (8, 16);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.blue);
		UI.put ("Panel.background", Color.blue);
		
		// Constructors for each objects
		Fiction fiction1 = new Fiction(null, 0.00);
		NonFiction nonfiction1 = new NonFiction(null, 0.00);
		
		// Change title properties
		fiction1.setTitle("Unwind");
		nonfiction1.setTitle("The Diary of a Young Girl");
		
		// Method to call setPrice
		fiction1.setPrice();
		nonfiction1.setPrice();
		
		outputArea.append("Book: "  + fiction1.toString() + "\n\n");
		outputArea.append("Book: "  + nonfiction1.toString());
		
		// Results displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL
			("http://www.iconhot.com/icon/png/beos/128/library-17.png"));
		
		JOptionPane.showMessageDialog(null, outputArea, 
			"Book Listings", JOptionPane.INFORMATION_MESSAGE, icon);
	}

}
