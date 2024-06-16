<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.* , DaoDto.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");

	// 주소록 테이블 가져오기
	AddressDAO dao = new AddressDAO();
	List<AddressDTO> searchList = dao.searchAddress(request.getParameter("find_name"));
	
	// 주소록 목록을 request에 저장
	request.setAttribute("searchList", searchList);
	List<String> imageList=new ArrayList<String>(Arrays.asList("사원","대리","과장","차장","부장","이사","사장"));

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/address.css">
	<title>제이엠 컴퍼니</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
		<div class="searchContainer">
		<div class="addressHeader">
		    <span><a href="/Mini/address/list.jsp">Contact List</a></span>
		    <form method="get" action="list_search.jsp">
			    <input type="text" name="find_name" id="find_name" placeholder="검색하고 싶은 성함을 작성해 주세요.">
			    <input type="submit" value="Search">
			</form>
		</div>
		    
	     
			
		<div id="SearchaddressList">
			<c:choose>
		        <c:when test="${empty searchList}">
		            <p class="nullResult">검색 결과가 없습니다.</p>
		        </c:when>
		        
		        <c:otherwise>
		            <ul>
			            <c:forEach items="${searchList}" var="searchAddress">
			             <li id="search_container" class="floating">
				           		 <div class="list_image">
		                    <div class="image_box">
		                       <img src="../image/${searchAddress.ad_rank}.png" class="profile" /> 		              
		                    	<div class="edit_btn">
				                        	<a href="${pageContext.request.contextPath}/address/modify.jsp?ad_id=${searchAddress.ad_id}"><img src="../image/ic_modify.png" style="width:20px;height:20px; margin-right:7px" /></a>
			                            	<a href="${pageContext.request.contextPath}/frontcontroller/address/delete?ad_id=${searchAddress.ad_id}"><img src="../image/ic_delete.png" style="width:20px;height:20px;"/></a>
				                        </div>
		                    </div>
		                </div>
				                
				                <div class="list_content">
				                    <div class="list_header">
				                        <div id="ad_name">${searchAddress.ad_name}</div>
				                        
				                    </div>
				                    
				                    <div class="list_body">
				                        <div class="company_info">
				                            <div id="ad_department">${searchAddress.ad_department}</div>
				                            <div id="ad_rank">${searchAddress.ad_rank}</div>
				                        </div>
				                        <div class="member_info">
				                            <div id="ad_phone">${searchAddress.ad_phone}</div>
				                            <div id="ad_email">${searchAddress.ad_email}</div>
				                        </div>
				                    </div>
				                </div>
			                </li>
			            </c:forEach>
		            </ul>
		        </c:otherwise>
		    </c:choose>
		</div>
</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>