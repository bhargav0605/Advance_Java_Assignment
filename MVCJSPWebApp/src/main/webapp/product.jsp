<%@ page language="java" contentType="text/html; charset=UTF-8"
    session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<!-- </head> -->
<%@include file="header.html" %>
<body bgcolor="pink">
	<%
		HttpSession ss = request.getSession(false);
	if(ss!=null){ %>
		<p>Dear <%= ss.getAttribute("user") %> Select Products of your choice</p>
	<% } else { %>
		<h2 style="color:red;">Sorry! Your Session is expired.</h2>
		
	<% } %>
</body>
<%@include file="footer.html" %>
</html>