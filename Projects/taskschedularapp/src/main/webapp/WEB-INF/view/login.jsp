<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">

</head>

<body>

	<%@include file="./common/header.jsp"%>
	

	<!-- Begin page content -->
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div align="center">
		<br> <br> <br>
		<main role="main" class="container">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<h2 class="mt-5">Login Here</h2>

		<form font-size="75px;" name="myForm" action="profiles.ds"  method="GET">
			<table>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<tr align="justify">
					<td><label>Choose an Option</label></td>
					<td align="center" style="width: 50px"><input type="radio"
						name="login" value="username" checked="checked">Login
						Name&nbsp; <input type="radio" name="login" value="email">Email</td>
				</tr>
				<tr align="justify">
					<td><label for="lname">Login name</label></td>
					<td align="right"><input type="text"
						style="padding-right: 40px" id="lname" name="loginname"
						placeholder="Enter Your Login name or Email.." required="required"></td>
				</tr>
				<tr align="justify">
					<td><label for="password">Password</label></td>
					<td align="right"><input type="password"
						style="padding-right: 40px" id="password" name="password" required="required"></td>
				</tr>

			</table>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<tr align="right">
				<td><a href="registration.jsp">Sign up!</a></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
			</form>
		</main>
		
	</div>

	<%@include file="./common/footer.jsp"%>
</body>
</html>