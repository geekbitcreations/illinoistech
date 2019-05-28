<%@ page import = "geekbitjava.entities.*" %>
<html>

<body>
<h3>Login successful</h3>

You logged in at: <%= new java.util.Date() %>
<br />
 
<input type="text" name="" value="<%=UserBean.myString() %>">

<br />

<%=UserBean.myString() %>- you have logged in

</body>
</html>