// This is the specification file for the Menu class.

#pragma once
#define Menu_H
#include <iostream>
#include <string>
using namespace std;

class Menu
{
	private:
		int size;		// Size of the array the user wants
		int usernum;	// variable of number given by the user
		int* list;		// array for numbers given by user

	public:
		short choice;	// Selection made by user

	int arraymenu(int * list, int size)
	{
		// Do/While loop to allow the user to continue to display the menu, make a selection,
		// and have the steps for the selection carried out. Loops continues until user enters 6
		// to exit the program.
		do
		{
			Menu::size = size;
			// Display the menu
			cout << endl;
			cout << "Welcome to Fun With Arrays.\n\n";
			cout << "1. Sort in Ascending Order" << endl;
			cout << "2. Sort in Descending Order" << endl;
			cout << "3. Sort in both Ascending and Descending Order" << endl;
			cout << "4. Find the Highest Number" << endl;
			cout << "5. Find the Lowest Number" << endl;
			cout << "6. Exit\n" << endl;
			cout << "Please select a number from 1 to 6." << endl;
			cin >> choice;

			// Get the selection from the user.
			switch (choice)
			{
				case 1: // Call function numup()
					numup(list);
					break;

				case 2: // Call function numdown()
					numdown(list);
					break;

				case 3: // Call function numboth()
					numboth(list);
					break;

				case 4: // Call function highnum()
					highnum(list);
					break;

				case 5: // Call function lownum()
					lownum(list);
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

	void numup(int list[])
	{
		int temp;
		for (int x = 0; x < Menu::size; x++)
		{
			for (int y = x; y < Menu::size; y++)
			{
				if (list[x] > list[y])
				{
					// swap them
					temp = list[y];
					list[y] = list[x];
					list[x] = temp;
				}
			}

			
		}
		cout << "Ascending Order: ";
		for (int x = 0; x < Menu::size; x++)
			cout << list[x] << " ";
		cout << endl;
		cout << endl;
	}

	void numdown(int list[])
	{
		int temp;
		for (int x = 0; x < Menu::size; x++)
		{
			for (int y = x; y < Menu::size; y++)
			{
				if (list[y] > list[x])
				{
					// swap them
					temp = list[x];
					list[x] = list[y];
					list[y] = temp;
				}
			}

			
		}
		cout << "Descending Order: ";
		for (int x = 0; x < Menu::size; x++)
			cout << list[x] << " ";
		cout << endl;
		cout << endl;
	}

	void numboth(int list[])
	{
		int temp;
		for (int x = 0; x < Menu::size; x++)
		{
			for (int y = x; y < Menu::size; y++)
			{
				if (list[x] > list[y])
				{
					// swap them
					temp = list[y];
					list[y] = list[x];
					list[x] = temp;
				}
			}

			
		}
		cout << "Ascending Order: ";
		for (int x = 0; x < Menu::size; x++)
			cout << list[x] << " ";
		cout << endl;

		for (int x = 0; x < Menu::size; x++)
		{
			for (int y = x; y < Menu::size; y++)
			{
				if (list[y] > list[x])
				{
					// swap them
					temp = list[x];
					list[x] = list[y];
					list[y] = temp;
				}
			}

		}
		cout << "Descending Order: ";
		for (int x = 0; x < Menu::size; x++)
			 cout << list[x] << " ";
		cout << endl;
		cout << endl;
	}

	void highnum(int list[])
	{
		// List the highest number
		int count;
		int highest;
		highest = list[0];
		
		for (count = 1; count < Menu::size; count++)
		{
			if (list[count] > highest)
			{
				highest = list[count];
			}
		}
		cout << "Highest number is: " << highest << endl;

		cout << endl;
		cout << endl;
	}

	void lownum(int list[])
	{
		// List the lowest number
		int count;
		int lowest;
		lowest = list[0];

		for (count = 1; count < Menu::size; count++)
		{
			if (list[count] < lowest)
			{
				lowest = list[count];
			}
		}
		cout << "Lowest number is: " << lowest << endl;

		cout << endl;
		cout << endl;
	}
};
