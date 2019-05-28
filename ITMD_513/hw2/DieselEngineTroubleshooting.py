'''
Deborah Barndt
1-30-19
DieselEngineTroubleshooting.py
hw1: Diesel Engine Troubleshooting

This program will ask the user for input on how to troubleshoot their diesel
engine via a troubleshooting chart, and display a solution to their problem.

Written by Deborah Barndt.
'''

# Give a welcome message to the user.
print('Welcome to the Diesel Engine Troubleshooting Program.\n')

# Ask the user what color their status lights are.
light_status = input('What color are the status lights? [green, red, or amber] ')

# Create if/else statements to flow through the troubleshooting chart.
# Display the result if light status is green.
if (light_status == 'green'):
    print('Do a restart procedure.')
    print('\nThank you for using the Diesel Engine Troubleshooting Program.')

# Display the result if light status is amber.
elif (light_status == 'amber'):
    print('Check the fuel line service routine.')
    print('\nThank you for using the Diesel Engine Troubleshooting Program.')

# Display the result if the light status is red.
elif (light_status == 'red'):
    print('Shut off all input lines, then check meter #3.')

    # Ask the user if meter #3 is less than 50 or greater than or equal to 50.
    meter3 = int(input('\nWhat number does meter #3 display? '))

    # Display the result if meter #3 is less than 50.
    if (meter3 < 50):
        print('Check the main line for test pressure.')

        # Ask the user what the test pressure is.
        test_pressure = input(
            '\nWhat is the test pressure on the main line? [normal, high, or low] ')

        # Display result if the test pressure is normal.
        if (test_pressure == 'normal'):
            print('Refer to the motor service manual.')
            print('\nThank you for using the Diesel Engine Troubleshooting Program.')

        # Display the result if the test pressure is high or low.
        elif (test_pressure == 'high' or test_pressure == 'low'):
            print('Refer to the main line manual.')
            print('\nThank you for using the Diesel Engine Troubleshooting Program.')

        else:
            print('Please enter the correct input.')
            print('Please try again.')

    # Display the result if meter #3 is greater than or equal to 50.
    elif (meter3 >= 50):
        print('Measure the flow velocity at inlet 2-B.')

        # Ask the user what is the flow velocity of inlet 2-B.
        flow_velocity = input(
            '\nWhat is the flow velocity of inlet 2-B? [high, low, or normal] ')

        # Display the result if the flow velocity is high or low.
        if (flow_velocity == 'high' or flow_velocity == 'low'):
            print('Refer the diesel engine unit for factory service.')
            print('\nThank you for using the Diesel Engine Troubleshooting Program.')

        # Display the result if the flow velocity is normal.
        elif (flow_velocity == 'normal'):
            print('Refer to the inlet service manual.')
            print('\nThank you for using the Diesel Engine Troubleshooting Program.')

        else:
            print('Please enter the correct input.')
            print('Please try again.')

else: 
    print('Please enter the correct input.')
    print('Please try again.')
