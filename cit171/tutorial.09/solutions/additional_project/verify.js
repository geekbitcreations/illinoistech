/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 9 Additional Project Solution

   Cakes by Emily
   Author: John Q. Student
   Date:   

   Variable list:
*/

var favCakes = new Array();

favCakes[0] = "Butter Cream";
favCakes[1] = "Chocolate";
favCakes[2] = "Vanilla";
favCakes[3] = "Red Velvet";


/* this function attachs the event handler under both event models */
function addEvent(object, evName, fnName, cap) {
	if (object.attachEvent)
		object.attachEvent("on" + evName, fnName);
	else if (object.addEventListener)
		object.addEventListener(evName, fnName, cap);
}

addEvent(window, "load", retrieveMemberInfo, false);


function retrieveCookie(cName) {
  if (document.cookie) {
    var cookiesArray = document.cookie.split("; ");
    for (var i = 0; i < cookiesArray.length; i++) {
      if (cookiesArray[i].split("=")[0] == cName) {
        return unescape(cookiesArray[i].split("=")[1]);
      }
    }
  }
}

function retrieveMemberInfo() {
   if (retrieveCookie("lastName")) {
       // Retrieve the membership data
         var allSpans = document.getElementsByTagName("span");
        for (var i = 0; i < allSpans.length; i++) {
            var cValue = retrieveCookie(allSpans[i].id);
            if (cValue) allSpans[i].innerHTML = cValue;
            }

        var favCakeIndex = retrieveCookie("favoriteCake");
        document.getElementById("favoriteCake").innerHTML = favCakes[favCakeIndex];

   // Retrieve the frequency option
   if (retrieveCookie("frequency1") == "true")
       document.getElementById("frequency").innerHTML = "Monthly Emails";
   else if (retrieveCookie("frequency2") == "true")
       document.getElementById("frequency").innerHTML = "Quarterly Emails";
   else if (retrieveCookie("frequency3") == "true")
       document.getElementById("frequency").innerHTML = "Week before birthday";

   }
}