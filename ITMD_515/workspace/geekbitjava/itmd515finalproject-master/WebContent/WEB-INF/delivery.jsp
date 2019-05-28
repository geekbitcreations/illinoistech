<%-- 
Deborah Barndt
Thomas Boller
3-29-18
delivery.jsp
Final Project
This program includes a request delivery page for the rideshare app.
Written by Deborah Barndt & Thomas Boller. --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hitch: Request a Delivery</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
  <div class="main">
   <h1>Request a Delivery</h1>
  </div>
  <div class="containmain">
  <div class="center">
  <div class="profile"><img src="images/car.png">
  </div>
  <div class="row">
    <div class="icons">
      <ul>
        <li><img src="images/car.png"></li>
        <li><img src="images/profile.png"></li>
        <li><img src="images/location.png"></li>
        <li><img src="images/car.png"></li>
        <li><img src="images/feedback.png"></li>
        <li><img src="images/reward.png"></li>
      </ul>
    </div>
    <div class="services">
      <ul>
        <li><h2><a href="ride.html">Request a Ride</a></h2></li>
        <li><h2><a href="profile.html">Profile</a></h2></li>
        <li><h2><a href="places.html">Saved Places</a></h2></li>
        <li><h2><a href="delivery.html">Request a Delivery</a></h2></li>
        <li><h2><a href="feedback.html">Give Feedback</a></h2></li>
        <li><h2><a href="rewards.html">Frequent Rewards</a></h2></li>
      </ul>
    </div>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>