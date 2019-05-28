/**
 * Deborah Barndt
 * 10-31-16
 * MaleComparator.java
 * Lab 4
 * This program will compare various fields in the application's data analysis requirements. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.util.Comparator;

public class MaleComparator implements Comparator<BankRecords> 
{
	@Override
	public int compare(BankRecords m1, BankRecords m2) 
	{
		// TODO Auto-generated method stub
		
		// The first sort through the array.
		int result = m1.getSex().compareTo(m2.getSex());
		if (result != 0)  
		{ 
			return result; 
		}
		
		// The second sort through the array.
		result = m1.getCar().compareTo(m2.getCar());
		
		if (result != 0)  
		{ 
			return result; 
		}
				
		// The third sort through the array.
		result = Integer.compare(m1.getChildren(),m2.getChildren());
		
		if (result != 0)  
		{ 
			return result; 
		}
		
		// The fourth sort through the array.
		return m1.getRegion().compareTo(m2.getRegion());
	}

}
