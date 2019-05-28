'''
Deborah Barndt
4-29-19
ChangeCounter.py
hw13: Graphical User Interface

This program will create a GUI that will allow the user to input the number of each
type of coin they have in their possession, and then compute and display the total
dollar and cents value of these coins. The solution must accommodate Quarter, Dime,
Nickel, and Penny coins. Include Half-dollar and Dollar coins as well. The solution
must be robust against invalid inputs.
#83D681
Written by Deborah Barndt.
'''

from tkinter import *
from tkinter import messagebox

# Function to calculate the coin in user's possesion.
def calcPurse():
    total = 0
    dollars = float(t1.get(1.0, END))
    halfdollars = float(t2.get(1.0, END))
    quarters = float(t3.get(1.0, END))
    dimes = float(t4.get(1.0, END))
    nickels = float(t5.get(1.0, END))
    pennies = float(t6.get(1.0, END))

    if (dollars < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    elif (halfdollars < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    elif (quarters < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    elif (dimes < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    elif (nickels < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    elif (pennies < 0):
        messagebox.showerror('Error', 'Input cannot be a negative number.')

    else:
        # Calculate the total amount of coin.
        doltotal = dollars * 1.00
        halftotal = halfdollars * 0.50
        qtotal = quarters * 0.25
        dtotal = dimes * 0.10
        ntotal = nickels * 0.05
        ptotal = pennies * 0.01
        total = doltotal + halftotal + qtotal + dtotal + ntotal + ptotal

        change = 'Total Change Value: $' + str(float('%.2f' % total))
        calc.set(change)

        dolcalc.set('{0:.2f}'.format(doltotal))
        halfcalc.set('{0:.2f}'.format(halftotal))
        qcalc.set('{0:.2f}'.format(qtotal))
        dcalc.set('{0:.2f}'.format(dtotal))
        ncalc.set('{0:.2f}'.format(ntotal))
        pcalc.set('{0:.2f}'.format(ptotal))

# Create an instance for window.
window = Tk()

# Give the window a title.
window.title('Change Counter')
window.geometry('500x300')
window.config(background = '#83D681')
calc = StringVar()
dolcalc = StringVar()
halfcalc = StringVar()
qcalc = StringVar()
dcalc = StringVar()
ncalc = StringVar()
pcalc = StringVar()

# Create a label for the instructions on window.
label = Label(window, background = '#83D681', text = 'Enter the number of each coin type and hit Compute Button:')
label.grid(column = 0, row = 0, padx = 5, pady = 5)

# Create a label for the dollars.
lb1 = Label(window)
lb1.config(height = 1, width = 10, background = '#83D681', text = 'Dollars:')
lb1.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for dollars.
t1 = Text(window, height = 1, width = 10)
t1.grid(column = 0, row = 1, padx = 5, pady = 5)

# Create a label for the dollars value.
lb7 = Label(window)
lb7.config(height = 1, width = 15, background = '#83D681', text = 'Dollars Value: $')
lb7.grid(sticky = E, row = 1, padx = 5, pady = 5)

# Create a entry box to display the dollars value.
t7 = Entry(window, state = "readonly", width = 10, textvariable = dolcalc)
t7.grid(column = 2, row = 1, padx = 5, pady = 5)

# Create a label for the half-dollars.
lb2 = Label(window)
lb2.config(height = 1, width = 10, background = '#83D681', text = 'Half-dollars:')
lb2.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for half-dollars.
t2 = Text(window, height = 1, width = 10)
t2.grid(column = 0, row = 2, padx = 5, pady = 5)

# Create a label for the half-dollars value.
lb8 = Label(window)
lb8.config(height = 1, width = 15, background = '#83D681', text = 'Half-dollars Value: $')
lb8.grid(sticky = E, row = 2, padx = 5, pady = 5)

# Create a entry box to display the half-dollars value.
t8 = Entry(window, state = "readonly", width = 10, textvariable = halfcalc)
t8.grid(column = 2, row = 2, padx = 5, pady = 5)

# Create a label for the quarters.
lb3 = Label(window)
lb3.config(height = 1, width = 10, background = '#83D681', text = 'Quarters:')
lb3.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for the quarters.
t3 = Text(window, height = 1, width = 10)
t3.grid(column = 0, row = 3, padx = 5, pady = 5)

# Create a label for the quarters value.
lb9 = Label(window)
lb9.config(height = 1, width = 15, background = '#83D681', text = 'Quarters Value: $')
lb9.grid(sticky = E, row = 3, padx = 5, pady = 5)

# Create a entry box to display the quarters value.
t9 = Entry(window, state = "readonly", width = 10, textvariable = qcalc)
t9.grid(column = 2, row = 3, padx = 5, pady = 5)

# Create a label for the dimes.
lb4 = Label(window)
lb4.config(height = 1, width = 10, background = '#83D681', text = 'Dimes:')
lb4.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for the dimes.
t4 = Text(window, height = 1, width = 10)
t4.grid(column = 0, row = 4, padx = 5, pady = 5)

# Create a label for the dimes value.
lb10 = Label(window)
lb10.config(height = 1, width = 15, background = '#83D681', text = 'Dimes Value: $')
lb10.grid(sticky = E, row = 4, padx = 5, pady = 5)

# Create a entry box to display the dimes value.
t10 = Entry(window, state = "readonly", width = 10, textvariable = dcalc)
t10.grid(column = 2, row = 4, padx = 5, pady = 5)

# Create a label for the nickels.
lb5 = Label(window)
lb5.config(height = 1, width = 10, background = '#83D681', text = 'Nickels:')
lb5.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for the nickels.
t5 = Text(window, height = 1, width = 10)
t5.grid(column = 0, row = 5, padx = 5, pady = 5)

# Create a label for the nickels value.
lb8 = Label(window)
lb8.config(height = 1, width = 15, background = '#83D681', text = 'Nickels Value: $')
lb8.grid(sticky = E, row = 5, padx = 5, pady = 5)

# Create a entry box to display the nickels value.
t8 = Entry(window, state = "readonly", width = 10, textvariable = ncalc)
t8.grid(column = 2, row = 5, padx = 5, pady = 5)

# Create a label for the pennies.
lb6 = Label(window)
lb6.config(height = 1, width = 10, background = '#83D681', text = 'Pennies:')
lb6.grid(sticky = N+W, padx = 5, pady = 5)

# Create an input box for the pennies.
t6 = Text(window, height = 1, width = 10)
t6.grid(column = 0, row = 6, padx = 5, pady = 5)

# Create a label for the pennies value.
lb8 = Label(window)
lb8.config(height = 1, width = 15, background = '#83D681', text = 'Pennies Value: $')
lb8.grid(sticky = E, row = 6, padx = 5, pady = 5)

# Create a entry box to display the pennies value.
t8 = Entry(window, state = "readonly", width = 10, textvariable = pcalc)
t8.grid(column = 2, row = 6, padx = 5, pady = 5)

# Create a button to calculate the change.
btn = Button(window, text = 'Compute', fg = 'green', command = calcPurse).grid(column = 0, row = 7, padx = 5, pady = 5)

# Create a label for the change calculation results.
lbl = Label(window)
lbl.config(height = 1, width = 50, background = '#83D681', textvariable = calc)
lbl.grid(column = 0, row = 8, padx = 5, pady = 5)

# Create an event loop.
window.mainloop()
