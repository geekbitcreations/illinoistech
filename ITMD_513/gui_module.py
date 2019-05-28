'''
This program demonstrates Python GUI.

Name: Deborah
'''

from tkinter import *

window = Tk()
label = Label(window, text = 'Welcome to Python')
button = Button(window, text = 'Click Me')
label.pack()
button.pack()

# Start the program.
window.mainloop()
