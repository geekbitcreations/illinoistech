/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 10
   Tutorial Case

   Author:  Teresa Jenner 
   Date:    3/1/2012


   Filename: status.js


   Functions List:

   initPage()
      Change the status bar message displayed by the browser
      and prevents the page from appearing within a frame

*/

addEvent(window, "load", initPage, false);


function initPage() {
   window.defaultStatus = "Welcome to iMusicHistory.com";

   // Prevent the page from appearing within a frame
   if (top.location.href != self.location.href) {
      top.location.href = self.location.href;
   }

}

