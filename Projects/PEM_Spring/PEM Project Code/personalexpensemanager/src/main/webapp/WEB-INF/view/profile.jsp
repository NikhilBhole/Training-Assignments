<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">
<style>
body {
    height: 100%;   
    background-size: 100%; 
    background-image: url("../static/images/expense.jpeg");
    background-repeat: no-repeat;
}
.content h2{
	color: black;
	font-weight: 600;
}
.content p{
	color: black;
	font-weight: 600;
	font-size: large;
}
</style>
</head>

<body>
	<%if(session.getAttribute("userId")==null)
		{
			out.println(session.getAttribute("userId"));
			System.out.println("session id = "+session.getId()+" session interval="+session.getMaxInactiveInterval());
			response.sendRedirect("login.jsp");
		}
	%>

<%@include file="./common/expenseHeader.jsp" %>

	<main role="main" class="container">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br><br><br>
      <div class="content">
      	<h2>Welcome </h2><h2><% session.getAttribute("userName"); %></h2>
      	<p>Personal Expense Manager Application are keeps note a person daily expenses. </p>
      </div>
      <h3></h3>
    </main>


<%@include file="./common/footer.jsp" %>

</body>
</html>