// This program will get 5 numbers from the user and store them in an array. Then a menu will display with a list of options to sort
// the array: in ascending order, descending order, in both ascending and descending order, give the highest number, and give the lowest
// number. When the user is finished, it will exit the program.

#include "Menu.h"
#include <iostream>
using namespace std;

// Function prototypes
void numbers();

int main()
{
	numbers();
	
	return 0;
}

void numbers()
{
	int size=0;				// Size of the array the user wants
	int usernum;			// Variables of numbers given by the user
	int * list;
	
	cout << "How many integers between 5 to 10 would you like to enter? " << endl;
	cin >> size;

	list = new int[size];	// Array to hold the numbers given by user
	
	Menu m;
	
	cout << "Enter " << size << " integers:" << endl;
	for (int j = 0; j < size; j++)
	{
		cin >> usernum;
		list[j] = usernum;
	}
	
	m.arraymenu(list, size);
	delete[]list;
}