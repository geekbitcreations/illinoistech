/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 5 Additional Project Solution

   Cakes by Emily
   Author: John Q. Student
   Date:   

   Variable list:

   FormName  
      Name of the form
   CheckName  
      Name of the checkboxes (without 1,2,3...10,11,12...)
   TextName  
      Name of the textfields (without 1,2,3...10,11,12...)d

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
FormName  = "myform"  //Name of the form
CheckName = "check" //Name of the checkboxes (without 1,2,3...10,11,12...)
TextName  = "text"  //Name of the textfields (without 1,2,3...10,11,12...)
window.onload = startForm;

function startForm() {
   document.forms[0].onsubmit = validData;
}


function docheck(strW) {
  var w = parseInt(strW);
  var elemID = "text" + w;
  var element = document.getElementById(elemID);
  var checkID;
  var checkbx;

  if ((w == 0) || (w == 1))
     {
          // this checks the First and Last name fields
          // make sure the field has a value
          if (element.value != "")
             {
                checkID = "check" + w;
                checkbx = document.getElementById(checkID);
                checkbx.checked = true;
             }
          else
             alert("Please enter a First Name");
     }
  else if (w == 2)
     {
          // this checks e-mail addresses using regular expression
          emailRegx = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
          if (emailRegx.test(element.value)) 
             {
                checkID = "check" + w;
                checkbx = document.getElementById(checkID);
                checkbx.checked = true;
             }
          else
            alert("Please enter a valid email address.");            

     }
  else if (w == 3)
     {
          // this checks that birthdate is in date format
          birthdayRegx = /^([0-1]?[0-9])\/([1-2]?[0-9])\/([1-9][0-9]{3})$/;
          if (birthdayRegx.test(element.value)) 
             {
                checkID = "check" + w;
                checkbx = document.getElementById(checkID);
                checkbx.checked = true;
             }
          else
            alert("Please enter a valid date.");    
     }
}
function validData() {
   var boxes = new Array();
   var allElems = document.getElementsByTagName("*");
   var checkClass = /^[c][h][e][c][k][0-3]$/;
   var isvalid = true;

   for (var i = 0; i < allElems.length; i++) {
      if (checkClass.test(allElems[i].className))
       {
         boxes.push(allElems[i]);
       }
   }
   
   for (var i = 0; i < boxes.length; i++) {
      if (!boxes[i].checked) isvalid = false;
   }
   
   if (isvalid) 
     alert("You will be added to our list.");
   else
      alert("Please fill in form with valid data.");
   

   return valid;  
}

