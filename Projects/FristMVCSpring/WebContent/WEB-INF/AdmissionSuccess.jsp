<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>${msg}</h3> 

<table>
<tr>
<td>student name</td><td>${student1.studentName}</td>
</tr>
<tr>
<td>student hobby</td><td>${student1.studentHobby}</td>
</tr>
<tr>
<td>student mobile</td><td>${student1.studentMobile}</td>
</tr>
<tr>
<td>student DOB</td><td>${student1.studentDOB}</td>
</tr>
<tr>
<td>student skills</td><td>${student1.studentSkills}</td>
</tr>
<tr>
<td>student address:</td>

<td>country</td><td>${student1.studentAddress.country}</td>
<td>city</td><td>${student1.studentAddress.city}</td>
<td>street</td><td>${student1.studentAddress.street}</td>
<td>pincode</td><td>${student1.studentAddress.pincode}</td>
</tr>

</table>
</body>
</html>