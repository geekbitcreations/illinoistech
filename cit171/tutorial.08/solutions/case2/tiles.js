/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 8
   Case Problem 2

   Author:  Pete Burnham
   Date:    3/1/2012

   Filename: tiles.js


   Global Variables
   flipCount
      Used to track the number of tiles currently being turned over

   firstFlip
      Used to reference the first tile turned over

   secondFlip
      Used to reference the second tile turned over


   Functions
  
   addEvent(object, evName, fnName, cap)
      Run the function fnName when the event evName occurs in object.

   randomSort(arr)
      Randomly sorts the contents of the arr array.

   setOpacity(object, value)
      Sets the opacity level of object to value

   setupTiles()
      Sets up the tiles for use in the Concentration game

   flipTile()
      Flips a tile showing the image associated with the tile

   checkTiles(tile1, tile2)
      Checks whether the tile1 image source is the same as the
      tile2 image source

   flipBack()
      Flips back flipped over tiles and resets the flipCount
      variable to 0.

   



*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}

function randomSort(arr) {

   arr.sort(function () {
      return 0.5 - Math.random();
   })

}

function setOpacity(object, value) {


   // Apply the opacity value for IE and non-IE browsers
   object.style.filter = "alpha(opacity = " + value + ")";
   object.style.opacity = value/100;

}




/* Add new code below */


var flipCount = 0;
var firstFlip;
var secondFlip;


addEvent(window, "load", setupTiles, false);


function setupTiles() {

   var tiles = new Array();

   // Populate array of tile objects
   for (var i = 0; i < document.images.length; i++) {

      if (document.images[i].className == "tile" && document.images[i].parentNode.tagName == "A") {
         tiles.push(document.images[i]);
      }

   }

   // Create an array of tile images
   var tileImages = new Array(tiles.length);

   for (var i = 0; i < tiles.length/2; i++) {
      tileImages[i] = new Image();
      tileImages[i].src = "tileimage" + i + ".jpg";
   }
   
   for (var i = tiles.length/2; i < tiles.length; i++) {
      tileImages[i] = new Image();
      tileImages[i].src = "tileimage" + (i - tiles.length/2) + ".jpg";
   }
   
   // Sort the tile images in random order
   randomSort(tileImages);

   // Attach each tile image to a tile from the board
   for (var i = 0; i < tiles.length; i++) {
   
      // Attach each tile image as a custom property of a tile
      tiles[i].image = tileImages[i];

      tiles[i].onclick = flipTile;

   }

   // Show the solution when the showAll button is clicked   
   document.getElementById("showAll").onclick = function() {
      for (var i = 0; i < tiles.length; i++) {
         tiles[i].src = tiles[i].image.src;
      }
   }

   // Reload the Web page when the reload button is clicked
   document.getElementById("reload").onclick = function() {
      location.reload();
   }

}

function flipTile() {

   // If no tiles have been flipped, flip over the first one and
   // update firstFlip and flipCount.

   if (flipCount == 0) {
      this.src = this.image.src;
      firstFlip = this;
      flipCount++;

    // If one tile has been flipped, flip over the second one and
    // up date secondFlip and flipCount
    } else if (flipCount == 1) {
      this.src = this.image.src;
      secondFlip = this;
      flipCount++;
      checkTiles();
    }

    // Halt the propagation of the click event
    return false;

}

function checkTiles() {

   // Check whether firstFlip and secondFlip show the same image

   if (firstFlip.image.src != secondFlip.image.src) {
      setTimeout("flipBack()", 800);
   } else {
      flipCount = 0;
      setOpacity(firstFlip, 70);
      firstFlip.onclick = function() {
         return false;
      }
      setOpacity(secondFlip, 70);
      secondFlip.onclick = function() {
         return false;
      }
   }
}

function flipBack() {

   // Flip back firstFlip an secondFlip and reset flipCount
   firstFlip.src = "tile.jpg";
   secondFlip.src = "tile.jpg";
   flipCount = 0;

}







