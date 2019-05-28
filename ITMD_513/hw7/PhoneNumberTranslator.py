'''
Deborah Barndt
3-6-19
PhoneNumberTranslator.py
hw7: Alphabetic Telephone Number Translator

Alphabetic Telephone Number Translator:
Many companies use telephone numbers like 555-GET-FOOD so the number is easier for their
customers to remember. On a standard telephone, the alphabetic letters are mapped to numbers
in the following fashion:
A, B, and C = 2
D, E, and F = 3
G, H, and I = 4
J, K, and L = 5
M, N, and O = 6
P, Q, R, and S = 7
T, U, and V = 8
W, X, Y, and Z = 9

This program will ask the user to enter a 10-character telephone number in the format
XXX-XXX-XXXX, then the program will display the telephone number with any alphabetic
characters that appeared in the original translated to their numeric equivalent.
For example, if the user enters 555-GET-FOOD, the program will display 555-438-3663.

Written by Deborah Barndt.
'''

# Function to translate the letters to numbers.
def letterToNum(usernum):
    realnum = ''

    for i in range(0, 12):    
        # Check in the input has a length of 12.
        if (len(usernum) != 12):
            return None

        # Check if the input is a number.
        elif (usernum[i] in '0123456789'):
            realnum += usernum[i]

        # Check if the letter is A, B, or C.
        elif (usernum[i] in 'ABC'):
            realnum += '2'

        # Check if the letter is D, E, or F.
        elif (usernum[i] in 'DEF'):
            realnum += '3'

        # Check if the letter is G, H, or I.
        elif (usernum[i] in 'GHI'):
            realnum += '4'

        # Check if the letter is J, K, or L.
        elif (usernum[i] in 'JKL'):
            realnum += '5'

        # Check if the letter is M, N, or O.
        elif (usernum[i] in 'MNO'):
            realnum += '6'

        # Check if the letter is P, Q, R, or S.
        elif (usernum[i] in 'PQRS'):
            realnum += '7'

        # Check if the letter is T, U, or V.
        elif (usernum[i] in 'TUV'):
            realnum += '8'

        # Check if the letter is W, X, Y, or Z.
        elif (usernum[i] in 'WXYZ'):
            realnum += '9'

        # Check if the input contains 10-characters.
        elif (usernum[i] == '-'):
            if (i != 3 and i != 7):
                #print(realnum)
                return None

            else:
                realnum += '-'

    #print(realnum)
    return realnum

# Function to ask the user to enter a 10-character telephone number and then translate it.
def main():
    while True:
        # Ask the user to enter a 10-character telephone number in a specific format.
        usernum = input('Enter a 10-character telephone number in the format XXX-XXX-XXXX: ')

        # Get the real phone number from the user input.
        realnum = letterToNum(usernum)

        # Check if the number entered by the user is in the correct format.
        if (realnum == None):
            print('Invalid phone number. Please enter in the correct format of XXX-XXX-XXXX')

        else:
            print('The real phone number of ', usernum, ' is: ', realnum)

        # Ask the user if they would like to enter another phone number.
        enterAgain = input('Would you like to enter another phone number? (y/n): ')

        if (enterAgain != 'y'):
            print('Thank you for using the Alphabetic Telephone Number Translator.\n')
            break

# Call the main function to begin the program.
main()

        

