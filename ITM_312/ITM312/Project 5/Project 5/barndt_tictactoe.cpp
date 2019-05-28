// This program is a tic tac toe game. If gives the option of 1 or 2 players and gives 
// the player 10 tries in order to win the game. 
// Written by Deborah Barndt

#include <iostream>
#include "Game.h"
#include <conio.h>
#include <iomanip>
using namespace std;

// Function prototypes
void welcome();
const void getInput();
void printBoard();
const void boardReset();
int checkGame();

int main()
{
	char restartgame;	// Variable to restart the game
	TicTac game;		// The game
	game.welcome();		// The game's welcome message
	game.getInput();	// Get input from the player

	cout << "Do you want to play again? Enter (y/n): ";
	cin >> restartgame;

	if (restartgame == 'y')
	{
		cout << "\n\n\n";
		game.welcome();
		game.getInput();
	}

	else if (restartgame == 'n')
	{
		cout << "Exiting program....." << endl;
		return 0;
	}
}

// Default Constructor
TicTac::TicTac()		
{

}

// Displays the welcome message
void TicTac::welcome()
{
	cout << endl;
	cout << "Welcome to the Programmer's Tic Tac Toe Game." << endl;
	cout << endl;
	// Print game board
	printBoard();
}

// Default Destructor
TicTac::~TicTac()
{

}

// Get input from the user and find the winner of the game
const void TicTac::getInput()
{
	char sign = 'X';
	int input = 0;
	int player = 1;

	do
	{
		// Alternate user
		player = (player % 2) ? 1 : 2;

		cout << endl;
		cout << "Player " << player << ", please enter your move (1-9): ";
		// Input the array numbers
		cin >> input;

		if ((input >= 1 && input <= 9) && (box[input - 1] != 'X' && box[input - 1] != 'O'))
		{
			cout << endl;
			sign = (player == 1) ? 'X' : 'O';
			box[input - 1] = sign;
			printBoard();

			if (checkGame() == 1)
			{
				cout << "Congratulations!" << endl;
				cout << "Player" << player << " Wins!" << endl;
				cout << endl;
				turns = 0;
				boardReset();
			}

			turns = turns - 1;
			player++;
		}

		else if (input == 0)
			turns = 0;

		else
		{
			cout << "Invalid move ";
			cin.ignore();
			cout << endl;
			cin.get();
		}
	}

	while (turns > 1);

	if (turns == 1)
	{
		cout << "This game is a draw!" << endl;
		cout << "Player 1 and Player 2 Tied!" << endl;
		cout << endl;
		boardReset();
	}
}

// Print the game board
void TicTac::printBoard() const
{
	cout << "Player 1 (X)   ||   Player 2 (O)" << endl;
	cout << setw(30) << "Enter 0 to terminate it." << endl;
	cout << endl;
	cout << "        |     |        " << endl;
	cout << "     " << box[0] << "  |  " << box[1] << "  |  " << box[2] << endl;
	cout << "   _____|_____|_____   " << endl;
	cout << "        |     |        " << endl;
	cout << "     " << box[3] << "  |  " << box[4] << "  |  " << box[5] << endl;
	cout << "   _____|_____|_____   " << endl;
	cout << "        |     |        " << endl;
	cout << "     " << box[6] << "  |  " << box[7] << "  |  " << box[8] << endl;
}

// Check the status of the game
int TicTac::checkGame() const     
{
	if (((box[0] == box[1] && box[1] == box[2]) ||
		(box[0] == box[3] && box[3] == box[6]) ||
		(box[6] == box[7] && box[7] == box[8]) ||
		(box[2] == box[5] && box[5] == box[8]) ||
		(box[0] == box[4] && box[4] == box[8]) ||
		(box[2] == box[4] && box[4] == box[6]) ||
		(box[1] == box[4] && box[4] == box[7]) ||
		(box[3] == box[4] && box[4] == box[5])) &&
		(turns > 1)
		)
	{
		return 1;
	}
}

// Reset the game board
const void TicTac::boardReset()
{
	// '1' has value 49
	int values = 49; 
	for (int i = 0; i <= 9; i++)
	{
		box[i] = values;
		values += 1;
	}
}