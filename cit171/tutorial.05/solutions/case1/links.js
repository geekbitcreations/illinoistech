/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 5
   Case Problem 1

   Author:   Denise Kruschev
   Date:     3/1/2012

   Filename: links.js



   Functions List:

   init()
      Initializes the contents of the Web page

   loadLink()
      Opens a Web page based on the value property of
      the selected option from a selection list


*/

window.onload = init;

function init() {
   var menuTabs = new Array();
   var allSelect = document.getElementsByTagName("select");

   for (var i=0; i< allSelect.length; i++) allSelect[i].onchange=loadLink;

}

function loadLink() {
   sIndex = this.selectedIndex;
   location.href = this.options[sIndex].value;
}
