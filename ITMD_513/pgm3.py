# This program demonstrates statements if/elif/else.
# Deborah Barndt

code = input('Type a 2-letter state code that starts with letter C: ')

if code == 'CA':
    print('CA is California.')
elif code == 'CO':
    print('CO is Colorado.')
elif code == 'CT':
    print('CT is Connecticut.')
else:
    print('Invalid state code with letter C.')

print('Thank you.')
