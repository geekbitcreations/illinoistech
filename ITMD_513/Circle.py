'''
Class Circle
'''
import math

class Circle:
    def __int__(self, radius=1): # Constructor
        self.radius = radius

    def getPerimeter(self):
        return (2 * math.pi * self.radius)

    def getArea(self): # Accessor
        return (self.radius * self.radius * math.pi)

    def setRadius(self, radius): # Mutator
        self.radius = radius

    def getRadius(self): # Accessor
        return (self.radius)

    def printAll(self):
        print(self.radius)
        print(self.getArea())
        print(self.getPerimeter())
        
