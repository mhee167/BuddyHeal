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
	<script language="Javascript" src="validation.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>

	<div id="container">
        <form name="join_frm" id="join" method="post" action="${pageContext.request.contextPath}/frontcontroller/member/join">
        	<h2 class="title">회원 가입</h2>
        	
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
			
			<div class="agree_area terms_agree">
				<h3>이용 약관 동의<span class="required">필수 항목</span></h3>
				<div class="content">
					<p>
						제1조(목적)<br>
				                        이 약관은 OO 회사(전자상거래 사업자)가 운영하는 OO 사이버 몰(이하 “몰”이라 한다)에서 제공하는 인터넷 관련 서비스(이하 “서비스”라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리․의무 및 책임사항을 규정함을 목적으로 합니다.
				                        ※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」
				                        제2조(정의)<br>
				                        ① “몰”이란 OO 회사가 재화 또는 용역(이하 “재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.
				                        ② “이용자”란 “몰”에 접속하여 이 약관에 따라 “몰”이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
				                        ③ ‘회원’이라 함은 “몰”에 회원등록을 한 자로서, 계속적으로 “몰”이 제공하는 서비스를 이용할 수 있는 자를 말합니다.
				                        ④ ‘비회원’이라 함은 회원에 가입하지 않고 “몰”이 제공하는 서비스를 이용하는 자를 말합니다.
					</p>
				</div>
                <input id="terms" type="checkbox" name="agree_terms"><label for="terms">동의함</label>
			</div>
			
			<div class="agree_area privacy_agree">
				<h3>개인정보 수집 및 이용 동의<span class="required">필수 항목</span></h3>
				<div class="content">
					<p>
						1. 개인정보 수집목적 및 이용목적<br>
						2. 수집하는 개인정보 항목 : 이름 , 로그인ID , 비밀번호 , 이메일 <br>
						3. 개인정보의 보유기간 및 이용기간<br>
						원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다.<br>
						단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다.<br>
						※ 동의를 거부할 수 있으나 거부시 회원 가입이 불가능합니다.<br>
					</p>
				</div>
                <input id="privacy" type="checkbox" name="agree_privacy"><label for="privacy">동의함</label>
			</div>
			
			<div class="btn_join">
				<input type="button" value="회원가입" onclick="joinConfirm()">
			</div>
        </form>
    
    </div>
    
    <%@ include file="../footer.jsp" %>
</body>
</html>