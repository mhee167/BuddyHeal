<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>제이엠 컴퍼니</title>
    <link rel="stylesheet" href="css/animations.css">
    <link rel="stylesheet" href="../css/member.css" />
    <script language="Javascript" src="validation.js"></script>
    <link
      rel="stylesheet"
      as="style"
      crossorigin
      href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css"
    />
    <link rel="stylesheet" href="../css/address.css" />
    
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  </head>

  <body>
 <%@ include file="../header.jsp" %>
 <div id="write_container">

     <div id="write-wrap" class="slideRight">
        <div class="write">
          <div class="write_image">
            <lottie-player
              id="lottie"
              src="../image/contact_animation.json"
              background="transparent"
              speed="1"
              loop
              autoplay
            ></lottie-player>
          </div>
          <div class="write-content">
            <div class="write-head">
              <span class="head-title">Add ContactList</span>
            </div>
            <div class="write-body">
              <div class="body-content">
                <form
                  name="write_frm"
                  method="post"
                  action="/Mini/frontcontroller/address/write"
                >
                <div class="content">
                    <input type="text" name="ad_id" placeholder="아이디"/>
                    <label>아이디</label>
                  </div>
                
                  <div class="content">
                    <input type="text" name="ad_name" placeholder="이름" />
                    <label>이름</label>
                  </div>

                  <div class="content">
                    <input type="text" name="ad_phone" placeholder="전화번호"/>
                    <label>전화번호</label>
                  </div>
                  <div class="content">
                    <input type="text" name="ad_email" placeholder="이메일" />
                    <label>이메일</label>
                  </div>
                  <div class="content">
                    <select name="ad_department">
                      <option value="PlanningTeam">Planning Team</option>
                      <option value="MarketingTeam">Marketing Team</option>
                      <option value="DesignTeam" selected>Design Team</option>
                      <option value="FrontEndTeam">FrontEnd Team</option>
                      <option value="BackEndTeam">BackEnd Team</option>
                    </select>
                    <label>부서</label>
                  </div>
                  <div class="content">
                    <select name="ad_rank">
                      <option value="사원" selected>사원</option>
                      <option value="대리">대리</option>
                      <option value="과장">과장</option>
                      <option value="차장">차장</option>
                      <option value="이사">이사</option>
                      <option value="사장">사장</option>
                    </select>
                    <label>직급</label>
                  </div>
                  <div class="write-foot">
                    <input type="submit" id="add_btn" value="추가" />
                    <input
                      type="button"
                      value="취소"
                      id="close_btn"
                      onClick="window.location.href='${pageContext.request.contextPath}/address/list.jsp'"
                    />
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>

    <%@ include file="../footer.jsp" %>
  </body>
</html>