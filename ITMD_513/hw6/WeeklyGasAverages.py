'''
Deborah Barndt
2-28-19
WeeklyGasAverages.py
hw6: Question 2 1994 Weekly Gas Averages

This program will read data from 1994_Weekly_Gas_averages.txt and then plot the
data as either a line graph or a bar chart.

Written by Deborah Barndt.
'''

import matplotlib.pyplot as plt

# Function to read a text file, and then build and display a line graph or bar chart.
def main():
    # Ask the user if they would like the values to be displayed as a line graph or bar chart. 
    display = input('Would you like to display a line graph or bar chart? (line/bar) ')
     
    # Open the text file in read mode.
    averages = open('1994_weekly_gas_averages.txt', 'r')

    # Read the content of the gas averages.
    content = averages.read()

    # Split the content of the gas averages.
    gas = content.split()

    # Close the text file.
    averages.close()

    # For loop to strip the gas price into a float.
    for i in range(0, len(gas)):
        gas[i] = float(gas[i].strip())

    # Create the range for the x-coordinates.
    x_coords = list(range(1,53))

    # Build the line graph or bar chart dependent on user input.
    if (display == 'line'):
        # Build the line graph.
        plt.plot(x_coords, gas, color = 'lightskyblue')

        # Set the limit of x-axis.
        plt.xlim([1, 52])

        # Create the label for the x-axis.
        plt.xlabel('Week')

        # Create the label for the y-axis.
        plt.ylabel('Gas Price')

        # Create the title of the line graph.
        plt.title('Weekly Average Gas Price in 1994')

        # Display the line graph.
        plt.show()

    elif (display == 'bar'):
        # Build the bar chart.
        plt.bar(x_coords, gas, color = 'lightskyblue')

        # Set the limit of x-axis.
        plt.xlim([1, 52])

        # Create the label for the x-axis.
        plt.xlabel('Week')

        # Create the label for the y-axis.
        plt.ylabel('Gas Price')

        # Create the title of the line graph.
        plt.title('Weekly Average Gas Price in 1994')

        # Display the line graph.
        plt.show()

    else:
        print('Invalid input: Type either line or bar.')


# Call the main function the run the program.
main()

    
