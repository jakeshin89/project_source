<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> hello.jsp </title>
</head>
<body>

<h3> hello.jsp </h3>

<%

request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String id = request.getParameter("id");

%>

<table border="1">
	<tr> 
		<th> NAME </th> 
		<th> ID </th> 
	</tr>
	<tr> 
		<th> <%= name %> </th> 
		<th> <%= id %> </th> 
	</tr>

</table>

</body>
</html>