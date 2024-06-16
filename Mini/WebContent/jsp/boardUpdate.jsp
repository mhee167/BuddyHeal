<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if (session.getAttribute("ValidMem") != null) { %>
    <jsp:forward page="main.jsp" />
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
<!--bootstrap css-->
  
<link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap/bootstrap.css">
<link rel="stylesheet" href="../css/board.css">
<style>@font-face {
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
       
         <!-- <header>

        </header> -->
        <div id="call">
          <img id="logo2" src="../img/logo2.png" >
        </div>
       <nav >
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
              <img src="../img/header.png" >&nbsp;&nbsp;&nbsp;
        </header>
        <div id="contents">
          
                <fieldset>

                    <ul>
                        <h1>게시판</h1>
                    <hr>
                    <div class="blank"></div>

                    
                    <div id="section1">
                        <details style="inset-inline-start: ;">
                            <summary>전체</summary>
                            전체<br>
                            제목<br>
                            작성자
                        </details>
                        <form id="query-form" action="/search" method="GET">
                            <input id="query-input" type="text" name="query" placeholder="검색어를 입력하세요...">
                            <button id="search-button" type="submit">
                                <img src="../img/search.png" alt="Search">
                            </button>
                        </form>
                   
                    </div>
                    <div class="blank"></div>
                    <div id="section2">
                        <table border="1" align="center">
                                <tr align=center>
                                    <td><p>작성번호</p></td> 
                                    <td><p>제목</p></td>
                                    <td><p>작성자</p></td> 
                                    <td><p>작성일</p></td> 
                                    <td><p>조회수</p></td> 
                                    <td><p>좋아요</p></td> 

                        
                                </tr>
                                <tr>
                                    <td>${id}</td>
                                    <td>${pwd}</td>
                                    <td>${name}</td>
                                    <td>${age}</td>
                                    <td>${height}</td>
                                    <td>${height}</td>

                            
                                </tr>
                                
                                </table>
                </div>
               
                   
                      
                    </ul>
                </fieldset>



                
                  <input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp;&nbsp;
               
        </div>
        <div class = "navigator">
            페이징

            전체 글개수 : ${totalRecordCount }<br>
            ◁
            <c:forEach var ="page" begin="1" end = "${totalPageCount }">
                <c:if test = "${currentPage eq page}">
                    <span style = "color : red; font-weight: bold">"${page}"</span>
                </c:if>
                <c:if test = "${currentPage ne page}">
                    <a href = "boardlist?currentPage=${page }&currentPage=${page}&searchItem=${ searchItem}&searchWord=${searchWord}">
                        ${page} &nbsp;
                    </a>
                </c:if>
            </c:forEach>
            ▷
        </div>
		</main>
	
	</div>
  <footer>
    <img id="phonenum" src="../img/call.png" >
 </footer>
	

</body>
</html>