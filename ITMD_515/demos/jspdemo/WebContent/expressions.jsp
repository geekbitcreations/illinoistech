<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- expression -->
<%= new String("Hello JSP").toUpperCase() %>
<br />
<%= 25*3 %>

<!-- scriptlet -->
<%
for(int i=0;i<=5;i++)
	out.println("<br /> " + i);
	
%>

<br />
<!-- declaration -->
<%!

 String makeItLower(String data){
	
	return data.toLowerCase();
}
%>

LC call -> <%= makeItLower("DOOD")    %>

</body>
</html>