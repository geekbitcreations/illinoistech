<?php
      //the value of the 'agency' field from top_stories.html is retrieved using $_GET autoglobal variable into $news_source.
	  $news_source = $_GET['agency'];
	  
	  //PHP uses header() function that will be returned with response
	  header("Content-Type: text/xml");
	  header("Content-Length: ".strlen(file_get_contents($news_source)));
	  header("Cache-Control: no-cache");
	  
	  //readfile() function returns the the contents of the RSS feed as a response
	  readfile($news_source);
	  

?>