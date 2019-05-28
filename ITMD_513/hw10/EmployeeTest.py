'''
Deborah Barndt
4-8-19
EmployeeTest.py
hw10: Inheritance

This program will contain two classes: Employee and ProductionWorker. The Employee class
will keep data attributes for the following pieces of information: Employee name and
Employee number. The ProductionWorker will be a subclass of the Employee class. The
ProductionWorker class will keep data attributes for the following information: Shift
number (an integer, such as 1, 2, or 3) and Hourly pay rate.

The workday is divided into two shifts: day and night. The shift attribute will hold an
integer value representing the shift that the employee works. The day shift is shift 1 and
the night shift is shift 2. Write the appropriate accessor and mutator methods for each
class. Once you have written the classes, write a program that creates an object of the
ProductionWorker class and prompts the user to enter data for each of the object's data
attributes. Store the data in the object, then use the object's accessor methods to
retrieve it and display it on the screen.

Written by Deborah Barndt.
'''
from Employee import ProductionWorker

# Function to display the values of the data attributes.
def main():
    while True:
        print('Please enter the details of the employee.\n')

        while True:
            name = input('Enter employee name: ')

            if not name:
                print('\nInvalid input: Employee name cannot be empty.')
                continue

            else:
                break

        while True:
            emp_num = input('Enter employee number: ')

            if not emp_num:
                print('\nInvalid input: Employee number cannot be empty.')
                continue

            try:
                emp_num = int(emp_num)

            except:
                print('\nInvalid input: Please type a number.')
                continue

            else:
                break

        while True:
            shift_num = input('Enter shift number: ')

            if not shift_num:
                print('\nInvalid input: Shift number cannot be empty.')
                continue

            try:
                shift_num = int(shift_num)

            except:
                print('\nInvalid input: Please type a number.')
                continue

            else:
                break

        while True:
            hourly_rate = input('Enter hourly pay rate: ')

            if not hourly_rate:
                print('\nInvalid input: Hourly pay rate cannot be empty.')
                continue

            try:
                hourly_rate = float(hourly_rate)

            except:
                print('\nInvalid input: Please type a number.')
                continue

            else:
                break

        while True:
            enterAgain = input('Would you like to enter another phone number? (y/n): ')

            if not enterAgain:
                print('\nInvalid input: Employee name cannot be empty.')
                continue

            else:
                break

        employee = ProductionWorker(name, emp_num, shift_num, hourly_rate)
    
        print('\n\n----------------------------------')
        print('    Production Worker Details')
        print('----------------------------------')

        print('Employee Name: ', employee.getEmployeeName())
        print('Employee Number: ', employee.getEmployeeNum())

        if (employee.getShiftNum() == 1):
            print('Shift Number: ', employee.getShiftNum(), 'Day shift')

        elif (employee.getShiftNum() == 2):
            print('Shift Number: ', employee.getShiftNum(), 'Night shift')
        
        print('Hourly Pay Rate: $' + '%.2f' % employee.getHourlyRate())
        print('----------------------------------\n\n')
        
        if (enterAgain != 'y'):
            print('Thank you for using the Production Worker Details program.')
            break

# Call the main function to start the program.
main()
