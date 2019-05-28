const express = require('express')
const app = express()
const port = 3000

var MongoClient = require('mongodb').MongoClient
var ObjectID = require('mongodb').ObjectID

app.use(express.json())

MongoClient.connect('mongodb://localhost:27017/reviewr', function (err, client) {
  if (err) throw err

  let db = client.db('reviewr')
  let reviews = db.collection('reviews')
  app.post('/reviews', (req, res) => {
    let newReview = req.body

    reviews.insertOne(newReview, function(err, result) {
      if (err) {
        console.log(err)
        res.status(500).send("There was an internal error")
      } else {
        res.send(result.ops[0])
      }
    });
  });

  app.get('/reviews/:id', (req, res) => {
    let id = ObjectID.createFromHexString(req.params.id)

    reviews.findOne({"_id": id}, function(err, review) {
      if (err) {
        console.log(err)
        res.status(500).send("Internal server error")
      } else {
        console.log(review)
        if (review === null) {
          res.status(404).send("Not found")
        } else {
          res.send(review)
        }
      }
    });
  });
})

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
