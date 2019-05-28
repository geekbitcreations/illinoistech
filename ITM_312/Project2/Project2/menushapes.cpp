// This program will create a menu with 4 to 5 options, have the user pick the option, and
// then ask the user to enter the amount of stars from 1-50. Then a for loop will create the 
// shape.
// Written by Deborah Barndt.

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

// Function prototypes
void tri(int lines);				
void invert(int lines);
void rect(int lines, int width);
void bow(int lines);
void hour(int lines);

int main()
{
	int lines = 0,		// height of the shape
		width = 0;		// width of the shape
	short choice;	// selection made by user

	// Do/While loop to allow the user to continue to display the menu, make a selection,
	// and have the steps for the selection carried out. Loops continues until user enters 5
	// to exit the program.
	do
	{
		// Display the menu
		cout << "Welcome to the Programmers Art Gallery.\n\n";
		cout << "1. Draw a Filled Triangle" << endl;
		cout << "2. Draw a Filled Inverted Triangle" << endl;
		cout << "3. Draw a Unfilled Rectangle" << endl;
		cout << "4. Draw a Filled Bow Tie" << endl;
		cout << "5. Draw a Filled Hourglass" << endl;
		cout << "6. Exit\n" << endl;
		cout << "Please select a number from 1 to 6." << endl;
		cin >> choice;

		// Get the selection from the user.
		switch (choice)
		{
			case 1: // Call function tri()
				tri(lines);
				break;

			case 2: // Call function invert()
				invert(lines);
				break;

			case 3: // Call function rect()
				rect(lines, width);
				break;

			case 4: // Call function bow()
				bow(lines);
				break;

			case 5: // Call function hour()
				hour(lines);
				break;

			case 6: // Exit the program
				cout << "Exiting program...\n";
				return 0;
				break;
		}
	}

	while (choice >= 1 && choice <= 6);
	system("pause");

	return 0;
}

void tri(int lines)
{
	// Filled Triangle
	// Ask, read, and validate the number of stars needed.
	cout << "Enter the amount of stars for the shape from 1-50: ";
	cin >> lines;

	while (lines < 1 || lines > 50)
	{
		cout << "Number of stars has to be between 1 and 50.\n";
		cout << "Enter the amount of stars for the shape from 1-50: ";
		cin >> lines;
	}

	cout << endl;

	// Draw the shape.
	int x, y;

	for (x = 0; x <= lines; ++x)
	{
		for (y = 0; y <= x; ++y)
			cout << "*";
		cout << endl;
	}
}

void invert(int lines)
{
	// Filled Inverted Triangle
	// Ask, read, and validate the number of stars needed.
	cout << "Enter the amount of stars for the shape from 1-50: ";
	cin >> lines;

	while (lines < 1 || lines > 50)
	{
		cout << "Number of stars has to be between 1 and 50.\n";
		cout << "Enter the amount of stars for the shape from 1-50: ";
		cin >> lines;
	}

	cout << endl;

	// Draw the shape.
	int x, y;

	for (x = lines; x >= 1; --x)
	{
		for (y = 1; y <= x; ++y)
			cout << "*";
		cout << endl;
	}
}

void rect(int lines, int width)
{
	// Unfilled Rectangle
	// Ask, read, and validate the number of stars needed.
	cout << "Enter the amount of stars for the height of the shape from 1-50: ";
	cin >> lines;
	cout << "Enter the amount of stars for the width of the shape from 1-50: ";
	cin >> width;

	while (lines < 1 || lines > 50)
	{
		cout << "Number of stars has to be between 1 and 50.\n";
		cout << "Enter the amount of stars for the height of the shape from 1-50: " << endl;
		cin >> lines;
		cout << "Enter the amount of stars for the width of the shape from 1-50: " << endl;
		cin >> width;
	}

	cout << endl;

	// Draw row of width of asterisks to top side
	cout << string(width, '*') << endl;

	// Draw sides
	for (int a = 0; a < lines - 2; ++a)
		cout << "*" << string(width - 2, ' ') << '*' << endl;

	// Draw row of width asterisks for bottom side
	cout << string(width, '*') << endl;

	cout << endl;
}

void bow(int lines)
{
	// Filled Bow Tie
	// Ask, read, and validate the number of stars needed.
	cout << "Enter the amount of stars for the shape from 1-50: ";
	cin >> lines;

	while (lines < 1 || lines > 50)
	{
		cout << "Number of stars has to be between 1 and 50.\n";
		cout << "Enter the amount of stars for the shape from 1-50: " << endl;
		cin >> lines;
	}

	cout << endl;

	// Draw the shape.
	for (int i = -lines; i <= lines; i++)
	{
		for (int j = -lines; j <= lines; j++)
			if (abs(i) <= abs(j))
			{
				cout << "*";
			}
			else
			{
				cout << " ";
			}
		cout << endl;
	}
}

void hour(int lines)
{
	// Filled Hourglass
	// Ask, read, and validate the number of stars needed.
	cout << "Enter the amount of stars for the shape from 1-50: ";
	cin >> lines;

	while (lines < 1 || lines > 50)
	{
		cout << "Number of stars has to be between 1 and 50.\n";
		cout << "Enter the amount of stars for the shape from 1-50: " << endl;
		cin >> lines;
	}

	cout << endl;

	// Draw the shape.
	for (int i = -lines; i <= lines; i++)
	{
		for (int j = -lines; j <= lines; j++)
			if (abs(i) >= abs(j))
			{
				cout << "*";
			}
			else
			{
				cout << " ";
			}
		cout << endl;
	}
}