/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Case Problem 3


   Author:   Susan Crawford
   Date:     3/1/2012

   Filename: orders.js


   Functions List:

  addOrder()
      Adds an order to the user's shopping cart using the entries in the
      completed order form.
*/


addEvent(window, "load", setupOrders, false);

function setupOrders() {
   document.getElementById("submitButton").onclick = addOrder;
}


function addOrder() {
   // Set the cookie expiration date to 48 hours hence.
   var expiryDate = new Date();
   expiryDate.setHours(expiryDate.getHours() + 48);

   // Loop through the cookies setting the value of itemCount to 1 more than
   // the higher cart item number.

   var itemCount = 1;
   if (document.cookie) {
      var cookies = document.cookie.split("; ");
      for (var i = 0 ; i < cookies.length; i++) {
         var cookieName = cookies[i].split("=")[0];
         if (cookieName.indexOf("cartItem") != -1) {
            var cartItemNumber = parseInt(cookieName.slice(8));
            if (cartItemNumber >= itemCount) itemCount = cartItemNumber + 1;
         }
      }
   }

   // newItem is a variable containing the name of the new
   // cart item cookie
   var newItem = "cartItem" + itemCount;
   setCookie(newItem, "", expiryDate);

   // Store the product name in the product field of the newItem cookie   
   setField(newItem, "product", document.forms[0].product.value, expiryDate);

   // Store the price in the price field of the new item cookie
   setField(newItem, "price", document.forms[0].price.value, expiryDate);

   
   // For all selection lists, record the text of the selected option and
   // store that text in the corresponding field in the newItem cookie
   var allSelects = document.getElementsByTagName("select");
   for (var i = 0; i < allSelects.length; i++) {
      var optionIndex = allSelects[i].selectedIndex;
      var optionText = allSelects[i].options[optionIndex].text;
      setField(newItem, allSelects[i].id, optionText, expiryDate);
   }

   // Display an alert message indicating that the cookie has been written
   alert(getField(newItem, "quantity") + " " + getField(newItem, "product") + " added to your shopping cart.");
}
