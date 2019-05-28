const express = require('express')
const app = express()
const port = 3000

let dummyBook = {
  id: 0,
  author: "Martin Freeman",
  pages: 100,
  title: "Hello World"
}
let books = [dummyBook];

app.use(express.static('public'))
app.use(express.json())

app.get('/books', (req, res) => res.send(books))
app.get('/books/:id', (req, res) => {
  let id = req.params.id
  let foundBook = books[id];

  if (foundBook === undefined) {
    res.status(404)
    res.send()
  } else {
    res.send(foundBook)
  }
});

app.post('/books', (req, res) => {
  let newBook = req.body;
  newBook.id = books.length;
  books.push(newBook);
  res.status(200).send(newBook)
});

app.put('/books/:id', (req, res) => {
  let updatedBook = req.body;
  let id = req.params.id;
  let existingBook = books[id];

  if (existingBook === undefined) {
    res.status(404).send();
  } else {
    existingBook.author = updatedBook.author;
    existingBook.pages = updatedBook.pages;
    existingBook.title = updatedBook.title;
    res.status(204).send()
  }
});

app.delete('/books/:id', (req, res) => {
  let id = req.params.id;
  books[id] = undefined;
  res.status(204).send();
});

app.listen(port, () => console.log(`Example app listening on port ${port}!`))