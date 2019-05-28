/*
   New Perspectives on JavaScript, 2nd Edition
   Tutorial 7
   Case Problem 2

   Author: David Forrest
   Date:   3/1/2011

   Filename: filter.js

   Global Variables:
   filterTable
      References the the table containing the filter data

   filterCols
      References the col elements within the filter table

   filterHead
      References the head section of the filter table

   filterBody
      References the body section of the filter table


   Function List:
   addEvent(object, evName, fnName, cap)
      Adds an event hander to object where evName is the name of the event,
      fnName is the function assigned to the event, and cap indicates whether
      event handler occurs during the capture phase (true) or bubbling
      phase (false)

   isUnique(matchValue, arrList)
      Returns a value true if matchValue is found in the array, arrList, otherwise
      it returns the value, false.

   init()
      Initiates the filter table, generating the selectin lists, and creating event 
      handlers for each select element and counting the number of records in the 
      data table

   countRecords()
      Counts the number of visible rows in the data table

   addTotalsRow()
      Adds a new row to the top of the header section displaying the total
      number of records in the table

   createSelectionList(colIndex)
      Creates a selection list populated with option text matching the
      unique values in the table column indicated by colIndex

   addUniqueOptions(selectionList, colIndex)
      Adds option elements to the selectionList with the text of each 
      option reflecting a unique value from the data column. The index
      parameter specifies the index of the column from which the 
      option values are drawn.

   resetTable()
      Resets the data table, displaying all table rows

   doFilter()
      Filters the data table based on the values selected in the drop-down 
      selection lists. Also updates the record count.

   filterColumn(colIndex, fText)
      If the cell value from the current column does not equal the value
      of fText, this function hides the table row of which the table cell is part.


*/

function addEvent(object, evName, fnName, cap) {
   if (object.attachEvent)
       object.attachEvent("on" + evName, fnName);
   else if (object.addEventListener)
       object.addEventListener(evName, fnName, cap);
}

function isUnique(matchValue, arrList) {
   var joinArray = "^"+arrList.join("^")+"^";
   var index = joinArray.indexOf("^"+matchValue+"^");
   if (index == -1) return true
   else return false;
}


addEvent(window, "load", init, false);

var filterTable;
var filterCols;
var filterHead;
var filterBody;

function init() {
   filterTable = document.getElementById("filterTable");
   filterCols = filterTable.getElementsByTagName("col");
   filterHead = filterTable.tHead;
   filterBody = filterTable.tBodies[0];

   addTotalsRow();

   var newRow = document.createElement("tr");

   for (var i = 0; i < filterCols.length; i++) {
      var newCell = document.createElement("th");
      newCell.style.textAlign = "left";
      newCell.style.backgroundColor = "white";
      newCell.style.color = "black"

      if (filterCols[i].className == "filter") {
         var newSelect = createSelectionList(i);
         newCell.appendChild(newSelect);
      }

      // Append the cell to the table row
      newRow.appendChild(newCell);

   }

      // Append the cells and the new row to the thead section
      filterHead.appendChild(newRow);
}


function countRecords() {
   var rowCount=0;
   for (var i = 0; i < filterBody.rows.length; i++) {
      if (filterBody.rows[i].style.display == "") rowCount++;
   }
   return rowCount;
}

function addTotalsRow() {
   var newRow = document.createElement("tr");
   var newCell = document.createElement("td");
   newCell.colSpan = filterHead.rows[0].cells.length;
   newCell.innerHTML = "Matches Found: " + countRecords();
   
   newRow.appendChild(newCell);
   filterHead.insertBefore(newRow, filterHead.rows[0]);
}


function createSelectionList(colIndex) {
   // Create a selection list for the column
   var newSelect = document.createElement("select");
   newSelect.cIndex = colIndex; // mark the table column containing the selection box

   var blankOption = document.createElement("option");
   blankOption.innerHTML = "";
   newSelect.appendChild(blankOption);

   // Populate the rest of the selection list with column values
   addUniqueOptions(newSelect, colIndex);
         
   // Append selection list to the table header cell
   newSelect.style.width = "100%";
   newSelect.onchange = doFilter;
   
   return newSelect;
}


function addUniqueOptions(selectionList, colIndex) {
   var uniqueList = new Array();

   // Loop through the table body rows for a specific column
   // extracting the unique values from the column and storing them in
   // the uniqueList array and then as options in the selectionList
   // object

   for (var i = 0; i < filterBody.rows.length; i++) {
      var rowCell = filterBody.rows[i].cells[colIndex];
      var cellValue = rowCell.innerText || rowCell.textContent;

      if (isUnique(cellValue, uniqueList)) {
         uniqueList.push(cellValue);
      }
   }

   uniqueList.sort();

   // Create the option items for the selection list
   for (var j = 0; j < uniqueList.length; j++) {
      var newOption = document.createElement("option");
      newOption.innerHTML = uniqueList[j];
      selectionList.appendChild(newOption);
   }

}


function resetTable() {
   // Unhide all table rows
   for (var i = 0; i < filterBody.rows.length; i++) {
      filterBody.rows[i].style.display = "";
   }
}


function doFilter() {
   // Unhide all of the table rows
   resetTable();

   // Looop through the selection lists applying the filter values
   // from the selection lists to the table rows

   var allSelects = filterHead.getElementsByTagName("select");
   for (var i = 0; i < allSelects.length; i++) {
      var filterIndex = allSelects[i].selectedIndex;
      var filterText = allSelects[i].options[filterIndex].text;
      colIndex = allSelects[i].cIndex;

      // If filterText is not empty, filter the values for the corresponding column

      if (filterText !="") filterColumn(colIndex, filterText);      
   }

   // Update the rowcount table cell
   filterHead.rows[0].cells[0].innerHTML = "Matches Found: " + countRecords();
}


function filterColumn(colIndex, fText) {

   // Loop through all of the table body rows, filtering each row
   // for the filter values of the column indicated by colIndex

   for (var i = 0; i < filterBody.rows.length; i++) {
      rowCell= filterBody.rows[i].cells[colIndex];
      rowCellText = rowCell.innerText || rowCell.textContent;

      if (rowCellText != fText) filterBody.rows[i].style.display = "none";
   }
}















