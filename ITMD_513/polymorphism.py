'''
This program demonstrates Polymorphism concepts.

Name: Deborah
'''

class User(object):
    def __init__(self, firstname):
        self.name = firstname

class Animal(object):
    pass

class Fox(Animal):
    name = 'Fox'

class Bear(Animal):
    name = 'Bear'

for a in [User('Polymorphism'), Fox(), Bear()]:
    print(a.name)
    
