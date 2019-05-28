'''
Deborah Barndt
1-14-19
StockTransaction.py
hw1: Stock Transaction Program

This program will display the amount of money Joe paid for the stock, the amount
of commission Joe paid his broker when he bought the stock, the amount Joe sold
the stock, the amount of commission Joe paid his broker when he sold the stock,
and the amount of money Joe had left when he sold the stock and paid his broker
(both times). If the amount is positive, then Joe made a profit. If the amount
is negative, then Joe lost money.

Written by Deborah Barndt.
'''

numShares = 2000            # number of shares purchased
purchasePrice = 40.00       # purchase price per share
commissionRate = 0.03       # commission is 3%
sellPrice = 42.75           # selling price per share
numSold = 2000              # number of shares sold

'''
# Testing values

# Test value set 1
numShares = 2500            # number of shares purchased
purchasePrice = 50.00       # purchase price per share
commissionRate = 0.03       # commission is 3%
sellPrice = 53.50           # selling price per share
numSold = 2500              # number of shares sold

#Test value set 2
numShares = 3000            # number of shares purchased
purchasePrice = 30.00       # purchase price per share
commissionRate = 0.03       # commission is 3%
sellPrice = 32.75           # selling price per share
numSold = 3000              # number of shares sold

# Test value set 3
numShares = 1000            # number of shares purchased
purchasePrice = 20.00       # purchase price per share
commissionRate = 0.03       # commission is 3%
sellPrice = 23.25           # selling price per share
numSold = 1000              # number of shares sold
'''

# Calculate the amount paid for the stocks.
amountPaid = numShares * purchasePrice

# Calculate the commission paid to broker from purchase.
purchaseCommission = amountPaid * commissionRate

# Calculate the total paid for the stock.
totalPaid = amountPaid + purchaseCommission

# Calculate the amount the stocks sold for.
stockSold = numSold * sellPrice

# Calculate the commission paid to broker from sale.
sellCommission = stockSold * commissionRate

# Calculate the total amount received from selling the stock.
totalReceived = stockSold - sellCommission

# Calculate the profit or loss from the stock and the broker.
totalProfitLoss = totalReceived - totalPaid

# Display the results.
print('Amount Joe paid for stocks: $', \
      format(totalPaid, '.2f'))
print('Amount broker was paid for purchase: $', \
      format(purchaseCommission, '.2f'))
print('Amount Joe sold the stocks: $', \
      format(totalReceived, '.2f'))
print('Amount broker was paid for sale: $', \
      format(sellCommission, '.2f'))

# Display the results if Joe lost money or made a profit.
if totalProfitLoss < 0:
    print('Joe lost at total of $', \
          format(int(totalProfitLoss), '.2f'))
else:
    print('Joe made a profit of $', \
          format(totalProfitLoss, '.2f'))
