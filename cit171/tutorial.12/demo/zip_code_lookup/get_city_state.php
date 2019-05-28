<?php
include 'class.geodata.inc.php'; 

function get_city_state($zip_code) {
	// dedlcare variables
	$return_value = "";
	$zip_code_length = 0;
	$city_name = "";
	$state_name = "";
	
	// remove any spaces from the zip code
	$zip_code = trim($zip_code);
	
	// get the string length of the zip code
	$zip_code_length = strlen($zip_code);
	
	if ($zip_code_length == 0) {
		$return_value = "";
	}
	else if ($zip_code_length > 5) {
		$return_value = "<span id=\"warning\">Length of Zip Code is Too Long</span>";	
	}
	else if ($zip_code_length < 5 ) {
		$return_value = "<span id=\"warning\">Length of Zip Code is Too Short</span>";	
	}
	else if (!is_numeric($zip_code)) {
		$return_value = "<span id=\"warning\">Invalid Zip Code</span>";		
	}
	else {
		// instantiate new EyeGeoData object
		$lookup = new EyeGeoData();
		
		// lookup postal code. Note that $lookup is an array
		$result_array = $lookup->query($zip_code);	
		
		// get the city name
		$city_name = $result_array['City'];
		
		// get the state name
		$state_name = $result_array['Province'];
		
		if (strlen($city_name) > 0 Or strlen($state_name) > 0) {
			// send the name of the city back to the Web page
			$return_value = "<span id=\"valid\">$city_name, $state_name</span>";
		}
		else {
			$return_value = "<span id=\"warning\">Zip Code NOT Found</span>";	
		}
	}

	// send the input comments back to the calling procedure
	return $return_value;
}

echo get_city_state(trim($_REQUEST['zip_code']));
?>