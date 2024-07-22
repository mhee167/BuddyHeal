<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>



<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>

<div id="container"> <!-- 로고 이미지, 네비게이션 바, 헤더 이미지 -->
    <div id="call">
        <a href="../main.jsp">
            <img id="logo2" src="../img/logo2.png" >
        </a>
    </div>
    <nav>
        <div class="container">
            <div id="icon">
                <div class="icon-item">
                    <img src="../img/icon2.png" alt="Menu Image">
                    <div class="menu">
                        <a href="./login.jsp">로그인</a>
                        <a href="./join.jsp">회원가입</a>
                    </div>
                </div>
                <img src="../img/icon3.png">&nbsp;&nbsp;&nbsp;
                <a href="board.html">
                    <img src="../img/icon1.png">&nbsp;&nbsp;&nbsp;
                </a>
            </div>
        </div>
    </nav>
    <header>
        <img src="../img/header.png">
    </header>
    <div id="contents"> <!-- 로그인 폼 정의. -->
        <fieldset>
            <form  name="frmMember2" method="post" id="login-form" action="/Mini/memberServlet" >

                <ul>
                    <li>로그인</li>
                    <link href="https://fonts.google.com/specimen/Black+Han+Sans?preview.text=%EB%A1%9C%EA%B7%B8%EC%9D%B8&subset=korean&noto.script=Kore" rel="stylesheet">
                    <hr style="width: 400px; margin-left: 0; transform: scale(1.3);">
                    <li>
                        <input name="id" type="text" id="id" placeholder="id" required>
                    </li>
                    <li>
                        <input name="pwd" type="password" id="pwd" placeholder="password" required>
                    </li>
                </ul>
                <input type="hidden" name="command" value="userCheckMember" />
                <br>    <br>    <br>
                
                <div class="buttons">
                    <input type="submit" value="로그인" >
                    <input type="reset" value="취소" >
                </div>

                <div class="option">
                    아이디찾기 | 비밀번호찾기 | <a href="./join.jsp">회원가입하기</a>
                </div>
            </form>
        </fieldset>
    </div>

    <%-- login.jsp --%>

    <%
        // 서블릿에서 바인딩한 데이터 받아오기
        String contextData = (String) application.getAttribute("context");
        String sessionData = (String) session.getAttribute("session");
        String requestData = (String) request.getAttribute("request");

        if ("2".equals(sessionData)) {
            System.out.println(sessionData);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
            dispatcher.forward(request, response);
        } else {
            /* <a href="/jsp/login.jsp"></a> */
            System.out.println("다시 로그인하세요");
            session.invalidate();
        }
    %>

    <footer>
        <img id="phonenum" src="../img/call.png" >
    </footer>
</div>

</body>
</html>
