'''
Deborah Barndt
3-14-19
LoanAmortization.py
midterm: Financial Application: Loan Amortization Schedule

This program will let the user enter the loan amount, the number of years, and
the interest rate. Then it will display the amortization schedule for the loan.

The monthly payment for a given loan pays the principal and the interest. The
monthly interest is computed by multiplying the monthly interest rate and the
balance (the remaining principal). The principal paid for the month is therefore
the monthly payment minus the monthly interest.

Written by Deborah Barndt.
'''

# Function to get the input from the user, and print the loan amortization schedule.
def main():
    # Ask the user for the loan amount and check if it is valid.
    while True:
        try:
            loanAmount = float(input('Enter the total loan amount: '))

        except ValueError:
            print('The loan amount you entered is not valid.')
            continue

        if(loanAmount <= 0):
            print('The loan amount is not valid and must be a positive number.')
            continue

        break

    # Ask the user for the number of years and check if it is valid.
    while True:
        try:
            numYears = int(input('Enter the number of years: '))

        except ValueError:
            print('The number of years is not valid.')
            continue

        if(numYears <= 0):
            print('The number of years is not valid and must be greater than 0.')
            continue

        break
    
    # Ask the user for the annual interest rate and check if it is valid.
    while True:
        try:
            annualInterestRate = float(input('Enter the annual interest rate: '))

        except ValueError:
            print('The interest rate is not valid.')
            continue

        if(annualInterestRate <= 0):
            print('The interest rate is not valid and must be a positive number.')
            continue

        break

    # Calculate the monthly interest rate.
    monthlyInterestRate = annualInterestRate / 1200

    # Calculate the monthly payments.
    monthlyPayment = loanAmount * monthlyInterestRate / (1 - (pow(1 / (1 + monthlyInterestRate), numYears * 12)))

    # Calculate the total payments.
    totalPayment = int(monthlyPayment * 12 * numYears * 100) / 100.00

    # Convert the principal to the balance.
    balance = loanAmount

    # Print the input from the user.
    print('\nLoan Amount: ', format(loanAmount, '.2f'))
    print('Number of Years: ', numYears)
    print('Annual Interest Rate: ', format(annualInterestRate, '.2f') + '\n')

    # Print the monthly and total payments.
    print('Monthly Payment: ' + format(int(monthlyPayment * 100) / 100.0, '.2f'))
    print('Total Payment: ', format(totalPayment, '.2f') + '\n')

    # Print the headers for the table.
    print('Payment#\t Interest\t Principal\t Balance')

    # For loop to create the data for the table.
    for i in range(1, numYears * 12 + 1):
        interest = int(monthlyInterestRate * balance * 100) / 100.00
        principal = int((monthlyPayment - interest) * 100) / 100.00
        balance = int((balance - principal) * 100) / 100.00
        print(i, '\t\t', format(interest, '.2f') + '\t\t', format(principal, '.2f') + '\t\t', format(balance, '.2f') + '\t\t')
        

# Call the main function to run the program.
main()
    
        
        
    
