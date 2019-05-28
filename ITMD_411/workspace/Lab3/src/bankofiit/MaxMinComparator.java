/**
 * Deborah Barndt
 * 10-17-16
 * MaxMinComparator.java
 * Lab 3
 * This program will compare various fields in the application's data analysis requirements. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMinComparator implements Comparator<BankRecords>
{
	@Override
	public int compare(BankRecords r1, BankRecords r2) 
	{
		// TODO Auto-generated method stub
		
		// The first sort through the array.
		int result = r1.getRegion().compareTo(r2.getRegion());
		if (result !=0)  
		{ 
			return result; 
		}
		
		// The second sort through the array.
		return Integer.compare(r1.getAge(),r2.getAge());
	}

}
