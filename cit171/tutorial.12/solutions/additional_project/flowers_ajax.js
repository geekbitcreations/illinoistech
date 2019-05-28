/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 12 Additional Project Solution

   Carol's Flower Shop
   Author: John Q. Student
   Date:   

   Variable list:
*/


// XMLHttpRequest Constructor
if (typeof XMLHttpRequest == "undefined") {
      XMLHttpRequest = function() {
               // Array of MSXML PIDs
              var pids = ["Msxml2.XMLHTTP.6.0",
                                "Msxml2.XMLHTTP.3.0",
                                "Msxml2.XMLHTTP",
                                 "Microsoft.XMLHTTP"];
              // Test each PID
            for (var i = 0; i < pids.length; i++) {
                 try {
                            return new ActiveXObject(pids[i]);
                } catch (e) {}
            }
          // Halt if unable to create request object
          throw new Error("Unable to create request object");
      }
 }

addEvent(window, "load", getCarolQuote, false);


function getCarolQuote() {
       var main = document.getElementById("carolquote");
       // Request object for the CarolQuote.txt file
       var reqCom = new XMLHttpRequest();
       reqCom.open("GET", "carol_quote.txt");
       reqCom.send(null);

       reqCom.onreadystatechange = function() {
           if (this.readyState == 4) {
               if (this.status == 200) {
                   main.innerHTML = this.responseText;
              }
           }
       }


}

addEvent(window, "load", getFloralNews, false);

function getFloralNews() {
   var news = document.getElementById("floralNews");
   // Request object for the headlines feed
   var reqHead = new XMLHttpRequest();
   reqHead.open("GET", "flower_update.xml");
   reqHead.setRequestHeader("Cache-Control", "no-cache");
   reqHead.send(null);
   reqHead.onreadystatechange = function() {
      if (this.readyState == 4) {
         if (this.status == 200) {
           // Retrieve the headlines feed
           var newsDoc = this.responseXML;
           var rssDoc = new RSSFeed(newsDoc);
           rssDoc.parseToHTML(news);
         }
      }
   }
}




/* Constructor function for RSS news feeds */
function RSSFeed(xmlDoc) {
    // Retrieve the news feed title, link, and description
    var channel = xmlDoc.getElementsByTagName("channel")[0];
    var title = channel.getElementsByTagName("title")[0];
    var link = channel.getElementsByTagName("link")[0];
    var description =
    channel.getElementsByTagName("description")[0];
    this.title = title.firstChild.nodeValue;
    this.link = title.firstChild.nodeValue;
    this.description = title.firstChild.nodeValue;

   /* Constructor function for an RSS news item */
   function RSSItem(item) {
      var title = item.getElementsByTagName("title")[0];
      var link = item.getElementsByTagName("link")[0];
      var description = item.getElementsByTagName("description")[0];
      this.title = title.firstChild.nodeValue;
      this.link = link.firstChild.nodeValue;
      this.description = description.firstChild.nodeValue;
    }

    // Create an array of news feed items
    this.items = new Array();
    var feedItems = channel.getElementsByTagName("item");
     for (var i = 0; i < feedItems.length; i++) {
          var feedItem = new RSSItem(feedItems[i]);
          this.items.push(feedItem);
     }

    /* Method to write the RSSFeed document to an HTML fragment */
    RSSFeed.prototype.parseToHTML = function(outputNode) {
        var fTitle = document.createElement("h2");
        fTitle.innerHTML = this.title;
        outputNode.appendChild(fTitle);

        for (var i = 0; i < this.items.length; i++) {
	var iTitle = document.createElement("h3");
	var iTitleLink = document.createElement("a");
	iTitleLink.innerHTML = this.items[i].title;
	iTitleLink.href = this.items[i].link;
	iTitle.appendChild(iTitleLink);
	outputNode.appendChild(iTitle);
	var iPara = document.createElement("p");
	iPara.innerHTML = this.items[i].description;
	outputNode.appendChild(iPara);
         }
     }



} // end of function

