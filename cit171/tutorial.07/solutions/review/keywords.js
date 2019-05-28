/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 7
   Review Assignment

   Author:   Norene Somerville
   Date:     3/1/2011

   Filename: keywords.js


   Functions List:

   addEvent(object, evName, fnName, cap)
      Adds an event hander to object where evName is the name of the event,
      fnName is the function assigned to the event, and cap indicates whether
      event handler occurs during the capture phase (true) or bubbling
      phase (false)

   makeElemList(elem)
      Returns an array containing the content of all elements with the tag name
      "elem" with the content changed to lowercase letters and sorted.

   setElemId(elem, elemText)
      Sets and returns the id for an element with the tag name "elem" and containing
      the content "elemeText".

   makeKeyWordBox()
      Creates a keyword box containing a sorted list of hyperlinks pointing to
      all of the dfn elements in the main document.


*/

addEvent(window, "load", makeKeyWordBox, false);

function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


function makeElemList(elem) {
   var elemList = document.getElementsByTagName(elem); 
   var elemTextArr = new Array();

   for (var i=0; i < elemList.length; i++) {
      elemTextArr[i] = elemList[i].innerHTML.toLowerCase();
   }

   elemTextArr.sort();
   return elemTextArr;
}


function setElemId(elem, elemText) {
   elemList = document.getElementsByTagName(elem);
   for (var i=0;  i < elemList.length; i++) {
      if (elemList[i].innerHTML.toLowerCase() == elemText) {
         if (elemList[i].id == "") {
            elemId = "keyword"+i;
            elemList[i].id = elemId;
         }
         else elemId = elemList[i].id;
      }
   }
   return elemId;
}

function makeKeyWordBox() {

   var historyDoc = document.getElementById("doc");
   var keywordBox = document.createElement("div");
   keywordBox.id="keywords";

   var keywordBoxTitle = document.createElement("h1");
   keywordBoxTitle.innerHTML = "Keywords";
   keywordBox.appendChild(keywordBoxTitle);

   var ulList=document.createElement("ul");
   keywordBox.appendChild(ulList);
   
   var keywords = makeElemList("dfn");   

   for (var i = 0; i < keywords.length; i++) {
      newListItem = document.createElement("li");
      newLink = document.createElement("a");
      newLink.innerHTML = keywords[i];

      linkId = setElemId("dfn",keywords[i]);
      newLink.href = "#"+linkId;

      newListItem.appendChild(newLink);
      ulList.appendChild(newListItem);
   }


   historyDoc.insertBefore(keywordBox, historyDoc.firstChild);

}