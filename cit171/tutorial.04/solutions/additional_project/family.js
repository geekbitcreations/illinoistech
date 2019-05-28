/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 4 Additional Project Solution

  The Jones Family
   Author: John Q. Student
   Date:   

   Variable list:

   activeMenu
      An object variable pointing to the currently active and open menu
   timeID
      A variable containing the id of a timed command using the setInterval method

   Function list: 

   init()
      Initializes the contents of the tutorial13solution.htm Web page
   openMenu()
      opens a menu
   closeMenu()
      closes a menu
   moveItemRight
      applies a slide-right effect to a menu
   moveItemLeft
      applies a slide-left effect to a menu

*/

window.onload = init;


var activeMenu = null;
var timeID;


function init() {
   var menus = new Array();
   var allElems = document.getElementsByTagName("*");


   for (var i = 0; i < allElems.length; i++) {
      if (allElems[i].className == "navG")  menus.push(allElems[i]);
   }

   for (var i = 0; i < menus.length; i++) {
      menus[i].onclick = openMenu;
   }

}

function openMenu() {
   
      menuID = this.id; 
      activeMenu = document.getElementById(menuID);
      timeID = setInterval("moveItemRight()", 1);

}




function closeMenu() {

      menuID = this.id; 
      activeMenu = document.getElementById(menuID);
      timeID = setInterval("moveItemLeft()", 1);

}




function moveItemRight() {
 
   currentPos = parseInt(activeMenu.style.left);
   
   if ((currentPos + 5) <= 0) {
     leftPos = parseInt(activeMenu.style.left);
     activeMenu.style.left = leftPos + 5 + "px";
   } else {
     clearInterval(timeID);
   }
   activeMenu.onclick = closeMenu;
}

function moveItemLeft() {
   
   currentPos = parseInt(activeMenu.style.left);
   if ((currentPos ) >= -145) {
     leftPos = parseInt(activeMenu.style.left);
     activeMenu.style.left = leftPos - 5 + "px";
   } else {
     clearInterval(timeID);
   }
   activeMenu.onclick = openMenu;
}