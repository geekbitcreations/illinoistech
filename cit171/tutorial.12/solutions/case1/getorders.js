/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 12
   Case Problem 1

   Author:   Bernard Kolbe
   Date:     3/1/2012

   Filename: getorders.js



   Functions List:

   retrieveOrders()
      Retrieves the orders from the Web server and displays
      the HTML code in the orderhistory section of the
      document

*/

addEvent(window, "load", retrieveOrders, false);

function retrieveOrders() {
   var user = document.getElementById("userid");
   var pwd = document.getElementById("pwd");
   var sButton = document.getElementById("submitButton");
   var orderHistory = document.getElementById("orderhistory");

   sButton.onclick = function() {

      var userValue = user.value;
      var pwdValue = pwd.value;

      if (userValue != "" && pwdValue != "") {
         // Request object for the order history record
         var reqOrders = new XMLHttpRequest();
         reqOrders.open("GET", "/cgi-bin/wworders.pl?user=" + userValue + "&pwd=" + pwdValue);
         reqOrders.send(null);
  
         reqOrders.onreadystatechange = function() {
           // Process the data when the response is
           // completed without error
           if (this.readyState == 4) {
              if (this.status == 200) {
                 // Retrieve the daily commentary and
                 // display it within the main section
                 orderHistory.innerHTML = this.responseText;
               }
           }
         }

       }
   }

}