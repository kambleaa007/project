<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form modelAttribute="company" method="post" action="${userActionUrl }">
			<table>
								
				<tr>
					<td>Name</td>
					<td> <form:input path="name"/> </td>
					<td><font color='red'><form:errors path='name' cssClass="error"/></font></td>
				</tr>
				<tr>
					<td>Branch</td>
					<td><form:input path="branch"/></td>
					<td><font color='red'><form:errors path='branch' /></font></td>
				</tr>
				<tr>
					<td>Qualification</td>
					<td><form:input path="qualification"/></td>
					<td><font color='red'><form:errors path='qualification' /></font></td>
				</tr>
				<tr>
					<td>Package</td>
					<td><form:input path="pkg"/></td>
					<td><font color='red'><form:errors path='pkg' /></font></td>
				</tr>
				<tr>
					<td>Company Type</td>
					<td><form:select path="ctype">
   						<form:option value="Government" label="Company"/>
   						<form:option value="IT" label="Company"/>
   						<form:option value="Non IT" label="Company"/>
   						<form:option value="Core" label="Company"/>
   						<form:option value="Other" label="Company"/>
					</form:select>
					</td>
					<td><font color='red'><form:errors path='ctype' /></font></td>
					
				</tr>
				
				<tr>
					<td>Post Date</td>
					<td><form:input path="postDate" placeholder="dd/MM/yyyy"/></td>
					
				</tr>
				<tr>
									
					<td><input type="submit" value="Register" /> </td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>