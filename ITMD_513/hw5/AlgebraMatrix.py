'''
Deborah Barndt
2-20-19
AlgebraMatrix.py
hw5: Question 2 Algebra Matrix

This program will prompt a user to enter two 3 x 3 matrices and display their
product.

Written by Deborah Barndt.
'''

# Function that will multiply two matrices given by the user.
def multiplyMatrix(a, b):
    rowA = len(a)
    colA = len(a[0])
    rowB = len(b)
    colB = len(b[0])

    if (colA != rowB):
        print('You entered the wrong dimensions for matrices.')
        return

    result = [[0 for row in range(colB)] for col in range(rowA)]

    # For loop to iterate through each of the rows and columns.
    for i in range(rowA):
        for j in range(colB):
            for k in range(colA):
                result[i][j] += round(a[i][k] * b[k][j], 1)

    return result

# Function to prompt the user to enter the two 3 x 3 matrices and displays
# the product.
def userMatrix(num):
    userinput = input('Enter a matrix with spaces for matrix' + str(num) + ': ').split()

    userinput = list(map(float, userinput))
    total = len(userinput)
    row = int(total ** 0.5)

    matrix = [userinput[i:i + row] for i in range(0, total, row)]

    return matrix

# Function that will store the input into both matrices.
def main():
    matrix1 = userMatrix(1)
    matrix2 = userMatrix(2)
    productMatrix = multiplyMatrix(matrix1, matrix2)
    display = [[' ', ' '], ['* ', '= '], [' ', ' ']]

    print('The multplication of the matrices is:\n')

    for i in range(len(matrix1)):
        print(str(matrix1[i][0]) + ' ' + str(matrix1[i][1]) + ' '
              + str(matrix1[i][2]) + '\t ' + display[i][0] + str(matrix2[i][0])
              + ' ' + str(matrix2[i][1]) + ' ' + str(matrix2[i][2]) + '\t '
              + display[i][1] + str(productMatrix[i][0]) + ' '
              + str(productMatrix[i][1]) + ' ' + str(productMatrix[i][2]))


# Call the main function to begin the program.
main()

    
