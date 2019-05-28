/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 10
   Case Problem 2

   Author:   Andrew Seaborn
   Date:     3/1/2012

   Filename: script.js



   Functions List:

   addEvent(object, evName, fnName, cap)
      Adds an event handler to object where object is the object 
      reference, evName is the name of the event, fnName is the
      reference to the function, and cap specifies the
      capture phase.

   setupButtons()
      Create event handlers for the form buttons

   sendCode()
      Retrieves the CSS and HTML code found in the documents in the inputcss
      and inputhtml frames and then writes the HTML document based on
      those text strings.

   showPreview()
      Changes the frame layout to show the Web page preview


   showCode()
      Changes the frame layout to show only the code frames

   showBoth()
      Changes the frame layout to show both the Web page preview
      and the code frames

*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


/* Add new code below */


addEvent(window, "load", setupButtons, false);

function setupButtons() {
   document.getElementById("submitCode").onclick = sendCode;
   document.getElementById("showCode").onclick = showCode;
   document.getElementById("showPreview").onclick = showPreview;
   document.getElementById("showBoth").onclick = showBoth;
}


function sendCode() {
   var previewFrame = parent.frames[3];
   var htmlCode = parent.frames[1].document.getElementById("inputhtml").value;
   var cssCode = parent.frames[2].document.getElementById("inputcss").value;

   previewFrame.document.write("<html><head><title></title>");
   previewFrame.document.write("<style type='text/css'>" + cssCode + "</style>");
   previewFrame.document.write("</head><body>" + htmlCode + "</body></html>");
   previewFrame.document.close();
}


function showPreview() {
   parent.document.getElementById("demo").rows="100,1,*";
}

function showCode() {
   parent.document.getElementById("demo").rows="100,*,1";
   parent.frames[1].document.getElementById("inputhtml").style.height="300px" 
   parent.frames[2].document.getElementById("inputcss").style.height="300px"  
}

function showBoth() {
   parent.document.getElementById("demo").rows="100,210,*";
   parent.frames[1].document.getElementById("inputhtml").style.height="150px" 
   parent.frames[2].document.getElementById("inputcss").style.height="150px" 
}


