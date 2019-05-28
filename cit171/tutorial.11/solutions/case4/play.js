/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Case Problem 4

   Author:   Pete Burnham
   Date:     3/1/2012

   Filename: play.js


*/


addEvent(window, "load", playGame, "false");


function playGame() {

   var allSizeControls = new Array();
   var allColorControls = new Array();
   var allOpacityControls = new Array();
   var allShapeControls = new Array();

   var myGame = new game();

   var allElems = document.body.getElementsByTagName("*");

   for (var i = 0; i < allElems.length; i++) {
      if (allElems[i].className == "controlSize") allSizeControls.push(allElems[i]);
      if (allElems[i].className == "controlColor") allColorControls.push(allElems[i]);
      if (allElems[i].className == "controlOpacity") allOpacityControls.push(allElems[i]);
      if (allElems[i].className == "controlShape") allShapeControls.push(allElems[i]);
   }

   document.onselectstart = function() {return false;}

   for (var i = 0; i < allSizeControls.length; i++) {
      allSizeControls[i].onmousedown = function() {

         for (var i = 0; i < allSizeControls.length; i++) {
            allSizeControls[i].style.borderColor = "white";
         }

         this.style.borderColor = "#444588";
         if (this.id == "size0") myGame.currentSize = "32px"
         else if (this.id == "size1") myGame.currentSize = "96px"
         else if (this.id == "size2") myGame.currentSize = "160px";

      }
   }

   for (var i = 0; i < allColorControls.length; i++) {
      allColorControls[i].onmousedown = function() {

         for (var i = 0; i < allColorControls.length; i++) {
            allColorControls[i].style.borderColor = "white";
         }

         this.style.borderColor = "#444588";
         myGame.currentColor = getStyle(this,"backgroundColor");

      }
   }

   for (var i = 0; i < allOpacityControls.length; i++) {
      allOpacityControls[i].onmousedown = function() {

         for (var i = 0; i < allOpacityControls.length; i++) {
            allOpacityControls[i].style.borderColor = "white";
         }

         this.style.borderColor = "#444588";
         if (this.id == "opacity10") myGame.currentOpacity = 10;
         else if (this.id == "opacity30") myGame.currentOpacity = 30;
         else if (this.id == "opacity50") myGame.currentOpacity = 50;
         else if (this.id == "opacity70") myGame.currentOpacity = 70;
         else if (this.id == "opacity100") myGame.currentOpacity = 100;
      }
   }

   for (var i = 0; i < allShapeControls.length; i++) {
      allShapeControls[i].onmousedown = function(e) {
         var evt = e || window.event;

         for (var i = 0; i < allShapeControls.length; i++) {
            allShapeControls[i].style.borderColor = "white";
         }

         this.style.borderColor = "#444588";
         myGame.currentShape = this.innerHTML;

         var myShape = new shape(myGame.currentSize, myGame.currentColor, myGame.currentOpacity, myGame.currentShape);

         document.body.appendChild(myShape.divElem);

         if (evt.pageX) {
            myShape.divElem.style.left = evt.pageX - parseInt(myShape.size)/2 +  "px";
            myShape.divElem.style.top = evt.pageY - parseInt(myShape.size)/2 +  "px";
         } else {
            var offX = document.documentElement.scrollLeft + document.body.scrollLeft;
            var offY = document.documentElement.scrollTop + document.body.scrollTop;
            myShape.divElem.style.left = evt.clientX + offX - parseInt(myShape.size)/2 + "px";
            myShape.divElem.style.top = evt.clientY + offY - parseInt(myShape.size)/2 + "px";
         }

         document.onmousemove = function(e) {
            var evt = e || window.event;
           
            if (evt.pageX) {
               myShape.divElem.style.left = evt.pageX - parseInt(myShape.size)/2 +  "px";
               myShape.divElem.style.top = evt.pageY - parseInt(myShape.size)/2 +  "px";
            } else {
               var offX = document.documentElement.scrollLeft + document.body.scrollLeft;
               var offY = document.documentElement.scrollTop + document.body.scrollTop;
               myShape.divElem.style.left = evt.clientX + offX - parseInt(myShape.size)/2 + "px";
               myShape.divElem.style.top = evt.clientY + offY - parseInt(myShape.size)/2 + "px";
           }
        }

        document.onmouseup = function(e) {
           document.onmousemove = null;
        }

      }
   }

}
