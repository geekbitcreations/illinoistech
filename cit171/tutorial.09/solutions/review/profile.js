/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Review Assignment

   Author:   Kevin Geary
   Date:     3/1/2012

   Filename: profile.js

   Functions List:

   getSelection(selectionList)
      Retrieves the index  number of the selected option from the selection
      list, selectionList.

   getOption(optionGroup) 
      Retrieves index number of the selected radio button from the
      group of radio buttons with the name, optionGroup

   initPage()
      Adds an event handler to the profile form submit button
      when the page is opened.

   saveProfile()
      Saves the values in the profile form to fields in
      the memberInfo multi-valued cookie

*/

function getSelection(selectionList) {
   return parseInt(selectionList.selectedIndex);
}

function getOption(optionGroup) {
   for (var i = 0; i < optionGroup.length; i++) {
      if (optionGroup[i].checked) return parseInt(i);
   }
}


/* Add new code below */


addEvent(window, "load", initPage, false);

function initPage() {

   //Add event handler to the Submit button
   document.getElementById("submitButton").onclick = saveProfile;

   if (navigator.cookieEnabled == false) {
      alert("You must have cookies enabled to save your profile");

      var allFields = document.forms[0].elements;
      for (var i = 0; i < allFields.length; i++) {
         allFields[i].disabled = true;
      }

   } else {

      if (getCookie("profile")) {
      
         document.getElementById("firstName").value = getCookieField("profile", "firstName");
         document.getElementById("lastName").value = getCookieField("profile", "lastName");  
         document.forms[0].gender[getCookieField("profile", "gender")].checked = true;
         document.forms[0].age.selectedIndex = getCookieField("profile", "age");
         document.forms[0].bikeOption[getCookieField("profile", "bike")].checked = true;
         document.forms[0].routeOption[getCookieField("profile", "route")].checked = true;
         document.forms[0].sagOption[getCookieField("profile", "sag")].checked = true;
         document.forms[0].accOption[getCookieField("profile", "accommodation")].checked = true;
         document.forms[0].region.selectedIndex = getCookieField("profile", "region");
         document.forms[0].miles.selectedIndex = getCookieField("profile", "miles");
         document.getElementById("comments").value = getCookieField("profile", "comments");

      }
   }

}


function saveProfile() {

      // Set the cookie expiration 6 months hence
      var expire = new Date();
      expire.setMonth(expire.getMonth() + 6);
 
      storeCookieField("profile", "firstName", document.getElementById("firstName").value, expire);
      storeCookieField("profile", "lastName", document.getElementById("lastName").value, expire);
      storeCookieField("profile", "gender", getOption(document.forms[0].gender), expire);
      storeCookieField("profile", "age", getSelection(document.getElementById("age")), expire);
      storeCookieField("profile", "bike", getOption(document.forms[0].bikeOption), expire);
      storeCookieField("profile", "route", getOption(document.forms[0].routeOption), expire);
      storeCookieField("profile", "sag", getOption(document.forms[0].sagOption), expire);
      storeCookieField("profile", "accommodation", getOption(document.forms[0].accOption), expire);
      storeCookieField("profile", "region", getSelection(document.getElementById("region")), expire);
      storeCookieField("profile", "miles", getSelection(document.getElementById("miles")), expire);   
      storeCookieField("profile", "comments", document.getElementById("comments").value, expire);

      alert("Profile Stored");
}



