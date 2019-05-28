/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 4
   Case Problem 2

   Author:    Rebecca Peretz
   Date:      3/1/2011

   Filename:  puzzle.js

   -------------------------------------------------------------
   Function List:
   setPuzzle()
      Initializes event handlers for the cells within the Hanjie
      table. 

   changeColor()
      Toggles the background color of the active cell between
      black and white

   showSolution()
      Shows the solution of the Hanjie puzzle

   hideSolution()
      Hides the solution of the Hanjie puzzle

   checkSolution()
      Checks the user's solution of the Hanjie puzzle

   uncheckSolution()
      Restores the user's solution of the Hanjie puzzle
      to its original state

   -------------------------------------------------------------
   Global Variable List:

   allCells
      An object variable referencing all of the clickable cells
      within the Hanjie puzzle


   -------------------------------------------------------------
*/

window.onload = setPuzzle;

var allCells;

function setPuzzle() {

   var puzzleTable = document.getElementById("puzzleCells");
   allCells = puzzleTable.getElementsByTagName("td");


   for (var i=0; i < allCells.length; i++) {
      allCells[i].style.backgroundColor = "white";
      allCells[i].onclick = changeColor;
   }

   document.forms[0].solution.onclick = showSolution;
   document.forms[0].hide.onclick = hideSolution;
   document.forms[0].check.onclick = checkSolution;
   document.forms[0].uncheck.onclick = uncheckSolution;
   
}

function changeColor() {
  this.style.backgroundColor = (this.style.backgroundColor == "black") ? "white" : "black";
}

function showSolution() {

   for (var i=0; i < allCells.length; i++) {
      if (allCells[i].className == "dark") {
         allCells[i].style.backgroundColor = "black";
      } else {
         allCells[i].style.backgroundColor = "white";
     }
   }

   document.forms[0].checkCount.value=0;
}

function hideSolution() {

   for (var i=0; i < allCells.length; i++) {
      allCells[i].style.backgroundColor = "white";
   }

   document.forms[0].checkCount.value="";

}

function checkSolution() {
   var checkCount = 0;
   for (var i=0; i < allCells.length; i++) {
      if (allCells[i].style.backgroundColor == "black" && allCells[i].className != "dark") 
         allCells[i].style.backgroundColor = "red"
      else if (allCells[i].style.backgroundColor == "white" && allCells[i].className == "dark")
         checkCount++;
   }

  document.forms[0].checkCount.value=checkCount;
}

function uncheckSolution() {

   for (var i=0; i < allCells.length; i++) {
      if (allCells[i].style.backgroundColor == "red") allCells[i].style.backgroundColor = "black";
   }

   document.forms[0].checkCount.value="";

}

