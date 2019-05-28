/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 10
   Case Problem 2

   Author:   Jacob Terrell
   Date:     3/1/2012

   Filename: iframe.js



   Functions List:

   addEvent(object, evName, fnName, cap)
      Adds an event handler to object where object is the object 
      reference, evName is the name of the event, fnName is the
      reference to the function, and cap specifies the
      capture phase.

   setupFrame()
      Sets up the inline frame by adding the custom index property
      and onmouseover and onmouseout event handlers

   writeFrame()
      Writes the title and summary text to the document in the inline
      frame

   clearFrame()
      Clears the title and summary text from the document in the inline
      frame

*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


/* Add new code below */


addEvent(window, "load", setupFrame, false);


function setupFrame() {

   var allAreas = document.getElementsByTagName("area");
   for (var i = 0; i < allAreas.length; i++) {
      allAreas[i].index = i;
      allAreas[i].onmouseover = writeFrame;
      allAreas[i].onmouseout = clearFrame;
   }

}

function writeFrame() {

   var areaIndex = this.index;
   var frameWin = document.getElementById("parts").contentWindow;
   var frameDoc = frameWin.document;

   frameDoc.getElementById("docTitle").innerHTML = title[areaIndex];
   frameDoc.getElementById("docSummary").innerHTML = summary[areaIndex];

}

function clearFrame() {

   var frameWin = document.getElementById("parts").contentWindow;
   var frameDoc = frameWin.document;

   frameDoc.getElementById("docTitle").innerHTML = "";
   frameDoc.getElementById("docSummary").innerHTML = "";

}
