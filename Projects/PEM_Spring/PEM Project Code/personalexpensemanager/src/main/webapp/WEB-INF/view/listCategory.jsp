<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />
<s:url var="url_main" value="/static/css/main.css"></s:url>
<s:url var="url_util" value="/static/css/util.css"></s:url>

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">
<link href="${url_main}" type="text/css" rel="stylesheet">
<link href="${url_util}" type="text/css" rel="stylesheet">
<style>
body {
    height: 100%;   
    background-size: 100%; 
    background-image: url("../static/images/expense.jpeg");
    background-repeat: no-repeat;
}
.main{
	
	
}
</style>
</head>
<body>
<%if(session.getAttribute("userId")==null)
		{
			System.out.println(session.getAttribute("userId"));
			System.out.println("session id = "+session.getId()+" session interval="+session.getMaxInactiveInterval());
			response.sendRedirect("userlogin.ds");
		}
	%>
<%@include file="./common/expenseHeader.jsp" %>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div align="center">
<main role="main" class="container" >
	<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50" style="width: 85%; background-color: aqua; opacity:0.9;">
	<h3>${message}</h3>
	<h2>Category List</h2>
		<table border="1px" style="width:400px; padding: 10px; text-align: center;">
		    <tr style="color: red;">
        	    <th>Category ID</th>
            	<th>Category Name</th>                                
         	</tr>
        	<c:forEach items="${catList}" var="category">
        	   	<tr>
   		     	    <td><c:out value="${category.categoryId}"></c:out></td>
                	<td><c:out value="${category.name}"></c:out></td>
            	</tr>
        	</c:forEach>
        </table>
     </div>
  </main>
</div>

<%@include file="./common/footer.jsp" %>

</body>
</html>