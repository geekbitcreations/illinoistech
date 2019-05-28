// This program displays Pattern A, followed by another loop that displays
// Pattern B.

#include <iostream>
using namespace std;

int main()
{
	int num1 = 1;
	int num2 = 1;
			
	cout << "_________________________________" << endl;
	cout << "Pattern A\t\tPattern B" << endl;
	cout << "_________________________________" << endl;
	
	for (int line = 0; line < 10; line++)
	{
		for (int num3 = 11; num3 > num2; num3--)
			cout << "+";
			num2 += 1;
			cout << "\t\t\t";

		for (int up = 0; up < num1; up++)
			cout << "+";
			num1 += 1;
			cout << endl;
	}
		
	return 0;
}
