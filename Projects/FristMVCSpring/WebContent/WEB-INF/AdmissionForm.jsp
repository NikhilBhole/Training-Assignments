<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/FirstMVCSpring/admissionForm.html?siteLanguage=en">English</a> | <a href="/FirstMVCSpring/admissionForm.html?siteLanguage=fr">French</a>

<h1><spring:message code="label.msg"/></h1>
<h3><spring:message code="label.AdmissionForm"/></h3>
<form:errors path="student1.*"/>

<form action="/submitAdmissionForm.html" method="post">
<table>
<tr>
<td><spring:message code="label.studentName" /> </td><td><input type="text" name="studentName"/></td>
</tr>
<tr>
<td><spring:message code="label.studentHobby" />  </td><td><input type="text" name="studentHobby"/></td>
</tr>
<tr>
<td><spring:message code="label.studentMobile" />  </td><td><input type="text" name="studentMobile"/></td>
</tr>
<tr>
<td><spring:message code="label.studentDOB" />   </td><td><input type="text" name="studentDOB"/></td>
</tr>
<tr>
<td><spring:message code="label.studentSkills" />  </td><td>  <select name="studentSkills" multiple="multiple">
								 <option value="java core">java core</option>
								 <option value="spring MVC">spring MVC</option>
								 </select></td>
</tr>
</table>

<table>
<tr>
<td><spring:message code="label.studentAddress" /></td>
</tr>
<tr>
<td><spring:message code="label.country" /> <input type="text" name="studentAddress.country"/></td>
<td><spring:message code="label.city" />  <input type="text" name="studentAddress.city"/></td>
<td><spring:message code="label.street" />  <input type="text" name="studentAddress.street"/></td>
<td><spring:message code="label.pincode" /> <input type="text" name="studentAddress.pincode"/></td>
</tr>

<tr>
<td>
<spring:message code="label.submit.admissionForm" var="labelSubmitAdmissionForm"></spring:message>
<input type="submit" value=${labelSubmitAdmissionForm}></td>
</tr>
</table>
</form>

</body>
</html>