/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 4
   Case Problem 3

   Author:    Denise Young
   Date:      3/1/2011

   Filename:  marquee.js

   -------------------------------------------------------------
   Function List:
   defineMarquee()
      Initializes the contents of the marquee, determines the
      top style positions of each marquee item, and sets the
      onclick event handlers for the document

   showTab()
      Shows the currently-select tab menu, bring it to the top
      of the stack

   startMarquee()
      Starts the marquee in motion

   stopMarquee()
      Stops the marquee

   moveMarquee()
      Moves the individual text elements within the marquee

   -------------------------------------------------------------
   Global Variable List:

   timeID
      A variable used for controlling time interval functions
   
   marqueeTxt
      An array referencing each text element in the marquee

   marqueeOff
      A Boolean variable indicating whether the marquee is currently running

   -------------------------------------------------------------
*/

window.onload = defineMarquee;

var timeID;
var marqueeTxt = new Array();
var marqueeOff = true;

function defineMarquee() {
   var allElems = document.getElementsByTagName("*");

   for (var i=0; i < allElems.length; i++) {
      if (allElems[i].className == "marqueeTxt") marqueeTxt.push(allElems[i]);
   }

   for (var i=0; i < marqueeTxt.length; i++) {

      if (window.getComputedStyle) {
         topValue = document.defaultView.getComputedStyle(marqueeTxt[i], null).getPropertyValue("top");
      } else if (marqueeTxt[i].currentStyle) {
         topValue = marqueeTxt[i].currentStyle["top"]
      }

      marqueeTxt[i].style.top = topValue;
   }

   document.getElementById("startMarquee").onclick = startMarquee;
   document.getElementById("stopMarquee").onclick = stopMarquee;
}

function startMarquee() {
   if (marqueeOff) {
      timeID =setInterval("moveText()", 50);
      marqueeOff = false;
   }
}

function stopMarquee() {
   clearInterval(timeID);
   marqueeOff = true;
}

function moveText() {
   for (var i=0; i < marqueeTxt.length; i++) {
     topPos = parseInt(marqueeTxt[i].style.top);
     if (topPos < -110) {
        marqueeTxt[i].style.top = "700px";
     } else {
        marqueeTxt[i].style.top = (topPos - 1) + "px";
     }
   }
}
