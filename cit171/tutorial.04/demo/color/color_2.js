// declare global variables
var time_id = -1;
var incrementAmount = 20;
var red = 0;
var green = 0;
var blue = 0;
var red_flag = false;
var green_flag = false;
var blue_flag = true;

window.onload = init;

function init() {
	// execute the function to change the color of the h1 tag
	reset_h1_color();
	
	// assign (but not execute) the function named go() to the button's onclick event
	document.getElementById("go").onclick = go;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [0].onclick = go;
	
	// assign (but not execute) the function named stop() to the button's onclick event
	document.getElementById("stop").onclick = stop;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [1].onclick = stop;
	
	// assign (but not execute) the function named reset() to the button's onclick event
	document.getElementById("reset").onclick = reset;
	// this next statement does the same thing
	//document.getElementsByTagName("input") [2].onclick = reset;
}
function go() {
	// 1000 ms = 1 second
	if (time_id == -1) {
		time_id = setInterval('change_color()', 1);
	}
}
function stop() {
	// stop the timer
	clearInterval(time_id);
	
	// reset the timer id value
	time_id = -1;
}
function reset() {
	// stop the timer
	stop();
	
	// reset the color of the h1 element to black
	reset_h1_color();
}
function change_color() {
	// because the increment amount will allow the color values to exceed the maximum value of 255,
	// cap the values at 255 before they are displayed on the Web page
	if (red > 255) {
		red = 255;
	}
	if (green > 255) {
		green = 255;
	}
	if (blue > 255) {
		blue = 255;
	}
	
	// change the color of the h1 element
	document.getElementById("heading").style.color = "rgb(" + red + "," + green + "," + blue + ")";
	// this next line of code would work too:
	//document.getElementsByTagName("h1") [0].style.color = "rgb(" + red + "," + green + "," + blue + ")";
	
	// display the rgb color value numbers on the Web page
	document.getElementById("color").firstChild.nodeValue = "rgb(" + red + "," + green + "," + blue + ")";
	// note that the next TWO lines of code will NOT work in Firefox, therefore we use the line above with
	//document.getElementsByTagName("span") [0].innerText = "rgb(" + red + "," + green + "," + blue + ")";
	//document.getElementById("color").innerText = "rgb(" + red + "," + green + "," + blue + ")";
	
	// change the rgb color value.
	// note that although we could have written this code using nested loops this code
	// was written this way so that the JavaScript timer would control execution of the color change
	if (blue_flag == true) {
		if (blue < 255) {
			blue = blue + incrementAmount;
		}
		else {
			blue = 0;
			blue_flag = false;
			green_flag = true;
		}
	}
	
	if (green_flag == true) {
		if (green < 255) {
			green = green + incrementAmount;
			green_flag = false;
			blue_flag = true;
		}
		else {
			green = 0;
			green_flag = false;
			red_flag = true;
		}
	}
	
	if (red_flag == true) {
		if (red < 255) {
			red = red + incrementAmount;
			red_flag = false;
			blue_flag = true;
		}
		else {
			stop();
		}
	}
}
function reset_h1_color() {
	// reset color values
	red = 0;
	green = 0;
	blue = 0;

	// reset the h1 heading color
	document.getElementById("heading").style.color = "rgb(" + red + "," + green + "," + blue + ")";

	// display the rgb color value numbers on the Web page
	document.getElementById("color").firstChild.nodeValue = "rgb(" + red + "," + green + "," + blue + ")";
}
