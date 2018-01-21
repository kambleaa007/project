<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Details Page</title>
	</head>
	<body>
	<form action="<c:url value='logout'/>">
		UDeatails is: <c:out value="${sessionScope.UserDetails.name}"/><br/>
		UID is: <c:out value="${sessionScope.UID}"/><br/>
		<input type="submit" value="Logout">
		<br/>
		<br/><br/><br/><br/><br/><br/>
		
		
		
	</form>
	</body>
</html>