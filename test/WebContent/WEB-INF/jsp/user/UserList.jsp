<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Users List Page</title>
	</head>
	<body>
		
			<table>								
				<c:forEach var="user" items="${userList}">
    				<tr>
    				<td>User ID: <c:out value="${user.id}"/></td>
    				<td>Name: <c:out value="${user.name}"/></td>
    				<td>Email: <c:out value="${user.email}"/></td>
    				<td>Role: <c:out value="${user.role}"/></td>
    				</tr>    				
				</c:forEach>								
			</table>
		
		
	</body>
</html>