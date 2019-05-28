/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 9
   Review Assignment

   Author:   Kevin Geary
   Date:     3/1/2012

   Filename: rides.js


   Global Variables List:

   genderGroup
      Array of gender values
   ageGroup
      Array of age categories
   bikeGroup
      Array of bike types
   routeGroup
      Array of route types
   sagGroup
      Array of sag values
   accommodationGroup
      Array of accommodation values
   regionGroup
      Array of regions
   milesGroup
      Array of mileage categories


   Functions List:

   retrieveProfile()
      Retrieves profile information from the fields within the profile
      cookie

*/



var genderGroup = new Array("Male", "Female");
var ageGroup = new Array("", "16 - 20", "21 - 30", "31 - 40",
                         "41 - 50", "51 - 60", "61 - 70", "71+");
var bikeGroup = new Array("Road Bike", "Mountain Bike", "Either");
var routeGroup = new Array("Road", "Trail", "Either");
var sagGroup = new Array("Yes", "No");
var accommodationGroup = new Array("Camping", "Motel", "Either");
var regionGroup = new Array("", "Northeast", "East Coast", "Southeast",
                            "Midwest", "Mountain", "Southwest", 
                            "West Coast", "Northwest");
var milesGroup = new Array("", "21 - 40", "41 - 60", "61 - 80",
                          "81 - 100", "100+");

addEvent(window, "load", retrieveProfile, false);

function retrieveProfile() {

   if (getCookie("profile")) {

      document.getElementById("firstName").innerHTML = getCookieField("profile", "firstName");
      document.getElementById("lastName").innerHTML = getCookieField("profile", "lastName");
      document.getElementById("gender").innerHTML = genderGroup[getCookieField("profile", "gender")];
      document.getElementById("age").innerHTML = ageGroup[getCookieField("profile", "age")];
      document.getElementById("bike").innerHTML = bikeGroup[getCookieField("profile", "bike")];
      document.getElementById("route").innerHTML = routeGroup[getCookieField("profile", "route")];
      document.getElementById("sag").innerHTML = sagGroup[getCookieField("profile", "sag")];
      document.getElementById("accommodation").innerHTML = accommodationGroup[getCookieField("profile", "accommodation")];
      document.getElementById("region").innerHTML = regionGroup[getCookieField("profile", "region")];
      document.getElementById("miles").innerHTML = milesGroup[getCookieField("profile", "miles")];  
      document.getElementById("comments").innerHTML = getCookieField("profile", "comments");

   } else {

      // Display text for people with no profiles
      var nonMember = "No rider profile on record with CycloCrossings. ";
      nonMember += "Submit a <a href='profile.htm'>profile</a> ";
      nonMember += "today to meet other riders in your area who ";
      nonMember += "share your passion for touring.";

      document.getElementById("intro").innerHTML = nonMember;
      document.getElementById("profileTable").style.visibility = "hidden";
   } 

}









