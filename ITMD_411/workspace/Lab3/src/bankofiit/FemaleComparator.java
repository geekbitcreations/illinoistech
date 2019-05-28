/**
 * Deborah Barndt
 * 10-17-16
 * FemaleComparator.java
 * Lab 3
 * This program will compare various fields in the application's data analysis requirements. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.util.Comparator;

public class FemaleComparator implements Comparator<BankRecords>
{
	@Override
	public int compare(BankRecords f1, BankRecords f2) 
	{
		// TODO Auto-generated method stub
		
		// The first sort through the array.
		int result = f1.getSex().compareTo(f2.getSex());
		if (result != 0)  
		{ 
			return result; 
		}
		
		// The second sort through the array.
		return f1.getMortgage().compareTo(f2.getMortgage());
	}

}

