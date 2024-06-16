boardWrite.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>

<%
    String cp = request.getContextPath(); // Context Path를 가져와 변수에 할당
%>

<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>게시판 글쓰기</title>
        <!--bootstrap css-->
    <link rel="stylesheet" href="../css/boardWrite.css">
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
    </style>
</head>
<body>
<div id="container">
    <div id="call">
        <img id="logo2" src="<%= cp %>/img/logo2.png">
    </div>
    <nav>
        <div class="container">
            <div id="icon">
                <div class="icon-item">
                    <img src="<%= cp %>/img/icon2.png" alt="Menu Image">
                    <div class="menu">
                        <a href="<%= cp %>/jsp/login.jsp">로그인</a>
                        <a href="<%= cp %>/jsp/join.jsp">회원가입</a>
                    </div>
                </div>
                <img src="<%= cp %>/img/icon3.png">&nbsp;&nbsp;&nbsp;
                <a href="<%= cp %>/board.jsp">
                    <img src="<%= cp %>/img/icon1.png">&nbsp;&nbsp;&nbsp;
                </a>
            </div>
        </div>
    </nav>
    <header>
        <img src="<%= cp %>/img/header.png">&nbsp;&nbsp;&nbsp;
    </header>
    <div class="contents">
     
            <ul>
                <h1>수다 글쓰기</h1>
              </ul>
              <div class="bictitle">
              <div class="title"  style="margin-right: 100px; margin-left: -190px;">
                <div id="section1" style="margin-right:70px;">
                   <div id="query-form">
                        <input id="query-input" type="text" name="query" placeholder="제목을 입력해주세요.">
                    </div>
                    </div>
                     <div id="checkbox">
              <label class="checkbox_label large" style="margin-left: -450px;">
    <input type="checkbox" style="transform: scale(2);">
</label>
                    </div>
                    <div id="privacy-options">
                            <img src="<%= cp %>/img/Lock.png" alt="Lock Icon" style="width: 100px; height: auto; margin-left: -700px;">
                      </button>
                    </div>
                    </div>
                <div class="blank"></div>
                <div id="section2">
                  <textarea id="content-input" placeholder="내용을 입력하세요"></textarea>
                   </div>
                </div>
                <!-- 등록 버튼 -->
               <div class="button">
                
                    <a href="<%= cp %>/jsp/board.jsp">
                         <input type="submit" value="등록" class="input-submit">
                          <a href="<%= cp %>/jsp/boardWrite.jsp">
                          <input type="reset" value="취소" class="input-reset">
                    </a>
                </div>
                <input type="hidden" name="command" value="boardInsert" />
                <div id="footer">
                    <%-- <%= pageIndexList %> --%>
                </div>
            </ul>
      
    </div>
<footer>
    <img id="phonenum" src="<%= cp %>/img/call.png">
</footer>
</body>
</html>
