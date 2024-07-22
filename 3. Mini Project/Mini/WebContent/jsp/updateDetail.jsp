<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.BoardDTO" %>
<%@ page import="dao.BoardDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="util.MyUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css">
    <style>
        @font-face {
            font-family: 'LeferiPoint-WhiteObliqueA';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        body {
            font-family: LeferiPoint-WhiteObliqueA;
        }
        #board-form {
            margin-top: 340px; /* 중앙 정렬 */
        }
        input[type="submit"] {
            margin-left: 850px;
            display: flex;
        }
    </style>
    <script>
        document.getElementById("updateForm").addEventListener("submit", function(event) {
            event.preventDefault(); // 기본 제출 동작을 막음
            // 폼을 제출한 후 리다이렉트할 URL
            var redirectUrl = "${pageContext.request.contextPath}/memberServlet?command=detail&board_id=${param.id}";
            window.location.href = redirectUrl;
        });
    </script>
</head>
<body>
<div id="container">
    <div id="call">
        <img id="logo2" src="${pageContext.request.contextPath}/img/logo2.png">
    </div>
    <nav>
        <div class="container">
            <div id="icon">
                <div class="icon-item">
                    <img src="${pageContext.request.contextPath}/img/icon2.png" alt="Menu Image">
                    <div class="menu">
                        <a href="${pageContext.request.contextPath}/jsp/login.jsp">로그인</a>
                        <a href="${pageContext.request.contextPath}/jsp/join.jsp">회원가입</a>
                    </div>
                </div>
                <img src="${pageContext.request.contextPath}/img/icon3.png">&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/board.jsp">
                    <img src="${pageContext.request.contextPath}/img/icon1.png">&nbsp;&nbsp;&nbsp;
                </a>
            </div>
        </div>
    </nav>
    <header>
        <img src="${pageContext.request.contextPath}/img/header.png">&nbsp;&nbsp;&nbsp;
    </header>
     <div id="contents">
        <fieldset>
            <ul>
                <h1>게시판</h1>
                <hr>
                <div class="blank"></div>
                
                <div class="blank"></div>
                <div id="section2">
                    <!-- 수정 폼 -->
                    <!-- 제목이 없어서 안들어가짐 -->
                    <form id="updateForm" action="${pageContext.request.contextPath}/memberServlet" method="post">
                    <div id="section1"> 
                    		제목: <input type="text" id="title" name="title" value="${detail.title}" style="border: none;"><br>
                   		 비밀글: <input type="checkbox" id="is_public" name="secret" value="yes"><br>
                </div>
                        <input type="hidden" name="command" value="updateBoard">
                        <input type="hidden" name="board_id" value="${param.id}">
                        <textarea id="content" name="content" rows="5" style="border: none;">${detail.content}</textarea><br>
                        <input type="submit" value="수정완료" onclick="return confirmUpdate()" style="margin-right: 100px; margin-top: 10px;">
                    </form>
                </div>
                <br>
                <a href="${pageContext.request.contextPath}/jsp/board.jsp">목록으로 돌아가기</a>
            </ul>
        </fieldset>
    </div>
    <div id="footer">
    </div>
</div>
<footer>
    <img id="phonenum" src="${pageContext.request.contextPath}/img/call.png">
</footer>
</body>
</html>
