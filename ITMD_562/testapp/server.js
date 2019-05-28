var express = require('express')
var app = express()
const port = 3000

app.get('/', function (req, res) 
{
  res.send('hello Deb')
})

app.listen(port, () => console.log('Started on port ${port}!'))