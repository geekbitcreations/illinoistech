// This program will get a withdrawal amount from the user, subtract the amount from a savings account, and calculate the 
// interest. It will return to the user the starting balance, amount withdrawn, interest accrued, and the ending balance to the 
// user. If the withdrawal is greater than the starting balance, it will return a message. If the withdrawal is a negative 
// number, it will return another message. 
// Written by Deborah Barndt

#include <iostream>
#include <iomanip>
#include <assert.h>
using namespace std;

// Declare function prototypes
double deposit(double);
double withdrawal(double);
double calcInterest(double);

int main()
{
	double balance = 5000.00;	// balance of the savings account
	double newbalance = 0.00;	// new balance of the savings account
	int answer = 0;				// what the user wants to do
	bool account = true;		// variable to check the loop

	while (account == true)
	{
		// Display welcome message.
		cout << "Welcome to Hacker Savings." << endl;
		cout << "Would you like to make a deposit, withdrawal, or check your balance?" << endl;
		cout << "Enter 1 for Deposit, 2 for Withdrawal, 3 for Check Balance, or 0 to Quit: " << endl;
		cin >> answer;
		
		if (answer == 1)
		{
			balance = deposit(balance);
		}

		else if (answer == 2)
		{
			balance = withdrawal(balance);
		}

		else if (answer == 3)
		{
			cout << "Your ending balance is : " << setprecision(2) << fixed << balance << "\n\n" << endl;
		}

		else if (answer == 0)
		{
			account = false;
		}
	}
		
	cout << "Thank you and have a nice day!";
	
	return 0;
}

// Definition of functions for the program
double deposit (double balance)
{
	double deposit = 0.00;		// amount user would like to deposit
	// Get the amount the user wants to deposit
	cout << "How much would you like to deposit? " << endl;
	cin >> deposit;
	
	balance+= calcInterest(balance) + deposit;

	cout << "Your deposit is : " << setprecision(2) << fixed << deposit << endl;
	cout << "Your ending balance is : " << setprecision(2) << fixed << balance << "\n\n" << endl;
	return balance;
}

double withdrawal (double balance)
{
	double withdrawal = 0.00;	// amount user would like to withdrawal
	// Get the amount the user wants to withdrawal
	cout << "How much would you like to withdrawal? " << endl;
	cin >> withdrawal;
	
	if (withdrawal > balance)
	{
		cout << "Your account has insufficient funds, please make a deposit \n";
		cout << "in your account before attempting to withdraw more funds." << endl;
		assert(withdrawal < balance);
	}

	if (withdrawal < 0)
	{
		cout << "Invalid entry! Negative entries are not allowed. \n";
		cout << "Please try entering another amount." << endl;
		assert(withdrawal > 0);
	}

	balance+= calcInterest(balance) - withdrawal;
	cout << "Your withdrawal is: " << setprecision(2) << fixed << withdrawal << endl;
	cout << "Your ending balance is: " << setprecision(2) << fixed << balance << "\n\n" << endl;
	
	return balance;
}

double calcInterest (double balance)
{
	double interest = 0.01;		// percent of interest
	double accruedint = 0.00;	// amount of interest accrued

	for (int x = 0; x < 12; x++)
	{
		accruedint += (balance + accruedint) * (interest / 12);
	}
	
	cout << "Your starting balance is: " << setprecision(2) << fixed << balance << endl;
	cout << "Your interest accrued is: " << setprecision(2) << fixed << accruedint << endl;

	return accruedint;
}