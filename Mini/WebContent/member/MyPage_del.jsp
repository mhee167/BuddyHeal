<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="frontcontroller.*;" %>
    
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao=MemberDAO.getInstance();
	dao.delMember((String)session.getAttribute("user_id"));
%>
<script language="javascript">
	alert("회원 탈퇴가 완료되었습니다.");
	session.invalidate();
	response.sendRedirect("../index.jsp");
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>