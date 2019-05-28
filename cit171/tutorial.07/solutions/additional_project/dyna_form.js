/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 7 Additional Project Solution

   Favorite CDs
   Author: John Q. Student
   Date:       

   Variable list:
	var numAdd;
	var olElem;
	var favDiv;

   Function list: 

   init()
      Initializes the page
   addEvent(object, evName, fnName, cap) 
      Attaches an event
   addCDs()
      adds input boxes to form for CDs
   addList
      adds cds from form to favorite cd list   

*/
var numAdd;
var olElem;
var favDiv; 

function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}

        window.onload = init;

function init() {

   var cdbutton = document.getElementById("btnCD");
   addEvent(cdbutton, "click", addCDs, false);
   olElem = document.createElement("ol");
   favDiv = document.getElementById("myFav"); 
   favDiv.appendChild(olElem);  
   
}
  
function addCDs() {

  
   var formDiv = document.getElementById("divCD");

   var numCDObj = document.getElementById("numCD");
   numAdd = parseInt(numCDObj.value);

    for (var i = 0; i < numAdd; i ++) {
      var newPara = document.createElement("p");
      var newInput = document.createElement("input");
      var newText = document.createTextNode("Name of CD " + (i + 1) + " : ");
          newInput.type = "text";
          newInput.id = "CD" + (i + 1);
          newPara.appendChild(newText);
          newPara.appendChild(newInput);
          formDiv.appendChild(newPara);
    } 
   var newButton = document.createElement("input");
       newButton.type = "button";
       newButton.id = "btnAdd";
       newButton.value = "Add CDs to list";
   formDiv.appendChild(newButton);
   addEvent(newButton, "click", addList, false); 

}

function addList() {


  



   for (var i = 0; i < numAdd; i++) {
      var newLI = document.createElement("li");
      var getCDObj = document.getElementById("CD" + (i + 1));
      var textCD = getCDObj.value;

      newLI.innerHTML = textCD;
      newLI.id = i + "CD";
      newLI.style.cursor = "pointer";
 
      olElem.appendChild(newLI);
   }


   var formDiv = document.getElementById("divCD");
   formDiv.innerHTML = "";
   var numCDObj = document.getElementById("numCD");
   numCDObj.value = 0;
    

}
  