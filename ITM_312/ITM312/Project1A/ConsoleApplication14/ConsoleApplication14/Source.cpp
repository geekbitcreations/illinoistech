/*#include <iostream>
#include "Header.h"
using namespace std;

int main()
{
	CRectangle rect(3, 4), rectb(5, 6);

	cout << "rect area: " << rect.area() << endl;
	cout << "rectb area: " << rectb.area() << endl;

	return 0;
}

CRectangle::CRectangle(int a, int b)
{
	width = new int;
	height = new int;

	*width = a;
	*height = b;
}

CRectangle::~CRectangle()
{
	delete width;
	delete height;
}*/

/*#include <iostream>
#include "Header.h"
using namespace std;

int main()
{
	Rectangle Rect;
	int area;

	Rect.setWidth(5);
	Rect.setHeight(7);

	area = Rect.getArea();

	// Print the area of the object
	cout << "Total area: " << Rect.getArea() << endl;

	// Print the total cost of painting
	cout << "Total paint cost: $" << Rect.getCost(area) << endl;

	return 0;
}

#include <iostream>
using namespace std;

// Function prototype
double divide(int, int);

int main()
{
	int num1, num2;		// To hold two numbers
	double quotient;	// To hold the quotient of the numbers

	// Get two numbers
	cout << "Enter two numbers: ";
	cin >> num1 >> num2;

	// Divide num1 by num2 and catch any potential exceptions
	try
	{
		quotient = divide(num1, num2);
		cout << "The quotient is " << quotient << endl;
	}

	catch (char *exceptionString)
	{
		cout << exceptionString;
	}

	cout << "End of the program.\n";

	return 0;
}

// The divide function divides numerator by denominator. If denominator is zero,
// the function throws an exception.
double divide(int numerator, int denominator)
{
	if (denominator == 0)
	{
		throw "ERROR: Cannot divide by zero.\n";
	}

	return static_cast<double>(numerator) / denominator;
}

// Implementation file for the Rectangle class
#include "Header.h"
#include <iostream>
using namespace std;

// setWidth set the value of the member variable width
void Rectangle::setWidth(double w)
{
	if (w >= 0)
		width = w;
	else
		throw NegativeSize();
}

// setLength set the value of the member variable length
void Rectangle::setLength(double len)
{
	if (len >= 0)
		length = len;
	else
		throw NegativeSize();
}


// This program demonstrates Rectangle class exceptions
int main()
{
	int width;
	int length;

	// Create a Rectangle object
	Rectangle myRectangle;

	// Get the width and length
	cout << "Enter the rectangle's width: ";
	cin >> width;

	cout << "Enter the rectangle's length: ";
	cin >> length;

	// Store these values in the Rectangle object
	try
	{
		myRectangle.setWidth(width);
		myRectangle.setLength(length);
		cout << "The area of the rectangle is "
			<< myRectangle.getArea() << endl;
	}

	catch (Rectangle::NegativeSize)
	{
		cout << "Error: A negative value was entered.\n";
	}

	cout << "End of the program.\n";

	return 0;
}*/

#include <iostream>
#include "Header.h"
using namespace std;

int main()
{
	Rectangle rect;
	Triangle trgl;
	Polygon poly;
	
	Polygon * ppoly1 = &rect;
	Polygon * ppoly2 = &trgl;
	Polygon * ppoly3 = &poly;
	
	ppoly1->set_values(4, 5);
	ppoly2->set_values(4, 5);
	ppoly3->set_values(4, 5);
	
	cout << ppoly1->area() << '\n';
	cout << ppoly2->area() << '\n';
	cout << ppoly3->area() << '\n';

	return 0;
}