const express = require('express')
const app = express()
const port = 3000

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/reviewr');
var MongoClient = require('mongodb').MongoClient
var ObjectID = require('mongodb').ObjectID

app.use(express.json())
// Needed for allowing form data
app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'))
app.set('view engine', 'pug')
app.set('views', __dirname + '/views');

var reviewSchema = new mongoose.Schema({
  author: { type: String, required: true },
  title: { type: String, required: true },
  content: { type: String, required: true },
  movie: { type: String, required: true }
});
var Review = mongoose.model('Review', reviewSchema);

var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {

  // Get request for the index page. Finds all the reviews and renders it to the page.
  app.get('/', (req, res) => {
    Review.find({}, function(err, reviews) {
      if (err) {
        console.log(err)
        res.render('error', {})
      } else {
        res.render('index', { reviews: reviews })
      }
    });
  });

  // Get that renders the review form and passes an empty review object
  app.get('/reviews/new', (req, res) => {
    res.render('review-form', { title: "New Review", review: {} })
  });

  // Get request to get the review to pre-fill the fields, render the form, and then 
  //pass the review form to allow for an update.
  app.get('/reviews/:id/update', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.findById(id, function(err, review) {
      if (err) {
        console.log(err)
        res.render('error', {})
      } else {
        if (review === null) {
          res.render('error', { message: "Not found" })
        } else {
          res.render('review-form', { title: "Update Review", review: review })
        }
      }
    });
  });

  // Post request to render the new review from the review form.
  app.post('/reviews/new', function(req, res, next) {
    let newReview = new Review(req.body);
    newReview.save(function(err, savedReview){
      if (err) {
        console.log(err)
        res.render('review-form', { review: newReview, error: err })
      } else {
        res.redirect('/reviews/' + savedReview.id);
      }
    });
  });

  // Get request to render the detailed view of a review.
  app.get('/reviews/:id', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.findById(id, function(err, review) {
      if (err) {
        console.log(err)
        res.render('error', {})
      } else {
        if (review === null) {
          res.render('error', { message: "Not found" })
        } else {
          res.render('review-detail', { review: review})
        }
      }
    });
  });

  // Post request to reset the new detailed view when the user updates the information in the form.
  app.post('/reviews/:id/update', function(req, res, next) {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.updateOne({"_id": id}, { $set: req.body }, function(err, details) {
      if (err) {
        console.log(err)
        res.render('error', {})
      } else {
        res.redirect('/reviews/' + id);
      }
    });
  });

  // Post request to delete one of the reviews by clicking the delete button in the detailed review page.
  app.post('/reviews/:id/delete', function (req, res) {
    let id = ObjectID.createFromHexString(req.params.id)
    Review.deleteOne({_id: id}, function(err, product) {
      res.redirect("/");
    });
  });

  app.post('/api/reviews', (req, res) => {
    console.log(req.body)
    let newReview = new Review(req.body)

    newReview.save(function (err, savedReview) {
      if (err) {
        console.log(err)
        res.status(500).send("There was an internal error")
      } else {
        res.send(savedReview)
      }
    });
  });

  app.get('/api/reviews', (req, res) => {
    Review.find({}, function(err, reviews) {
      if (err) {
        console.log(err)
        res.status(500).send("Internal server error")
      } else {
        res.send(reviews)
      }
    });
  });

  app.get('/api/reviews/:id', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.findById(id, function(err, review) {
      if (err) {
        console.log(err)
        res.status(500).send("Internal server error")
      } else {
        if (review === null) {
          res.status(404).send("Not found")
        } else {
          res.send(review)
        }
      }
    });
  });

  app.put('/api/reviews/:id', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.updateOne({"_id": id}, { $set: req.body }, function(err, details) {
      if (err) {
        console.log(err)
        res.status(500).send("Internal server error")
      } else {
        res.status(204).send()
      }
    });
  });

  app.delete('/api/reviews/:id', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    Review.deleteOne({"_id": id}, function(err) {
      if (err) {
        console.log(err)
        res.status(500).send("Internal server error")
      } else {
        res.status(204).send()
      }
    });
  });
});

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
