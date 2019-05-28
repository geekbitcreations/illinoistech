/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Case Problem 1

   Author: Rita Sato
   Date:   3/1/2012

   Filename: shop.js

   
   Functions
   startShopping()
      Reads the properties of the shopping items from the Web table
      and places them in custom objects. The function then allows users
      to move items from the shelf and their virtual cart.
	
*/

addEvent(window, "load", startShopping, false);

function startShopping() {

   var saltItems = document.getElementById("saltItems");
   var tBody = saltItems.tBodies[0];
   var tRows = tBody.rows;
   var viewCart = document.getElementById("viewCart");
 
   // Loop through the cells in the table, where each row represents a store item.
   for (var i = 0; i < tRows.length; i++) {

      var newItem = new storeItem();

      newItem.pid = tRows[i].cells[0].innerHTML;
      newItem.prod = tRows[i].cells[1].innerHTML;
      newItem.desc = tRows[i].cells[2].innerHTML;
      newItem.price = tRows[i].cells[3].innerHTML;

      var qtySelect = tRows[i].cells[4].firstChild;
      newItem.qty = qtySelect.options[qtySelect.selectedIndex].value;

      qtySelect.currentItem = newItem;
      qtySelect.onchange = function() {
         var storeItem = this.currentItem;
         storeItem.qty = this.options[this.selectedIndex].value;
      }

      var selCheckBox = tRows[i].cells[5].firstChild;
      selCheckBox.currentItem = newItem;

   }


   // Event handler to write selected items to a multi-valued cookie
   viewCart.onclick = function() {

      var allInputs = document.getElementsByTagName("input");
      var allCheckBoxes = new Array();
      for (var i = 0; i < allInputs.length; i++) {
         if (allInputs[i].type == "checkbox") allCheckBoxes.push(allInputs[i]);
      }

      var cartCount = 0;
      for (var i = 0; i < allCheckBoxes.length; i++) {
         var storeItem = allCheckBoxes[i].currentItem;
         if (allCheckBoxes[i].checked == true) {
            storeCookieField(storeItem.pid, "prod", storeItem.prod);
            storeCookieField(storeItem.pid, "desc", storeItem.desc);
            storeCookieField(storeItem.pid, "price", storeItem.price);
            storeCookieField(storeItem.pid, "qty", storeItem.qty);
            cartCount++;

         } else {
            removeCookie(storeItem.pid);
         }
      }

      // Alert the user that the cookie has been written and redirect them
      // to the checkout page.

      alert(cartCount + " items in your cart");
      location.href = "checkout.htm";
   }

}