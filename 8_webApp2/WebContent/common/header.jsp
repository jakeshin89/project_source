<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <header>
       <hgroup>
		   <h1>Page Title</h1> 
		   <h2>Page SubTitle</h2>
		   <h3>(로그인정보 : ${login})</h3>
		</hgroup>
	 </header>	
	 
		<nav>
		   <ul>
		      <li> <a href="index.jsp">Home</a></li>
		      <li class="dropbox"> 
		            <a id="etc" href="#">게시판</a>
		          <span class="dropmenu">
			          <span> <a href="table1.html" class="btn">자유</a></span>
				      <span> <a href="table2.html" class="btn">문의</a></span>
				      <span> <a href="booklist.do" class="btn">Book</a></span>
				      <span> <a href="#" class="btn">Link4</a></span>
				      <span> <a href="#" class="btn">Link5</a></span>
		          </span>
		      </li>
		      <li> <a href="#">Tutorials</a></li>
		      <li> <a href="#">About</a></li>
		      <c:if test="${empty login}">
			      <li> <a href="login.jsp">Login</a></li>
		      </c:if>
		      <c:if test="${!empty login}">
			      <li> <a href="/logout.do">Logout</a></li>
		      </c:if>      
		   </ul>
		</nav>
		