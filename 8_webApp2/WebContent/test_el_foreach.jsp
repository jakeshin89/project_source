<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Test el foreach </title>
</head>


<body>

<%
	String[] names = {"홍길동", "고길동"};
	request.setAttribute("listname", names);
%>

<c:forEach var="data" items="${listname}">
	<h3> ${data} </h3>
</c:forEach>

<hr/>
<c:forEach begin="1" end="9" step="2" var="data">
	${data}
</c:forEach>

<%= //null이 들어오면 data 없음, 주소값 들어오면 data 있음.
	request.getAttribute("listname1") 
%>

<hr>

<!-- 위에꺼랑 똑같은 코드. el표현식. 
request객체 뒤져서 없으면 session 에서 없으면 아무것도 안뜸 -->
${listname1}

<hr/>
${2+3+6}

<hr/>
${2 lt 3}

<hr/>
<%= request.getParameter("id") %>

<hr/>
${para.id}

</body>
</html>