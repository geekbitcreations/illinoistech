<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hitch: Profile</title>
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
  <h1 class="request">Profile</h1>
  
  <div class="card">
  <img class="userpic" src="images/jpapa.jpg" alt="jpapa">
  <h1>James Papademas</h1>
  <p class="title">Professor</p>
  <p class="customer" id="userid">Username: jpapa</p>
  <p class="customer" id="email">Email: jpapadem@iit.edu</p>
  <p class="customer" id="phone">Phone: 855-888-5547</p>
  <p>Location: Chicago</p>
  <a href="#"><i class="fa fa-dribbble"></i></a> 
  <a href="#"><i class="fa fa-twitter"></i></a> 
  <a href="#"><i class="fa fa-linkedin"></i></a> 
  <a href="#"><i class="fa fa-facebook"></i></a> 
  
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>