'''
This program demonstrates Python GUI.

Name: Deborah
'''

from tkinter import *

window = Tk()
window.title('Welcome to GUI App')
window.geometry('350x200')
lb1 = Label(window, text = 'Hello')
lb1.grid(column = 0, row = 0)

txt = Entry(window, width = 10)
txt.grid(column = 1, row = 0)

def clicked():
    res = 'Welcome to ' + txt.get()
    lb1.configure(text = res)

btn = Button(window, text = 'Click Me', command = clicked)
btn.grid(column = 2, row = 0)

# Start the program.
window.mainloop()
