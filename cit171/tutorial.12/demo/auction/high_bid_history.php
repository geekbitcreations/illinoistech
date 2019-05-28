<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Bid History</title>
</head>
<body>
<h1>Bid History</h1>

<?php

// establish a connection to MySQL
$db_connection_string = mysqli_connect("localhost", "student", "mysql");

$database_name = "auction";
$table_name = "bid";

// establish a connection to the attendees table
@mysqli_select_db($db_connection_string, $database_name);

// build our SQL select statment
$sql_select_statement = "SELECT " .
"bid_id, bid " .
"FROM " . $table_name .
" ORDER BY bid_id";

// run the SQL select statement
$query_result = @mysqli_query($db_connection_string, $sql_select_statement);

// get the number of query rows and fields
$num_rows = mysqli_num_rows($query_result);
$num_fields = mysqli_num_fields($query_result);

// display the number of bids  on the Web page
$num_bids_message = "<p>There";
if ($num_rows == 1) {
	$num_bids_message = $num_bids_message . " is ";
}
else {
	$num_bids_message = $num_bids_message . " are ";
}
$num_bids_message = $num_bids_message . $num_rows . " bid";
if ($num_rows == 0 || $num_rows > 1) {
	$num_bids_message = $num_bids_message . "s";
}
$num_bids_message = $num_bids_message . "</p>";
echo $num_bids_message;

// loop through the result set
$row = mysqli_fetch_assoc($query_result);
echo "<table border='1'>";
echo "<tr>";
echo "<th>bid_id</th>";
echo "<th>bid</th>";
echo "</tr>";
do {
	echo "<tr>";
	echo "<td>{$row['bid_id']}</td>";
	echo "<td>{$row['bid']}</td>";
	echo "</tr>";
	// get the next record
	$row = mysqli_fetch_assoc($query_result);
} while ($row);
echo "</table>";

// let go of the query connection
mysqli_free_result($query_result );

// close connection to MySQL
mysqli_close($db_connection_string);
?>

</body>
</html>
