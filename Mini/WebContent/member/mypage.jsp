<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<%
	String user_id=(String)session.getAttribute("user_id");
	String user_name=(String)session.getAttribute("user_name");
	String user_pw=(String)session.getAttribute("user_pw");
	String user_phone=(String)session.getAttribute("user_phone");
	String user_email=(String)session.getAttribute("user_email");

%>
<head>
	<meta charset="UTF-8">
	<title>제이엠 컴퍼니</title>
	<link rel="stylesheet" href="../css/member.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
    <div id="container">
        <div class="mypage">
            <div class="inner">
                <div class="profile">
                    <img src="../image/ic_profile.svg" alt="프로필 이미지">
                    <span class="id">${user_name}<b>${user_id}</b></span>
                    
                    <ul class="pf_detail">
                       
                        <li class="tel">
                            <img src="../image/ic_phone.svg" alt="핸드폰 번호">
                            <span>${user_phone}</span>
                        </li>
                        <li class="email">
                            <img src="../image/ic_email.svg" alt="이메일 주소">
                            <span>${user_email}</span>
                        </li>
                    </ul>
                    
                    <a href="./modify.jsp" class="btn">회원 정보 수정</a>
                    <p class="announ">* 회원 정보의 변경 사항 확인을 위해 마이페이지를 다시 클릭해 주세요.</p>
                </div>
            </div>
        </div>
    </div>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>