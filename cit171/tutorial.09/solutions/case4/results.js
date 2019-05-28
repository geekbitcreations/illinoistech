/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Case Problem 4

   Author:           Todd Ferris
   Date:             3/1/2012
   Filename: results.js

*/

addEvent(window, "load", showResults, false);

function showResults() {

   resultDIV = document.getElementById("qresults");
   quizzes = ["Presidents", "Movies", "Sports", "Music"];
   var correctCount = 0;

   for (var i = 0; i < 4; i++) {

      var qDIV = document.createElement("div");
      qDIV.innerHTML = "";
      qDIV.className = "quizList";
      var cName = quizzes[i];
      var textStr = "<h2>" + cName + "</h2>";

      for (var j = 1; j <= 10; j++) {

         var correct = getCookieField(cName, "correct"+j);
         var ans = getCookieField(cName, "ans"+j);

         if (correct == ans) {
            textStr += (ans + "<br />");
            correctCount++;
         } else {
            textStr += ("<br /><strike>"+ans+"</strike><br />"+correct+"<br /><br />");
         }

         qDIV.innerHTML = textStr;

      }      

      resultDIV.appendChild(qDIV);
   }

   var resultP = document.createElement("p");
   resultP.innerHTML = "You got " + correctCount + " correct out of 40.";
   resultDIV.appendChild(resultP);


}

function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}


function storeCookie(cName, cValue, expDate, cPath, cDomain, cSecure) {
   if (cName && cValue != null) {
      var cString = cName + "=" + escape(cValue);
      cString += (expDate ? ";expires=" + expDate.toGMTString(): "");
      cString += (cPath ? ";path=" + cPath : "");
      cString += (cDomain ? ";domain=" + cDomain : "");
      cString += (cSecure ? ";secure" : "");
      document.cookie = cString;
   }
}


function getCookie(cName) {
   if (document.cookie) {
      var cookies = document.cookie.split("; ");
      for (var i = 0; i < cookies.length; i++) {
         if (cookies[i].split("=")[0] == cName) {
            return unescape(cookies[i].split("=")[1]);
         }
      }
   }
}


function removeCookie(cName) {
   if (document.cookie) {
      var cookies = document.cookie.split("; ");
      for (var i = 0; i < cookies.length; i++) {
         if (cookies[i].split("=")[0] == cName) {
            document.cookie = cName + "=;expires=Thu, 01-Jan-1970 00:00:01 GMT";
         }
      }
   }
}

function storeCookieField(cName, fName, fValue, expDate, cPath, cDomain, cSecure) {

   if (cName  && fName  && fValue != null) {

      var subkey = fName + "=" + escape(fValue);

      var cValue = null;
      var cookies = document.cookie.split("; ");
      for (var i = 0; i < cookies.length; i++) {
         if (cookies[i].split("=")[0] ==  cName) {
            cValue = cookies[i].slice(cookies[i].indexOf("=") + 1);
            break;
         }
      }
     if (cValue) {
         var foundField = false;
         var subkeys = cValue.split("&");
         for (var i = 0; i < subkeys.length; i++) {
            if (subkeys[i].split("=")[0] == fName) {
               foundField = true;
               subkeys[i] = subkey;
               break;
            }
         }
         if (foundField) cValue = subkeys.join("&")
         else cValue += "&" + subkey;
     } else {
         cValue = subkey;
     }
      var cString = cName + "=" + cValue;
      cString += (expDate ? ";expires=" + expDate.toGMTString(): "");
      cString += (cPath ? ";path=" + cPath : "");
      cString += (cDomain ? ";domain=" + cDomain : "");
      cString += (cSecure ? ";secure" : "");
      document.cookie = cString;
   } 
}

function getCookieField(cName, fName) {
   if (document.cookie) {
      var cValue = null;
      var cookies = document.cookie.split("; ");
      for (var i = 0; i < cookies.length; i++) {
         if (cookies[i].split("=")[0] == cName) {
            cValue = cookies[i].slice(cookies[i].indexOf("=") + 1 );
            break;
         }
      }
      if (cValue) {
         var subkeys = cValue.split("&");
         for (var i = 0; i < subkeys.length; i++) {
            if (subkeys[i].split("=")[0] == fName)
               return unescape(subkeys[i].split("=")[1]);
         }
      }
   }
}






