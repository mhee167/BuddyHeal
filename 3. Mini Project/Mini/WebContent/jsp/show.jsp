<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*, dto.MemberDTO, dao.MemberDAO" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.sql.Date" %>

<%
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");

    // DB에서 회원 정보를 가져옴
    MemberDAO dao = new MemberDAO();
    List<MemberDTO> memberList = dao.selectMember("*");
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록 창</title>
    <style>@font-face {
        font-family: 'LeferiPoint-WhiteObliqueA';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff') format('woff');
        font-weight: normal;
        font-style: normal;
    }

    body {
        font-family: LeferiPoint-WhiteObliqueA;
    }
     .modal {
            display: none; 
            position: fixed; 
            z-index: 1; 
            padding-top: 60px; 
            left: 0;
            top: 0;
            width: 100%; 
            height: 100%; 
            overflow: auto; 
            background-color: rgb(0,0,0); 
            background-color: rgba(0,0,0,0.4); 
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%; 
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;}
    </style>
    <script>
        // 모달 열기
        // 모달 열기
			function openModal(memberId) {
			    document.getElementById('myModal').style.display = "block";
			    // 모달 내 input 요소에 memberId 값을 할당
			    
			    document.getElementById('memberId').value = memberId;
			}


        // 모달 닫기
        function closeModal() {
            document.getElementById('myModal').style.display = "none";
        }

        // 모달 외부 클릭 시 닫기
        window.onclick = function(event) {
            var modal = document.getElementById('myModal');
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</head>
<body>
    <table border="1" >
	        <tr align="center">
	            <td><strong>아이디</strong></td>
	            <td><strong>비밀번호</strong></td>
	            <td><strong>이름</strong></td>
	            <td><strong>주소</strong></td>
	            <td><strong>휴대전화</strong></td>
	            <td><strong>이메일</strong></td>
	            <td><strong>삭제</strong></td>
	    		<td><strong>수정</strong></td>
	            
	        </tr>
        <!-- DB에서 가져온 정보를 출력 -->
		<% for (int i = 0; i < memberList.size(); i++) { 
		    MemberDTO member = memberList.get(i); %>
		    <tr>
		        <td><%= member.getId() %></td>
		        <td><%= member.getPwd() %></td>
		        <td><%= member.getName() %></td>
		        <td><%= member.getAddress() %></td>
		        <td><%= member.getPhone() %></td>
		        <td><%= member.getEmail() %></td>
		        <td><a href="/BoardProject/memberServlet?command=delMember&id=<%= member.getId() %>">삭제</a></td>
		        <td><button onclick="openModal('<%= member.getId() %>')">수정</button></td>
					
		
		    </tr>
		<% } %>
    </table>

	<!-- 모달창 열림 -->
	<div id="myModal" class="modal">
	    <div class="modal-content">
	        <span class="close" onclick="closeModal()">&times;</span>
	        <form action="${pageContext.request.contextPath}/memberServlet?command=updateMember" method="post">
	            <input type="hidden" id="memberId" name="id">
	            <p><label for="pwd">비밀번호:</label> <input type="password" id="pwd" name="pwd"></p>
	            <p><label for="name">이름:</label> <input type="text" id="name" name="name"></p>
	            <p><label for="address">주소:</label> <input type="text" id="address" name="address"></p>
	            <p><label for="phone">전화번호:</label> <input type="text" id="phone" name="phone"></p>
	            <p><label for="email">이메일:</label> <input type="text" id="email" name="email"></p>
	            <button type="submit">수정완료</button>
	        </form>
	    </div>
	</div>

		 
</body>
</html>
