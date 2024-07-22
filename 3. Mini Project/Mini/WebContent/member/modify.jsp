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
        <div class="member_modify">
            <form id="m_modify" method="post" action="${pageContext.request.contextPath}/frontcontroller/member/modify">
                <h2 class="title">회원 정보 수정</h2>
                
                <table>
                    <colgroup>
                        <col style="width:140px;">
                        <col style="width:auto;">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>아이디<span class="required">필수 항목</span></th>
                            <td><input type="text" name="user_id" placeholder="아이디"></td>
                        </tr>
                        <tr>
                            <th>이름<span class="required">필수 항목</span></th>
                            <td><input type="text" name="user_name" placeholder="이름"></td>
                        </tr>
                        <tr>
                            <th>비밀번호<span class="required">필수 항목</span></th>
                            <td><input type="password" name="user_pw" placeholder="비밀번호 (5자 이상)"></td>
                        </tr>
                        <tr>
                            <th>비밀번호 확인<span class="required">필수 항목</span></th>
                            <td><input type="password" name="user_pw_re" placeholder="비밀번호 (5자 이상)"></td>
                        </tr>
                        <tr>
                            <th>전화번호<span class="required">필수 항목</span></th>
                            <td><input type="tel" name="user_phone" placeholder="전화번호 (하이픈 포함)"></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td><input type="email" name="user_email" placeholder="이메일"></td>
                        </tr>
                    </tbody>
                </table>
                
                <div class="btn_modify">
                    <input type="submit" value="수정하기">
                </div>
            </form>
            
            <div class="m_delete">
       			<a href="${pageContext.request.contextPath}/frontcontroller/member/joinOut">회원탈퇴</a>
       		</div>
        </div>
    </div>
    
    <%@ include file="../footer.jsp" %>
</body>
</html>