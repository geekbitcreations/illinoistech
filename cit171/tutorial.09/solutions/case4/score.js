/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Case Problem 4

   Author:           Todd Ferris
   Date:             3/1/2012
   Filename:         score.js

*/


addEvent(window, "load", setupQuiz, false);

function setupQuiz() {

   document.getElementById("submit").onclick = storeAns;

}

function storeAns() {

   if (cookiesEnabled()) {
      var allInputs = document.getElementsByTagName("input");
      var questionGroup = document.getElementsByTagName("h2")[0].innerHTML;
      var questionCount = 0;

      inputNum = 0;

      for (var i = 0; i < 10; i++) {
         questionCount++;
         var correctAns = "";
         var selectedAns = "";

         for (var j = 0; j < 4; j++) {         
            if (allInputs[inputNum].value == "true") {
               correctAns = (i + 1) + ") " + getAlpha(j);
               correctAns += allInputs[inputNum].parentNode.childNodes[1].nodeValue;
            }
            if (allInputs[inputNum].checked) {
               selectedAns = (i + 1) + ") " + getAlpha(j); 
               selectedAns += allInputs[inputNum].parentNode.childNodes[1].nodeValue;
            } 

            inputNum++;      
         } 

         expire = new Date();
         expire.setMonth(expire.getMonth() + 6);

         storeCookieField(questionGroup, "correct" + questionCount, correctAns, expire);
         storeCookieField(questionGroup, "ans" + questionCount, selectedAns, expire);
      }

      alert("Answers to " + questionGroup + " quiz stored. Click OK to go to next page.");

      var fileName = getFilename();
      if (fileName == "trivia1.htm") window.location = "trivia2.htm"
      else if (fileName == "trivia2.htm") window.location = "trivia3.htm"
      else if (fileName == "trivia3.htm") window.location = "trivia4.htm"
      else if (fileName == "trivia4.htm") window.location = "results.htm";
   } else {
      alert("You must enable cookies to use this quiz");
   }
}

function cookiesEnabled() {

   var cookiesTest = false;

   storeCookie("tempCookie", "temp");
   if (getCookie("tempCookie")) {
      cookiesTest = true;
      removeCookie("tempCookie");
   }

   return cookiesTest;

}

function getAlpha(num) {

   if (num == 0) return "a. "
   else if (num == 1) return "b. "
   else if (num == 2) return "c. "
   else return "d. ";

}

function getFilename() {
   var url = document.location.href;
   var urlLength = url.length;
   while((url.substring(urlLength,urlLength-1))!= "/"){ 
      urlLength--; 
   } 
   clipstart = urlLength;
   return url.substring(url.length, clipstart);
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






