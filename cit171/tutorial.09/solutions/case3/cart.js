/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Case Problem 3


   Author:   Susan Crawford
   Date:     3/1/2012

   Filename: cart.js


   Functions List:

   retrieveOrder()
      Retrieves the multi-valued cookies with names starting
      with cartItem[n] where [n] is an integer that indicates
      the number of the cart item and displays the subkey
      values in a table on the page.

*/

addEvent(window, "load", retrieveOrders, false);


function retrieveOrders() {

   if (document.cookie) {
      var itemsInCart = new Array();
      var cookies = document.cookie.split("; ");

      // Create the itemsInCart array listing the names of the cart items
      for (var i = 0; i < cookies.length; i++) {
         if (cookies[i].split("=")[0].indexOf("cartItem") != -1) {
            itemsInCart.push(cookies[i].split("=")[0]);
         }
      }

      if (itemsInCart.length > 0) {
         // Create the shopping cart table
         cartTable = document.createElement("table");
         cartTable.id = "cartTable";
         shoppingCart = document.getElementById("cartStatus");
         shoppingCart.replaceChild(cartTable, shoppingCart.firstChild);

         // Create the thead element
         var thead = document.createElement("thead");
         cartTable.appendChild(thead);

         // Create the heading row
         var headRow = document.createElement("tr");
         var productHead = document.createElement("th");
         productHead.innerHTML = "Product";
         var descriptionHead = document.createElement("th");
         descriptionHead.innerHTML = "Description";
         var quantityHead = document.createElement("th");
         quantityHead.innerHTML = "Qty";
         var priceHead = document.createElement("th");
         priceHead.innerHTML = "Price";
         var alterHead = document.createElement("th");
         alterHead.innerHTML = "Change";
        
         headRow.appendChild(productHead);
         headRow.appendChild(descriptionHead);
         headRow.appendChild(quantityHead);
         headRow.appendChild(priceHead);
         headRow.appendChild(alterHead);

         thead.appendChild(headRow);

         // Create the tbody element
         var tbody = document.createElement("tbody");
         cartTable.appendChild(tbody);

         // Add a table row for each shopping cart item
         for (var i = 0; i < itemsInCart.length; i++) {
            var newRow = document.createElement("tr");

            // Insert the product name cell
            var productCell = document.createElement("td");
            productCell.style.backgroundColor = "rgb(255, 255, 191)";
            productCell.innerHTML = getField(itemsInCart[i], "product");
            newRow.appendChild(productCell);

            // Insert the product description cell
            var productDescription = "";
            if (getField(itemsInCart[i], "gender") != null) 
               productDescription += getField(itemsInCart[i], "gender") + " ";
            if (getField(itemsInCart[i], "size") != null) 
               productDescription += getField(itemsInCart[i], "size") + " ";
            if (getField(itemsInCart[i], "color") != null) 
               productDescription += getField(itemsInCart[i], "color") + " ";
            var descriptionCell = document.createElement("td");
            descriptionCell.innerHTML = productDescription;
            newRow.appendChild(descriptionCell);

            // Insert the quantity ordered cell
            var quantityCell = document.createElement("td");
            quantityCell.style.textAlign = "right";
            quantityCell.innerHTML = getField(itemsInCart[i], "quantity");
            newRow.appendChild(quantityCell);

            // Insert the item price cell
            var priceCell = document.createElement("td");
            priceCell.style.textAlign = "right";
            priceCell.innerHTML = getField(itemsInCart[i], "price");
            newRow.appendChild(priceCell);

            // Insert the cell containing the Remove Item button
            var alterCell = document.createElement("td");
            var changeButton = document.createElement("input");
            changeButton.type = "button";
            changeButton.id = itemsInCart[i];
            changeButton.className = "deleteItem";
            changeButton.value = "Remove Item";

            changeButton.onclick = function() {
               // Delete the cookie with the name matching the button id
               delCookie(this.id);
               window.location.reload();
            }

            alterCell.appendChild(changeButton);
            newRow.appendChild(alterCell);

            tbody.appendChild(newRow);
         }
      }
   }
}