'''
This program demostrates Abstract class.

Name: Deborah
'''

class AbstractAnimal(object):
    #__metaclass__ = abc.ABCMeta

    def walk(self):
        ''' data '''

    def talk(self):
        ''' data '''

class Duck(AbstractAnimal):
    name = ''

    def __init__(self, name):
        self.name = name
        print(name, 'created')

    def walk(self):
        print('waddle')

    def talk(self):
        print('quack')


# Main Program
obj = Duck('Steven')
obj.talk()
obj.walk()
