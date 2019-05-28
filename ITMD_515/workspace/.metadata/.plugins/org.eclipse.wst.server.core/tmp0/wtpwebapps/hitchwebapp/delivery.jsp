<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hitch: Request a Delivery</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Khand" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
 <header>
    <img src="images/hitch.png" id="logo">
    <h1 class="myheader">HITCH</h1>
      
    <nav id="navmenu">
      <ul>
        <li id="nav-home"><a href="main.jsp">Home</a></li>
        <li id="nav-ride"><a href="ride.jsp">Ride</a></li>
        <li id="nav-profile"><a href="profile.jsp">Profile</a></li>
        <li id="nav-delivery"><a href="delivery.jsp">Delivery</a></li>
      </ul>
    </nav>
  </header>
  <img class="services" src="images/delivery.png">
  <h1 class="request">Request a Delivery</h1>
    <form class="delivery" action="/action_page.php" target="_blank" method="POST" enctype="multipart/form-data">
      <h3 class="location">PICK-UP LOCATION:</h3>
      <p>
        <label>Street Address:</label>
        <input type="text" name="street1">
      </p>
      <p>
        <label>City:</label>
        <input type="text" name="city1">
      </p>
      <p>
        <label>State:</label>
        <select name="state1">
			<option value="AL">AL</option>
			<option value="AK">AK</option>
			<option value="AR">AR</option>	
			<option value="AZ">AZ</option>
			<option value="CA">CA</option>
			<option value="CO">CO</option>
			<option value="CT">CT</option>
			<option value="DC">DC</option>
			<option value="DE">DE</option>
			<option value="FL">FL</option>
			<option value="GA">GA</option>
			<option value="HI">HI</option>
			<option value="IA">IA</option>	
			<option value="ID">ID</option>
			<option value="IL">IL</option>
			<option value="IN">IN</option>
			<option value="KS">KS</option>
			<option value="KY">KY</option>
			<option value="LA">LA</option>
			<option value="MA">MA</option>
			<option value="MD">MD</option>
			<option value="ME">ME</option>
			<option value="MI">MI</option>
			<option value="MN">MN</option>
			<option value="MO">MO</option>	
			<option value="MS">MS</option>
			<option value="MT">MT</option>
			<option value="NC">NC</option>	
			<option value="NE">NE</option>
			<option value="NH">NH</option>
			<option value="NJ">NJ</option>
			<option value="NM">NM</option>			
			<option value="NV">NV</option>
			<option value="NY">NY</option>
			<option value="ND">ND</option>
			<option value="OH">OH</option>
			<option value="OK">OK</option>
			<option value="OR">OR</option>
			<option value="PA">PA</option>
			<option value="RI">RI</option>
			<option value="SC">SC</option>
			<option value="SD">SD</option>
			<option value="TN">TN</option>
			<option value="TX">TX</option>
			<option value="UT">UT</option>
			<option value="VT">VT</option>
			<option value="VA">VA</option>
			<option value="WA">WA</option>
			<option value="WI">WI</option>	
			<option value="WV">WV</option>
			<option value="WY">WY</option>
		</select>
      </p>
      <h3 class="location">DROP-OFF LOCATION:</h3>
      <p>
        <label>Street Address:</label>
        <input type="text" name="street2">
      </p>
      <p>
        <label>City:</label>
        <input type="text" name="city2">
      </p>
      <p>
        <label>State:</label>
        <select name="state2">
			<option value="AL">AL</option>
			<option value="AK">AK</option>
			<option value="AR">AR</option>	
			<option value="AZ">AZ</option>
			<option value="CA">CA</option>
			<option value="CO">CO</option>
			<option value="CT">CT</option>
			<option value="DC">DC</option>
			<option value="DE">DE</option>
			<option value="FL">FL</option>
			<option value="GA">GA</option>
			<option value="HI">HI</option>
			<option value="IA">IA</option>	
			<option value="ID">ID</option>
			<option value="IL">IL</option>
			<option value="IN">IN</option>
			<option value="KS">KS</option>
			<option value="KY">KY</option>
			<option value="LA">LA</option>
			<option value="MA">MA</option>
			<option value="MD">MD</option>
			<option value="ME">ME</option>
			<option value="MI">MI</option>
			<option value="MN">MN</option>
			<option value="MO">MO</option>	
			<option value="MS">MS</option>
			<option value="MT">MT</option>
			<option value="NC">NC</option>	
			<option value="NE">NE</option>
			<option value="NH">NH</option>
			<option value="NJ">NJ</option>
			<option value="NM">NM</option>			
			<option value="NV">NV</option>
			<option value="NY">NY</option>
			<option value="ND">ND</option>
			<option value="OH">OH</option>
			<option value="OK">OK</option>
			<option value="OR">OR</option>
			<option value="PA">PA</option>
			<option value="RI">RI</option>
			<option value="SC">SC</option>
			<option value="SD">SD</option>
			<option value="TN">TN</option>
			<option value="TX">TX</option>
			<option value="UT">UT</option>
			<option value="VT">VT</option>
			<option value="VA">VA</option>
			<option value="WA">WA</option>
			<option value="WI">WI</option>	
			<option value="WV">WV</option>
			<option value="WY">WY</option>
		</select>
      </p>
      <p>
        <label>Package Size:</label>
            <select name="pkgsize">
              <option value="xsmall">EXTRA SMALL</option>
              <option value="small">SMALL</option>
              <option value="medium">MEDIUM</option>
              <option value="large">LARGE</option>
              <option value="xlarge">EXTRA LARGE</option>
            </select>
      </p>
      <p>
        <label>When would you like it delivered:</label>
            <select name="when">
              <option value="asap">ASAP</option>
              <option value="later">LATER</option>
            </select>
      </p>
      <p>
        <label>Time:</label>
        <input type="time" name="usertime">
      </p>
      <input type="submit" value="Submit" onclick="main.jsp">
    </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>