// This program with output a random number, then ask the player
// to enter a number. The player will be given 10 attempts to try
// to guess the number. If correct, it will display a message and
// if wrong it will display an different message.
// Written by Deborah Barndt

#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

using namespace std;
char chr;

int main()
{
	int num;				// random number generated
	int guess;				// number of guesses made by the user
	float tries = 10;		// number of tries allowed
	float timesplayed = 0;	// number of times the users has played
	char answer;			// variable whether the user wants to play again
	bool loop = true;		// variable to validate the loop

	srand(time(0));			// Seed random number generator
	
	// Loop to control the entire game.
	do
	{
		// Random number generated for game.
		num = rand() % 21;

		// Welcome message for game.
		cout << "Welcome to Guess the Number Game." << endl;
		tries = 10;
		loop = true;

		do
		{
			// Ask user to enter a number
			cout << "Pick a number from 0 to 20: ";
					
			if (!(cin >> guess))
			{
				cout << endl;
				cout << "Error! Please enter numbers only." << endl;
				cin.clear();
				cin.ignore(20, '\n');
			}
			
			// Validate if the user enter a number not in the given range.
			if (guess > 20 || guess < 0)
			{
				cout << endl << "Incorrect Input! Pick a number from 0 to 20." << endl;
			}
			
			// Let's the user know if their guess is too low.
			else if (guess < num)
			{
				tries--;
				cout << "Sorry! Please try again. You guessed too low!" << endl;
				cout << "You have " << tries << " tries remaining." << endl;
				cout << endl;
			}	
			
			// Let's the user know if their guess is too high.
			else if (guess > num)
			{
				tries--;
				cout << "Sorry! Please try again. You guessed too high!" << endl;
				cout << "You have " << tries << " tries remaining." << endl;
				cout << endl;
			}
			
			// User guesses the number correctly.
			else if (guess == num)
			{
				cout << "Congratulations! You guessed correctly!" << endl;
				loop = false;
			}

			//	User has no more guesses left.
			if (tries == 0 && loop == true)
			{
				cout << "You have " << tries << " tries remaining." << endl;
				cout << "The correct number was " << num << ". Sorry, you lose." << endl;
				cout << endl;
				loop = false;
			}
		}

		// Prompt user if they would like to play again.
		while (loop == true);
		
		timesplayed++;
		cout << "Would you like to play again?\t";
		cout << "Enter Y/N" << endl;
		cin >> answer;
		cout << endl;

		// Thank user if they do not want to play again.
		if (answer == 'N' || answer == 'n')
			cout << "Thanks for playing!" << endl << "You played " << timesplayed << " times!" << endl;
	}

	// Continue loop if user wants to play again.
	while (answer == 'Y' || answer == 'y');
		
	cin >> chr;

	return 0;
}