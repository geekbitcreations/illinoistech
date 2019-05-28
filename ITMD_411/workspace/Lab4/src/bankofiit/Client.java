/**
 * Deborah Barndt
 * 10-31-16
 * Client.java
 * Lab 4
 * This program will create an abstract class Client to allow for three abstract methods the bank needs to process. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Deborah Barndt
 *
 */
public abstract class Client 
{

	/**
	 * 
	 */
	public Client() 
	{
		// TODO Auto-generated constructor stub
	}
	
	// Method to read all the record data from the CSV file in the ArrayList.
	abstract void readData();
	
	// Method to process all the record data from the ArrayList and add the data into each of the instance fields.
	abstract void processData();
	
	// Method to print the first 25 records for various fields to be displayed.
	abstract void printData() throws MalformedURLException;
}
