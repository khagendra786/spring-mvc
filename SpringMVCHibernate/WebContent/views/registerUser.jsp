<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>springmvc hibernate integration</title>
</head>
<body>
	<h2>Registration Form</h2>
	<form:form action="/spring/register.html" method = "POST">
		<form:label path= "username"> Username</form:label>
		<form:input path = "username" value = "${user.username }" readonly = "true"/>
		<form:label path= "password"> password</form:label>
		<form:input path = "password" value = "${user.password }" readonly = "true"/>
		<input type = "submit" value = "submit"/>
	</form:form>
	
	<c:if test = "${!empty user }"></c:if>
	<c:forEach items = "${user }" var = "user">
		<c:out value="${user.username }"/>
	</c:forEach>
</body>
</html>