/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Case Problem 2

   Author:  Kyle Mitchell   
   Date:    3/1/2012


   Custom objects and methods

   shadow(source, offX, offY, r, g, b, op)
      Constructs a shadow object for the source object
      with horizontal and vertical offsets offX and offY, and color
      value r,g,b and opacity op.

*/


function shadow(source, offX, offY, r, g, b, op) {

   this.srcObject = source;
   this.offsetX = offX;
   this.offsetY = offY;
   this.color = "rgb(" + r + "," + g + "," + b + ")";
   this.opacity = op;

}

shadow.prototype.addToPage = function() {

   this.divElem = document.createElement("div");
   document.body.appendChild(this.divElem);

   this.divElem.id = this.srcObject.id + "DropShadow";

   this.divElem.style.backgroundColor = this.color;
   this.divElem.style.width = getStyle(this.srcObject, "width");
   this.divElem.style.height = getStyle(this.srcObject, "height");
   setOpacity(this.divElem, this.opacity);

   this.divElem.style.position = "absolute";
   this.divElem.style.display = "none";

   var objectZ = getStyle(this.srcObject, "z-index");

   if (objectZ == undefined || objectZ == "auto") objectZ = 1;

   this.srcObject.style.zIndex = objectZ + 1;

   this.divElem.style.zIndex = objectZ;

}