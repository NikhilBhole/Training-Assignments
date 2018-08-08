<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Task</title>
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

<%@include file="./common/taskHeader.jsp"%>

<main role="main" class="container">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
   	<form font-size="75px;" name="myform" action="update.ds" method="post" > 
      <div align="center" ><br><br><br>
      <h1>list of task</h1>
      
      	<table border="1" cellspacing="3" cellpadding="3">
      	
	<c:forEach var="task" items="${tasklist}">
	
	<tr>
		<td>	
			<input type="radio" name="radio" value="${task.title}" />
		</td>
		<td>
			
			<c:out value="${task.id}"></c:out>
		</td>
		<td>
			<c:out value="${task.title}"></c:out>
		</td>
		<td>
			<c:out value="${task.description}"></c:out>
		</td>
		<td>
			<c:out value="${task.startDate}"></c:out>
		
		</td>
		<td>
			<c:out value="${task.endDate}"></c:out>
		
		</td>
		<td>
			<c:out value="${task.status}"></c:out>
		
		</td>
	</tr>
	</c:forEach>
	</table>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<tr align="right">
				<td><input type="submit" value="update"></td>
			</tr>
	</form>
      </div>
      <h3></h3>
    </main>

<%@include file="./common/footer.jsp"%>


</body>
</html>