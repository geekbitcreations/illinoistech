/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Case Problem 3

   Author: Anna Lopez
   Date:   3/1/2012

   Filename: demo.js

   
   Functions:
   runDemo() 
      Runs the code that updates the appearance of the two
      sample boxes whenever a blur event occurs win any of
      10 input boxes on the Web form.

   loadSliders()
      Creates an instance of a slider object and attaches it
      to the Web form directly after the input boxes it is
      associated with.
	
*/

addEvent(window, "load", runDemo, false);

function runDemo() {

   var r1 = document.getElementById("red1");
   var r2 = document.getElementById("red2"); 
   var g1 = document.getElementById("green1");
   var g2 = document.getElementById("green2");
   var b1 = document.getElementById("blue1");
   var b2 = document.getElementById("blue2"); 
   var o1 = document.getElementById("opacity1");
   var o2 = document.getElementById("opacity2"); 
   var z1 = document.getElementById("zIndex1");
   var z2 = document.getElementById("zIndex2");
   var db1 = document.getElementById("box1");
   var db2 = document.getElementById("box2");

   var allInputs = document.getElementsByTagName("input");

   for (var i = 0; i < allInputs.length; i++) {
      allInputs[i].onblur = function() {     
         db1.style.backgroundColor = "rgb(" + r1.value + "," + g1.value + "," + b1.value + ")";
         setOpacity(db1, parseInt(o1.value)); 
         db1.style.zIndex = z1.value; 

         db2.style.backgroundColor = "rgb(" + r2.value + "," + g2.value + "," + b2.value + ")";
         setOpacity(db2, parseInt(o2.value)); 
         db2.style.zIndex = z2.value;      
      }
   }

   document.getElementById("resetB").onclick = function() {
      window.location.reload(true);
   }  
     
}


/*   Add new code below */


addEvent(window, "load", loadSliders, false);

function loadSliders() {

   var allSliderInputs = new Array(); // Array of input boxes associated with sliders 
 
   var allInputs = document.getElementsByTagName("input");

   for (var i = 0; i < allInputs.length; i++) {
      if (allInputs[i].className.indexOf("sliderInput") != -1) allSliderInputs.push(allInputs[i]);
   }

   for (var i = 0; i < allSliderInputs.length; i++) {

      /* Retrieve the slider parameters */
      var sliderParams = allSliderInputs[i].className.split(" ")[1];

      /* Leftmost slider value */
      var first = parseFloat(sliderParams.split(";")[0]);

      /* Rightmost slider value */
      var last = parseFloat(sliderParams.split(";")[1]);

      /* Increment of slider values */
      var inc = parseFloat(sliderParams.split(";")[2]);

      /* Style number associated with slider bar */
      var style = parseFloat(sliderParams.split(";")[3]);

      /* Instantiate my slider */
      var mySlider = new sliderBox(allSliderInputs[i], first, last, inc, style);

      /* Construct the host objects displaying mySlider */
      mySlider.constructDOM();

      /* Insert the mySlider widget after the input box */
      insertAfter(allSliderInputs[i], mySlider.divElem);


      /* Determine the size the mySlider widget */
      mySlider.getSizes();


      /* Setup event handlers for the mySlider widget */
      mySlider.setupEvents();

   }

}
      
     

