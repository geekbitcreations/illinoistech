#pragma once

/*class CRectangle
{
	int *width, *height;

	public:
		CRectangle(int, int);
		~CRectangle();

		int area()
		{
			return (*width * *height);
		}
};

// Base Class Shape
class Shape
{
	public:
		void setWidth(int w)
		{
			width = w;
		}

		void setHeight(int h)
		{
			height = h;
		}

	protected:
		int width;
		int height;
};

// Base class PaintCost
class PaintCost
{
	public:
		int getCost(int area)
		{
			return area * 70;
		}
};

// Derived class
class Rectangle : public Shape, public PaintCost
{
	public:
		int getArea()
		{
			return (width * height);
		}
};

// Specifications file for the Rectangle class
#ifndef RECTANGLE_H
#define RECTANGLE_H

class Rectangle
{
	private:
		double width;		// the rectangle's width
		double length;		// the rectangle's length

	public:
		// Exception class
		class NegativeSize
		{};					// Empty class declaration

		// Default constructor
		Rectangle()
		{
			width = 0.0; length = 0.0;
		}

		// Mutator functions, defined in Rectangle.cpp
		void setWidth(double);
		void setLength(double);

		// Accessor functions
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
#endif // !RECTANGLE_H*/

// Virtual members
#include <iostream>
using namespace std;

class Polygon
{
	protected:
		int width, height;

	public:
		void set_values(int a, int b)
		{
			width = a; height = b;
		}

		virtual int area()
		{
			return 0;
		}
};

class Rectangle : public Polygon
{
	public:
		int area()
		{
			return width * height;
		}
};

class Triangle : public Polygon
{
	public:
		int area()
		{
			return (width * height / 2);
		}
};
