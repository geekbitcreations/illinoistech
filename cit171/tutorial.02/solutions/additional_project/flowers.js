/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 2 Additional Project Solution

   Author: John Q. Student
   Date:   

   Function List:
   displayBanner(currentDate)
      Using the date, sets the banner image source
   calcDaysToSale(currentDate)
      Returns the days to sale message

*/

function displayBanner(currentDate) {

   // get current month
   thisMonth = parseInt(currentDate.getMonth() + 1);
   
   // set the logo
   imgSrc = "default_logo.gif"
   imgSrc = ((thisMonth == 12) || (thisMonth == 1) || (thisMonth == 2)) ? "winter_logo.gif" : "defaultLogo.gif"; 
   imgSrc = ((thisMonth == 3) || (thisMonth == 4) || (thisMonth == 5)) ? "spring_logo.gif" : imgSrc; 
   imgSrc = ((thisMonth == 6) || (thisMonth == 7) || (thisMonth == 8)) ? "summer_logo.gif" : imgSrc; 
   imgSrc = ((thisMonth == 9) || (thisMonth == 10) || (thisMonth == 11)) ? "fall_logo.gif" : imgSrc; 
   document.getElementById("myBanner").src = imgSrc;
}

function calcDaysToSale(currentDate) {
   // calculate 15th date         
   midDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), 15);

   // calculate days until
   daysDiff = parseInt((midDate - currentDate)/(1000*60*60*24));
   
   // set sale message
   newMessage = (daysDiff > 0) ? daysDiff : "Sale over for this month";
   
   return newMessage;
}