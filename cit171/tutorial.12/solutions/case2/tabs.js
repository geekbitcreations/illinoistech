/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 12
   Case Problem 2

   Author:   Janet Schmidt
   Date:     3/1/2012

   Filename: tabs.js



   Functions List:

   makeTabs()
      Places external content into a tabbed overlay box.

*/

addEvent(window, "load", makeTabs, false);

function makeTabs() {

   var tabContent = document.getElementById("tabContent");

   var allTabs = new Array();

   for (var i = 0; i < document.getElementsByTagName("div").length; i++) {
      if (document.getElementsByTagName("div")[i].className == "divTab") {
         allTabs.push(document.getElementsByTagName("div")[i]);
      }
   }

   var activeTab = allTabs[0];

   for (var i = 0; i < allTabs.length; i++) {

      allTabs[i].onclick = function() {
         var clickedTab = this;
         var tabName = clickedTab.innerHTML.toLowerCase() + ".htm";

         // Request object for the tab content
         var reqDoc = new XMLHttpRequest();
         reqDoc.open("GET", tabName);
         reqDoc.send(null);
  
         reqDoc.onreadystatechange = function() {
           // Process the data when the response is
           // completed without error
           if (this.readyState == 4) {
              if (this.status == 200) {
                 // Retrieve the tab content
                 tabContent.innerHTML = this.responseText;

                 // Change the tabs
                 activeTab.style.backgroundImage = "url(inactivetab.png)";
                 clickedTab.style.backgroundImage = "url(activetab.png)";
                 activeTab = clickedTab;
               }
           }
         }
       }

   }

}