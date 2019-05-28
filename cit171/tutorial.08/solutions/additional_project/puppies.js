/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 8 Additional Project Solution

   Kira's Place
   Author: John Q. Student
   Date:       

   Variable list:
*/

/* this function attachs the event handler under both event models */
function addEvent(object, evName, fnName, cap) {
	if (object.attachEvent)
		object.attachEvent("on" + evName, fnName);
	else if (object.addEventListener)
		object.addEventListener(evName, fnName, cap);
}

addEvent(window, "load", setupSlideshow, false);

function setupSlideshow() {

  var slides = new Array();
  // populate array of slide images
  for (var i = 0; i < document.images.length; i++) {
     var thumb = document.images[i];
    if (thumb.className == "puppies" ) { 
       slides.push(thumb);
     }
  }

  for (var i = 0; i < slides.length; i++) {
  
    createSlidePic(slides[i], i);
   }

   if (slides.length > 0) {
      createGallery(slides);
      createOverlay();
   }

}

function createGallery(slides) {
   var galleryBox = document.createElement("div");
   galleryBox.id = "galleryBox";


   var galleryTitle = document.createElement("p");
   galleryTitle.id = "galleryTitle";


   var closeButton = document.createElement("input");
   closeButton.type = "image";
   closeButton.src = "close.jpg";
   closeButton.onclick = function() {
      galleryBox.style.display = "none";
      document.getElementById("pageOverlay").style.display = "none";
   }
   closeButton.height = "30";
   closeButton.width = "150";

   var slidePrevious = document.createElement("input");
   slidePrevious.type = "image";
   slidePrevious.src = "previous.jpg";
   slidePrevious.height = "30";
   slidePrevious.width = "150";
   slidePrevious.onclick = function() {
       var currentSlide = document.getElementById("gallerySlide");
       var currentIndex = currentSlide.index;
       currentIndex--;
      if (currentIndex == -1) currentIndex = slides.length -1;
         changeSlide(slides[currentIndex]);
   }
   
   var slideNext = document.createElement("input");
   slideNext.type = "image";
   slideNext.src = "next.jpg";
   slideNext.height = "30";
   slideNext.width = "150"; 
   slideNext.onclick = function() {
     var currentSlide = document.getElementById("gallerySlide");
     var currentIndex = currentSlide.index;
     currentIndex++;
     if (currentIndex == slides.length) currentIndex = 0;
        changeSlide(slides[currentIndex]);
   }

   galleryTitle.appendChild(slidePrevious);
   galleryTitle.appendChild(slideNext);
   galleryTitle.appendChild(closeButton);
   galleryBox.appendChild(galleryTitle);




   // Insert a slide
  var slide = document.createElement("img");
  slide.id = "gallerySlide";
  slide.src = slides[0].big.src;
  slide.index = 0;
  galleryBox.appendChild(slide);

  // Insert the slide caption
   var slideCaption = document.createElement("p");
   slideCaption.id = "slideCaption";
   slideCaption.innerHTML = slides[0].alt;
   galleryBox.appendChild(slideCaption);

  document.body.appendChild(galleryBox);
}


function createSlidePic(thumb, index) {
   thumb.big = new Image();
   thumb.big.src = thumb.src.replace(/_small/, "_big");
   thumb.onclick = showGallery;
   thumb.big.index = index;
}

function showGallery() {
   // Change the image based on the clicked thumbnail
   changeSlide(this);   


   // Reveal the slide show
   document.getElementById("galleryBox").style.display = "block";
   document.getElementById("pageOverlay").style.display = "block";
   // Halt propagation of the click event
   return false;
}

function changeSlide(slide) {
   // Set object references
   var galleryBox = document.getElementById("galleryBox");
   var oldSlide = document.getElementById("gallerySlide");
   var slideCaption = document.getElementById("slideCaption");
   // Replace current slide with new slide
   setOpacity("gallerySlide", 0);
   var newSlide = oldSlide.cloneNode(true);
   newSlide.src = slide.big.src;
   newSlide.index = slide.big.index;
   galleryBox.replaceChild(newSlide, oldSlide);
   fadeIn("gallerySlide", 100, 0.5, 0);
   // Replace current caption with new caption
   slideCaption.innerHTML = slide.alt;
}

function createOverlay() {
    // Create an overlay to obscure the view of the Web page
   var pageOverlay = document.createElement("div");
   pageOverlay.id = "pageOverlay";
   document.body.appendChild(pageOverlay);
}
function fadeIn(objID, maxOpacity, fadeTime, delay) {
   var fadeInt = Math.round(fadeTime*1000)/maxOpacity;
   for (var i = 0; i <= maxOpacity; i++) {
      setTimeout("setOpacity('" + objID + "', " + i + ")", delay);
      delay += fadeInt;
   }
}
function setOpacity(objID, value) {
   var object = document.getElementById(objID);
   // Apply the opacity value for IE and non-IE browsers
   object.style.filter = "alpha(opacity = " + value + ")";
   object.style.opacity = value/100;
}
