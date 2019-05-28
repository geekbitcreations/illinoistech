// This program will test the class Book, Fiction, and NonFiction. It will
// get 10 books in fiction or non-fiction, and then display the results.
// Written by Deborah Barndt

package lab10hw10;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class BookArray 
{
	//public final static int library = 10;
	
	public static void main(String[] args) throws Exception
	{
		// Create a Text Area
		JTextArea outputArea = new JTextArea (40, 25);
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.blue);
		UI.put ("Panel.background", Color.blue);
		
		// Create an array of books
		Book read[] = new Book[10];
	
		// Create objects of books
		read[0] = new Fiction("Unwind", 24.99);
		read[1] = new NonFiction("The Diary of a Young Girl", 37.99);
		read[2] = new Fiction("Maze Runner", 24.99);
		read[3] = new NonFiction("The Seven Storey Mountain", 37.99);
		read[4] = new Fiction("Hunger Games", 24.99);
		read[5] = new NonFiction("Outliers: The Story of Success", 37.99);
		read[6] = new Fiction("EverLost", 24.99);
		read[7] = new NonFiction("Wait: The Art of Science of Delay", 37.99);
		read[8] = new Fiction("City of Ashes", 24.99);
		read[9] = new NonFiction("Lost Girls: An Unsolved American Mystery", 37.99);
		
		//For Loop using instanceof operator
		for(int i = 0; i < read.length; ++i)
		{
			outputArea.append("Book: " + read[i].toString() + "\n\n");
		}
		
		// Results displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL
			("http://origin.arstechnica.com/Media/2004/11/8/dl-icon-64.png"));
		
		JOptionPane.showMessageDialog(null, outputArea, 
				"Our Book Titles Include", JOptionPane.INFORMATION_MESSAGE, icon);
	}

}
