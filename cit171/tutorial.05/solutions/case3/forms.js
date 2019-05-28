/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 5
   Case Problem 3

   Author:   Rajiv Rammohan
   Date:     3/1/2012

   Filename: forms.js



   Functions List:

   init() 
      Initializes the onsubmit event handler for the form

   calcCost()
      Calculates the registration cost for the participant

   testLength()
      Tests the length of  field. If the length is 0, change
      the background color to yellow and return the value false;
      otherwise leave the background color white and return the value
      true

   testPattern()
      Tests a field to verify that it matches the regular expression
      pattern. If the test fails, change
      the background color to yellow and return the value false;
      otherwise leave the background color white and return the value
      true

   submitForm
      Validates a Web form by calling the testLength() and testPattern()
      functions. If all tests are passed, run the calcCost() function
      to calculate the registration cost; otherwise return the value
      false.

*/

window.onload = init;

function init() {
   document.forms[0].onsubmit = submitForm;
}


function calcCost() {
   var rform = document.forms[0];
   var cost = 145;
   cost += rform.guests.selectedIndex*30;
   if (rform.member[0].checked) cost-=25;
 
   rform.total.value = cost;
}
   
function testLength(field) {
   if (field.value.length == 0) {
      field.style.backgroundColor="yellow";
      return false;
   } else {
      field.style.backgroundColor="white";
      return true;
   }
}

function testPattern(field, reg) {
   if (reg.test(field.value)==false) {
      field.style.backgroundColor="yellow";
      field.style.color="red";
      return false;
   } else {
      field.style.backgroundColor="white";
      field.style.color="black";
      return true;
   }
}

function submitForm() {
   var valid = true;
   var rform = document.forms[0];
   
   if (testLength(rform.fname)==false) valid=false;
   if (testLength(rform.lname)==false) valid=false;
   if (testLength(rform.address)==false) valid=false;  
   if (testLength(rform.email)==false) valid=false; 
   if (testPattern(rform.phone1,/^\d{3}$/)==false) valid=false; 
   if (testPattern(rform.phone2,/^\d{3}$/)==false) valid=false; 
   if (testPattern(rform.phone3,/^\d{4}$/)==false) valid=false; 

   if ((rform.member[0].checked || rform.member[1].checked)== false) {
      rform.member[0].style.backgroundColor="yellow";
      rform.member[1].style.backgroundColor="yellow";
      valid=false;
   }

   if (valid == false) alert("Enter all required information in the appropriate format");
   else calcCost();

   return valid;
}