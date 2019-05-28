/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 2
   Case Problem 3

   Author: David Lin
   Date:   3/1/2011

   Function List:
   addTime(oldTime, milliSeconds)
      Used to add a specified number of milliseconds to a date object named oldTime.
      A new date object with the new time value is returned by the function.

   showTime(time)
      Displays a time value in the format:
      hh:mm AM/PM
*/

function addTime(oldTime, milliSeconds) {
   var newTime = new Date();
   var newValue = oldTime.getTime()+milliSeconds;
   newTime.setTime(newValue);
   return newTime;
}  

function showTime(time) {
   minute = time.getMinutes();
   hour = time.getHours();

   ampm = (hour < 12) ? "AM" : "PM";
   hour = (hour > 12) ? hour - 12 : hour;
   hour = (hour == 0) ? 12 : hour;

   minute = minute < 10 ? "0"+minute : minute;

   return hour+":"+minute+ampm;
}





