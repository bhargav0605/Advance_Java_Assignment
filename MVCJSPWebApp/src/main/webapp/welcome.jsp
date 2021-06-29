<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request">
</jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="header.html" %>
<body bgcolor="cyan">
	<h3>Dear <jsp:getProperty property="username" name="ob"/>Welcome to Phoenix</h3>
	<%
		String username = request.getParameter("username");
	
		//setting attribute
		session.setAttribute("user", username);
		
		//session timeout
		session.setMaxInactiveInterval(3);
		
		//getting forwarded parameter
		System.out.println("book1: "+request.getParameter("book1"));
		System.out.println("book2: "+request.getParameter("book2"));
		
		//encoding product url
		String encodedProductUrl = response.encodeURL("product.jsp");
	%>
	<p>Session time out is: <%=session.getMaxInactiveInterval() %> second</p>
	<p>To enjoy Shopping <a href="<%= encodedProductUrl %>">Click here</a>
</body>
<%@include file="footer.html" %>
</html>