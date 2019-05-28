// This program asks for the number of hours worked by six employees. It stores
// the values in an array.

#include <iostream>
using namespace std;

int main()
{
	/*const int NUM_EMPLOYEES = 6;
	int hours[NUM_EMPLOYEES];

	// Get the hours worked by each employee.
	cout << "Enter the hours worked by "
		<< NUM_EMPLOYEES << " employees: ";

	cin >> hours[0];
	cin >> hours[1];
	cin >> hours[2];
	cin >> hours[3];
	cin >> hours[4];
	cin >> hours[5];

	// Display the values in the array.
	cout << "The hours you entered are:";
	cout << " " << hours[0];
	cout << " " << hours[1];
	cout << " " << hours[2];
	cout << " " << hours[3];
	cout << " " << hours[4];
	cout << " " << hours[5] << endl;

	return 0;

	const int SIZE = 3;	// Constant for the array size
	int values[SIZE];	// An array of 3 integers
	int count;			// Loop counter variable

	// Attempt to store five numbers in the three-element array.
	cout << "I will store 5 numbers in a 3 element array!\n";
	for (count = 0; count < 5; count++)
		values[count] = 100;

	// This program demonstrates the range-based for loop.

	// Define an array of integers.
	int numbers[] = { 10, 20, 30, 40, 50 };

	// Display the values in the array.
	for (int val : numbers)
		cout << val << endl;

	return 0;*/

	const int SIZE = 5;
	int numbers[5];

	// Get values for the array.
	for (int &val : numbers)
	{
		cout << "Enter an integer value: ";
		cin >> val;
	}

	// Display the values in the array.
	cout << "Here are the values you entered:\n";
	for (int val : numbers)
		cout << val << endl;
}