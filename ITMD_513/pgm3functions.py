# This program shows how to write functions

import random

# This function allows user to play guessing number.
def main():
    number = random.randint(0, 100)
    print('Guess a magic number between 0 and 100')

    guess = -1
    while guess != number:
        guess = eval(input('Enter your guess: '))
        if (guess == number):
            print('Congratulations! You got it right!')
        elif (guess > number):
            print('Too high')
        else:
            print('Too low')

# Calling the function
main()
