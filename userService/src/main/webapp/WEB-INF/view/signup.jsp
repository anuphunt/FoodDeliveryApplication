<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Signup Form</h1>
	<hr>
	<form action="signup" method="post">
		<table style="with: 50%">

			<tr>
				<td>Role</td>
				<td><select name="role">
						<option>Select Role</option>
						<%
							ArrayList<String> roles = new ArrayList<String>();
							roles.add("Admin");
							roles.add("Customer");
							roles.add("Restaurant");
							roles.add("Driver");
						%>
						<%
							for (String r : roles) {
						%>
						<option value="<%=r%>"><%=r%></option>
						<%
							}
						%>
				</select>
			</tr>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>

			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="mname" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>

			<tr>
				<td>Date of Birth</td>
				<td><input type="date" id="start" name="dob" value="2018-07-22"
					min="1800-01-01" max="2050-12-31"></td>
			</tr>
			
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><select name="gender">
						<option>Select gender</option>
						<%
							ArrayList<String> genders = new ArrayList<String>();
							genders.add("male");
							genders.add("female");
							genders.add("Other");
						%>
						<%
							for (String g : genders) {
						%>
						<option value="<%=g%>"><%=g%></option>
						<%
							}
						%>
				</select>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="email" /></td>
			</tr>

			<tr>
				<td>Street Address</td>
				<td><input type="text" name="streetAddress" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city" /></td>
			</tr>

			<tr>
				<td>State/Province/Region</td>
				<td><input type="text" name="state" /></td>
			</tr>

			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="zipCode" /></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
		</table>
		<input type="submit" value="save" />
	</form>
</body>
</html>