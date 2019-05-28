function displayMonth() {
   // declare an array with ? elements
   //var Month = new Array(3);

   // assign values to the array elements
   //Month[0] = "January";
   //Month[1] = "February";
   //Month[2] = "March";
   //Month[3] = "April";

   var Month = new Array("January", "February", "March",  "April");

   // display a month
   // document.write(Month[3]);

   // display all elements in the array using the for statement
   // for (elementNum = 0; elementNum <= 3; elementNum ++) {
   //    document.write(Month[elementNum] + " / " + elementNum //+ "<br>");
   //}

   // display all elements in the array using the while loop
 
   var elementNum2 = 0;
   while (elementNum2 <= 3) {
        document.write(Month[elementNum2] + " / " + elementNum2 + "<br>"); 
        elementNum2++;     
   }
}
