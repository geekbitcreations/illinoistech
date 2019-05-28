package BankofIIT;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JTextArea;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.UIManager;

/**
 * Deborah Barndt
 * 9-6-16
 * AccountHolderTest.java
 * Lab 1
 * This programs tests the AccountHolder class.
 * Written by Deborah Barndt. */

public class AccountHolderTest 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		double balance,			// balance of the account
	           annualamount;	// the annual amount added to the user's account
		
		int   selection = 0;	// menu selection made by the user
		
		//Print 2 decimal places.
		DecimalFormat mydf = new DecimalFormat("0.00");
		
		// Change the color of the background of the dialog box
		UIManager UI = new UIManager();
		UI.put ("OptionPane.background", Color.lightGray);
		UI.put ("Panel.background", Color.lightGray);
		
		// Print a time stamp for program.
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		// Prompt the user for the initial balance.
		balance = Double.parseDouble(JOptionPane.showInputDialog("Please enter your starting balance: "));
		
		// Create an AccountHolder object.
		AccountHolder account = new AccountHolder(balance);
		
		// Change icon inside dialog box.
		final ImageIcon icon = new ImageIcon(new URL("http://iconshow.me/media/images/Business/e-commerce-icon/png/32/bank.png"));
		
		do
		{
			selection = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Bank of IIT!\n"
					+ "How many I help you today?\n\n"
					+ "1: Check your current balance.\n2: Make a deposit.\n"
					+ "3: Make a withdraw.\n4: Update your interest.\n"
					+ "5: Check your 12 month annual interest.\n6: Exit\n\n"
					+ "Please make a selection: "));	
			
			// Switch statement containing the Bank of IIT Service Menu.
			switch (selection)
			{
				case 1:
					// Display the user's current balance.
					
					JOptionPane.showMessageDialog(null, "Your current balance is $" + mydf.format(account.getBalance()) + ".\n\n"
							+ "Cur dt = " + timeStamp + "\nProgrammed by Deborah Barndt\n", "Account Balance", 
							JOptionPane.INFORMATION_MESSAGE, icon);
					break;
		
				case 2:
					// Prompt the user for the amount they would like to deposit.
					balance = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount you would like to deposit: "));
					account.deposit(balance);
					JOptionPane.showMessageDialog(null, "Your current balance is $" + mydf.format(account.getBalance()) + ".\n\n"
							+ "Cur dt = " + timeStamp + "\nProgrammed by Deborah Barndt\n", "Deposit", 
							JOptionPane.INFORMATION_MESSAGE, icon);
					break;
				
				case 3:
					// Prompt the user for the amount they would like to withdrawal.
					balance = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount you would like the withdraw: "));
					account.withdrawal(balance);
					JOptionPane.showMessageDialog(null, "Your current balance is $" + mydf.format(account.getBalance()) + ".\n\n"
							+ "Cur dt = " + timeStamp + "\nProgrammed by Deborah Barndt\n", "Withdraw", 
							JOptionPane.INFORMATION_MESSAGE, icon);
					break;
				
				case 4:
					// Check your current interest rate, and update the amount of interest added to the account.
					account.modifyMonthlyInterest(Double.parseDouble(JOptionPane.showInputDialog("Your current interest rate is " + 
							mydf.format(account.getAnnualInterestRate()) + "\n"
							+ "Input the new interest rate in decimal format: ")));
					break;
				
				case 5:
					// Display a 12 month print out showing the interest being added to the user's account. Showing a text area containing the headers for columns,
					// the current balance, and the 12 month print out showing the interest for each of the 12 months.
					String output = "Your current balance is $" + mydf.format(account.getBalance()) + ".\n\n"
									+ "Your monthly balances for one year at " + mydf.format(account.getAnnualInterestRate() * 100) + "% interest rate.\n\n"
									+ "Month\tBalance with Interest\n";
		
					Double monthBal = account.getBalance();
					
					// Loop to calculate the 12 month print out.
					for (int monthNum = 1; monthNum <= 12; monthNum++)
					{
						output += monthNum + ":\t" + "$" + mydf.format((monthBal += monthBal * (account.getAnnualInterestRate()/12))) + "\n" ;
					}
					
					output += "\n\n" + "Cur dt = " + timeStamp + "\nProgrammed by Deborah Barndt\n";
					
					// Display the results.
					JOptionPane.showMessageDialog(null, new JTextArea(output), "12 Month Interest Rate Print Out", 
							JOptionPane.INFORMATION_MESSAGE, icon);

					break;	
						
				case 6:
					// Exit the program.
					System.exit(0);	
			}
		}
		
		while (selection != 6); // Ends the loop.
	}
}
