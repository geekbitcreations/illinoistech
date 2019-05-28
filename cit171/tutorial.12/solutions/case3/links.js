/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 12   Case Problem 3

   Author:   Susan Crawford
   Date:     3/1/2012

   Filename: links.js



   Functions List:

   makeLinkPreviews()
      Creates event handlers for all links marked with
      the previewLink class to display an overlay preview
      of the target of the link

*/

addEvent(window, "load", makeLinkPreviews, false);

function makeLinkPreviews() {

   var previewLinks = new Array();
   var activeLink = null;
   var activeOverlay = null;

   for (var i = 0; i < document.links.length; i++) {
      if (document.links[i].className == "previewLink") {
         previewLinks.push(document.links[i]);
      }
   }

   for (var i = 0; i < previewLinks.length; i++) {

      var glassIcon = document.createElement("img");
      glassIcon.src = "glass.png";

      insertAfter(previewLinks[i], glassIcon);

      previewLinks[i].onmouseover = showPreview;
      previewLinks[i].onmouseout = hidePreview;

   }

   function showPreview(e) {

      var evt = e || window.event;
      var hyperlink = evt.target || evt.srcElement;
      var activeLink = hyperlink.href;

      // Request object for the page preview
      var reqPage = new XMLHttpRequest();
      reqPage.open("GET", activeLink, false);
      if (reqPage.overrideMimeType) reqPage.overrideMimeType("text/xml");
      reqPage.send(null);

      // Store the XHTML document object   
      xhtmlDoc = reqPage.grabXHTMLAsXML();
     
      // Create a link document from the XHTML code
      myLink = new linkDocument(xhtmlDoc);

      // Create the pop-up overlay
      activeOverlay = myLink.makeOverlay();
   
      var mouseX = parseInt(evt.clientX);
      var mouseY = parseInt(evt.clientY);

      activeOverlay.style.display = "block";
      activeOverlay.style.top = mouseY + 5 + "px";
      activeOverlay.style.left = mouseX + 5 + "px";

      document.body.appendChild(activeOverlay);


   }

   function hidePreview(e) {
      if (activeOverlay) document.body.removeChild(activeOverlay);
      activeOverlay = null;
   }


}