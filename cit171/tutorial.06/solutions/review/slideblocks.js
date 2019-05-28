/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 6
   Review Assignment

   Author:   Pete Burnham
   Date:     3/1/2011

   Filename: slideblocks.js


   Global Variables List;

   blocks
      An array of elements belonging to the block class

   blankBlock
      The puzzle representing a blank space in the sliding block puzzle
   
   keyBlock
      The puzzle block currently selected by the user's keyboard

   
   Functions List:
   init()
      Sets up and initializes the Web page, defining the blocks array,
      and appying event handlers to mouse and keyboard actions

   swapWithBlank(e)
      Responds to the mousedown event to swap the current block with an adjacent
      blank space (if one exists)

   highlightBlank(e)
      Highlights a block on the mouseover event by changing the mouse cursor if the block
      is adjacent to a blank space 

   removeHighlightBlank(e)
      Removes highlighting from a puzzle block by changing the cursor style to "default".

   keySwapWithBlank()
      Swaps keyBlock with an adjacent blank space (if one exists)

   selectBlock(diffX, diffY)
      Moves the keyBlock diffX to the right and diffY down.

   keyEvent(e)
      Responds to the spacebar event to swap keyBlock with an adjacent blank
      space or to arrow keys to move the position of keyBlock up, down, to
      the left, or to the right

*/

var blocks = new Array();
var blankBlock;
var keyBlock;


window.onload = init;

function init() {
   var allElem = document.getElementsByTagName("*");

   for (var i = 0; i < allElem.length; i++) {
      if (allElem[i].className == "block") blocks.push(allElem[i]);
   }

   for (var i = 0; i < blocks.length; i++) {
      blocks[i].style.top = getStyle(blocks[i], "top");
      blocks[i].style.left = getStyle(blocks[i], "left");
      blocks[i].style.width = getStyle(blocks[i], "width");
      blocks[i].style.height = getStyle(blocks[i], "height");
   }

   var randomIntegers = scrambleIntegers(blocks.length - 1);
   for (var i = 0; i < blocks.length - 1; i++) {
      blocks[i].style.backgroundImage = "url(block" + randomIntegers[i] + ".jpg)";

      addEvent(blocks[i], "click", swapWithBlank, false);
      addEvent(blocks[i], "mouseover", highlightBlank, false);
      addEvent(blocks[i], "mouseout", removeHighlightBlank, false);
   }

   blankBlock = blocks[24];
   keyBlock = blocks[0];

   addEvent(document, "keydown", keyEvent, false);
   addEvent(document.getElementById("solve"), "click", solveIt, false);  
   addEvent(document.getElementById("scramble"), "click", scrambleIt, false);  
}

function swapWithBlank(e) {
   var evt = e || window.event;
   mouseBlock = evt.target || evt.srcElement;
   
   if (nextTo(mouseBlock, blankBlock)) swapObjects(mouseBlock, blankBlock);
}

function highlightBlank(e) {
   var evt = e || window.event;
   mouseBlock = evt.target || evt.srcElement;
   
   if (nextTo(mouseBlock, blankBlock)) {
      mouseBlock.style.cursor = "pointer";
   }
}

function removeHighlightBlank(e) {
   var evt = e || window.event;
   mouseBlock = evt.target || evt.srcElement;
   mouseBlock.style.cursor = "default";
}

function keySwapWithBlank() {
   if (nextTo(keyBlock, blankBlock)) swapObjects(keyBlock, blankBlock)
}

function selectBlock(diffX, diffY) {
   var newX = parseInt(keyBlock.style.left) + diffX;
   var newY = parseInt(keyBlock.style.top) + diffY;
   var oldKeyBlock = keyBlock;

   for (var i = 0; i < blocks.length; i++) {
      if (withinIt(newX, newY, blocks[i])) {
         keyBlock = blocks[i];
         keyBlock.style.borderColor = "red";
         oldKeyBlock.style.borderColor = "black";
         break;
      }
   }
}


function keyEvent(e) {
   var evt = e || window.event;

   if (evt.keyCode == 32) {keySwapWithBlank(); return false}
   else if (evt.keyCode == 37) {selectBlock(-30, 0); return false}
   else if (evt.keyCode == 38) {selectBlock(0, -30); return false}
   else if (evt.keyCode == 39) {selectBlock(90, 0); return false}
   else if (evt.keyCode == 40) {selectBlock(0, 90); return false}
}



