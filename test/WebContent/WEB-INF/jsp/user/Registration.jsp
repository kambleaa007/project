<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration Page</title>
	</head>
	<body>
		<form:form modelAttribute="user" method="post" action="${userActionUrl }">
			<table>
								
				<tr>
					<td>Name</td>
					<td> <form:input path="name"/> </td>
					<td><font color='red'><form:errors path='name' cssClass="error"/></font></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password"/></td>
					<td><font color='red'><form:errors path='password' /></font></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email"/></td>
					<td><font color='red'><form:errors path='email' /></font></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><form:select path="role">
   						<form:option value="JobSeeker" label="Job Seeker"/>
   						<form:option value="Company" label="Company"/>
					</form:select>
					</td>
					<%-- <td><form:select path="role" items="JobSeeker" /></td> --%>
				</tr>
				
				<tr>
					<td>Join Date</td>
					<td><form:input path="regDate" placeholder="dd/MM/yyyy"/></td>
					<td><font color='red'><form:errors path='regDate' /></font></td>
				</tr>
				<tr>
									
					<td><input type="submit" value="Register" /> </td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>