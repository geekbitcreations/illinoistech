#include <iostream>
using namespace std;

class BaseClass
{
public:
	BaseClass()		// Constructor
	{
		cout << "This is the BaseClass constructor.\n";
	}

	~BaseClass()	// Destructor
	{
		cout << "This is the BaseClass destructor.\n";
	}
};

class DerivedClass : public BaseClass
{
public:
	DerivedClass()	// Constructor
	{
		cout << "This is the DerivedClass constructor.\n";
	}

	~DerivedClass()	// Destructor
	{
		cout << "This is the DerivedClass destructor.\n";
	}
};

int main()
{
	cout << "We will now define a DerivedClass object.\n";

	DerivedClass object;

	cout << "The program is now going to end.\n";

	return 0;
}