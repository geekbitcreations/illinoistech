/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 7
   Case Problem 4

   Author:   Clare Daynes
   Date:     3/1/2011

   Filename: scene.js


   Function List:
   uniqueElemText(elemName)
      Returns the unique content from HTML tags with the
      tag name elemName. The list is sorted in alphabetical
      ordered and returned as an array.
*/

addEvent(window, "load", makeCharacterList, false);


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


function uniqueElemText(elemName) {
   elems = document.getElementsByTagName(elemName);
   elemsArray = new Array();

   for (var i=0; i<elems.length; i++) elemsArray[i]=elems[i].innerHTML;  
   elemsArray.sort();
   for (i=0; i<elemsArray.length-1; i++) {
      if (elemsArray[i]==elemsArray[i+1]) {
         elemsArray.splice(i+1,1);
         i--;
      }
   }
   return elemsArray;
}


function makeCharacterList() {
   newP = document.createElement("p");
   newP.innerHTML = "Show Only Lines By:";
   document.getElementById("characterList").appendChild(newP);

   selectList = document.createElement("select");
   selectList.id="cList";
   selectList.onchange=filterScene;

   newOption = document.createElement("option");
   newOption.innerHTML="Show All Character Lines";
   selectList.appendChild(newOption);

   var characters = uniqueElemText("h3");
   for (i=0; i<characters.length; i++) {
      newOption = document.createElement("option");
      newOption.innerHTML=characters[i];
      selectList.appendChild(newOption);
   }

   document.getElementById("characterList").appendChild(selectList);
}

function filterScene() {
   cIndex = document.getElementById("cList").selectedIndex;
   characterText=document.getElementById("cList").options[cIndex].text;

   for (n=document.getElementById("scene").firstChild; n != null; n=n.nextSibling) {
      if (n.nodeName=="H3") {
         if (n.innerHTML==characterText || characterText=="Show All Character Lines") displayStatus="";
         else displayStatus="none";
      }
      if (n.nodeType == 1) n.style.display=displayStatus;
   }
}
