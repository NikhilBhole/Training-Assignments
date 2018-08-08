<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

</head>



<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">


</head>
<body style="text-align: center;" background='./static/images/781042.jpg'>
	<%@include file="./common/header.jsp"%>
	<br><br><br><br>
	<h1 class="mt-5" >User
		Registration Form</h1>
	<br>
	<br>
	<form font-size="75px;" name="myform" method="post" action="showLogin.ds">
		<table align="center">
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstname" id="fn"
				style="padding-right: 40px"
					placeholder="Enter Your FirstName" required="required" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastname" id="ln"
				style="padding-right: 40px"
					placeholder="Enter Your LastName" required="required" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email" id="em"
				style="padding-right: 40px"
					placeholder="Enter Your Email" required="required" /></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><input type="text" name="contact" id="numloc"
				style="padding-right: 40px"
					placeholder="Enter Your Contact" required="required" maxlength="10" /></td>

			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" id="ad"
				style="padding-right: 40px"
					placeholder="Enter Your Address" required="required" /></td>
			</tr>
			<tr>
				<td>Login-Name :</td>
				<td><input type="text" name="loginname" id="ln"
				style="padding-right: 40px"
					placeholder="Enter Your Username" required="required" /></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" id="ps"
				style="padding-right: 40px"
					placeholder="Enter Your Password" required="required" /></td>
			</tr>
		</table>
		<br> &nbsp &nbsp <input type="submit" value="Submit" /> &nbsp
		&nbsp &nbsp &nbsp <input type="reset" value="Reset" /> <br>
		<tr>
			<td colspan="2">Already registered!! <a href="login.jsp">Login
					Here</a></td>
		</tr>
	</form>
	<%@include file="./common/footer.jsp"%>

</body>
</html>