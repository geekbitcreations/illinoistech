// Specification file for the Rectangle class. This version has a constructor.
/*#pragma once
#ifndef RECTANGLE_H
#define RECTANGLE_H

class Rectangle
{
	private:
		double width;
		double length;

	public:
		Rectangle();	// Constructor
		void setWidth(double);
		void setLength(double);

		double getWidth() const
		{
			return width;
		}

		double getLength() const
		{
			return length;
		}

		double getArea() const
		{
			return width * length;
		}
};
#endif*/

#pragma once
#ifndef Degree_H
#define Degree_H
#include <string>
using namespace std;

class Degree
{
private:
	string fname;
	string lname;
	string subject;
	char grade;

public:
	Degree();	// Constructor
	void setfName(string);
	void setlName(string);
	void setSubject(string);
	void setGrade(char);

	string getfName() const
	{
		return fname;
	}

	string getlName() const
	{
		return lname;
	}

	string getSubject() const
	{
		return subject;
	}

	char getGrade() const
	{
		return grade;
	}
};
#endif