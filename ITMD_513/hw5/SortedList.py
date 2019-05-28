'''
Deborah Barndt
2-20-19
SortedList.py
hw5: Question 1 Sorted List

This program will prompt the user to enter a list and display whether the list
is sorted or not sorted. 

Written by Deborah Barndt.
'''

# Function that returns true if the list is already sorted in increasing order.
def isSorted(lst):
    for i in range(len(lst) - 1):
        if (lst[i] > lst[i + 1]):
            return False
    return True

# Function that will prompt the user to enter a list and then displays whether
# the list is sorted or is not sorted.
def main():
    enterAgain = 'y'

    while (enterAgain == 'y'):
        lst = input('Please enter a list of numbers with spaces: ')

        lst = lst.split(' ')

        for i in range(len(lst)):
            lst[i] = int(lst[i])
        if isSorted(lst):
            print('The list is already sorted.')

            # Ask the user if they would like to enter another list.
            enterAgain = input('\nWould you like to enter another list? (y/n) ')
        else:
            print('The list is not sorted.')

            # Ask the user if they would like to enter another list.
            enterAgain = input('\nWould you like to enter another list? (y/n) ')

            if (enterAgain == 'n'):
                print('\nThank you. Please come again.')


# Call the main function to begin the test program.
main()
