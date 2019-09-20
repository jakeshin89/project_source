<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/prob1.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/button.css">
<style>
img {
	width: 50px;
	height: 70px;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<script>

function f1(){
	return confirm("진짜 삭제?");
}

</script>
</head>
<body>

<%@include file="common/header.jsp" %>

<div id="output">
<section>

<h3>book list</h3>


<form action="deleteBook.do" method="get">
	<table class="tablea">
		<tr>
			<th>bookid</th>
			<th>bookname</th>
			<th>publisher</th>
			<th>price</th>
			<th>image</th>
			<th><input type="submit" id="del" name="del" value="삭제" onclick="return f1()"/></th>
			<!-- return값 붙이고 안 붙이고가 달라짐 -->
		</tr>
	
<!-- ListBookServlet.java 에서 request.setAttribute("booklist", list); 에서 넘어온 애 출력-->
<!-- 이게 배열 형태로 들어있으니 for loop를 돌려서 꺼내보자 -->
	<c:forEach var="data" items="${booklist}">
	   <tr> 
	        <td> ${data.bookid} </td>
	        <td><a href="viewBook.do?bookid=${data.bookid}"> ${data.bookname} </a></td>
	        <td><a href="viewpublisher.do?publisher=${data.publisher}"> ${data.publisher} </a></td>
	        <td> ${data.price} </td>
	        <td><img alt="${data.bookname}" src="${data.img}"></td>
	        <td> <input type="checkbox" name="bookid" value="${data.bookid}"/> </td>
	   </tr>
	   		<input type="hidden" name="img" value="${data.img}"/>
			<!-- input data hidden은 submit해서 정보를 제출하긴 하는데 중요한 정보를 보낼 때 숨겨서 보냄 -->
	</c:forEach>
	</table>
</form>

</section>
</div>

<%@include file="common/footer.jsp" %>

</body>
</html>