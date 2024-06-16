<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.css">
    <link rel="stylesheet" href="../css/board.css">
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

        #myCheckbox {
            margin-left: 30px;
        }

        #section2 {
            border-radius: 20px;
            align-items: center; /* 세로 중앙 정렬 */
            width: 700px;
            height: 300px;
            background-color: #F1f1f1;
            display: flex;
            flex-direction: column; /* 수직 배치 */
            justify-content: center; /* 중앙 정렬 */
            padding: 20px;
            margin: 20px auto; /* 중앙 정렬 */
        }

        #query-form {
            display: flex;
            align-items: center;
            max-width: 700px;
            
        }

        #query-input, #content-input {
         border: none;
        
            flex: 1;
            height: 48px;
            padding: 0 10px;
            border-radius: 6px;
            background-color: #F1f1f1;
           transition: border-color 0.1s ease-in-out; /* 테두리 변화에 대한 transition 효과 추가 */
            
        }
  /* 입력란 포커스 시 스타일 */
        #query-input:focus, #content-input:focus {
             border-color: #F1f1f1;; /* 포커스 시 테두리 색상 변경 */
            outline: none; /* 포커스 시 기본 아웃라인 제거 */
        }
        input[type="submit"] {
            color: #fff;
            font-size: 16px;
            background-color: #6A24FE;
            padding: 10px 20px;
            border: none;
            border-radius: 70px; /* 둥근 모서리 */
            margin-top: 20px;
        }
        
        #board-form{
            margin-top: 340px; /* 중앙 정렬 */
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="call">
            <img id="logo2" src="../img/logo2.png">
        </div>
        <nav>
            <div class="container">
                <div id="icon">
                    <div class="icon-item">
                        <img src="../img/icon2.png" alt="Menu Image">
                        <div class="menu">
                            <a href="/login.jsp">로그인</a>
                            <a href="/join.jsp">회원가입</a>
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
        <div id="contents">
            <fieldset>
                <ul>
                    <h1>게시판</h1>
                    <hr>
                    <div class="blank"></div>
                    <div class="blank"></div>
                    
                    <div id="section1"> 제목:
                    	
                        <form name="frmMember" id="board-form" action="/Mini/memberServlet" method="POST">
                            <div id="query-form">
                               <input id="query-input" type="text" name="title" placeholder="제목을 입력하세요...">
                                <label  id="myCheckbox">비밀글</label>
    							<input type="checkbox" id="myCheckbox" name="secret" value="yes">
                                
                            </div>
                            <div id="section2">
                                <input id="content-input" type="text" name="content" placeholder="내용을 입력하세요">
                                <input type="submit" value="글쓰기">
                                <input type="hidden" name="command" value="boardInsert">
                            </div>
                        </form>
                    </div>
                    <div class="blank"></div>
                </ul>
            </fieldset>
        </div>
    </div>
    <footer>
        <img id="phonenum" src="../img/call.png">
    </footer>
</body>
</html>
