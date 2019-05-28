'''
Deborah Barndt
4-8-19
Employee.py
hw10: Inheritance

This program will contain two classes: Employee and ProductionWorker. The Employee class
will keep data attributes for the following pieces of information: Employee name and
Employee number. The ProductionWorker will be a subclass of the Employee class. The
ProductionWorker class will keep data attributes for the following information: Shift
number (an integer, such as 1, 2, or 3) and Hourly pay rate.

The workday is divided into two shifts: day and night. The shift attribute will hold an
integer value representing the shift that the employee works. The day shift is shift 1 and
the night shift is shift 2. Write the appropriate accessor and mutator methods for each
class. Once you have written the classes, write a program that creates an object of the
ProductionWorker class and prompts the user to enter data for each of the object's data
attributes. Store the data in the object, then use the object's accessor methods to
retrieve it and display it on the screen.

Written by Deborah Barndt.
'''

# Class Employee that contains data attributes for Employee name and Employee number.
class Employee():
    # Function to create a constructor of class Employee.
    def __init__(self, employee_name, employee_num):
        self.employee_name = employee_name
        self.employee_num = employee_num

    # Getter function to get employee name.
    def getEmployeeName(self):
        return self.employee_name

    # Setter function to set the employee name.
    def setEmployeeName(self, employee_name):
        self.employee_name = employee_name

    # Getter function to get employee number.
    def getEmployeeNum(self):
        return self.employee_num

    # Setter function to set the employee number.
    def setEmployeeNum(self, employee_num):
        self.employee_num = employee_num


# Class ProductionWorker that contains the data attributes for Shift number and Hourly pay rate.
class ProductionWorker(Employee):
    # Function to create a constructor of the class ProductionWorker.
    def __init__(self, employee_name, employee_num, shift_num, hourly_rate):
        # Invoke the constructor of Employee class.
        Employee.__init__(self, employee_name, employee_num)

        self.shift_num = shift_num
        self.hourly_rate = hourly_rate

    # Getter function to get shift number.
    def getShiftNum(self):
        return self.shift_num

    # Setter function to set the shift number.
    def setShiftNum(self, shift_num):
        self.shift_num = shift_num

    # Getter function to get the hourly pay rate.
    def getHourlyRate(self):
        return self.hourly_rate

    # Setter function to set the hourly pay rate.
    def setHourlyRate(self, hourly_rate):
        self.hourly_rate = hourly_rate
