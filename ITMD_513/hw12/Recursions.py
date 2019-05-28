'''
Deborah Barndt
4-22-19
Recursions.py
hw12: Recursions

This program will contain two functions using recursion. The first function
will prompt the user to enter an integer and display its reversal to the console.
The second function will prompt the user to enter a decimal number, convert the
decimal number into a hex number as a string, and then display it on the console.

Written by Deborah Barndt.
'''

# Function to display an integer value reversely on the console.
def reverseDisplay(value):
    # If statement for if the length of the string is zero.
    if (len(value) == 0):
        return

    # Display the result in reverse order.
    print(value[len(value) - 1], end = '')

    # Call the recursive function.
    reverseDisplay(value[: - 1])

# Function to test the reverseDisplay program.
def reverseMain():
    # Prompt the user to enter an integer.
    userValue = input('Please enter an integer: ')

    print('The reverse order of', userValue, 'is ', end = '')

    # Call the reverseDisplay recursive function.
    reverseDisplay(userValue)
    print('\n')


# Call the reverseMain function to begin the program.
reverseMain()


# Function to display the hex equivalent of a decimal number.
def decimalToHex(userDeci):
    # Array to store the hexadecimal number.
    hexDeci = ['0'] * 100

    # Counter for the hexadecimal array.
    i = 0

    while (userDeci != 0):
        # Temporary variable to store the remainder.
        tempNum = 0

        # Store the remainder in the temporary variable.
        tempNum = userDeci % 16

        # If statement to check if the temporary variable is < 10.
        if (tempNum < 10):
            hexDeci[i] = chr(tempNum + 48)
            i = i + 1

        else:
            hexDeci[i] = chr(tempNum + 55)
            i = i + 1

        userDeci = int(userDeci / 16)

    # Print the hexadecimal number in reverse order.
    hexNum = i - 1
    
    while (hexNum >= 0):
        print((hexDeci[hexNum]), end = '')
        hexNum = hexNum - 1
        
    
# Function to test the decimalToHex recursive function.
def decimalMain():
    # Prompt the user to enter a decimal number.
    userDeci = int(input('Please enter a decimal number to convert: '))

    # Call the decimalToHex function to convert user input to hexadecimal.
    decimalToHex(userDeci)


# Call the decimalMain function to begin the program.
decimalMain()
