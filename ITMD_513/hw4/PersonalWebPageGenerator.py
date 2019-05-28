'''
Deborah Barndt
2-15-19
PersonalWebPageGenerator.py
hw4: Question 1 Personal Web Page Generator

This program will ask the user for his or her name, then ask the user to enter
a sentence that describes himself or herself. Once the user has entered the
requested input, the program should create an HTML file, containing the input,
for a simple web page.

Written by Deborah Barndt.
'''

# Ask the user for his or her name.
username = input('Enter your name: ')

# Ask the user to enter a sentence that describes them.
userdesc = input('Describe yourself: ')

# Open the html file to write the html content
content = open('profile.html', 'w')

# Create the html file for the user profile.
html = '<html>\n' + \
       '<head>\n' + \
       '</head>\n' + \
       '<body>\n' + \
       '\t<center>\n' + \
       '\t\t<h1>' + username + '</h1>\n' + \
       '\t<center>\n' + \
       '\t<hr />\n' + \
       '\t' + userdesc + '\n' + \
       '\t<hr />\n' + \
       '</body>\n' + \
       '</html>\n'

# Write the html into the file for the user profile.
content.write(html)

# Close the file with the html content.
content.close()
