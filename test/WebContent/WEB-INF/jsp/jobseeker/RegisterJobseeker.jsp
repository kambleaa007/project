<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form modelAttribute="jobSeeker" method="post" action="${userActionUrl }">
			<table>
								
				<tr>
					<td>Name</td>
					<td> <form:input path="name"/> </td>
					<td><font color='red'><form:errors path='name' cssClass="error"/></font></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><form:input path="phno"/></td>
					<td><font color='red'><form:errors path='phno' /></font></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><form:input path="location"/></td>
					<td><font color='red'><form:errors path='location' /></font></td>
				</tr>
				<tr>
					<td>Experience</td>
					<td><form:input path="experience"/></td>
					<td><font color='red'><form:errors path='experience' /></font></td>
				</tr>
				<tr>
					<td>Education</td>
					
					
					<td><form:select path="education">
   						<form:option value="10th" label="SSC"/>
   						<form:option value="12th" label="HSC"/>
   						<form:option value="BE" label="BE"/>
					</form:select>
					<td><font color='red'><form:errors path='education' /></font></td>
				</tr>
				
				<tr>
					<td>Date Of Birth</td>
					<td><form:input path="dob" placeholder="dd/MM/yyyy"/></td>
					<td><font color='red'><form:errors path='dob' /></font></td>
				</tr>
				<tr>
					<td>Skills</td>
					<td><form:textarea path="skills" placeholder="Mention Skills"/></td>
					
				</tr>
				<tr>
									
					<td><input type="submit" value="Register" /> </td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>