<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Task</title>

<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">

</head>
<body style="text-align: center;">

	<%@include file="./common/taskHeader.jsp"%>
<br><br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<div align="center">

<h2 class="mt-5">Schedule Task</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form font-size="75px;" name="myform" action="saveTask.ds" method="post" >
	<h3>${errormessage}</h3>
		<table align="center">
			<tr>
				<td>Title : </td>
				<td><input type="text" name="title" id="title" style="padding-right: 40px" placeholder="Enter Your Title of Task"/></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><input type="text" name="description" id="description" style="padding-right: 40px; height: 100px; margin-top: 0px" placeholder="Enter Your Description"/></td>
			</tr>
			<tr>
				<td>Start Date : </td>
				<td><input type="date" name="startDate" id="startdate" style="padding-right: 35px"  /></td>
			</tr>
			<tr>
				<td>End Date : </td>
				<td><input type="date" name="endDate" id="enddate" style="padding-right: 35px" /></td>
			</tr>
			
		</table>
		<br> &nbsp; &nbsp; <input type="submit" value="Submit"/> &nbsp; &nbsp; &nbsp; &nbsp; <input type="reset"
			value="Reset"/>
			<br>
		
	</form>

	<%@include file="./common/footer.jsp"%>

</body>
</html>