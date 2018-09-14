/* Deborah Barndt
   ITMD 562 Web Site Application Development
   Professor Benjamin Zumhagen
   Week 4 Assignment
   9-11-18
   
  This program will implement a function.
  
  Implement the following function:
  
  function sumCongruentModulo(inputArray, divisor, remainder) { 
  // Your code goes here
  }
  console.log(sumCongruentModulo([1,2,3,6], 3, 0)); // Should log 9
  // Add more test cases, as I'll be running more than just the above

  Any two numbers are considered congruent modulo if their remainder is 
  the same given a specified divisor.
  Given the example test case above, [1, 2, 3, 6] is the input array, 3 
  is the divisor, and 0 is the expected remainder. When the function is 
  working properly, the output should be 9.

  In order to sum all the congruent modulo numbers in the input array, you 
  will need to apply the modulo operation to each input number given the 
  provided divisor and the remainder to determine if it should be summed 
  or not.

  Due next week. Submit your js file to blackboard and github before 
  Sep 18th @ 6:25PM.
*/

function sumCongruentModulo(inputArray, divisor, remainder) 
{   
  let sum = 0;
  let geekitem = 0;
  
  // For loop to go through each of the array elements for the length of the array.
  /*for (geekitem = 0; geekitem < inputArray.length; geekitem++)
  {
    // Check to see if the array element % the divisor equals the remainder, and add each of the elements that qualify.
    if (inputArray[geekitem] % divisor === remainder)
    {
      sum+= inputArray[geekitem];
    }
  }*/
  
  // Array forEach method to go through each of the array elements.
  inputArray.forEach(function(geekitem)
  {
    // Check to see if the array element % the divisor equals the remainder, and add each of the elements that qualify.
    if (geekitem % divisor === remainder)
    {
      sum+= geekitem;
    }
  })
  
  // Display the result of the sum of each of the elements.
  return sum;
}
  
console.log(sumCongruentModulo([1, 2, 3, 6], 3, 0)); // Should log 9
console.log(sumCongruentModulo([], 3, 0)); // Test with no elements in array and should log 0
console.log(sumCongruentModulo([1, 2, 3], 3, 0)); // Single element test and should log 3
console.log(sumCongruentModulo([1, 4, 4], 3, 0)); // Multi elements that don't have any sum and should log 0
console.log(sumCongruentModulo([4, 5, 6, 8], 6, 2)); // Multi elements test with non-zero remainder and different divisor and should log 8
console.log(sumCongruentModulo([1, 2, 5, 8], 3, 2)); // Multi elements test with a non-zero remainder and should log 15
console.log(sumCongruentModulo([1, 2, 7, 9], 0, 0)); // Multi elements test with divisor as zero and should log 0