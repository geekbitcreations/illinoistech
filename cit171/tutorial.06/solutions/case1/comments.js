/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 6
   Case Problem 1

   Author:  Helen Ungerstatz
   Date:    3/1/2011

   Filename: comments.js


   Global Variables:
  
   maxLength
      The maximum length allowed in the textarea box

   Functions List:

   init()
      Initializes the contents of the Web page. Creates
      event handlers for the keypress and keyup events.

   countText()
      Returns the number of a non-whitespace characters
      in the textarea box.

   checkLength(e)
      Verifies the number of non-whitespace characters
      in the textarea box is less than maxLength. Keeps
      user from entering a character that would exceed
      maxLength

   updateCount(e)
      Updates the count of characters in the wordcount
      box.


*/

var maxLength = 500;

window.onload = init;


function init() {
   var commentBox = document.getElementById("comment");
   var countBox = document.getElementById("wordcount");
   countBox.value = "0/"+maxLength;

   commentBox.onkeypress = checkLength;
   commentBox.onkeyup = updateCount;
}

function countText() {
   var commentBox = document.getElementById("comment");
   var commentregx = /\s/g;
   var commentText = commentBox.value.replace(commentregx, "");
   return commentText.length;
}   

function checkLength(e) {
   var evt = e || window.event;

   if (countText() < maxLength) return true;
   else if (evt.keyCode == 8 || evt.keyCode == 46) return true;
   else return false;

}

function updateCount(e) {
   var countBox = document.getElementById("wordcount");
   var currentLength = countText();

   countBox.value = currentLength +"/"+maxLength;

   if (currentLength < maxLength) {
      countBox.style.color = "black";
      countBox.style.backgroundColor = "white";
   } else {
      countBox.style.color = "white";
      countBox.style.backgroundColor= "red";
   }
}