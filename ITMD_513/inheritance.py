'''
This program demonstrates OOP.

Name: Deborah
'''

# This is class person (with inheritance).
class Person():
    #Constructor that is not initialized.
    def __init__(self, name, idnumber):
        self._name = name
        self._idnumber = idnumber
'''
    def display(self):
        print(self._name)
        print(self._idnumber)
'''

# Child class
class Employee(Person):
    def __init__(self, name, idnumber, salary, post):
        self.salary = salary
        self.post = post

        # Invoking the __init__ of the parent class
        Person.__init__(self, name, idnumber)

    def display(self):
        #print(self.salary)
        #print(self.post)
        print(self._name)
        print(self._idnumber)


# The main program
'''
a = Person('Ana', 81178)
a.display()
'''
a = Employee('Ana', 81178, 120000, 'TA')
a.display()

b = Person('John', 8888)
b.display()
