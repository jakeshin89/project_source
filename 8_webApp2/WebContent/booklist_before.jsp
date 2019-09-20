<%@page import="service.BookServiceImpl"%>
<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="service.BookService"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> BookList </title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>

<body>

<h3> BookList </h3>

<table class="tablea">
	<tr>
		<th> Book ID </th>
		<th> Book Name </th>
		<th> Book Publisher </th>
		<th> Book Price </th>
	</tr>

<%
	//자바코드
	//BookDao dao = new BookDao();
	//BookService service = new BookServiceImpl(dao);
	//List<BookVO> list = service.bookList();
	
	List<BookVO> list = (List<BookVO>)request.getAttribute("booklist");
	for(BookVO d: list){
%>

	<tr>
		<td> <%= d.getBookid() %> </td>
		<td> <%= d.getBookname() %> </td>
		<td> <%= d.getPublisher() %> </td>
		<td> <%= d.getPrice() %> </td>
	</tr>

<%} %>

</table>

</body>
</html>