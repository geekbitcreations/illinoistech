/* Deborah Barndt
   ITMD 562 Web Site Application Development
   Professor Benjamin Zumhagen
   Week 11 Assignment
   11-3-18
   
  This program will allow a user to manage the books application, so that the user can keep a record of the books.

  Description
    •	As a user of your application
    •	I want to be able to manage books
    •	So that I can keep a record of the books

  Acceptance Criteria
    •	Must expose the functionality from the previous assignment through a user interface. i.e. GET /book/{bookId} 
      should show a page listing the book details in an easy to read format.

  Other Details
    •	NO HARDCODING. DO NOT HARDCODE RESPONSES FROM THE SERVER.
    •	If your server doesn't run, you get no points.
    •	PLEASE PLEASE PLEASE delete your node_modules directory and rerun npm install && node server.js before submitting.
    •	No persistence needed.
    •	2 pts extra credit if you use templating + bootstrap.
    •	Due by the beginning of week 13. So you get two weeks to do it.

*/

// Required items for server
var express = require('express');
var app = express();
const port = 3000;

// Initiate MongoDB
var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectId;

app.use(express.json());

// Allow to use form data
app.use(express.urlencoded({ extended: true}));
app.use(express.static('public'));
app.set('view engine', 'pug');
app.set('views', __dirname + '/views');

var Book = []

// Connect to the MongoDB
MongoClient.connect('mongodb://localhost:27017/booklist', function (err, client)
{
  if (err) throw err

  let db = client.db('booklist');
  let books = db.collection('books');
  
  let book = 
  {
    title : "",
    author : "",
    numPages : 0
  }
  //let books = [dummyBook];
  
  // Get request for the index page that finds all the books and renders it to the page.
  app.get('/', (req, res) => 
  {
    Book.find({}, function(err, books) 
    {
      if (err) 
      {
        console.log(err)
        res.render('error', {})
      } 
      
      else 
      {
        res.render('index', { books: books })
      }
    });
  });

  // Get request to get the book to pre-fill the fields, render the form, and then pass the book form to allow for an update.
  app.get('/books/:id/update', (req, res) => 
  {
    let id = ObjectID.createFromHexString(req.params.id)

    Book.findById(id, function(err, book) 
    {
      if (err) 
      {
        console.log(err)
        res.render('error', {})
      } 
      
      else 
      {
        if (book === null) 
        {
          res.render('error', { message: "Not found" })
        } 
        
        else 
        {
          res.render('book-form', { title: "Update Book", book: book })
        }
      }
    });
  });

  // Post request to render the new book from the book form.
  app.post('/books/new', function(req, res, next) 
  {
    let newBook = new Book(req.body);
    newBook.save(function(err, savedBook)
    {
      if (err) 
      {
        console.log(err)
        res.render('book-form', { book: newBook, error: err })
      } 
      
      else 
      {
        res.redirect('/books/' + savedBook.id);
      }
    });
  });

  // Get request to render the detailed view of a book.
  app.get('/books/:id', (req, res) => 
  {
    let id = ObjectID.createFromHexString(req.params.id)

    Book.findById(id, function(err, book) 
    {
      if (err) 
      {
        console.log(err)
        res.render('error', {})
      } 
      
      else 
      {
        if (book === null) 
        {
          res.render('error', { message: "Not found" })
        } 
        
        else 
        {
          res.render('book-detail', { book: book})
        }
      }
    });
  });

  // Post request to reset the new detailed view when the user updates the information in the form.
  app.post('/books/:id/update', function(req, res, next) 
  {
    let id = ObjectID.createFromHexString(req.params.id)

    Book.updateOne({"_id": id}, { $set: req.body }, function(err, details) 
    {
      if (err) 
      {
        console.log(err)
        res.render('error', {})
      } 
      
      else 
      {
        res.redirect('/books/' + id);
      }
    });
  });

  // Post request to delete one of the books by clicking the delete button in the detailed book page.
  app.post('/books/:id/delete', function (req, res) 
  {
    let id = ObjectID.createFromHexString(req.params.id)
    Book.deleteOne({_id: id}, function(err, product) 
    {
      res.redirect("/");
    });
  });

  // Post to create a new book
  app.post('/books', (req, res) =>
  {
    let newBook = req.body;
    newBook.id = books.length;
    //books.push(newBook);
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
        res.status(200).send(result.ops[0]);
      }
    })
  })

  // Get the books inside the database
  app.get('/books', (req, res) => res.send(books))
  app.get('/books/:id', (req, res) =>
  {
    let id = ObjectID.createFromHexString(req.params.id);
    let foundBook = books[id];

    books.findOne({'_id': id}, function (err, book)
    {
      if (err)
      {
        console.log(err);
        res.status(500).send("Internal server error");
      }

      else
      {
        console.log(book);
        res.status(200).send(book);
        
        if (foundBook === null)
        {
          res.status(404).send("Not found");
        }

        else
        {
          res.send(foundBook);
        }
      }
    })
  })

  // Put to update a book inside the database
  app.put('/books/:id', (req, res) =>
  {
    let id = ObjectID.createFromHexString(req.params.id);
    let updatedBook = req.body;

    books.updateOne({'_id': id}, {$set: req.body}, function (err, updatedBook)
    {
      if (err)
      {
        console.log(err);
        res.status(404).send("Book not found");
      }

      else
      {
        res.status(204).send();
      }
    }); 
  });

  // Delete a book from the database
  app.delete('/books/:id', (req, res) =>
  {
    let id = ObjectID.createFromHexString(req.params.id);
    
    books.deleteOne({'_id': id}, function (err, book)
    {
      if  (books[id] = null)
      {
      
        res.status(404)
      }
      
      else
      {
        res.status(204).send();
      }
    } 
  )});
})

// Listen for the book app running on port 3000
app.listen(port, () => console.log(`Book app listening on port ${port}!`));