<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Hitch, Please Login</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
  <div class="contain">
   <div id="close" class="close">Close</div>
  </div>
  <div class="containmain">
  <div class="center">
  <div class="profile"><img src="images/hitch.png">
  </div>
  <form class="form" action="/hitchwebapp/login.do" method="POST">
  <input type="text" class="topform" placeholder="E-Mail" name="username"><br>
  <input type="password" class="bottomform" placeholder="Password" name="password"><br>
  <input type="submit">
  <p></p>
  <a href="register.jsp" class="register"><strong>Register with Hitch!</strong></a>
  </form>
  </div>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>