// Implementation file for the Rectangle class. This version has a constructor.
/*#include "Header.h"	// Needed for the Rectangle class
#include <iostream>		// Needed for cout
#include <cstdlib>		// Needed for the exit function
using namespace std;

// The constructor intializes width and length to 0.0.
Rectangle::Rectangle()
{
	width = 0.0;
	length = 0.0;
}

// setWidth sets the value of the member variable width
void Rectangle::setWidth(double w)
{
	if (w >= 0)
		width = w;
	else
	{
		cout << "Invalid width\n";
		exit(EXIT_FAILURE);
	}
}

// setLength sets the value of the member variable length
void Rectangle::setLength(double len)
{
	if (len >= 0)
		length = len;
	else
	{
		cout << "Invalid length\n";
		exit(EXIT_FAILURE);
	}
}

// This program uses the Rectangle class's constructor.
int main()
{
	Rectangle box;	// Define an instance of the Rectangle class

	// Display the rectangle's data
	cout << "Here is the rectangle's data:\n";
	cout << "Width: " << box.getWidth() << endl;
	cout << "Length: " << box.getLength() << endl;
	cout << "Area: " << box.getArea() << endl;

	return 0;
}*/

#include "Header.h"	// Needed for the Degree class
#include <iostream>		// Needed for cout
using namespace std;

// The constructor intializes width and length to 0.0.
Degree::Degree()
{
	fname = "";
	lname = "";
	subject = "";
	grade = 'F';
}

// setfName sets the value of the member variable fname
void Degree::setfName(string f)
{
	fname = f;
}

// setlName sets the value of the member variable lname
void Degree::setlName(string l)
{
	lname = l;
}

// setSubject sets the value of the member variable subject
void Degree::setSubject(string s)
{
	subject = s;
}

// setGrade sets the value of the member variable grade
void Degree::setGrade(char g)
{
	grade = g;
}

// This program uses the Rectangle class's constructor.
int main()
{
	Degree box;	// Define an instance of the Degree class
	
	string f;
	string l;
	string s;
	char g;
	
	cout << "What is the first name? ";
	cin >> f;
	
	cout << "What is the last name? ";
	cin >> l;
	
	cout << "What is the subject? ";
	cin >> s;

	cout << "What is the grade? ";
	cin >> g;
	
	// Store the data
	box.setfName(f);
	box.setlName(l);
	box.setSubject(s);
	box.setGrade(g);

	// Display the degree's data
	cout << "Here is the degree's data:\n";
	cout << "First Name: " << box.getfName() << endl;
	cout << "Last Name: " << box.getlName() << endl;
	cout << "Subject: " << box.getSubject() << endl;
	cout << "Grade: " << box.getGrade() << endl;

return 0;
}
