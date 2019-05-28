// this demonstrates how to attach  events to objects using external javascript file

window.onload = init;

function init() {
	// assign (but not execute) the function named getElementsByNameExample1()
	// to the button's onclick event
	document.getElementById("myButton").onclick = getElementByID4;
}
function getElementByID4() {
	// use the getElementByID method to change the text content of an element.
	// note that this function is attached to the button's click event in an external javascript file.
	document.getElementById("paragraph4").innerHTML = "This NEW text for &lt;p&gt; element #4 and event was handled in an external JavaScript file.";
}
