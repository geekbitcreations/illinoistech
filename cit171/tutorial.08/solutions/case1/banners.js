/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 8
   Case Problem 1

   Author:  Helen Ungerstatz
   Date:    3/1/2011

   Filename: banners.js


   Global Variables
   nextAd
      Used to track the next ad to be displayed in the banner box


   Functions
  
   addEvent(object, evName, fnName, cap)
      Run the function fnName when the event evName occurs in object.

   makeBannerAds()
      Create the banner box and stacked collection of banner ads

   changeBannerAd()
      Change the ad displayed in the banner box by changing the stacking
      order of the ads

   moveNextAd(top)
      Move the nextAd object down top pixels from its current location.

*/


function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}




/* Add new code below */

var nextAd;

addEvent(window, "load", makeBannerAds, false);


function makeBannerAds() {

   // Make the banner box
   bannerBox = document.createElement("div");
   bannerBox.id = "bannerBox";

   // Make a box for each banner ad
   for (var i=0; i < adURLs.length; i++) {
      var bannerAd = document.createElement("div");
      bannerAd.className = "bannerAd";
      bannerAd.style.zIndex = i;

      var aLink = document.createElement("a");
      aLink.href = adURLs[i];

      var adImage = document.createElement("img");
      adImage.src = "banner" + i + ".jpg";

      aLink.appendChild(adImage);
      bannerAd.appendChild(aLink);
      bannerBox.appendChild(bannerAd);
      
   }

   document.body.appendChild(bannerBox);

   setInterval("changeBannerAd()", 10000);

}

function changeBannerAd() {
   var allAds = document.getElementById("bannerBox").childNodes;


   // Locate the next banner ad to display and move out of the box
   for (var i = 0; i < allAds.length; i++) {
      if (allAds[i].style.zIndex == 0) {
         allAds[i].style.top = "-50px";
         nextAd = allAds[i];
      }
   }


   // Reorder the banner ad stack
   for (var i = 0; i < allAds.length; i++) {
      allAds[i].style.zIndex--;
      if (allAds[i].style.zIndex < 0) allAds[i].style.zIndex = allAds.length - 1;
   }



   // Move the next ad into position
   var timeDelay = 0;
   for (var i = -50; i <= 0; i++) {
      setTimeout("moveNextAd(" + i + ")", timeDelay);
      timeDelay += 15;
   }


}

function moveNextAd(top) {

   nextAd.style.top = top + "px";

}
