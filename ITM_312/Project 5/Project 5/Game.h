// This is the header file to the tic tac toe game.
// Written by Deborah Barndt

#pragma once
#ifndef GAME_H_INCLUDED
#define	GAME_H_INCLUDED

class TicTac
{
	public: 
		TicTac();				// Constructor
		~TicTac();				// Destructor
		void welcome();			// Welcome message function
		const void getInput();	// Function to get input from the user

	private:
		char square[9] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char *box = square;			// Pointer to array
		int checkGame() const;		// Variable to get the status of the game
		int turns = 10;				// The number of turns allowed for the game
		void printBoard() const;	// Function to print the game board
		const void boardReset();	// Function to reset the game board
};

#endif // !GAME_H_INCLUDED
