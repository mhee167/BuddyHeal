<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ValidMem=(String)session.getAttribute("ValidMem");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제이엠 컴퍼니</title>
	<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
	<link rel="stylesheet" href="../css/layout.css">
</head>
<body>
	<header>
		<div class="wd_contents flex">
	        <h1><a href="/Mini/index.jsp">제이엠 컴퍼니</a></h1>
	        
	        <nav>
		        <ul class="flex">
		            <li><a href="#none">게시판</a></li>
		            <li><a href="${pageContext.request.contextPath}/address/list.jsp">주소록 관리</a></li>
		        </ul>
	        </nav>
	        
	        <div class="login">
	        	<c:choose>
	            	<c:when test="${ValidMem eq 'yes'}">
	            		<a href="${pageContext.request.contextPath}/frontcontroller/member/load"><img src="../image/ic_mypage.svg" alt="마이페이지"></a>
            			<a href="${pageContext.request.contextPath}/frontcontroller/member/logout"><img src="../image/ic_logout.svg" alt="로그아웃"></a>
	            	</c:when>
	            	<c:otherwise>
	            		<a href="${pageContext.request.contextPath}/member/login.jsp"><img src="../image/ic_login.svg" alt="로그인"></a>
	            	</c:otherwise>
	            </c:choose>
        	</div>
        </div>
    </header>
</body>
</html>