# Simple I/O Program
# Name: Deborah Barndt / pgm1

print("Welcome to Python Programming!")
print("I'm here to assist\n")
FullName = "Jane Doe"
num1 = 88.581

print(format(num1, '7.2f'))
print(format(num1, '15.2f'))

amount_due = 5000.0
monthly_payment = amount_due / 12 # Divide the amount due by 12
print('The monthly payment is', \
      format(monthly_payment, '.2f'))

name = input('What is your name: ')
age = int(input('How old are you: '))
income = float(input('What is your income: '))

income = eval(input('What is your income: '))
print('Income: %.2f' % income)


'''
This is line1
This is line2
This is line3
'''
