<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
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
	<link rel="stylesheet" href="./css/layout.css">
	<link rel="stylesheet" href="./css/main.css">
	<script type="text/javascript" src="slider.js"></script>
</head>
<body>
	<header>
		<div class="wd_contents flex">
	        <h1><a href="/Mini/index.html">제이엠 컴퍼니</a></h1>
	        
	        <nav>
		        <ul class="flex">
		            <li><a href="./main.jsp">게시판</a></li>
		            <li><a href="./address/list.jsp">주소록 관리</a></li>
		        </ul>
	        </nav>
	        
	        <div class="login">
	        	<c:choose>
	            	<c:when test="${ValidMem eq 'yes'}">
	            		<a href="${pageContext.request.contextPath}/frontcontroller/member/load"><img src="./image/ic_mypage.svg" alt="마이페이지"></a>
            			<a href="${pageContext.request.contextPath}/frontcontroller/member/logout"><img src="./image/ic_logout.svg" alt="로그아웃"></a>
	            	</c:when>
	            	<c:otherwise>
	            		<a href="./member/login.jsp"><img src="./image/ic_login.svg" alt="로그인"></a>
	            	</c:otherwise>
	            </c:choose>
        	</div>
        </div>
    </header>
	
	<div id="container">
		<!-- 메인 배너 -->
        <div class="main_banner">
	       <div>
	           <ul class="slider">
	               <li><a href="./address/list.jsp"><img src="./image/bn_main01.jpg" alt="주소록 보러가기"></a></li>
	               <li><a href="#none"><img src="./image/bn_main02.jpg" alt="제이엠 컴퍼니 내부 사이트 OPEN"></a></li>
	               <li><a href="./address/list.jsp"><img src="./image/bn_main01.jpg" alt="주소록 보러가기"></a></li>
	               <li><a href="#none"><img src="./image/bn_main02.jpg" alt="제이엠 컴퍼니 내부 사이트 OPEN"></a></li>
	               <li><a href="./address/list.jsp"><img src="./image/bn_main01.jpg" alt="주소록 보러가기"></a></li>
	               <li><a href="#none"><img src="./image/bn_main02.jpg" alt="제이엠 컴퍼니 내부 사이트 OPEN"></a></li>
	           </ul>
	       </div>
	       <div class="btn_slide btn_slide_prev"><img src="./image/btn_arrow_left.svg" alt="이전 버튼"></div>
	       <div class="btn_slide btn_slide_next"><img src="./image/btn_arrow_right.svg" alt="다음 버튼"></div>
	   	</div>
        <!-- // 메인 배너 -->
        
        <!-- 퀵메뉴 -->
        <ul class="quick_menu flex">
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴1">
        			<span>메뉴 1</span>
        		</a>
        	</li>
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴2">
        			<span>메뉴 2</span>
        		</a>
        	</li>
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴3">
        			<span>메뉴 3</span>
        		</a>
        	</li>
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴4">
        			<span>메뉴 4</span>
        		</a>
        	</li>
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴5">
        			<span>메뉴 5</span>
        		</a>
        	</li>
        	<li>
        		<a href="#none">
        			<img src="./image/bn_quick_01.png" alt="퀵 메뉴6">
        			<span>메뉴 6</span>
        		</a>
        	</li>
        </ul>
        <!-- // 퀵메뉴 -->
        
        <!-- 회사 소개 -->
        <section class="company">
            <div class="wd_contents">
                <h2 class="title">제이엠 직원분들<br>환영합니다!</h2>
                <p>
			                    제이엠 컴퍼니 내부 사이트는 우리의 팀이 함께 성장하고 협업하는 공간입니다.<br>
			                    소통을 통해 함께 성장해 나가는 과정을 만들기 위해 내부 사이트가 제작되었습니다.<br>
			                    제이엠 컴퍼니 내부 사이트에서 팀원들과 소통하고 협력하여 더 나은 미래를 만들어보세요!<br>
                </p>
                <p></p>
                <a href="./address/write.jsp" class="btn">주소록 작성하러 가기</a>
            </div>
        </section>
        <!-- // 회사 소개 -->
        
        <!-- 공지사항 배너 -->
        <div class="notice_banner wd_contents">
        	<a href="#none"><img src="./image/bn_notice.jpg" alt="회사 공지사항"></a>
        </div>
        <!-- // 공지사항 배너 -->
    </div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>