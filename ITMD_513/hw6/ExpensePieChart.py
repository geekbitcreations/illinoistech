'''
Deborah Barndt
2-28-19
ExpensePieChart.py
hw6: Question 1 Expense Pie Chart

This program will read data from a text file and use the matplotlib to plot
out and display a pie chart showing how you spend your money.

Written by Deborah Barndt.
'''

import matplotlib.pyplot as plt

# Function to read a text file, and then build and display a pie chart.
def main():
    # Open the text file in read mode.
    budget = open('expenses.txt', 'r')

    # Create the labels for the pie chart.
    categories = ['Rent', 'Gas', 'Food', 'Clothing', 'Car Payment', 'Misc']

    # Store the expense amounts in the order of the category labels.
    expenses = []

    # Read the content of the expenses file and then read the file line by line.
    content = budget.read()

    for data in content.split('\n'):
        # Add the current expense in the file to the expenses.
        expenses.append(int(data))

    # Create the color scheme for the pie chart.
    colors = ['lightskyblue', 'yellowgreen', 'lightcoral', 'gold','lightgreen', 'orange']

    # Explode the first slice of the expense pie chart.
    explode = (0.1, 0, 0, 0, 0, 0)

    # Plot out the expenses pie chart from the values.
    plt.pie(expenses, labels = categories, colors = colors, explode = explode, autopct = '%1.1f%%', shadow = True, startangle = 90)

    # Set the axis of the expense pie chart as equal.
    plt.axis('equal')

    # Display the expense pie chart.
    plt.show()


# Call the main function to run the program.
main()
    
