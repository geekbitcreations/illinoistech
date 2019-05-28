'''
This program demonstrates Recursive call.

Name: Deborah
'''

'''
def main():
    message(7)

def message(times):
  if (times > 0):
    print('This is a recursive function')
    message(times - 1)
'''
'''
def main():
    number = int(input('Enter a non-negative integer: '))
    fact = factorial(number)
    print('The factorial of', number, 'is', fact)

def factorial(num):
    if (num == 0):
        return 1

    else:
        return num * factorial(num - 1)
'''

def main():
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    my_sum = range_sum(numbers, 2, 8)
    print('The sum of items 2 through 8 is', my_sum)

def range_sum(num_list, start, end):
    if (start > end):
        return 0

    else:
        return num_list[start] + range_sum(num_list, start + 1, end)
    
# call main program
main()
