<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/prob1.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/button.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%@include file="../common/header.jsp" %>
<div id="output">
<section>

<h3> menu 클릭하세요. </h3>
<div>

	<ul>
	<c:if test="${empty login}">
		<li><a href="login.jsp"> 로그인</a></li>
	</c:if>
	<c:if test="${!empty login}">
		<li><a href="logout.do"> 로그아웃</a></li>
		<li><a href="bookform.jsp"> 도서등록 폼</a></li>
		<li><a href="./listBook.do"> 도서목록</a></li>
	</c:if>
	</ul>
</div>
</section>
</div>
<%@include file="../common/footer.jsp" %>

</body>
</html>