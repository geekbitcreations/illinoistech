/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 7
   Review Assignment

   Author:   Norene Somerville
   Date:     3/1/2011

   Filename: styles.js

   Global Variables:
   styleList
      An array containing the link elements whose rel attribute equals "stylesheet"
      or "alternate stylesheet" and whose title attribute is not empty

   Functions List:

   addEvent(object, evName, fnName, cap)
      Adds an event hander to object where evName is the name of the event,
      fnName is the function assigned to the event, and cap indicates whether
      event handler occurs during the capture phase (true) or bubbling
      phase (false)

   makeStyleListBox()
      Generate selection list for each preferred and alternate style sheet linked
      to the current Web document

   changeStyle()
      Changes style sheet from the currently active sheet to whatever the
      user changes the selected style from the selection list

*/

function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}

addEvent(window, "load", makeStyleListBox, false);

var styleList = new Array();

function makeStyleListBox() {
   var allLinks = document.getElementsByTagName("link");

   // Create an array of preferred or alternate style sheets
   for (var i = 0; i < allLinks.length; i++) {
      if ((allLinks[i].rel == "stylesheet" || allLinks[i].rel == "alternate stylesheet")
          && allLinks[i].title != "") {
         styleList.push(allLinks[i]);
      }
   }

   // Create buttons for each preferred or alternate style sheet
   var styleSelect = document.createElement("select");

   for (var i = 0; i < styleList.length; i++) {
     // Initialize the style sheets
     if (styleList[i].rel == "stylesheet") {
        styleList[i].disabled = false;
     } else {
        styleList[i].disabled = true;
     }

     styleOption = document.createElement("option");
     styleOption.value = styleList[i].title;
     styleOption.innerHTML = styleList[i].title + " view";


     styleSelect.appendChild(styleOption);
   }

   // Define the styles of the style list box
   styleSelect.style.width = "220px";
   styleSelect.style.cssFloat = "right";
   styleSelect.style.styleFloat = "right";
   styleSelect.style.margin = "5px 5px 10px 10px";

   // Apply an event handler to the style list box
   addEvent(styleSelect, "change", changeStyle, false);

   // Add the style list box to the source document
   var sourceDoc = document.getElementById("doctitle");
   sourceDoc.insertBefore(styleSelect, sourceDoc.firstChild);
}

function changeStyle(e) {
   var selObj = e.target || event.srcElement;

   var selectedItem = selObj.selectedIndex;

   styleOption = selObj.options[selectedItem].value;

   for (var i = 0; i < styleList.length; i++) {
      if (styleList[i].title == styleOption) {
         styleList[i].disabled = false;
      } else {
         styleList[i].disabled = true;
      }
   }
}


