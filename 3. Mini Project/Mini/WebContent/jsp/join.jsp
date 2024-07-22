<%@ page language="java" contentType="text/html; charset=UTF-8"
 import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <!--bootstrap css-->
    <link rel="stylesheet" href="../css/join.css">
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
    <script>
        function showAlert() {
            alert("PUPPY CHAT의 이용자가 되신걸 환영합니다.");
        }
    </script>
</head>
<body>
    <div id="container">
        <div id="call">
            <img id="logo2" src="../img/logo2.png" >
        </div>
        <nav>
            <div class="container">
                <div id="icon">
                    <img src="../img/icon2.png" alt="Menu Image">
                    <div class="menu">
                        <a href="/login.jsp">로그인</a>
                        <a href="/join.jsp">회원가입</a>
                    </div>&nbsp;&nbsp;&nbsp;
                    <img src="../img/icon3.png" >&nbsp;&nbsp;&nbsp;
                    <a href="board.html">
                        <img src="../img/icon1.png" >&nbsp;&nbsp;&nbsp;
                    </a>
                </div>
            </div>
        </nav>
        <header>
            <img src="../img/header.png">
        </header>
        <div id="contents">
            <fieldset>
                <form name="frmMember" method="post" id="join-form" action="/Mini/memberServlet">
                    <ul>
                        <p> 구분 </p>
                        <hr>
                        <li>
                            <label for="id"> 아이디 &nbsp;<span class="star">*</span> :</label>
                            <input name="id" type="text" id="id" placeholder="id " required>
                        </li>
                        <li>
                            <label for="pwd">비밀번호 &nbsp;<span class="star">*</span> :</label>
                            <input name="pwd" type="password" id="pwd1" placeholder="password" required >  
                        </li>  
                        <li>
                            <label for="name"> 이름&nbsp;<span class="star">*</span>:</label>
                            <input name="name" type="text" id="name" placeholder="이름" required >
                        </li>
                        <li>
                            <label for="addr">주소 </label>
                            <input name="address" type="text" id="address" placeholder="00시 00구" required >
                        </li>     
                        <li>
                            <label for="price">전화번호&nbsp;<span class="star">*</span> :</label>
                            <input name="phone" type="tel" id="phone" placeholder="000-0000-0000" required >
                        </li>
                        <li>
                            <label for="mail">이메일</label>
                            <input name="email" type="email" id="email" placeholder="퍼피@ gmail.com" required >
                        </li>     
                    </ul>
                    <div id="buttons">
                        <input type="submit" value="가입하기" onclick="showAlert()">
                        <input type="reset" value="취소">
                        <input type="hidden" name="command" value="insertMember" />
                    </div>
                </form> 
            </fieldset>
        </div>
        <footer></footer>
    </div>
    <footer>
        <img id="phonenum" src="../img/call.png" >
    </footer>
</body>
</html>
