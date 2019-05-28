'''
This program demonstrates the concepts of Classes and Obejcts.

Author: Deborah
'''

from Circle import Circle

def main():
    
    circle1 = Circle(2.5) # Create a new object called circle1
    '''
    circle1.setRadius(1.5)
    print(circle1.getArea())
    print("The perimeter is ", circle1.getPerimeter())
    print("The radius of circle is ", circle1.getRadius())
    '''
    radius = 2.5
    circle1.printAll()

# Start the program
main()
