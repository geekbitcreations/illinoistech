/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Case Problem 4

   Author:   Pete Burnham
   Date:     3/1/2012

   Filename: shapes.js


*/


function shape(size, color, opacity, code) {

   this.size = size;
   this.color = color;
   this.opacity = opacity;
   this.code = code;

   this.divElem = document.createElement("div");

   this.divElem.innerHTML = this.code;

   this.divElem.style.color = this.color;
   setOpacity(this.divElem, this.opacity);
   this.divElem.style.fontSize = this.size;

   this.divElem.style.cursor = "move";

   this.divElem.style.width = "auto";
   this.divElem.style.height = "auto";
   this.divElem.style.position = "absolute";
   this.divElem.style.MozUserSelect="none"

   this.divElem.onmousedown = function(e) {

      var evt = e || window.event;

      var initX = evt.clientX;
      var initY = evt.clientY;

      var initPosX = parseInt(this.style.left);
      var initPosY = parseInt(this.style.top);

      this.onmousemove = function(e) {
         var evt = e || window.event;
         var newX = evt.clientX;
         var newY = evt.clientY;
         var distanceX = newX - initX;
         var distanceY = newY - initY;
   
         this.style.left = initPosX + distanceX + "px";
         this.style.top = initPosY + distanceY + "px";
      }

   }

   this.divElem.onmouseup = function(e) {

      var trashcan = document.getElementById("trashcan");
      trashcan.style.left = getStyle(trashcan, "left");
      trashcan.style.top = getStyle(trashcan, "top");
      trashcan.style.width= getStyle(trashcan, "width");
      trashcan.style.height = getStyle(trashcan, "height");

      if (withinIt(this, trashcan)) {

         document.body.removeChild(this);
      } else {
         this.onmousemove = null;
      }

   }  
      

}

function game() {

   this.currentSize = "32px";
   this.currentColor = "#C5D3EE";
   this.currentOpacity = 100;
   this.currentCode = "&#9728;";

}