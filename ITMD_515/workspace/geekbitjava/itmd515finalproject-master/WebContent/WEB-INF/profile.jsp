<%-- 
Deborah Barndt
Thomas Boller
3-29-18
profile.jsp
Final Project
This program includes a profile page for the rideshare app.
Written by Deborah Barndt & Thomas Boller. --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hitch: Profile</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
  <div class="main">
   <h1>Profile</h1>
  </div>
  <div class="containmain">
  <div class="center">
  <div class="profile"><img src="images/profile.png">
  </div>
  <h3>Please fill out your customer profile.</h3>
  <form id="custprofile" name="custprofile" action="custprofile.jsp" method="POST" autocomplete="on" oninput="output.value">
    <input type="text" id="fname" name="fname" placeholder="First Name" required />
    <p>
    <input type="text" id="lname" name="lname" placeholder="Last Name" required />
    </p>
    <p>
    <input type="text" id="userid" name="userid" placeholder="User ID" required />
    </p>
    <p>
    <input type="email" id="email" name="email" placeholder="example@email.com" required />
    </p>
    <p>
    <input type="text" id="credit" name="credit" placeholder="Credit Card Number" required />
    </p>
    <p>
		<input type="submit" id="submit" value="Submit" onclick="validate();" />
		</p>
  </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>