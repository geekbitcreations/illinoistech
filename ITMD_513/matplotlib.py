'''
matplotlib

For Windows:
go to command line and type pip install matplotlib

For MAC:
become super user, and then type pip3 install matplotlib

This is a simple program to create a simple line graph.

Written by Deborah Barndt
'''

import matplotlib.pyplot as plt


# This function builds and displays a line graph.
def main():
    # Create the lists with the X and Y coordinates of each data point.
    x_coords = [0, 1, 2, 3, 4]
    y_coords = [0, 3, 1, 5, 2]

    # Build the line graph
    plt.plot(x_coords, y_coords)

    # Displays the line graph
    plt.show()

# Call the main function
main()


'''
# This function builds and displays a pie chart.
def main():
    # Create a list of sales amounts.
    sales = [100, 400, 300, 600]

    # Create a list of labels for the pie chart slices.
    slice_labels = ['1st Qtr', '2nd Qtr', '3rd Qtr', '4th Qtr']

    # Create a pie chart from the values.
    plt.pie(sales, labels = slice_labels)

    # Display the pie chart
    plt.show()

# Call the main function.
main()

'''
'''
# Create a bar chart

# x-axis values
x = [5, 2, 9, 4, 7]

# y-axis values
y = [10, 5, 8, 4, 2]

# plot the bar
plt.bar(x, y)

# Display the bar plot
plt.show()
'''

'''
import turtle

obj = turtle.Turtle()

for i in range(4):
    obj.forward(50)
    obj.right(90)

turtle.done()
'''


