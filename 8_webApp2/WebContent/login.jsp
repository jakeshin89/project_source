<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
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

<h3> 로그인 폼 </h3>

<!-- Form은 서버로 데이터 보낼게요! -->

<form action="login.do" method="post" onsubmit="return check()">
	<table border="1">
		<tr>
			<td><label for="id">ID </label></td>
			<td><input type="text" id="id" name="id" value="${id}"/></td>
		</tr>
		<tr>
			<td><label for="pw">PW</label></td>
			<td><input type="password" id="pw" name="pw" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<a href="users.html"> 회원가입 </a>
				<span style="color: red;"> ${msg}</span>
			</td>
		</tr>	
	</table>
</form>


</section>
</div>
<%@include file="../common/footer.jsp" %>

<script>
function check(){
	let id = document.querySelector("#id");
	let pw = document.querySelector("#pw");
	
	if(id.value.trim().length < 5 ){
		alert("ID를 5글자 이상 입력하세요.");
		id.focus(); //위 문장 수행 후, id로 커서 이동
	}
}
</script>

</body>

</html>