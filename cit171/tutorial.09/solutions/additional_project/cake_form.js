/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 9 Additional Project Solution

   Cakes by Emily
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


addEvent(window, "load", initPage, false);

function initPage() {
   //Add event handler to the Submit button
   document.getElementById("sbutton").onclick = saveMailingInfo;
}

function writeCookie(cName, cValue, expDate, cPath, cDomain, cSecure) {
  if (cName && cValue != "") {
     var cString = cName + "=" + escape(cValue);
     if (expDate) 
        cString += ";expires=" + expDate.toGMTString();

     if (cPath) cString += ";path=" + cPath;
     if (cDomain) cString += ";domain=" + cDomain;
     if (cSecure) cString += ";secure";


     document.cookie = cString;
  }
}

function saveMailingInfo() {
   var expire = new Date();
   expire.setFullYear(expire.getFullYear() + 3);
   var allFields = document.mailingForm.elements;

   for (var i = 0; i < allFields.length; i++) {

     if (allFields[i].type == "text") {
         // Write input box value to a cookie
         writeCookie(allFields[i].id, allFields[i].value, expire);
      }

     if (allFields[i].nodeName == "SELECT") {
         writeCookie(allFields[i].id, allFields[i].selectedIndex, expire); 
      }

     if (allFields[i].type == "radio" || allFields[i].type == "checkbox") {
         writeCookie(allFields[i].id, allFields[i].checked, expire);
     }

   }
   alert("Mailing list data saved");
}

