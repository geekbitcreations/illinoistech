// This program will calculate what age the child will be when
// their birthday gift money exceeds %1000.
// Written by Deborah Barndt

package lab6;

//Import class JOptionPane
import javax.swing.JOptionPane;

//Import class net
import java.net.*;

//Import class swing
import javax.swing.*;

public class bdaygift 
{
	public static void main(String[] args) throws Exception
	{
		int age = 12;		// Age the child first gets their birthday money
		int gift = 10;		// Starting birthday fund
		
		// While Loop to determine how old the child will be
		while (gift < 1000)
		{
			gift *= 2;
			age++;
			if (gift > 1000) break;
		}
		
		// Results of the For Loop displayed in a dialog box
		final ImageIcon icon = new ImageIcon(new URL("http://www2.psd100.com/ppp/2013/11/0601/Birthday-cake-icon-1106185627.png"));
		
		JOptionPane.showMessageDialog(null,
			"The child will be " + age + " when their birthday gift is"
			+ " greater than $1000."
			+ "\n" + "They will get $" + gift + " on their " + age + " birthday!", "Birthday Fund", 
			JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
