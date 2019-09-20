<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/prob1.css">
<link rel="stylesheet" href="./css/table.css">
<link rel="stylesheet" href="./css/button.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../common/header.jsp" %>
<div id="output">
<section>

<h3> Book 등록 폼 </h3>
<form action="InsertBook.do" method="post" enctype="multipart/form-data">

	제목 : <input type="text" id="title" name="bookname"/><br/><br/>
	출판사 : <input type="text" id="title" name="publisher"/><br/><br/>
	가격 : <input type="number" id="title" name="price"/><br/><br/>
	img : <input type="file" name="img" multiple="multiple"/><br/><br/>
	
	<input type="submit" value="등록"/>
	<input type="reset" value="초기화"/>

</form>

</section>
</div>
<%@include file="../common/footer.jsp" %>

</body>
</html>