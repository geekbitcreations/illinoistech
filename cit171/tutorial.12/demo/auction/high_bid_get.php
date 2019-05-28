<?php
function get_high_bid() {
	// establish a connection to MySQL
	$db_connection_string = mysqli_connect("localhost", "student", "mysql");

	$database_name = "auction";
	$table_name = "bid";

	// establish a connection to the attendees table
	@mysqli_select_db($db_connection_string, $database_name);

	// build our SQL select statment
	$sql_select_statement = "SELECT MAX(bid)" .
	"AS high_bid " .
	"FROM " . $table_name;

	// run the SQL select statement
	$query_result = @mysqli_query($db_connection_string, $sql_select_statement);

	// get the number of query rows and fields
	$num_rows = mysqli_num_rows($query_result);
	
	if ($num_rows == 1) {
		// loop through the result set
		$row = mysqli_fetch_assoc($query_result);
		
		// get the high bid
		$high_bid = $row['high_bid'];
	}
	else {
		$high_bid = 0;
	}
	
	// format the result
	$high_bid = "$" . number_format($high_bid, 2);
	
	// let go of the query connection
	mysqli_free_result($query_result );

	// close connection to MySQL
	mysqli_close($db_connection_string);

	// send back the current high bid
	return $high_bid;
}

echo get_high_bid();
?>