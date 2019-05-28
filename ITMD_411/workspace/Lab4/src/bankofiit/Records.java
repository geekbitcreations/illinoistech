/**
 * Deborah Barndt
 * 10-31-16
 * Records.java
 * Lab 4
 * This program will extend the BankRecords class, and perform data analysis from the class
 * objects. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Records extends BankRecords
{
	// Create a formatted object to write the output directly to the console and to a file.
    private static FileWriter fw = null;
	
    public Records()
    {
		try 
		{
			fw = new FileWriter("bankrecords.txt");
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) throws MalformedURLException  
	{
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", new ColorUIResource(36, 154, 32));
		UI.put ("Panel.background", new ColorUIResource(138, 201, 136));
		
		// Change the font in the dialog box
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Rockwell", Font.PLAIN, 14)));
		
		// Change the font in the button
		UIManager.put("OptionPane.buttonFont", new Font("Rockwell", Font.BOLD, 14));
		
		BankRecords r = new Records();
		r.readData();
		// Call the analysis functions.  
 
		// Analyze the average income of the clients.
		AverageComparator();
		
		// The maximum and minimum age per location of the clients.
		MaxMinComparator();
		
		// The number of females with mortgages.
	    FemaleComparator();
	    
	    // The number of males with both a car and 1 child per location.
	    MaleComparator();
		
		try 
		{
			fw.close();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
   
	// Define the average comparator.
	private static void AverageComparator() throws MalformedURLException
	{
		double avgincome = 0,	// average income of the clients
			   sumincome = 0;			// sum of the incomes
		
		//Print 2 decimal places for distance
		DecimalFormat mydf = new DecimalFormat("#,##0.00");
		
		// Calculate the average income of the clients.
		for (int i = 0; i < clientInfo.length; i++)
		{
			sumincome += clientInfo[i].getIncome(); 
			avgincome = sumincome / clientInfo.length;
		}
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (20, 40);
					
		// Print the column header
		outputArea.append("The Average Income: $" + mydf.format(avgincome) + "\n\n");
		
		// Program time stamp
		outputArea.append("\n" + "Current date: " + timeStamp + "  " + "\nProgrammed by Deborah Barndt \n");
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://apps.ubuntu.com/site_media/icons/2015/04/qtiplot_24.png"));
		
		// Display with results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Record Analysis", 
				JOptionPane.INFORMATION_MESSAGE, icon);
		
		try 
		{
			fw.write(String.format("The Average Income: $" + avgincome + "%n"));
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	// Define the maximum and minimum comparator.
	private static void MaxMinComparator() throws MalformedURLException
	{
		Arrays.sort(clientInfo, new MaxMinComparator());
		
		int innerCityMax = 0,	// maximum number of inner city clients
			ruralMax = 0,		// maximum number of rural clients
			suburbanMax = 0,	// maximum number of suburban clients
			townMax = 0;		// maximum number of town clients
		
		// Check for the maximum ages per region.
		for (int i = 0; i < clientInfo.length; i++)
		{
			// Check for the inner city maximum value.
			if (clientInfo[i].getRegion().equals("INNER_CITY") && clientInfo[i].getAge() > innerCityMax)
			{
				// Reassign the maximum age value.
				innerCityMax = clientInfo[i].getAge();
			}
			
			// Check for the rural maximum value.
			if (clientInfo[i].getRegion().equals("RURAL") && clientInfo[i].getAge() > ruralMax)
			{
				// Reassign the maximum age value.
				ruralMax = clientInfo[i].getAge();
			}
			
			// Check for the suburban maximum value.
			if (clientInfo[i].getRegion().equals("SUBURBAN") && clientInfo[i].getAge() > suburbanMax)
			{
				// Reassign the maximum age value.
				suburbanMax = clientInfo[i].getAge();
			}
			
			// Check for the town maximum value.
			if (clientInfo[i].getRegion().equals("TOWN") && clientInfo[i].getAge() > townMax)
			{
				// Reassign the maximum age value.
				townMax = clientInfo[i].getAge();
			}
		}
		
		int 	innerCityMin = innerCityMax,	// minimum number of inner city clients
				ruralMin = ruralMax, 			// minimum number of rural clients
				suburbanMin = suburbanMax, 		// minimum number of suburban clients
				townMin = townMax; 				// minimum number of town clients
		
		// Check for the minimum ages per region.
		for (int i = 0; i < clientInfo.length; i++)
		{
			// Check for the inner city minimum value.
			if (clientInfo[i].getRegion().equals("INNER_CITY") && clientInfo[i].getAge() < innerCityMin)
			{
				// Reassign the minimum age value.
				innerCityMin = clientInfo[i].getAge();
			}
			
			// Check for the rural minimum value.
			if (clientInfo[i].getRegion().equals("RURAL") && clientInfo[i].getAge() < ruralMin)
			{
				// Reassign the minimum age value.
				ruralMin = clientInfo[i].getAge();
			}
			
			// Check for the suburban minimum value.
			if (clientInfo[i].getRegion().equals("SUBURBAN") && clientInfo[i].getAge() < suburbanMin)
			{
				// Reassign the minimum age value.
				suburbanMin = clientInfo[i].getAge();
			}
			
			// Check for the town minimum value.
			if (clientInfo[i].getRegion().equals("TOWN") && clientInfo[i].getAge() < townMin)
			{
				// Reassign the minimum age value.
				townMin = clientInfo[i].getAge();
			}
		}
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (20, 40);
					
		// Print the column header
		outputArea.append("Region Maximum Age" + "\n\n");
		
		// Print the maximum results in a text area
		outputArea.append("Inner City: " + innerCityMax + "\n" + "Rural: " + ruralMax + "\n"
				+ "Suburban: " + suburbanMax + "\n" + "Town: " + townMax + "\n\n");
		
		// Print the column header
		outputArea.append("Region Minimum Age" + "\n\n");
		
		// Print the minimum results in a text area
		outputArea.append("Inner City: " + innerCityMin + "\n" + "Rural: " + ruralMin + "\n"
				+ "Suburban: " + suburbanMin + "\n" + "Town: " + townMin + "\n\n");
		
		// Program time stamp
		outputArea.append("\n" + "Current date: " + timeStamp + "  " + "\nProgrammed by Deborah Barndt \n");
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://apps.ubuntu.com/site_media/icons/2015/04/qtiplot_24.png"));
		
		// Display results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Record Analysis", 
				JOptionPane.INFORMATION_MESSAGE, icon);
		
		try
		{
			fw.write(String.format("Inner City Maximum Age: " + innerCityMax + "%n" + "\t"
				+ "Rural Maximum Age: " + ruralMax + "%n" + "\t"
				+ "Suburban Maximum Age: " + suburbanMax + "%n" + "\t"
				+ "Town Region Maximum Age: " + townMax + "%n" + "\n\n"
				+ "Inner City Minimum Age: " + innerCityMin + "%n" + "\t"
				+ "Rural Minimum Age: " + ruralMin + "%n" + "\t"
				+ "Suburban Minimum Age: " + suburbanMin + "%n" + "\t"
				+ "Town Region Minimum Age: " + townMin + "%n" + "\n\n"));
		}
		
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Define the female comparator.	
	private static void FemaleComparator() throws MalformedURLException 
	{	
		// Sort the array
		Arrays.sort(clientInfo, new FemaleComparator());
			
		int fcount = 0;	// number of females with mortgages
		
		// Calculate the number of females with mortgages.
		for (int i = 0; i < clientInfo.length; i++)
		{
			if (clientInfo[i].getSex().equals("FEMALE") && clientInfo[i].getMortgage().equals("YES"))
		    {
				fcount++;
		    }
		}
		
		// Create a Text Area
		JTextArea outputArea = new JTextArea (20, 40);
						
		// Print the results in a text area
		outputArea.append("Number of Females with Mortgages: " + fcount + "  \n\n");
			
		// Program time stamp
		outputArea.append("\n" + "Current date: " + timeStamp + "  " + "\nProgrammed by Deborah Barndt \n");
			
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://apps.ubuntu.com/site_media/icons/2015/04/qtiplot_24.png"));
			
		// Display the results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Record Analysis", 
				JOptionPane.INFORMATION_MESSAGE, icon);
			
		try 
		{
			fw.write(String.format(" Number of Females with Mortgages: " + fcount + "%n"));
		} 
			
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} 
	
	// Define the male comparator.
	private static void MaleComparator() throws MalformedURLException
	{
		// Sort the array
		Arrays.sort(clientInfo, new MaleComparator());
		
		int innercount = 0,		// number of males in the inner city region with both a car and 1 child
			ruralcount = 0,		// number of males in rural region with both a car and 1 child
			suburbcount = 0,	// number of males in suburban region with both a car and 1 child
			towncount = 0;		// number of males in town region with both a car and 1 child
		
		// Calculate the number of males with both a car and 1 child per location.
		for (int i = 0; i < clientInfo.length; i++)
		{
			// Sort through array to find males with a car and 1 child in the inner city region
			if (clientInfo[i].getSex().equals("MALE") && clientInfo[i].getCar().equals("YES") 
					&& clientInfo[i].getChildren() == 1 && clientInfo[i].getRegion().equals("INNER_CITY"))
			{
				innercount++;
			}
			
			// Sort through array to find males with a car and 1 child in the rural region
			if (clientInfo[i].getSex().equals("MALE") && clientInfo[i].getCar().equals("YES") 
					&& clientInfo[i].getChildren() == 1 && clientInfo[i].getRegion().equals("RURAL"))
			{
				ruralcount++;
			}
			
			// Sort through array to find males with a car and 1 child in the suburban region
			if (clientInfo[i].getSex().equals("MALE") && clientInfo[i].getCar().equals("YES") 
					&& clientInfo[i].getChildren() == 1 && clientInfo[i].getRegion().equals("SUBURBAN"))
			{
				suburbcount++;
			}
			
			// Sort through array to find males with a car and 1 child in the town region
			if (clientInfo[i].getSex().equals("MALE") && clientInfo[i].getCar().equals("YES") 
					&& clientInfo[i].getChildren() == 1 && clientInfo[i].getRegion().equals("TOWN"))
			{
				towncount++;
			}
		}
			
		// Create a Text Area
		JTextArea outputArea = new JTextArea (20, 40);
			
		// Print the column header
		outputArea.append("Number of Males with a Car and 1 Child   " + "\n\n");
			
		// Print the results in a text area
		outputArea.append("Inner City: " + innercount + "\n" + "Rural: " + ruralcount + "\n"
				+ "Suburban: " + suburbcount + "\n" + "Town: " + towncount + "\n\n");
			
		// Program time stamp
		outputArea.append("\n" + " Current date: " + timeStamp + "  " + "\nProgrammed by Deborah Barndt \n");
			
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("https://apps.ubuntu.com/site_media/icons/2015/04/qtiplot_24.png"));
			
		// Display the results in a dialog box and to the file.
		JOptionPane.showMessageDialog(null, outputArea.getText(), "Bank of IIT Record Analysis", 
				JOptionPane.INFORMATION_MESSAGE, icon);
			
		try
		{
			fw.write(String.format("Inner City Region Males with a Car and 1 Child: " + innercount + "%n" + "\t"
				+ "Rural Region Males with a Car and 1 Child: " + ruralcount + "%n" + "\t"
				+ "Suburban Region Males with a Car and 1 Child: " + suburbcount + "%n" + "\t"
				+ "Town Region Males with a Car and 1 Child: " + towncount + "%n" + "\n\n"));
		}
			
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
