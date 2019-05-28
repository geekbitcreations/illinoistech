<?php
// get the input
$bid = trim($_REQUEST['bid']);

// establish a connection to MySQL
$db_connection_string = mysqli_connect("localhost", "student", "mysql");

$database_name = "auction";
$table_name = "bid";

// establish a connection to the attendees table
@mysqli_select_db($db_connection_string, $database_name);

// build our SQL insert statment
$sql_insert_statement = "INSERT INTO " . $table_name . 
								    " (bid) " .
									"VALUES (" . $bid  . ")";	
									
// run the sql insert command
$query_result = @mysqli_query($db_connection_string, $sql_insert_statement );
									
// close connection to MySQL
mysqli_close($db_connection_string);

echo "You have successfully entered your bid of $" . $bid . ".";

?>


