/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 8
   Case Problem 3

   Author:   Gerry Hayward
   Date:     3/1/2012

   Filename: filmstrip.js


   Functions
  
   addEvent(object, evName, fnName, cap)
      Run the function fnName when the event evName occurs in object.

   setOpacity(object, value)
      Sets the opacity of object to value (0 - 100)

   makeFilmStrip()
      Makes the filmstrip includes the strip of thumbnail images,
      the large-scale photo box, and the resizing buttons.


*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


function setOpacity(object, value) {

   // Apply the opacity value for IE and non-IE browsers
   object.style.filter = "alpha(opacity = " + value + ")";
   object.style.opacity = value/100;

}


/* Insert new code below */




addEvent(window, "load", makeFilmStrip, false);


function makeFilmStrip() {


   var photos = new Array();

   // Locate all of the filmstrip links
   for (var i = 0; i < document.links.length; i++) {
      if (document.links[i].rel == "filmstrip") photos.push(document.links[i]);
   }


   if (photos.length > 0) {


      // Create the slide gallery box
      var slideGallery = document.createElement("div");
      slideGallery.id = "slideGallery";


      // Create the strip of thumbnail images
      var thumbStrip = document.createElement("div");
      thumbStrip.id = "thumbStrip";

      // Loop through the filmstrip images in the photos array
      // and add them as thumbnail images to the filmscript box.
      for (var i = 0; i < photos.length; i++) {

         var thumbnail = new Image();
         thumbnail.src = photos[i].href;
         thumbnail.caption = photos[i].innerHTML;
      
         var thumbBox = document.createElement("div");
         thumbBox.className = "thumbBox";
         thumbBox.style.top = "0px";
         thumbBox.style.left = 125*i + "px";

         thumbBox.appendChild(thumbnail);
         thumbStrip.appendChild(thumbBox);


         // Set opacity to 100% when the mouse is over the thumbnail image
         thumbnail.onmouseover = function() {setOpacity(this, 100);}

         // Set opacity to 50% when the mouse pointer leaves the image
         thumbnail.onmouseout = function() {setOpacity(this, 50);}

         // Change the large-scale image in the photo box when the 
         // Thumbnail is clicked
         thumbnail.onclick = function() {
            var newPhoto = new Image();
            newPhoto.src = this.src;
            var oldPhoto = photoBox.childNodes[0];
            photoBox.replaceChild(newPhoto, oldPhoto);
            photoCaption.innerHTML = this.caption;
         }

      }
      
      slideGallery.appendChild(thumbStrip);

      // Create buttons to resize the photo image
      var resizeControls = document.createElement("div");
      resizeControls.id = "resizeControls"

      var reduceButton = document.createElement("input");
      reduceButton.type = "image";
      reduceButton.src = "reduce.png";
 
      var enlargeButton = document.createElement("input");
      enlargeButton.type = "image";
      enlargeButton.src = "enlarge.png";

      slideGallery.appendChild(resizeControls);

      resizeControls.appendChild(reduceButton);
      resizeControls.appendChild(enlargeButton);
      reduceButton.onclick = function() {
         var photo = photoBox.childNodes[0];
         var currentWidth = photo.width;
         var currentHeight = photo.height;
         var ratio = currentHeight/currentWidth;
         var newWidth = currentWidth - 20;
         if (newWidth > 0) {
            var newHeight = ratio*newWidth;
            photo.width = newWidth;
            photo.height = newHeight;
         }
      }

      enlargeButton.onclick = function() {
         var photo = photoBox.childNodes[0];
         var currentWidth = photo.width;
         var currentHeight = photo.height;
         var ratio = currentHeight/currentWidth;
         var maxWidth = photoBox.offsetWidth;
         var newWidth = currentWidth + 20;
         if (newWidth <= maxWidth) {
            var newHeight = ratio*Math.round(newWidth);
            photo.width = newWidth;
            photo.height = newHeight;
         }
      } 


      // Create the photo box containing the large-scale image
      var photoBox = document.createElement("div");
      photoBox.id = "photoBox";
      var photo = new Image();
      photo.src = photos[0].href;
      photo.id = "slidePhoto";
      photoBox.appendChild(photo);

      var lineBreak = document.createElement("br");
      photoBox.appendChild(lineBreak);
      
      var photoCaption = document.createElement("span");
      photoCaption.innerHTML = photos[0].innerHTML;

      photoBox.appendChild(photoCaption);

      slideGallery.appendChild(photoBox);

      // Replace the list of links with the filmstrip slide gallery
      var photoLinks = document.getElementById("photoLinks");
      document.getElementById("main").replaceChild(slideGallery, photoLinks);

   }

}

