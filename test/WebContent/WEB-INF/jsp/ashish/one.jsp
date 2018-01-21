<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form modelAttribute="customer" method="post">
			<table>
				<tr>
					<td>Email</td>
					<td><form:input path="email"/></td>
				</tr>
		
				<tr>
					<td>Password</td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>					
					<td><input type="submit" value="Login"/> </td>
					<td><input type="submit" value="Register" formaction="register"/> </td>
				</tr>
			</table>
		</form:form>
		
</body>
</html>