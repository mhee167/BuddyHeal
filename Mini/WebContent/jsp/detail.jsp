<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.BoardDTO" %>
<%@ page import="dao.BoardDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="util.MyUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
    String cp = request.getContextPath();
    BoardDAO dao = new BoardDAO();
    List<BoardDTO> BoardList = dao.selectBoard("*");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="<%= cp %>/css/detail.css">
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

                a#update-button{     /* 수정하기 링크 스타일 */
			    color: #fff;
			    font-size: 16px;
			    background-color: #6A24FE;
			    padding: 10px 20px;
			    border: none;
			    border-radius: 70px; /* 둥근 모서리 */
			    text-decoration: none; /* 링크의 기본 밑줄 제거 */
			    display: inline-block; /* 인라인 블록 요소로 표시 */
			    margin-top: 55px;
			    margin-left: 3px; /* 삭제 버튼과의 간격 조정 */
						}
			input[type="submit"]  {     /* 수정하기 링크 스타일 */
			    font-size: 16px;
			    background-color: #f1f1f1;
   				 color: black;
			    padding: 10px 20px;
			    border: none;
			    border-radius: 70px; /* 둥근 모서리 */
			    text-decoration: none; /* 링크의 기본 밑줄 제거 */
			    display: inline-block; /* 인라인 블록 요소로 표시 */
			    margin-top: 55px;
			    margin-left: 3px; /* 삭제 버튼과의 간격 조정 */
						}
			#button-container {
 				position: relative;
    		    right: -550px; /* 오른쪽으로 20px 이동 */			
			}
			.action-button {
			    display: inline-block;
			    padding: 8px 16px; /* 내부 여백 */
			    text-decoration: none; /* 밑줄 제거 */
			    border: none; /* 테두리 없음 */
			    cursor: pointer; /* 포인터 커서 */
			    margin-right: 20px; /* 오른쪽 여백 */
			}
			    a.back-link {
		        display: inline-block;
		        margin-left: -190px; /* 왼쪽으로 20px 이동 */
		        margin-top: -50px; /* 위로 50px 이동 */
		    }
			
    </style>
    <script>
        function confirmDelete() {
            var result = confirm("정말 삭제하시겠습니까?");
            if (result) {
                document.getElementById("deleteForm").submit();
            }
            return false;
        }

        function confirmUpdate() {
            var result = confirm("정말 수정하시겠습니까?");
            if (result) {
                document.getElementById("updateForm").submit();
            }
            return false;
        }
    </script>
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
    <div id="contents">
        <fieldset>
            <ul>
                <h1>게시판</h1>
                <hr>
                <div class="blank"></div>
                <div id="section1">
                    <c:choose>
                        <c:when test="${not empty detail}">
                            <h2>제목: ${detail.title}</h2><br> &nbsp;&nbsp;&nbsp;&nbsp;
                            <p>작성자: ${detail.author}</p><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <p>조회수: ${detail.count}</p><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <p>작성일: ${detail.regdate}</p><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <form action="${pageContext.request.contextPath}/memberServlet" method="get">
							    <input type="hidden" name="board_id" value="${detail.boardId}">
               				    <input type="hidden" name="command" value="likes">
							    <button type="submit" style="border:none;">♡ 좋아요 ${detail.likes}</button>
							</form>

                        </c:when>
                        <c:otherwise>
                            <p>해당 게시글을 찾을 수 없습니다.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="blank"></div>
                <div id="section2">
                    <p>&nbsp;&nbsp;&nbsp;&nbsp; ${detail.content}</p><br>
                </div>
                <br>
                <a class="back-link" href="${pageContext.request.contextPath}/jsp/board.jsp">목록으로 돌아가기</a>

                <div id="button-container">
                    <a id="update-button" href="${pageContext.request.contextPath}/jsp/updateDetail.jsp?id=${detail.boardId}" class="action-button">수정하기</a>
                    <form id="deleteForm" action="${pageContext.request.contextPath}/memberServlet" method="get" class="action-button">
                        <input type="hidden" name="command" value="delBoard">
                        <input type="hidden" name="board_id" value="${detail.boardId}">
                        <input type="submit" value="삭제" onclick="return confirmDelete()">
                    </form>
                </div>
                <div id="footer"></div>
            </ul>
        </fieldset>
    </div>
</div>

<footer>
    <img id="phonenum" src="<%= cp %>/img/call.png">
</footer>
</body>
</html>
