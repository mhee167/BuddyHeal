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
        <div class="wd_contents">
            <form id="login" method="post" action="${pageContext.request.contextPath}/frontcontroller/member/login">
                <h2 class="title">로그인</h2>
                <fieldset>
                    <legend>로그인</legend>
                        <input type="text" name="user_id" placeholder="아이디">
                        <input type="password" name="user_pw" placeholder="비밀번호">
                </fieldset>
                <div class="clear">
                	<a href="./join.jsp">회원 가입</a>
                	<ul class="right flex">
                        <li><a href="#none">아이디찾기</a></li>
                        <li><a href="#none">비밀번호찾기</a></li>
                    </ul>
                </div>
                <input type="submit" value="로그인" class="btn_login">
                <input type="reset" value="취소" class="btn_reset">
            </form>
        </div>
    </div>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>