/* Deborah Barndt
   ITMD 565 Rich Internet Applications
   Professor Brian Bailey
   Lab 1
   8-30-18
   
  This program will write a very simple console application in JavaScript and run it in the browser's 
  developer tools.
  
  Requirements:
  • Write a program that asks the user for a number n, then prints to the console the sum
    of the numbers 1 to n, and shows the user an alert box as described below.
  • Show the user an alert box that says “The sum of the first n numbers is x”. Dynamically
    fill in n and x.
  • Put your program in a single text file named YourUsername.js and zip that file and
    upload to the blackboard assignment.
  • Test your program by running it in the browser developer tools as show in class.
  • This should be a very simple program that only consists of a very small number of lines.
    If you have a lot of lines for this there probably is an easier way.
  • You should use the browser prompt function, alert function, and console objects that
    we talked about in class.
  • In the prompt ask the user “How many numbers do you want to sum?”
  • Assume the user will enter a positive number > 0.*/
  
  var n = prompt("How many numbers would you like to sum? ");
  var x = 0;
  
  if (n > 0)
  {
    for (y = 0; y <= n; y++)
    {
      x += y;
    }
  }
  
  else
  {
    alert("Please enter a positive number.");
  }
    
  alert("The sum of the first " + n + " numbers is " + x + ".");
  console.log("The sum of the first " + n + " numbers is " + x + ".");