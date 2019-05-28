/*
   New Perspectives on JavaScript 2nd Edition
   Tutorial 11 Additional Project Solution

   Favorite CDs
   Author: John Q. Student
   Date:   

   Variable list:
 */


function CD(CDid, title, artist, genre, producer, year) {
   this.CDid = CDid;
   this.title = title;
   this.artist = artist;
   this.genre = genre;
   this.producer = producer;
   this.year = year;

   this.yearsOwned = function () {

       var Today = new Date();
       var currYear = Today.getFullYear();
       var owned = currYear - this.year;
       return owned;
   }
}
function CDlist() {
    this.nextID = 1;
    this.current = 0;
    this.CDs = new Array();
    this.addCD = function (title, artist, genre, producer, year) {
          this.CDs[this.nextID] = new CD (this.nextID, title, artist, genre, producer, year);
          this.current = this.nextID;
          this.nextID = this.nextID + 1;
   }
}