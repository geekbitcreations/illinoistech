import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Deborah Barndt
 * 12-6-16
 * Duplicates.java
 * Final Exam
 * This program will take in an arraylist, will remove any duplicates 
 * in the array, and then print out the result.
 * Written by Deborah Barndt. */

public class Duplicates 
{

	public Duplicates() 
	{
		// TODO Auto-generated constructor stub
	}

	private static ArrayList<Integer> ArrayList(Collection<? extends Integer> data) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(2);
		list.add(4);
		
		JOptionPane.showMessageDialog(null, "List before: " + list,
				"Final Exam Code", 0);
		
		for(int i = 1; i < list.size(); i++)
		{
			int a1 = list.get(i);
			int a2 = list.get(i-1);
			
			if(a1 == a2)
			{
				list.remove(a1);
			}
		}
		
		JOptionPane.showMessageDialog(null, "List after removing the duplicates: " + list,
				"Final Exam Code", 0);
	}
}
