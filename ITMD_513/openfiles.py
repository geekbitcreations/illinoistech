'''
Program documentation here.....
'''

PI= 3.142

def main()
    filename = input('Enter the full path name of your file: ')
    fp = open(filename, 'r')

    if os.path.isfile(fp):
        for line in fp:
            s = fp.read() # will read the entire file
            scores = [eval(x) for x in s.split()]
            print(scores)

    fp.close()

# Call main function
main()

'''
    outfile = open('/users/u53r/downloads/temp/copyfile', 'w')

    for line in fp:
        print(line)
        print('\n')

    fp.close()
    
# Call the main program
main()

def main()
    filename = input('Enter the full path name of your file: ')
    fp = open(filename, 'w')

    radius = 1.5
    area = radius * PI * PI

    fp.write('With radius = %.2f, the area is %.2f' % (radius, area))
    fp.write('Bill Clinton')
    fp.write('George Bush')
    fp.write('Barack Obama')

    fp.close()

# Call the main program
main()

fp = open('/users/u53r/downloads/temp/data.txt', 'w')
fp.write('Python is a great language.')
fp.close()
'''


