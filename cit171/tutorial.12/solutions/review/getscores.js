/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 12   Review Assignment

   Author:   Steve Lavent
   Date:     3/1/2012

   Filename: getscores.js



   Functions List:

   updateScores()
      Retrieves the scores from a JSON file and places the scores
      in a series of Web tables

   getStories()
      Retrieves the RSS feed stored in the results.xml file,
      displaying it in the main section of the document

*/

addEvent(window, "load", updateScores, false);

function updateScores() {
   var scoresDIV = document.getElementById("scoresDIV");

   // Request object for the scores JSON file
   var reqScores = new XMLHttpRequest();
   reqScores.open("GET", "scores.txt");
   reqScores.setRequestHeader("Cache-Control", "no-cache");
   reqScores.send(null);

   reqScores.onreadystatechange = function() {
      // Process the data when the response is
      // completed without error
      if (this.readyState == 4) {
         if (this.status == 200) {
            // Retrieve the daily commentary and
            // display it within the main section
            var json = eval("(" + this.responseText +")");

            var scoreTitle = document.createElement("h2")
            scoreTitle.innerHTML = json.sport;
            scoresDIV.appendChild(scoreTitle);

            for (var i = 0; i < json.scores.length; i++) {
               var newTable = document.createElement("table");
               var newTBody = document.createElement("tbody");
               var row1 = document.createElement("tr");
               var cell11 = document.createElement("td");
               var cell12 = document.createElement("td");
               var cell13 = document.createElement("td");
               cell11.innerHTML = json.scores[i].team1;
               cell12.innerHTML = json.scores[i].score1;
               cell12.className = "num";
               cell13.innerHTML = json.scores[i].time;
               row1.appendChild(cell11);
               row1.appendChild(cell12);
               row1.appendChild(cell13);
               var row2 = document.createElement("tr");
               var cell21 = document.createElement("td");
               var cell22 = document.createElement("td");
               cell21.innerHTML = json.scores[i].team2;
               cell22.innerHTML = json.scores[i].score2;
               cell22.className = "num";
               row2.appendChild(cell21);
               row2.appendChild(cell22);
               newTBody.appendChild(row1);
               newTBody.appendChild(row2);
               newTable.appendChild(newTBody);

               scoresDIV.appendChild(newTable);
           }                   
         }
      }
   }

}

addEvent(window, "load", getStories, false);

function getStories() {
   var main = document.getElementById("main");

   // Request object for the NFL game feed
   var reqStories = new XMLHttpRequest();
   reqStories.open("GET", "results.xml");
   reqStories.setRequestHeader("Cache-Control", "no-cache");
   reqStories.send(null);

   reqStories.onreadystatechange = function() {
      if (this.readyState == 4) {
         if (this.status == 200) {
            // Retrieve the headlines feed
            var newsDoc = this.responseXML;
            var rssDoc = new RSSFeed(newsDoc);
            rssDoc.exportToHTML(main);
         }
      }
   }
}
