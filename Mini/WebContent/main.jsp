<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/main2.css">
</head>
<body>

<div id="container">

    <div id="call">
        <img id="logo2" src="./img/logo2.png">
    </div>

    <nav></nav>

    <main>
        <div class="transparent-circle"></div>
        <img id="balloon" src="./img/balloon.png">
        <img id="logo" src="./img/logo.png">
        
        <div class="container">
            <div id="icon">
                <img src="./img/icon2.png" alt="Menu Image">
                <div class="menu">
                    <a href="./jsp/login.jsp">로그인</a>
                    <a href="./jsp/join.jsp">회원가입</a>
                </div>
                &nbsp;&nbsp;&nbsp;
                <img src="./img/icon3.png">&nbsp;&nbsp;&nbsp;
                <a href ="board.html">
                    <img src="./img/icon1.png">&nbsp;&nbsp;&nbsp;
                </a>
            </div>
        </div>
    </main>

    <div class="blank"></div>

    <div id="contents">
        <div id="left">
            <a href="./jsp/show.jsp">
                <img src="./img/href1.png">
            </a>
        </div>
        
        <div id="middle">
            <a href="./jsp/join.jsp">
                <img src="./img/href2.png">
            </a>
        </div>
        
        <div id="right">
            <a href="./jsp/board.jsp">
                <img id="purple" src="./img/href3.png">
            </a>
        </div>
    </div>

</div>

<footer>
    <img id="phonenum" src="./img/call.png">
</footer>

</body>
</html>
