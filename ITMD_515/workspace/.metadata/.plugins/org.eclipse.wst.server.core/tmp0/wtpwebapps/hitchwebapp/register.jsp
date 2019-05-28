<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hitch: Register</title>
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
  <img class="services" src="images/profile.png">
  <h1 class="request">Register</h1>
  <h3>Please fill out your customer profile.</h3>
  <form id="custprofile" name="custprofile" action="/hitchwebapp/registration.do" method="POST" autocomplete="on" oninput="output.value">
    <input type="text" id="fname" name="fname" placeholder="First Name" required />
    <p>
    <input type="text" id="lname" name="lname" placeholder="Last Name" required />
    </p>
    <p>
    <input type="email" id="email" name="email" placeholder="example@email.com" required />
    </p>
    <p>
    <input type="password" id="password" name="password" placeholder="Password" required />
    </p>
    <p>
    <input type="text" id="name_on_card" name="name_on_card" placeholder="Name on Credit Card" required />
    </p>
    <p>
    <input type="text" id="credit" name="credit" placeholder="Credit Card Number" required />
    </p>
    <p>
    <input type="text" id="exp_date" name="exp_date" placeholder="Expiration Date" required />
    </p>
    <p>
    <input type="text" id="cvv" id="cvv" name="cvv" size="4" placeholder="CVV"  maxlength="4" required />
    </p>
    <p>
		<input type="submit" id="submit" value="Submit" onclick="validate();" />
		</p>
  </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>