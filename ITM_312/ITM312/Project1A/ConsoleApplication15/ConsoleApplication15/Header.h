#pragma once

class Account {
protected:
	int deposit, withdrawl;
	double interest, charge, bal;

public:

	void setAmmt(double a, double b, double c)
	{
		bal = a;
		interest = b;
		charge = c;
	}

	void setVals(int a, int b)
	{
		deposit = a;
		withdrawl = b;
	}

	virtual double bankDeposit(double ammt)
	{
		bal = bal + ammt;
		deposit++;
		return bal;
	}

	virtual double bankWithdrawl(double ammt)
	{
		bal = bal - ammt;
		withdrawl++;
		return bal;
	}

	virtual void calcInt() 
	{
		double MIR = interest / 12;
		double MI = bal * MIR;
		bal = bal + MI;
	}

	virtual double monthlyProc()
	{
		bal = bal - charge;
		calcInt();
		setVals(0, 0);
		return bal;
	};

};

class Savings: public Account {
private:
	bool active;

public:
	void status()
	{
		if (bal < 25)
			active = false;
	}

	double saveDeposit(double ammt)
	{
		if (active)
		{
			bal = bal + ammt;
			deposit++;
			return bal;
		}
	}

	 double saveWithdrawl(double ammt)
	{
		if (active)
		{
			bal = bal - ammt;
			withdrawl++;
			return bal;
		}
	}

	  double monthlyProc()
	 {
		 if (active) 
		 {
			bal = bal - charge;
			 calcInt();
			 return bal;
		 }
	 }
};

class Checking: public Account {

	double checkWithdrawl(double ammt)
	{
		if (bal <= 0) {
			bal = bal - 15.00;
		}

		else {
			bal = bal - ammt;
			withdrawl++;
			return bal;
		}
	}

	double monthlyProc()
	{
		charge = 5.00 * 12 + (.10*withdrawl);
		bal = bal - charge;
		calcInt();
		return bal;
	}
};