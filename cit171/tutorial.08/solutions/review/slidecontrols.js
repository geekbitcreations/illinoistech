/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 8
   Review Assignment

   Author: Alexis Richards
   Date:   3/1/2012
   Filename: slidecontrols.js
   
   Functions

   addEvent(object, evName, fnName, cap)
      Run the function fnName when the event evName occurs in object.

   closeObject(objID)
      Sets the display style of the object with id, objID, to "none"
      hiding it from the user.

   showObject(objID)
      Sets the display style of the object with id, objID, to "block"

   createHighRes(thumb, index)
      Creates image objects containing high resolution versions of the
      thumbnail images by attaching the high res versions as a custom
      property.

   createRollover(thumb)
      Creates image objects to act as rollover images for the thumbnail
      images in the document.

   getCurrentSlideIndex() 
      Returns the index number of the current slideshow image ranging
      from 0 up the 1 less than the length of the thumbs array.

   setOpacity(objID, value)  
      Set the opacity of the document object with the id, objID to value.

   fadeIn(objID, maxOpacity, fadeTime)
      Fades in an object with the id, objID up to a maximum opacity of 
      maxOpacity over an interval of fadeTime seconds.

   fadeOut(objID, maxOpacity, fadeTime)
      Fades out an object with the id, objID from a maximum opacity of 
      maxOpacity down to 0 over an interval of fadeTime seconds.
 
   makeSlides()
      Sets up the slideshow by locating all slide images in the document
      and then runs function to create the slide gallery and page
      overlay.

   createSlideBox(thumbs)
      Creates slide gallery containing all of slide images and captions
      stacked on each other.

   createSlideControls(thumbs)
      Create slide controls box containing a close button,
      navigation buttons, and a slide number counter.

   createOverlay()
      Creates a page overlay obscuring the page content when the slide gallery
      is visible.

   showSlideShow()
      Shows the slide gallery using a fade-in effect.


	
*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


function closeObject(objID) {
   document.getElementById(objID).style.display = "none";
}


function showObject(objID) {
   document.getElementById(objID).style.display = "block";
}


function createHighRes(thumb) {

   thumb.big = new Image();
   thumb.big.src = thumb.src.replace(/_thumb/, "");

}


function createRollover(thumb) {
   
   thumb.out = new Image();
   thumb.over = new Image();  

   thumb.out.src = thumb.src;
   thumb.over.src = thumb.src.replace(/_thumb/, "_over");

   thumb.onmouseout = function() {
      thumb.src = thumb.out.src;
   }

   thumb.onmouseover = function() {
      thumb.src = thumb.over.src;
   }
   
}

function getCurrentSlideIndex() {

   var currentSlide = document.getElementById("slideNumber").innerHTML;
   currentIndex = parseInt(currentSlide) - 1;
   return currentIndex;

}


function setOpacity(objID, value) {
  
   var object = document.getElementById(objID);

   // Apply the opacity value for IE and non-IE browsers
   object.style.filter = "alpha(opacity = " + value + ")";
   object.style.opacity = value/100;

}

function fadeIn(objID, maxOpacity, fadeTime) {

   // Calculate the interval between opacity changes
   var fadeInt = Math.round(fadeTime*1000)/maxOpacity;

   var delay = 0;
   
   // Loop up the range of opacity values
   for (var i = 0; i <= maxOpacity; i++) {
      setTimeout("setOpacity('" + objID + "', " + i + ")", delay);
      delay += fadeInt;
   }

}

function fadeOut(objID, maxOpacity, fadeTime) {

   // Calculate the interval between opacity changes
   var fadeInt = Math.round(fadeTime*1000)/maxOpacity;

   var delay = 0;

   // Loop up the range of opacity values
   for (var i = maxOpacity; i >= 0; i--) {
      setTimeout("setOpacity('" + objID + "', " + i + ")", delay);
      delay += fadeInt;
   }

}




/* Add new code below */




addEvent(window, "load", makeSlides, false);


function makeSlides() {

   var thumbs = new Array();

   // populate array of slide images
   for (var i = 0; i < document.images.length; i++) {
      var thumb = document.images[i];

      if (thumb.className == "thumb" && thumb.parentNode.tagName == "A") {
         thumbs.push(thumb);
      }

   }

   for (var i = 0; i < thumbs.length; i++) {

      thumbs[i].index = i;

      // Create a rollover for each slide
      createRollover(thumbs[i]);

      // Attach a high resolution image object to each slide
      createHighRes(thumbs[i]);

      thumbs[i].onclick = showSlideshow;

   }

   if (thumbs.length > 0) {
      createSlideBox(thumbs);
      createSlideControl(thumbs);
      createOverlay();
   }

}

