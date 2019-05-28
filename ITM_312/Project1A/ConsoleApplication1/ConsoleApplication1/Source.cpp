// This program demonstrates the ++ and -- operators.
#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	double cel = 0;		// Minimum temp value
	double fah = 20;	// Maximum temp value
	double temp = 0;	// temperature

	cout << "Celcius    Fahrenheit\n";
	cout << "_____________________\n";

	while (temp <= 20)
	{
		cout << cel << "\t\t" << fah << fixed << setprecision(2)<< endl;
		temp++;
		cel++;
		fah = fah + 1.8;
	}
		
	return 0;
}