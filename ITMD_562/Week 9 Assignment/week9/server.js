/* Deborah Barndt
   ITMD 562 Web Site Application Development
   Professor Benjamin Zumhagen
   Week 9 Assignment
   10-22-18
   
  This program will be to further practice what we learned, I want you to build a 
  server which implements the following API and SAVES DATA TO MONGO.

  • POST /books
    • Should accept the following JSON and save it to mongo 
    { 
      "title" : "", 
      "author" : "", 
      "numPages" : 0 
    }
    • Return saved object with 200 status

  • GET /books/{id}
    • Should return the book JSON object stored at that Id with 200 status 
    { 
      "id" : "", 
      "title" : "", 
      "author" : "", 
      "numPages" : 0 
    }

  • PUT /books/{id}
    • Should update the book JSON object stored at that ID with the values provided 
    and return 204 status 
    { 
      "title" : "", 
      "author" : "", 
      "numPages" : 0 
    }

  • DELETE /books/{id}
    • Delete the book stored at the id
    • Return 204 on successful deletion.

  4 pts extra credit if you write acceptance tests using Mocha and Chai for all 
  endpoints. Must run by using the `npm test` command.

  PLEASE SUBMIT YOUR APPLICATION (including server.js and package.json if using any 
  dependencies) via github and blackboard (must include a link to github)
  DUE BY THE BEGINNING OF WEEK 11 - SO YOU HAVE TWO WEEKS TO WORK ON IT
  Don't wait till the day before to work on it! As always, let me know if you have 
  any questions. Good luck!
*/

// Required items for server
var express = require('express');
var app = express();
const port = 3000;

// Initiate MongoDB
var MongoClient = require("mongodb").MongoClient;
var ObjectID = require("mongodb").ObjectId;

app.use(express.json());

// Connect to the MongoDB
MongoClient.connect("mongodb://localhost:27017/booklist", function (err, client)
{
  if (err) throw err

  let db = client.db("booklist");
  let books = db.collection("books");

  // Post to create a new book
  app.post("/books", (req, res) =>
  {
    let newBook = req.body;
    newBook.id = books.length;
    books.push(newBook);

    let newBook = 
    {
      "title" : "",
      "author" : "",
      "numPages" : 0
    }

    res.status(200).send(newBook);

    books.insertOne(newBook, function (err, result)
    {
      if (err)
      {
        console.log(err);
        res.status(500).send("There was an error with your entry");
      }

      else
      {
        res.status(200).send();
        res.send(result.ops[0]);
      }
    })
  })

  // Get the books inside the database
  app.get("/books", (req, res) => res.send(books))
  app.get("/books/:id", (req, res) =>
  {
    let id = ObjectID.createFromHexString(req.params.id);

    books.findOne({"_id": id}, function (err, book)
    {
      if (err)
      {
        console.log(err);
        res.status(500).send("Internal server error");
      }

      else
      {
        console.log(book);

        if (book === null)
        {
          res.status(404).send("Not found");
        }

        else
        {
          res.send(book)
        }
      }
    })
  })

  // Put to update a book inside the database
  app.put("/books/:id", (req, res) =>
  {
    let updatedBook = req.body;
    let id = req.params.id;
    let existingBook = books[id];

    if (existingBook === undefined)
    {
      res.status(404).send();
    }

    else
    {
      existingBook.title = updatedBook.title;
      existingBook.author = updatedBook.author;
      existingBook.numPages = updatedBook.numPages;

      res.status(204).send();
    }
  });

  // Delete a book from the database
  app.delete("/books/:id", (req, res) =>
  {
    let id = req.params.id;
    books[id] = undefined;
    res.status(204).send();
  });
})

// Listen for the book app running on port 3000
app.listen(port, () => console.log(`Book app listening on port ${port}!`));