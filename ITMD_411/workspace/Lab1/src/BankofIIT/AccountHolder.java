/**
 * Deborah Barndt
 * 9-6-16
 * AccountHolder.java
 * Lab 1
 * This program will similate a bank account. It will prompt users for options for creating an initial balance, entering deposits or withdrawals, and it will
 * allow for the printing of account information including interest at various interest rates. 
 * Written by Deborah Barndt. */

package BankofIIT;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class AccountHolder 
{
	static double balance, 					// account balance
	              annualInterestRate = .04;	// interest rate
	
	//Print 2 decimal places.
	DecimalFormat mydf = new DecimalFormat("0.00");
	
	// Constructor sets the balance to 0.00.
	public AccountHolder()
	{
		balance = 0.00;
	}
	
	// Constructor sets the starting balance of the account to the value passed.
	public AccountHolder(double newbalance)
	{
		balance = newbalance;
		
		// Check for a positive balance
		if (balance < 0)
		{
			JOptionPane.showMessageDialog(null, "Error: You can not start off with a negative balance.");
		}
		
		this.balance = balance >= 0 ? balance: 0;
	}
	
	// Constructor sets the balance of the account to the value as a string.
	public AccountHolder(String balstr)
	{
		balance = Double.parseDouble(balstr);
	}
	
	// Method to make a deposit money into the account.
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	// Method to make a deposit money into the account as a string.
	public void deposit(String depstr)
	{
		balance += Double.parseDouble(depstr);
	}
	
	// Method to withdraw money from the account.
	public void withdrawal(double amount)
	{		
		if (balance <= 100)
		{
			JOptionPane.showMessageDialog(null, "Insufficient Funds for Withdrawal.");
			amount = 0;
		}
		
		else
		{
			// Check if the user's balance goes below $500, and add a transaction fee.
			if (balance - amount < 500)
			{
				// Check if the user's balance is below $100.
				if (balance - amount < 100)
				{
					amount = balance - 100;
					JOptionPane.showMessageDialog(null, "Your balance cannot go below $100.\n"
							+ "Your withdrawal is now the maximum amount of $" + mydf.format(amount) + ".");					
					balance -= amount;
					amount = 0;
				}
				
				balance -= 50;
				JOptionPane.showMessageDialog(null, "Your account is below $500.\n"
						+ "A $50 transaction fee has been deducted from your account.\n");
			}	
			
			balance -= amount;
		}
		
		
	}
	
	// Method to withdraw money from the account as a string.
	public void withdrawal(String withstr)
	{
		balance -= Double.parseDouble(withstr);
	}
	
	// Method to calculate the monthly interest rate to the account.
	public void monthlyInterest()
	{
		balance += balance * (annualInterestRate / 12.0);
	}
	
	// Method to modify the monthly interest rate to the account.
	public void modifyMonthlyInterest(double interestRateUpdate)
	{
		if (interestRateUpdate >= 0 && interestRateUpdate <= 1.0)
		{
			annualInterestRate = interestRateUpdate;
		}
	}
	
	// Setter method to set the account balance.
	public void setBalance(double newbalance)
	{
		balance = newbalance;
	}
	
	// Setter method that sets the account balance as a string.
	public void setBalance(String balstr)
	{
		balance = Double.parseDouble(balstr);
	}
	
	// Getter method to return the account balance.
	public double getBalance()
	{
		return balance;
	}
	
	// Getter method to return the annual interest rate.
	public static double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	// Getter method to return the accounts current balance in a string.
	@Override
	public String toString()
	{
		return String.format("$%.2f", balance);
	}
	
}
