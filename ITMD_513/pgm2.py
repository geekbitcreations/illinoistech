# This program determines whether a bank customer qualifies for a loan.
# Deborah Barndt

min_salary = 30000
min_years = 2

salary = eval(input('Enter year annual salary: '))
years_on_job = eval(input('Enter the number of years employed: '))

if (salary >= min_salary or years_on_job >= min_years):
    print('You are qualified for the loan.')
else:
    print('You do not qualify for this loan.')
