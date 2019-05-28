'''
This program demonstrates Python GUI.

Name: Deborah
'''

import tkinter as tk

win = tk.Tk()
win.title('Python GUI')

tk.Label(win, text = 'A Label').grid(column = 0, row = 0)

def click_me():
    action.configure(text = '*** I have been clicked! ***')

action = tk.Button(win, text = 'Click Me!', command = click_me)
action.grid(column = 1, row = 0)

# Start the program.
win.mainloop()
