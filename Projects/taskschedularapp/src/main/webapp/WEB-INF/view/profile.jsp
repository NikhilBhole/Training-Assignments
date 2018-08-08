<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>

<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">

<body>
	<%if(session.getAttribute("userid")==null)
		{
			System.out.println(session.getAttribute("userid"));
			System.out.println("session id = "+session.getId()+" session interval="+session.getMaxInactiveInterval());
			response.sendRedirect("login.jsp");
		}
	%>

<%@include file="./common/taskHeader.jsp" %>

	<main role="main" class="container">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div align="center" ><br><br><br><h2 class="mt-5"><%= session.getAttribute("userid") %></h2></div>
      <h3></h3>
    </main>


<%@include file="./common/footer.jsp" %>

</body>
</html>