/**
 * Deborah Barndt
 * 10-31-16
 * AverageComparator.java
 * Lab 4
 * This program will compare various fields in the application's data analysis requirements. 
 * Written by Deborah Barndt. */

package bankofiit;

import java.util.Comparator;

public class AverageComparator implements Comparator<BankRecords>
{
	@Override
	public int compare(BankRecords i1, BankRecords i2) 
	{
		// TODO Auto-generated method stub
		
		// Sort through the array.
		return (int) (i1.getIncome() - i2.getIncome());
	}
}
