/*
    New Perspectives on JavaScript 2nd Edition
   Tutorial 11 Additional Project Solution

   Favorite CDs
   Author: John Q. Student
   Date:   

   Variable list:
 */




window.onload = init;

function init() {

   var favTable; 
   var myCDs = new CDlist();

   var cdbutton = document.getElementById("btnCD");

   favTable = document.getElementById("myFavTable"); 
   cdbutton.onclick = addList;
   
 
  function addList() {
   
       var newTR = document.createElement("tr");
       var getTitle = document.getElementById("title");
       var getArtist = document.getElementById("artist");
        var getGenre = document.getElementById("genre");
        var getProducer = document.getElementById("producer"); 
        var getYear = document.getElementById("year");

       // add CD to list
        myCDs.addCD(getTitle.value, getArtist.value, getGenre.value, getProducer.value, getYear.value);
       
       var cdToAdd = myCDs.CDs[myCDs.current];

        var newTD = document.createElement("td");
        newTD.innerHTML =cdToAdd.CDid;
        newTR.appendChild(newTD);


        newTD = document.createElement("td");
        newTD.innerHTML = cdToAdd.title;
        newTR.appendChild(newTD);
        getTitle.value = "";

        newTD = document.createElement("td");
        newTD.innerHTML = cdToAdd.artist;
        newTR.appendChild(newTD);

 
        newTD = document.createElement("td");
        newTD.innerHTML = cdToAdd.genre;
        newTR.appendChild(newTD);


        newTD = document.createElement("td");
        newTD.innerHTML = cdToAdd.producer;
        newTR.appendChild(newTD);


        newTD = document.createElement("td");
        newTD.innerHTML = cdToAdd.yearsOwned() + " years";
        newTR.appendChild(newTD);
  
       
        getTitle.value = "";
        getArtist.value = "";
        getGenre.value = "";
        getProducer.value = "";
        getYear.value="";

       favTable.appendChild(newTR);

  
   } // end of addlist
 }  //end of init