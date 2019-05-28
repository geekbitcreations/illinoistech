window.onload = init;

function init() {
	// when the web loads it will run the init() function

	// assign (but not execute) the function named increaseSize() to the button's onclick event
	document.getElementById("mybutton").onclick = increaseSize;
}
function increaseSize() {
	// declare variables
	var paragraphHandle;
	var fontSize;
	var node;

	// get a reference handle to the image element
	paragraphHandle = document.getElementById("mytext");
	
	// get the font size of the paragraph
	fontSize = paragraphHandle.style.fontSize;
	
	// get rid of the "px" in the string and convert the string to a number
	fontSize = parseInt(fontSize);
	
	// add 1 to the current left location of the image
	fontSize = fontSize + 1;
	
	// apply the new font size to the paragraph
	paragraphHandle.style.fontSize = fontSize + "px";	
}