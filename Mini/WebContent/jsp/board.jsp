<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.BoardDTO" %>
<%@ page import="dao.BoardDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="util.MyUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <!--bootstrap css-->
    <link rel="stylesheet" href="<%= cp %>/css/board.css">
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

        table {
            border: none;
        }
        .btn-group.pagination {
	        	width:200px;
	        	height:30px;
			    position: relative;
			    display: flex;
	    		justify-content: flex-end; /* li 요소들을 오른쪽에 정렬 */
			    
			    bottom: -700px; /* 원하는 위치 설정 */
			    left: 40%; /* 가운데 정렬 */
			    transform: translateX(-50%); /* 가운데 정렬 */
	}
    </style>
    <script>
        window.onload = function() {
            if (!window.location.href.includes("page=")) {
                window.location.href = "<%= request.getContextPath() %>/BoardListServlet?page=0";
            }
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
                    <details>
                        <summary>전체</summary>
                        <div class="dropdown-content">
                            <span>제목</span>
                            <span>작성자</span>
                        </div>
                    </details>
                    <div id="query-form">
                        <input id="query-input" type="text" name="query" placeholder="검색어를 입력하세요...">
                        <button id="search-button" type="submit">
                            <img src="<%= cp %>/img/search.png" alt="Search">
                        </button>
                    </div>
                </div>
                <div class="blank"></div>
                <div id="section2">
                    <table border="0" align="center">
                        <tr align="center">
                            <td class="board_id">번호</td>
                            <td class="subject">제목</td>
                            <td class="name">작성자</td>
                            <td class="created">작성일</td>
                            <td class="hitCount">조회수</td>
                            <td class="like">좋아요</td>
                        </tr>
                        
            <<c:forEach var="board" items="${list}">
				    <tr>
				        <td>${board.boardId}</td>
				        <td>
				            <form action="${pageContext.request.contextPath}/memberServlet" method="get" style="display:inline;">
				                <input type="hidden" name="command" value="detail">
				                <!-- board_id를 넘김 -->
				                <input type="hidden" name="board_id" value="${board.boardId}">
				                <button type="submit" style="background:none; border:none; color:blue; text-decoration:underline; cursor:pointer;">
				                    ${board.title}
				                </button>
				            </form>
				        </td>
				        <td>${board.author}</td>
				        <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
				        <td>${board.count}</td>
				        <td>${board.likes}</td>
				    </tr>
				</c:forEach>

                        
                    </table>
                </div>
                <!-- 글쓰기 버튼 -->
                <div id="write-button">
                    <a href="<%= cp %>/jsp/boardWrite.jsp">
                        <input type="submit" value="글쓰기">
                    </a>
                </div>
                <input type="hidden" name="command" value="boardInsert" />
                <div id="footer">
                    <%-- <%= pageIndexList %> --%>
                </div>
            </ul>
        </fieldset>
    </div>
    
    <!-- 페이지네이션 부분 -->
    <ul class="btn-group pagination">
        <c:if test="${pageDTO.prev}">
            <li>
                <a href='<c:url value="/BoardListServlet?page=${pageDTO.startPage-1}"/>'>
                    <i class="fa fa-chevron-left"></i>
                </a>
            </li>
        </c:if> 
        <c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}" var="pageNum">
            <li>
                <a href='<c:url value="/BoardListServlet?page=${pageNum}"/>'>
                   ${pageNum}&nbsp;&nbsp;&nbsp;
                </a>
            </li>
        </c:forEach>
        <c:if test="${pageDTO.next && pageDTO.endPage > 0}">
            <li>
                <a href='<c:url value="/BoardListServlet?page=${pageDTO.endPage+1}"/>'>
                    <i class="fa fa-chevron-right"></i>
                </a>
            </li>
        </c:if>
    </ul>
    
</div>

<footer>
    <img id="phonenum" src="<%= cp %>/img/call.png">
</footer>
</body>
</html>