function createSlideBox(thumbs) {


   var slideBox = document.createElement("div");
   slideBox.id = "slideBox";

   
   for (var i = 0; i < thumbs.length; i++) {

      // Insert a high resolution slide
      var slide = document.createElement("div");
      slide.id = "slideBox" + i;
      slide.className = "fullSlide";
   
      var slideImage = document.createElement("img");
      slideImage.src = thumbs[i].big.src;
      slide.appendChild(slideImage);

      var lineBreak = document.createElement("br");
      slide.appendChild(lineBreak);

      // Insert the slide caption
      var slideCaption = document.createTextNode(thumbs[i].alt);
      slide.appendChild(slideCaption);

      slideBox.appendChild(slide);
   }
   document.body.appendChild(slideBox);


   slideBox.onmouseover = function() {
      showObject("slideControls");
   }
   slideBox.onmouseout = function() {
      closeObject("slideControls");
   }

}


function createSlideControl(thumbs) {

   // Create slide control box
   var controlBox = document.createElement("div");
   controlBox.id = "slideControls";

   // Create a button to go to the previous slide
   var slideBack = document.createElement("input");
   slideBack.id = "slideBack";
   slideBack.type = "image";
   slideBack.src = "back.png";
   controlBox.appendChild(slideBack);

   // Show the initial slide number
   var slideNumber = document.createElement("span");
   slideNumber.id = "slideNumber";
   slideNumber.innerHTML = "1";
   controlBox.appendChild(slideNumber);

   // Show the total number of slides
   var slideTotal = document.createTextNode(" of " + thumbs.length);
   controlBox.appendChild(slideTotal);

   // Create a button to go to the next slide
   var slideForward = document.createElement("input");
   slideForward.id = "slideForward";
   slideForward.type = "image";
   slideForward.src = "forward.png";
   controlBox.appendChild(slideForward);

   // Insert a button to close the slide box
   var closeButton = document.createElement("input");
   closeButton.id = "slideBoxClose";
   closeButton.type = "image";
   closeButton.src = "close.png";
   controlBox.appendChild(closeButton);

      // Always show the slide controls during mouseover
         controlBox.onmouseover = function() {
         showObject("slideControls");
      }


      // Events for the slideBack button
         slideBack.onclick = function() {
            var currentIndex = getCurrentSlideIndex();
            var nextIndex = currentIndex - 1;
            if (nextIndex < 0) nextIndex = thumbs.length - 1;

            fadeOut("slideBox" + currentIndex, 100, 3);

            showObject("slideBox" + nextIndex);
            fadeIn("slideBox" + nextIndex, 100, 3);

            slideNumber.innerHTML = nextIndex + 1;
         }


      // Events for the slideForward button
         slideForward.onclick = function() {
            var currentIndex = getCurrentSlideIndex();
            var nextIndex = currentIndex + 1;
            if (nextIndex == thumbs.length) nextIndex = 0;

            fadeOut("slideBox" + currentIndex, 100, 3);

            showObject("slideBox" + nextIndex);
            fadeIn("slideBox" + nextIndex, 100, 3);

            slideNumber.innerHTML = nextIndex + 1;
         }


      // Events for the close button
         closeButton.onclick = function() {
            var currentIndex = getCurrentSlideIndex();
            closeObject("slideControls");
            closeObject("slideBox");
            setOpacity("slideBox" + currentIndex, 0);
            closeObject("slideBox" + currentIndex);

            fadeOut("pageOverlay", 80, 1);
            setTimeout(function() {
               closeObject("pageOverlay");
            }, 1000);
         }

   document.body.appendChild(controlBox);

}


function createOverlay() {

   // Create an overlay to obscure the view of the Web page
   var pageOverlay = document.createElement("div");
   pageOverlay.id = "pageOverlay";

   document.body.appendChild(pageOverlay);

}


function showSlideshow() {

   // Change the image based on the clicked thumbnail
   showObject("slideBox");
   showObject("pageOverlay");
   showObject("slideBox" + this.index);



   var slideNumber = document.getElementById("slideNumber");
   slideNumber.innerHTML = this.index + 1;


   fadeIn("slideBox" + this.index, 100, 1);
   fadeIn("pageOverlay", 80, 1);

   // Halt propagation of the click event
   return false;

}










