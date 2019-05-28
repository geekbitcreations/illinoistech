'''
This program demonstrates Python Dictionary and Set.

Name: Deborah
'''

'''
Dict = {}
print(Dict)

Dict = {1: 'Geeks', 2: 'For', 3: 'Geeks'}
print(Dict)

Dict = {'Name': 'Geeks', 1:[1, 2, 3, 4]}
print(Dict)

Dict = dict({1: 'Geeks', 2: 'For', 3: 'Geeks'})
print(Dict)

Dict = dict([(1, 'Geeks'), (2, 'For')])
print(Dict)

Dict = {1:'Geeks', 'name':'For', 3:'Geeks'}
print(Dict)

print('Accessing an element using key: ')
print(Dict['name'])

print('Accessing an element using key: ')
print(Dict[1])

print('Accessing an element using get() method: ')
print(Dict.get(3))
'''

# Initializing my dictionary
Dict = {5:'Welcome', 6:'To', 7:'Geeks',
        'A': {1:'Geeks', 2:'For', 3:'Geeks'},
        'B': {1:'Geeks', 2:'Life'}}
'''
print(Dict)
del Dict[6]
print(Dict)
print('\n')

del Dict['A'][2]
print(Dict)

Dict.pop(5)
print(Dict)

Dict.popitem()
print(Dict)
'''

Dict.clear()
print(Dict)
