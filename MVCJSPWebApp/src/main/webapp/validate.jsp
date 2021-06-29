<%-- Controller JSP --%>
<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request">
</jsp:useBean>

<jsp:setProperty property="username" name="ob"/>
<jsp:setProperty property="password" name="ob" param="passwd"/>

<% 
	//Invoking business logic
	if(ob.isValid()){ %>
		<jsp:forward page="/welcome.jsp">
			<jsp:param name="book1" value="Java" />
			<jsp:param name="book2" value="Jsp" />
		</jsp:forward>
<%	} else { %>
		<h2 style="color: red;">Invalid Login </h2>
		<jsp:include page="/login.html"/>
<% } %> 
			
