<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.* ,DaoDto.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");

	// 주소록 테이블 가져오기
	
	AddressDAO dao = new AddressDAO();
	List<AddressDTO> addressList = dao.listAddress();
	
	// 주소록 목록을 request에 저장
	request.setAttribute("addressList", addressList);
	HashMap<String,Integer> countMap=dao.getCount();
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>주소록 페이지</title>
	<link rel="stylesheet" href="../css/address.css">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div id="container">
		<div class="addressHeader">
		   <span><a href="/Mini/address/list.jsp">Contact List</a></span>
		    <form method="get" action="list_search.jsp">
			    <input type="text" name="find_name" id="find_name" placeholder="검색하고 싶은 성함을 작성해 주세요.">
			    <input type="submit" value="Search">
			</form>
		</div>
		    
        <ul class="groupMember">
         	<li >
           		<a href="/Mini/address/list_filter.jsp?ad_department=PlanningTeam" class="groupCount" style="color:white"><%= countMap.get("PlanningTeam") %></a>
           		<span class="depart">Planning Team</span>
           	</li>
           	<li >
           		<a href="/Mini/address/list_filter.jsp?ad_department=MarketingTeam" class="groupCount" style="color:white"><%= countMap.get("MarketingTeam") %></a>
           		<span class="depart">Marketing Team</span>
           	</li>
           	<li >
           		<a href="/Mini/address/list_filter.jsp?ad_department=DesignTeam" class="groupCount" style="color:white"><%= countMap.get("DesignTeam") %></a>
           		<span class="depart">Design Team</span>
           	</li>
           	<li>
           		<a href="/Mini/address/list_filter.jsp?ad_department=FrontEndTeam" class="groupCount" style="color:white"><%= countMap.get("FrontEndTeam") %></a>
           		<span class="depart">Front-end Team</span>
           	</li>
           	<li >
           		<a href="/Mini/address/list_filter.jsp?ad_department=BackEndTeam" class="groupCount" style="color:white"><%= countMap.get("BackEndTeam") %></a>
           		<span class="depart">Back-end Team</span>
           	</li>
            <li >
	           	<a href="${pageContext.request.contextPath}/address/write.jsp"> 
	           		<img id="addBtn" src="../image/ic_add.png" />
           		</a>
            </li>
	     </ul>
		     
		 <div id="addressList">
		 
			<c:choose>
		        <c:when test="${empty addressList}">
		            <p class="nullResult">주소록이 비어 있습니다.</p>
		        </c:when>
		        
		        <c:otherwise>
			        <ul>
			            <c:forEach items="${addressList}" var="address">
			            <li id="list_container" class="floating">
			                <div class="list_image">
		                    <div class="image_box">		                   
		                  		   <img src="../image/${address.ad_rank}.png" class="profile" /> 
		                  		   <div class="edit_btn">
			                        	<a href="${pageContext.request.contextPath}/address/modify.jsp?ad_id=${address.ad_id}" ><img src="../image/ic_modify.png" id="image_modify" /></a>
		                            	<a href="${pageContext.request.contextPath}/frontcontroller/address/delete?ad_id=${address.ad_id}" ><img src="../image/ic_delete.png" id="image_delete"/></a>
		                            	
			                        </div>		                  
		                  		</div>
			               </div>
			                <div class="list_content" >
			                    <div class="list_header">
			                        <div id="ad_name">${address.ad_name}</div>
			                        
			                    </div>
			                    
			                    <div class="list_body">
			                        <div class="company_info">
			                            <div id="ad_department">${address.ad_department}</div>&nbsp;
			                            <div id="ad_rank">${address.ad_rank}</div>
			                        </div>
			                        <div class="member_info">
			                            <div id="ad_phone">${address.ad_phone}</div>
			                            <div id="ad_email">${address.ad_email}</div>
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