'''
This program demonstrates Ecapsulation concepts.

Name: Deborah
'''

class Car(object):
    def __init__(self, make = 'Ford', model = 'Explorer', year = '2019', milage = '2812', color = 'blue'):
        self.__make = make
        self.__model = model
        self.__year = year
        self.__milage = milage
        self.__color = color
'''
    def getModel(self):
        return(self.__model)
'''

# Main program
mycar = Car()
print(mycar.getModel())
