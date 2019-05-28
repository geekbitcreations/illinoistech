/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 11
   Review Assignment

   Author: Bob Voiklund
   Date:   3/1/2012

   Filename: pickem.js

   
   Functions and Nested Functions

   playPickemPoker()
      Initializes and plays the video poker game

   disableButton(button)
      Disables and fades-out the form button

   enableButton(button)
      Enables and fades-in the form button

   deleteChildren(object)
      Deletes all of the child nodes within object

   evaluateHand()
      Evaluates the current poker hand, updates
      the pot value, and resets part of the poker table.
	
*/

addEvent(window, "load", playPickemPoker, false);

function playPickemPoker() {

   var pokerTable = document.getElementById("pokerTable");
   var dealButton = document.getElementById("dealB");
   var resetButton = document.getElementById("resetB");
   var handValueText = document.getElementById("handValue");
   var betSelection = document.getElementById("bet");
   var potValue = document.getElementById("pot");
   var set1 = document.getElementById("set1");
   var set2 = document.getElementById("set2");
   var player = document.getElementById("player");

   // Change the bet value from the selection list
   betSelection.onchange = function() {
      pickemGame.bet = parseInt(this.options[this.selectedIndex].value);
   }

   // Reload the Web page when the Reset button is clicked
   resetButton.onclick = function() {
      window.location.reload(true);
   }  

   // Function to disable and gray out a form button
   function disableButton(button) {
      button.disabled = true;
      setOpacity(button, 25);
   }

   // Function to enable and display a form button
   function enableButton(button) {
      button.disabled = false;
      setOpacity(button, 100);
   }

   // Function to delete all of the child nodes of an object
   function deleteChildren(object) {
      while (object.hasChildNodes()) {
         object.removeChild(object.lastChild);
      }
   }

   // Function to evaluate the player's hand and update the pot
   // and reset parts of the table.

   function evaluateHand() {

      handValueText.innerHTML = myHand.handValue();

      // Change the pot value based on the results of the hand
      var payoutValue = myHand.handOdds();
      pickemGame.payout(payoutValue);
      potValue.value = pickemGame.account;

      // Quit the game if the pot is empty
      if (pickemGame.account == 0) {
         alert("Game Over");
         disableButton(dealButton);
      } else {
         enableButton(dealButton);
         betSelection.disabled = false;
         myHand = new pokerHand(2);
         set1.onclick = null;
         set2.onclick = null;
      }
   
   }


   /* Add new code below   */

   // Set the initial values for the pot and player's bet
   pickemGame.account = 500;
   pickemGame.bet = 25;
   
   // Display the initial pot value in the game table
   potValue.value = pickemGame.account;

   // Create a new deck of cards and shuffle it
   var myDeck = new pokerDeck();
   myDeck.cards.randomize();

   // Define a poker hand for the game
   var myHand = new pokerHand(2);
   var mySet1 = new pokerHand(3);
   var mySet2 = new pokerHand(3);


   // Function to show the card images associated with each hand
   // in the appropriate containers
   function showCards(handObject, cardHolder) {

      for (var i = 0; i < handObject.cards.length; i++) {
         var cardImage = document.createElement("img");
         cardImage.className = "pokerCard";         
         if (handObject.cards[i].faceDown) cardImage.src = "cardback.png"
         else cardImage.src = handObject.cards[i].imageSrc();

         var suit = handObject.cards[i].suit;
         var rank = handObject.cards[i].rank;
         cardImage.card = new pokerCard(rank, suit);

         cardHolder.appendChild(cardImage);
      }
   }

   // Actions when the Deal button is clicked
   dealButton.onclick = function() {

      if (pickemGame.bet <= pickemGame.account) {

         // Enable or disable other buttons
         disableButton(dealButton);
         betSelection.disabled = true;
         handValueText.innerHTML = "";
         deleteChildren(player);
         deleteChildren(set1);
         deleteChildren(set2);

         // Subtract the bet from the pot
         pickemGame.placeBet();
         potValue.value = pickemGame.account;

         // Get a new deck if there are less than 8 cards in the current deck
         if (myDeck.cards.length < 8) {
            myDeck = new pokerDeck();
            myDeck.cards.randomize();
         }

         // Deal the cards from my deck to set1, set2, and myHand
         myDeck.dealTo(myHand);
         myDeck.dealTo(mySet1);
         myDeck.dealTo(mySet2);

         myHand.cards[0].faceDown = false;
         myHand.cards[1].faceDown = false;
         mySet1.cards[0].faceDown = false;
         mySet2.cards[0].faceDown = false;

         showCards(myHand, player);
         showCards(mySet1, set1);
         showCards(mySet2, set2);

         set1.onclick = moveCards;
         set2.onclick = moveCards;

  


      } else {
         
         alert("Reduce the size of your bet");

      }

      function moveCards() {

         var cardHolder = this;
         while (cardHolder.hasChildNodes()) {
            var firstImage = cardHolder.firstChild;
            var movedCard = firstImage.card;
            movedCard.faceDown = false;
            firstImage.src = movedCard.imageSrc();
            myHand.addToHand(movedCard);
            player.appendChild(firstImage);
      
         }

         evaluateHand(); 
        
      }   

   }


}

