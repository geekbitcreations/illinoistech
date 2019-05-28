// This program demonstrates a function with three parameters.

/*#include <iostream>

using namespace std;

// Function Prototype
void showSum(int, int, int);
void showSub(int, int, int);
void showMult(int, int, int);
void showDiv(int, int);
void showMod(int, int);

int main()
{
	int value1, value2, value3;

	// Get three integers.
	cout << "Enter three integers and I will display ";
	cout << "their sum: ";
	cin >> value1 >> value2 >> value3;

	// Call showSum passing three arguments.
	showSum(value1, value2, value3);
	showSub(value1, value2, value3);
	showMult(value1, value2, value3);
	showDiv(value1, value2);
	showMod(value1, value2);

	return 0;
}

// Definition of function showSum.
// It uses three integer parameters. Their sum is displayed.

void showSum(int num1, int num2, int num3)
{
	cout << "The sum is: " << (num1 + num2 + num3) << endl;
}

void showSub(int num1, int num2, int num3)
{
	cout << "The subtraction is: " << (num1 - num2 - num3) << endl;
}

void showMult(int num1, int num2, int num3)
{
	cout << "The multiplication is: " << (num1 * num2 * num3) << endl;
}

void showDiv(int num1, int num2)
{
	cout << "The division is: " << (num1 / num2) << endl;
}

void showMod(int num1, int num2)
{
	cout << "The modulus is: " << (num1 % num2) << "%" << endl;
}*/

// This program uses a function that returns true or false.
#include <iostream>
using namespace std;

// Function prototype
bool isEven(int);

int main()
{
	int val;

	// Get a number from the user.
	cout << "Enter an integer and I will tell you ";
	cout << "if it is even or odd: ";
	cin >> val;

	// Indicate whether it is even or odd.
	if (isEven(val))
		cout << val << " is even.\n";
	else
		cout << val << " is odd.\n";

	return 0;
}

// Definition of function isEven. This function accepts an integer argument and
// tests it to be even or odd. The function returns true if the argument is even
// or false if the argument is odd. The return value is a bool.

bool isEven(int number)
{
	bool status;

	if (number % 2 == 0)
		status = true;	// The number is even if there is no remainder.
	else
		status = false;	// Otherwise, the number is odd.
	return status;
}