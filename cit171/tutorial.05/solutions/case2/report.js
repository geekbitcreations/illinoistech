/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 5
   Case Problem 2

   Author:   Denise Kruschev
   Date:     3/1/2012

   Filename: report.js



   Functions List:

   initPage()
      Initializes the contents of the Web page

   testLength()
      Tests a field for its length

   testPattern()
      Tests a field for its pattern

   validateForm
      Validates a Web form

   calcRow
      Calculates the costs within one row of the travel report

   calcTotal
      Calculates the total cost of the travel

   upDate
      Updates the total travel cost
*/

window.onload = initPage;


function initPage() {
   var dataFields = new Array();
   var allInputs = document.getElementsByTagName("input");

   for (var i=0; i < allInputs.length; i++) {
      if (allInputs[i].className == "expenseEntry") dataFields.push(allInputs[i]);
   }

   for (var i=0; i < dataFields.length; i++) {
      dataFields[i].onblur = update;
   }

   document.forms[0].onsubmit = validateForm;
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

function testPattern(field, regx) {
   if (regx.test(field.value)==false) {
      field.style.backgroundColor="yellow";
      field.style.color="red";
      return false;
   } else {
      field.style.backgroundColor="white";
      field.style.color="black";
      return true;
   }
}


function validateForm() {
   isValid = true;
   eform = document.forms[0];

   if (testLength(eform.lname)==false) isValid=false;
   if (testLength(eform.fname)==false) isValid=false;
   if (testLength(eform.address)==false) isValid=false;
   if (testLength(eform.summary)==false) isValid=false;

   if (testPattern(eform.account,/^ACT\d{6}$/)==false) isValid=false;
   if (testPattern(eform.department,/^DEPT\d{3}$/)==false) isValid=false;
   if (testPattern(eform.project,/^PROJ\d{5}$/)==false) isValid=false;
   if (testPattern(eform.ssn,/^\d{9}$|^\d{3}-\d{2}-\d{4}$/)==false) isValid=false;

   if (isValid == false) {
      alert("Please fill out all required fields in the proper format");
   }

   return isValid;
}

function calcRow(row) {
   eform = document.forms[0];

   travel = parseFloat(eform.elements["travel"+row].value);
   lodge = parseFloat(eform.elements["lodge"+row].value);
   meal = parseFloat(eform.elements["meal"+row].value);
   return travel+lodge+meal;
}

function calcTotal() {
   totalExp=0;
   for (i=1;i<=4;i++) {
      totalExp += calcRow(i);
   }
   return totalExp;
}

function update() {
   eform = document.forms[0];
   numRegExp = /^\d*(\.\d{0,2})?$/;

   if (numRegExp.test(this.value)) {
      this.value=parseFloat(this.value).toFixed(2);
      for (i=1; i<=4; i++) {
         eform.elements["sub"+i].value=calcRow(i).toFixed(2);
      }
      eform.elements["total"].value=calcTotal().toFixed(2);
   } else {
      alert("Invalid currency value");
      this.value="0.00";
      this.focus();
  }
}
