<%@ page language="java"
   contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.* , DaoDto.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<%
	request.setCharacterEncoding("UTF-8");

	 String ad_department = request.getParameter("ad_department");

     AddressDAO dao = new AddressDAO();
     List<AddressDTO> filterList = dao.filterAddress(ad_department);
     request.setAttribute("filterList", filterList);
     List<String> imageList=new ArrayList<String>(Arrays.asList("사원","대리","과장","차장","부장","이사","사장"));
 	

%>
 <link
      rel="stylesheet"
      as="style"
      crossorigin
      href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css"
    />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/address.css">
	<title>제이엠 컴퍼니</title>
</head>
<body>
	<%@include file="../header.jsp" %>

	<div class="filterContainer" >
	<div class="addressHeader">
	    <span><a href="/Mini/address/list.jsp">Contact List</a></span>
	    <form method="get" action="list_search.jsp">
		    <input type="text" name="find_name" id="find_name" placeholder="검색하고 싶은 성함을 작성해 주세요.">
		    <input type="submit" value="Search">
		</form>
	</div>

	  <div id="FilteraddressList" >
		 
		<c:choose>
	        <c:when test="${empty filterList}">
	            <p class="nullResult">검색 결과가 없습니다.</p>
	        </c:when>
	        <c:otherwise>
	            <ul>	            
		            <c:forEach items="${filterList}" var="filterAddress">	   
	             	<li id="filter_container" class="floating">
		           
		                <div class="list_image" style="margin-top:10px;">
		                    <div class="image_box">
		                       <img src="../image/${filterAddress.ad_rank}.png" class="profile" /> 	
		                       <div class="edit_btn">
		                        	
		                        	<a href="${pageContext.request.contextPath}/address/modify.jsp?ad_id=${filterAddress.ad_id}"><img src="../image/ic_modify.png" style="width:20px;height:20px; margin-right:7px" /></a>
	                            	<a href="${pageContext.request.contextPath}/frontcontroller/address/delete?ad_id=${filterAddress.ad_id}"><img src="../image/ic_delete.png" style="width:20px;height:20px;"/></a>
		                        </div>	              
		                    </div>
		                </div>
		                <div class="list_content" >		                		           
		                    <div class="list_header">
		                        <div id="ad_name" style="margin-top:10px">${filterAddress.ad_name}</div>
		                        
		                    </div>
		                    
		                    <div class="list_body" style="margin-bottom:10px;" >
		                        <div class="company_info">
		                            <div id="ad_department">${filterAddress.ad_department}</div>
		                            <div id="ad_rank">${filterAddress.ad_rank}</div>
		                        </div>
		                        <div class="member_info">
		                            <div id="ad_phone">${filterAddress.ad_phone}</div>
		                            <div id="ad_email">${filterAddress.ad_email}</div>
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