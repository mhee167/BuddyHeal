<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제이엠 컴퍼니</title>
	<link rel="stylesheet" href="../css/member.css">
</head>
<body>
	<%@ include file="../header.jsp" %>

	<div id="container">
		<div class="join_success">
			<h2 class="title">
				${user_id}님,<br>
				회원가입이 완료되었습니다!
			</h2>
			<a href="${pageContext.request.contextPath}/member/login.jsp" class="btn">로그인하러 가기</a>
	    </div>
    </div>
    
    <%@ include file="../footer.jsp" %>
</body>
</html>