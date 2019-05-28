/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 6 Additional Project Solution

   Guessing Game
   Author: John Q. Student
   Date:   

   Variable list:
	holdWords //variable to hold the word
	wordsLength //the words length
	correct //correct letters found
	tries  //number of tries
        letters// will hold the letters of the game
        letter   // holds letter currently being validated
        keybrd // keeps track of if a key was pressed or not

   Function list: 

   init()
      Initializes the guessing game
   addEvent()
      attaches an event
   removeEvent()
      removes an event
   randomWords()
      generates a random word for the game
   catchKeyStrokes
      lets user use keyboard
   callMe
      checks if user chose a correct letter
   newGame
      starts a new game

*/
	var holdWords; //variable to hold the word
	var wordsLength; //the words length
	var correct = 0; //correct letters found
	var tries = 0; //number of tries
        var letters= new Array(); // will hold the letters of the game
        var letter = "";  // holds letter currently being validated
        var keybrd = new Array (0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        window.onload = init;

/* this function initializes the guessing game */
function init(){
	var allElem = document.getElementsByTagName("*");
	
 	for (var i = 0; i < allElem.length; i++) {
		if (allElem[i].className == "letter") letters.push(allElem[i]);
        }

        for (var i = 0; i < letters.length; i++) {

            addEvent(letters[i], "click", callMe, false);

        }

	holdWords = randomWords(); // generate a random word
	wordsLength = holdWords.length; 
 
	correct = 0; 
	tries = 0; 
        document.form1.trd.value = tries; //set textbox value to the tries
        document.onkeydown = catchKeyStrokes
        
}

/* this function attachs the event handler under both event models */
function addEvent(object, evName, fnName, cap) {
	if (object.attachEvent)
		object.attachEvent("on" + evName, fnName);
	else if (object.addEventListener)
		object.addEventListener(evName, fnName, cap);
}
/* This function returns a random word each time the game reloads */

function randomWords()
{
	w = new Array(17); //an array of 17 words
	w[0]="apple";
	w[1]="books";
	w[2]="clock";
	w[3]="block";
	w[4]="light";
	w[5]="crate";
	w[6]="sneak";
	w[7]="bleat";
	w[8]="brake";
	w[9]="truck";
	w[10]="racer";
	w[11]="eaten";
	w[12]="ruled";
	w[13]="green";
	w[14]="beans";
	w[15]="snare";
	w[16]="briar";


	var rand = Math.floor(Math.random() * 17); /* generates a random integer */
	var word = w[rand];	    /* here is the word */
	return word;				    /* return the word to the caller */

}


//the main function of the game - for mouse clicks
function callMe()
{
        if (letter == "") 
        {
              // this was a mouse click so get mouse info
              // otherwise letter will contain the id already
	        var evt = e || window.event;
        	var eventSource = e.target || event.srcElement
	        letter = eventSource.id;
        }
	tries++; //update tries
	document.form1.trd.value = tries; //set values to the tries textbox

	// a for loop to check the letter
	for(counter = 0; counter < wordsLength; counter++)
	{
	if(holdWords.charAt(counter) == letter) //if the letter matches
	{

		//then show the right letter's image
		document.images["blank"+ counter].src = document.images[letter].src;
		correct++; //update correct
		--tries; //update tries
		document.form1.trd.value = tries; //set values to the tries textbox

		if(correct == wordsLength) //if the whole word discovered
		{
		alert("Congratulations! You have successfully"
		+ " discovered the word " + holdWords.toUpperCase() + ".")
		}

	}
	}

	if(tries == 5) //losing condition
	{
		alert("Sorry, your chances over. The word was "
		+ holdWords.toUpperCase() + ".")
	}

       // find object that has the right id and detach the event 
       // so user can't try that letter again
       for(var i = 0; i < letters.length; i++) {
         
          if (letters[i].id == letter) {
             removeEvent(letters[i], "click", callMe, false);
          }
       }

       // set it so that keyboard option for the letter is disabled too
       keybrd[letter.charCodeAt(0) - 65] = 1;
       letter = ""; // so that user has option to click with mouse or use keyboard

}

function removeEvent(object, evName, fnName, cap) {
	if (object.detachEvent) object.detachEvent("on" + evName, fnName);
	else if (object.removeEventListener)
		object.removeEventListener(evName, fnName, cap);

}
/*
**function that enables the user
**to play from the keyboard
*/
function catchKeyStrokes()
{
	var alpha = "abcdefghijklmnopqrstuvwxyz";
        
        //pressing the RETURN key
	//will start a new game
	if(event.keyCode == 13)	{
            newGame();
	}
        else { 
	  //catch key strokes no matter the
  	  //CAPS LOCK is ON or OFF
          if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
                code = event.keyCode - 32 - 65;
                if (keybrd[code] == 0) {
                  letter = alpha.charAt(code);
                  callMe();
                  keybrd[code] = 1;
                }
          }
          if ((event.keyCode >= 65) && (event.keyCode <= 90)) {
               code = event.keyCode - 65;
               if (keybrd[code] == 0) {
                  letter = alpha.charAt(code);
                  callMe();
                  keybrd[code] = 1;
               }
          } 
        } // end of else



}


//function for playing a new game
function newGame()
{
	holdWords = randomWords(); // generate a random word
        // reset the wordsLength, correct, and tries variables
	wordsLength = holdWords.length; 
	correct = 0; 
	tries = 0; 
        letter="";

        // detach all events
        for (var i = 0; i < letters.length; i++) {

            removeEvent(letters[i], "click", callMe, false);

        }

        // attach all events
        for (var i = 0; i < letters.length; i++) {

            addEvent(letters[i], "click", callMe, false);

        }
        // reset the blank images
        for (var i = 0; i < wordsLength; i++) {
            document.images["blank" + i].src = "blank.jpg";
        }
        // reset the keybrd array
        for (var i = 0; i < keybrd.length; i ++ ) {
            keybrd[i] = 0;
        }	
 
        document.form1.trd.value = tries; //set textbox value to the tries


}