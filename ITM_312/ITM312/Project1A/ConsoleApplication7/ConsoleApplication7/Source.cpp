// This program demonstrates an array being passed to a function.

/*#include <iostream>
using namespace std;

void showValues(int[], int);	// Function prototype

int main()
{
	const int ARRAY_SIZE = 8;
	int numbers[ARRAY_SIZE] = { 5, 10, 15, 20, 25, 30, 35, 40 };

	showValues(numbers, ARRAY_SIZE);

	return 0;
}

// Definition of function showValue. This function accepts an array of integers
// and the array's size as its arguments. The contents of the array are displayed.

void showValues(int nums[], int size)
{
	for (int index = 0; index < size; index++)
		cout << nums[index] << " ";
	cout << endl;
}*/

// This program will keep track of sales for five different types of salsa.
// Then will produce a report that displays sales for each salsa type, total sales,
// and the names of the highest selling and lowest selling products.

#include <iostream>
#include <string>
using namespace std;

int main()
{
	string mild;
	string medium;
	string sweet;
	string hot;
	string zesty;

	string salsatypes[] = { "mild", "medium", "sweet", "hot", "zesty" };
	int numjars[5];

	for (int x = 0; x < 5; x++)
	{
		cout << "How many jars were sold for " << salsatypes[x] << "?" << endl;
		cin >> numjars[x];

		if (numjars[x] < 0)
		{
			cout << "No negative numbers allowed!" << endl;
			x--;
		}

	}

	for (int j = 0; j < 5; j++)
	{
		cout << "Total Amount of Salsa Types Sold are: " << salsatypes[j] << " " << numjars[j] << endl;
	}

	// Total number of sales
	int totalnum;
	double sum = 0;
	
	for (totalnum = 0; totalnum < 5; totalnum++)
		sum += numjars[totalnum];
	cout << "Total jars sold: " << sum << endl;

	// Name of the highest selling salsa
	int count;
	int highest;
	highest = numjars[0];
	string high = salsatypes[0];

	for (count = 1; count <= 5; count++)
	{
		if (numjars[count] > highest)
		{
			highest = numjars[count];
			high = salsatypes[count];
		}
	}
	cout << "Highest salsa type sold: " << high << " at " << highest << endl;

	// Name of the lowest selling salsa
	int count1;
	int lowest;
	lowest = numjars[0];
	string low = salsatypes[0];

	for (count1 = 1; count1 < 4; count1++)
	{
		if (numjars[count1] < lowest)
		{
			lowest = numjars[count1];
			low = salsatypes[count1];
		}
	}
	cout << "Lowest salsa type sold: " << low << " at " << lowest << endl;

	return 0;
}