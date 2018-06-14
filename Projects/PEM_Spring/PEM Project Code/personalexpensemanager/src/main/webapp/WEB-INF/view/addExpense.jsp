<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.erp.personalexpensemanager.model.Category" %>
<%@page import="com.erp.personalexpensemanager.dao.CategoryDao" %>
<%@page import="com.erp.personalexpensemanager.daoimpl.CategoryDaoImpl" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>

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

<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<div align="center" style="background-image: url("../static/images/expense.jpg");">
		<br>
		<main role="main" class="container" >
		
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50" style="background-color: aqua; opacity:0.9;">
				<form class="login100-form validate-form" action="addNewExpense.ds" method="post">
					<span class="login100-form-title p-b-33">
						Add Expense
					</span>
					
					Select Category : 
					<select name="categoryId">
					<c:forEach items="${categoryList}" var="category">
					
				    <option value="${category.categoryId}">"${category.name}"</option>
				    </c:forEach>
				    </select><br>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="amount" placeholder="Amout">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="date" name="date" placeholder="Date">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="remark" placeholder="Remark">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>
					<br>
					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Add Expense
						</button>
					</div>
                    <br>
				</form>
			</div>
		
		</main>
		
	</div>

<%@include file="./common/footer.jsp" %>

</body>
</html>