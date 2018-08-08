<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">


<body>

<%@include file="./common/taskHeader.jsp"%>
<main role="main" class="container">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	<form font-size="75px;" name="myform" action="export.ds" method="post" > 
      <div align="center" ><br><br><br>
      	<form font-size="75px;" name="myForm" action="import.ds"  method="post" enctype="multipart/form-data">
			<table>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<tr align="justify">
					<td><label for="file">Choose file :</label></td>
					<td align="right"><input type="file"
						style="padding-right: 40px"  name="file"
						placeholder="choose file.." required="required"></td>
				</tr>
			    

			</table>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			</form>
      
    
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<tr align="right">
				<td><input type="submit" value="Import File"></td>
			</tr>
	</form>
      </div>
      <h3></h3>
    </main>



<%@include file="./common/footer.jsp"%>


</body>
</html>