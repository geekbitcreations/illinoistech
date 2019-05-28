# Sample of "while" loop
# Name: _________________

import random

'''
keep_going = 'y'

while (keep_going == 'y'):
    sales = float(input('Enter the amount of sales: '))
    comm_rate = float(input('Enter the commission rate: '))

    commission = sales * comm_rate
    print('The commission is $', format(commission, '.2f'))

    keep_going = input('Do you want to calculate another? <y/n> ')
'''    

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

      
