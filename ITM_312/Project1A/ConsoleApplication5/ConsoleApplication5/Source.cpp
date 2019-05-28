// This program uses a reference variable as a function parameter.

#include <iostream>

using namespace std;

// Function prototype. The parameter is a reference variable.
int doubleNum(int );
int addNum(int );
int subNum(int );
int multNum(int );
int divNum(int );

int main()
{
	int value = 4;

	cout << "In main, value is " << value << endl;
	cout << "Now calling doubleNum..." << endl;
	doubleNum(value);

	cout << "Now back in main. value is " << value << endl;
	addNum(value);
	cout << "The added value is " << value << endl;
	subNum(value);
	cout << "The subtracted value is " << value << endl;
	multNum(value);
	cout << "The multiplied value is " << value << endl;
	divNum(value);
	cout << "The divided value is " << value << endl;
	return 0;
}

// Definition of doubleNum. The parameter refVar is a reference variable. The
// value in refVar is doubled.

int doubleNum(int refVar)
{
	refVar *= 2;
}

int addNum(int refVar)
{
	refVar += 2;
}

int subNum(int refVar)
{
	refVar -= 2;
}

int multNum(int refVar)
{
	refVar *= 2;
}

int divNum(int refVar)
{
	refVar /= 2;
}
