/* Deborah Barndt
   ITMD 562 Web Site Application Development
   Professor Benjamin Zumhagen
   Week 6 Assignment
   9-28-18
   
  This program will implement a simple counter application. It will increment the counter, retrieve its value, and reset
  it back to 0. 

  This will involve the following routes:

  1.	POST /counter
    1.	Should increment a number variable in your webapp by 1
    2.	Should return a 204 success code
  2.	GET /counter
    1.	Should return the current value of the number variable
    2.	Should return a 200 success code
  3.	DELETE /counter
    1.	Should reset the current value of the number variable to 0
    2.	Should return a 204 success code
  
  You should be able to test the functionality using the following flow.
    1.	Run `curl localhost:3000/counter`
      1.	This does a GET against the provided route and should return 0 as the initial value of the counter
    2.	Run `curl -X POST localhost:3000/counter`
      1.	This does a POST against the provided route and should return a 204 success code
    3.	Run `curl localhost:3000/counter`
      1.	This does a GET against the provided route and should return a 1 with a 200 success code, as the counter has been incremented
    4.	Run `curl -X DELETE localhost:3000/counter`
      1.	This does a DELETE against the provided route and should return a 204 success code
    5.	Run `curl localhost:3000/counter`
      1.	This does a GET against the provided route and should return a 0 with a 200 success code, as the counter has been reset.

  PLEASE SUBMIT YOUR APPLICATION (including server.js and package.json if using any dependencies) via github and blackboard.
  DUE BY BEGINNING OF CLASS NEXT WEEK
*/

// The required items for the server.
var express = require('express')
var app = express()
const port = 3000

// Initiate the counter.
var counter = 0;

app.use(express.static('public'));
app.use(express.json());

// Get the counter and display the value.
app.get('/counter', function (req, res) 
{
  res.status(200).send('\nThe current count is: ' + counter)
});

// Post to increment the counter by 1.
app.post('/counter', function (req,res)
{
  counter++;
  res.status(204).send() 
});

// Delete the counter value and reset to 0.
app.delete('/counter', function (req, res)
{
  counter = 0;
  res.status(204).send()
});

// Listen for the counter app running on port 3000.
app.listen(port, () => console.log(`Counter app listening on port ${port}!`))