/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 4
   Case Problem 4

   Author:    Tara Anderson
   Date:      3/1/2011

   Filename:  menus.js

   -------------------------------------------------------------
   Function List:
   makeMenus()
      Initializes the contents of the mystery.htm Web page, locating
      the sliding menus, setting their initial positions and 
      display styles and defining the onevent handlers.

   showSlide()
      Shows a sliding menu while hiding any inactive menus

   closeSlide()
      Closes an inactive sliding menu

   moveSlide()
      Moves a sliding menu horizontally across the page


   -------------------------------------------------------------
   Global Variable List:

   currentSlide
      An object variable pointing to the currently active sliding menu
   
   timeID
      A variable containing the id of a timed command using the setInterval method

   leftPos
      The current left position of the sliding menu as it is 
      moved across the page

   -------------------------------------------------------------
*/

window.onload = makeMenus;

var currentSlide = null;
var timeID = null;
var leftPos = 0;

function makeMenus() {
   var slideMenus = new Array();
   var allElems = document.getElementsByTagName("*");

   for (var i=0; i < allElems.length; i++) {
      if (allElems[i].className == "slideMenu") slideMenus.push(allElems[i]);
   }

   for (var i=0; i < slideMenus.length; i++) {
      slideMenus[i].onclick = showSlide;
      slideMenus[i].getElementsByTagName("ul")[0].style.left = "0px";
   }

   document.getElementById("head").onclick = closeSlide;
   document.getElementById("main").onclick = closeSlide;
}

function showSlide() {
   slideList =    this.getElementsByTagName("ul")[0];
   if (currentSlide && currentSlide.id == slideList.id) {
      closeSlide();
   } else {
      closeSlide();
      currentSlide = slideList;
      currentSlide.style.display = "block";
      timeID = setInterval("moveSlide()", 1);
   }       
}

function closeSlide() {
   if (currentSlide) {
      clearInterval(timeID);
      currentSlide.style.left = "0px";
      currentSlide.style.display = "none";
      currentSlide = null;
   }
}

function moveSlide() {
   leftPos += 5;
   if (parseInt(currentSlide.style.left) <= 220) {
      currentSlide.style.left = leftPos + "px";
   } else {
      clearInterval(timeID);
      leftPos = 0;
   }
}
