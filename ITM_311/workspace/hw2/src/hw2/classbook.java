// This program will input six integers from the user,
// then display the book code, single copy cost, number of copies in stock,
// number of prospective students, if the book is required or not, and
// if the book has been used before.
// Written by Deborah Barndt

package hw2;

// Import class JOptionPane
import javax.swing.JOptionPane;

// Import class DecimalFormat
import java.text.DecimalFormat;

public class classbook 
{
	public static void main(String args[])
	{
		String bookCode,  		// book code string entered by the user
			   singleCost, 		// single copy cost string entered by the user
			   copyStock,		// number of copies in stock entered by the user
			   proStudent,		// number of prospective students entered by the user
			   bookRequired,	// if the book is required by the user
			   bookUsed,		// if the book has been used before by the user
			   bookOrder;		// results string that will be displayed in the dialog box

		int stock,				// copies in stock at bookstore
			student,			// total amount of students expected
			require,			// book required or recommended for class
			used,				// book used before in class
			order;				// number of books to order for class
		
		double cost;			// single copy cost for class book
		double totalC;			// total cost of books to be ordered for class
		double profit;			// amount of the bookstore's profit
		
		// Read in book code from user as a string
		bookCode = JOptionPane.showInputDialog("Enter book code:");
		
		// Read in single copy cost from user as a string
		singleCost = JOptionPane.showInputDialog("Enter single copy cost:");
		
		// Read in number of copies in stock from user as a string
		copyStock = JOptionPane.showInputDialog("Enter number of copies in stock:");
		
		// Read in number of prospective students from user as a string
		proStudent = JOptionPane.showInputDialog("Enter number of prospective students:");
		
		// Read in if the book is required from user as a string
		bookRequired = JOptionPane.showInputDialog("Is this book required? [1=required, 2=recommended]:");
		
		// Read in if the book has been used before from user as a string
		bookUsed = JOptionPane.showInputDialog("Has the book been used before? [1=yes, 2=no]:");
		
		// Convert the numbers from type String to type int
		cost = Double.parseDouble( singleCost );
		stock = Integer.parseInt( copyStock );
		student = Integer.parseInt( proStudent );
		require = Integer.parseInt( bookRequired );
		used = Integer.parseInt( bookUsed );
		
		// "if" and "else" statement to determine if book is required
		if (require == 1)
		{
			bookRequired = "required";
		}
		else if (require == 2)
		{
			bookRequired = "recommended";
		}
		
		// "if" and "else" statement to determine if the book has been used before
		if (used == 1)
		{
			bookUsed = "been";
		}
		else if (used == 2)
		{
			bookUsed = "not been";
		}
				
		// Compute the number of books to be ordered, total cost of books to order, 
		// and the bookstore's profit
		order = student - stock;
		totalC = order * cost;
		profit = totalC - (totalC * 0.8);
		
		//Print 2 decimal places for total cost of order and profit
		DecimalFormat mydf = new DecimalFormat("0.00");
				
		// Initialize bookOrder variable to an empty string
		bookOrder = "";
		bookOrder = "Book code: " + bookCode + "\n";
		bookOrder = bookOrder + "Single copy cost: $" + (mydf.format(cost)) + "\n";
		bookOrder = bookOrder + "Number of copies in stock: " + stock + "\n";
		bookOrder = bookOrder + "Number of prospective students: " + student + "\n" + "\n";
		bookOrder = bookOrder + "This book is " + bookRequired + "." + "\n";
		bookOrder = bookOrder + "This book has " + bookUsed + " used before." + "\n" + "\n";
		bookOrder = bookOrder + "Number of books to order: " + order + "\n";
		bookOrder = bookOrder + "Total cost of books to order: $" + (mydf.format(totalC)) + "\n";
		bookOrder = bookOrder + "Store's profit: $" + (mydf.format(profit)) + "\n";
		
		// Display the results of the string
		JOptionPane.showMessageDialog(null, bookOrder, "Results", JOptionPane.INFORMATION_MESSAGE);
	}
}
