'''
Deborah Barndt
4-3-19
TestMain.py
hw9: Coffee Vending Machine

This program will create a vending machine that will tell the user how many
cups of coffee are available, the cost of one cup of coffee, and the total
amount of money that the user inserted into the machine. The machine will
require exact change.

Written by Deborah Barndt.
'''

from VendingMachine import CoffeeVendingMachine

def testmain():
    option = ''
    quantity = 10
    cost = 0.50
    
    vendingMachine = CoffeeVendingMachine(quantity, cost)

    print('\n\nWelcome to the Coffee Vending Machine.')

    while option.lower() != 'exit':
        option = input('Please select an option from the menu by number or name:\n'
                       '1. Menu\n'
                       '2. Insert Money\n'
                       '3. Select Coffee\n'
                       '4. Refund Money\n'
                       '5. Exit\n\n'
                       'Select Option: ')

        # If statement for each of the options on the menu.
        if (option.lower() in '1. menu'):
            vendingMachine.menu()

        elif (option.lower() in '2. insert money'):
            # Ask user to enter the number of quarters, dimes, and nickels they are inserting.
            quarters = int(input('Enter the number of quarters inserted: '))
            dimes = int(input('Enter the number of dimes inserted: '))
            nickels = int(input('Enter the number of nickels inserted: '))

            vendingMachine.insert(quarters, dimes, nickels)

        elif (option.lower() in '3. select coffee'):
            vendingMachine.select()                

        elif (option.lower() in '4. refund money'):
            vendingMachine.refund()

        elif (option.lower() in '5. exit'):
            break

        else:
            print('Your input is invalid. Please enter a number or name from the menu.\n')
    
    print('Thank you for using the Coffee Vending Machine.')
    

# Call testmain function to begin program.
testmain()
