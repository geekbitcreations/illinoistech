#pragma once

// Rectangle class declaration.

/*class Rectangle
{
	private:
		double width;
		double length;
	
	public:
		void setWidth(double);
		void setLength(double);
		double getWidth() const;
		double getLength() const;
		double getArea() const;
};*/


// Calculation class declaration

class Calculation
{
	private:
		double num1;
		double num2;

	public:
		double setNum1(double num1);
		double setNum2(double num2);
		double getAdd() const;
		double getSubtract() const;
		double getMultiply() const;
		double getDivide() const;
};