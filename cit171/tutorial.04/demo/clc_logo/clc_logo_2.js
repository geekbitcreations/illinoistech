window.onload = init;

function init() {
	// assign (but not execute) the function named move_right to the button's onclick event
	document.getElementById("right").onclick = move_right;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [0].onclick = move_right;
	
	// assign (but not execute) the function named move_left to the button's onclick event
	document.getElementById("left").onclick = move_left;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [1].onclick = move_left;

	// assign (but not execute) the function named move_left to the button's onclick event
	document.getElementById("up").onclick = move_up;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [2].onclick = move_up;

	// assign (but not execute) the function named move_left to the button's onclick event
	document.getElementById("down").onclick = move_down;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [3].onclick = move_down;
	
	//set the image in back of all of the other page objects
	document.getElementById("clc_logo").style.zIndex = -1;	
}

function move_right() {
	// declare variables
	var image_handle;
	var image_left;
	var string_length;

	// get a reference to the image
	image_handle = document.getElementById("clc_logo");
	
	// get the current location of the image
	image_left = image_handle.style.left;
	
	// get rid of the "px" in the string and convert the string to a number
	image_left = parseInt(image_left);
		
	// add 50 to the current left location of the image
	image_left = image_left + 50;
	
	// move the image to the right
	image_handle.style.left = image_left + "px";
}

function move_left() {
	// declare variables
	var image_handle;
	var image_left;
	var string_length;

	// get a reference to the image
	image_handle = document.getElementById("clc_logo");
	
	// get the current location of the image
	image_left = image_handle.style.left;
	
	// get rid of the "px" in the string and convert the string to a number
	image_left = parseInt(image_left);
		
	// add 50 to the current left location of the image
	image_left = image_left - 50;
	
	// move the image to the left
	image_handle.style.left = image_left + "px";
}

function move_down() {
	// declare variables
	var image_handle;
	var image_top;
	var string_length;

	// get a reference to the image
	image_handle = document.getElementById("clc_logo");
	
	// get the current location of the image
	image_top = image_handle.style.top;
	
	// get rid of the "px" in the string and convert the string to a number
	image_top = parseInt(image_top);
		
	// add 50 to the current top location of the image
	image_top = image_top + 50;
	
	// move the image down
	image_handle.style.top = image_top + "px";
}

function move_up() {
	// declare variables
	var image_handle;
	var image_top;
	var string_length;

	// get a reference to the image
	image_handle = document.getElementById("clc_logo");
	
	// get the current location of the image
	image_top = image_handle.style.top;
	
	// get rid of the "px" in the string and convert the string to a number
	image_top = parseInt(image_top);
		
	// add 50 to the current top location of the image
	image_top = image_top - 50;
	
	// move the image up
	image_handle.style.top = image_top + "px";
}
