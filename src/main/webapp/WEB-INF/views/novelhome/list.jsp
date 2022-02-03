<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
   href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<link rel="stylesheet" href="${root}/css/novelhome/listStyle.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>소설로고 리스트</title>
</head>
<body>
    <c:if test="${nNumSess !=null}">
      <c:set var="nNumSess" value="${nNumSess}" scope="session" />
   </c:if>
    <div class="wrap">
        <!--표지-->
        <div class = "upbox">
            <div class= "leftbox">
                <div class="profile">
                    <img src="${root}/images/novelLabel/${novelHomeDto.n_image_name}" style ="border-radius : 15px;">
                </div>
                <button style = "margin-left:0px; color : rgb(209, 206, 206);">첫화보기</button>
            </div>
            <!--소설-->
            <div class = "rightbox">
                <div class="right_up">
                    <h1 style ="margin-top : 10px;">${novelHomeDto.n_title}</h1>
                    <img src="https://img2.quasarzone.co.kr/img/data/img/editor/1906/1906___1791183465.jpg">
                    <span class = "right_up_span">전체 삭제</span>
                </div>
                <div class="right_up2">
                    <h3>작가 : <span style= "color : rgb(148, 21, 127); font-weight : bold;">고속도루</span></h3>
                    <span class = "right_up2_span">+팔로우</span>
                </div>
                <div class="right_middle">
                    <img src="https://novelpia.com/img/new/icon/count_view.png" style="margin-top:2px; margin-right : 2px;">
                    <h3>11111 명</h3>
                    <img src="https://novelpia.com/img/new/icon/count_book.png" style="margin-top:2px; margin-right : 2px;">
                    <h3>11111 회차</h3>
                    <img src="https://novelpia.com/img/new/icon/count_good.png" style="margin-top:2px; margin-right : 2px;">
                    <h3>11111 개</h3>                
                </div>
                <div class = "right_bottom">
                    <p style ="font-size: 15px;">줄거리 : ${novelHomeDto.n_summary}</p>
                </div>
                <div class="right_bottom2">
                    <h3>장르 :</h3>
                   <span style="margin-left : 10px;">#판타지</span>
                   <span>#하렘</span>
                   <span>#착각</span>
                </div>
                <div class="nhF2">
                    <!-- 장르값 != null 이면 장르 리스트 -->
                    <input type="button" value="장르선택" onclick="categoryRead('${root}')" />
                    <script type="text/javascript">
                       function categoryRead(root) {
                          var url = root + "/novelCategory/novelCategoryAdd.do";
                           //alert(url);
             
                          window.open(url, "", "width=400, height=400");
                       }
                    </script>
                 </div>
            </div>
        </div>
        <div class= "bottombox">
            <div class="bottom_up">
                <h3>회차리스트</h3>
                <span OnClick="location.href='${root}/novelpost/register.do'">등록</span>
            </div>

      <!-- 회차리스트 -->
      <c:if test="${novelPostList.size() > 0 }">
         <c:forEach var="novelPostDto" items="${novelPostList}"
            varStatus="status">
            <div class="form_style"
               style="height: 30px; border: 1px solid black;">
               <div class="disp" style="border-width: 1px;">
                  Ep.${status.count} ${novelPostDto.n_POST_TITLE} <a
                     href="javascript:updateCheck('${novelPostDto.n_POST_NUM}', '${root}')">수정</a>
                  <a
                     href="javascript:deleteCheck('${novelPostDto.n_POST_NUM}', '${root}')">삭제</a>
                  <fmt:formatDate value="${novelPostDto.n_POST_TIME}"
                     pattern="yyyy-MM-DD HH:mm:ss" />
               </div>
            </div>
         </c:forEach>
      </c:if>

           

        </div>

    </div> 
    <div align="center">
      <c:if test="${count>0}">
         <%-- 총  페이지 수  --%>
         <fmt:parseNumber var="pageCount"
            value="${count/boardSize +  (count%boardSize == 0 ? 0:1)}"
            integerOnly="true" />
      </c:if>
      <%-- 페이지 블럭 --%>
      <c:set var="pageBlock" value="${2}" />

      <%-- 블럭의 시작번호, 끝번호 --%>
      <fmt:parseNumber var="rs" value="${(currentPage - 1)/pageBlock}"
         integerOnly="true" />
      <c:set var="startPage" value="${rs * pageBlock + 1}" />
      <c:set var="endPage" value="${startPage + pageBlock - 1}" />

      <c:if test="${endPage > pageCount}">
         <c:set var="endPage" value="${pageCount}" />
      </c:if>

      <c:if test="${startPage > pageBlock}">
         <a href="${root}/guest/write.do?pageNumber=${startPage-pageBlock}">[이전]</a>
      </c:if>

      <c:forEach var="i" begin="${startPage}" end="${endPage}">
         <a href="${root}/guest/write.do?pageNumber=${i}">[${i}]</a>
      </c:forEach>

      <c:if test="${endPage < pageCount}">
         <a href="${root}/guest/write.do?pageNumber=${startPage+pageBlock}">[다음]</a>
      </c:if>

      <div>pageCount : ${pageCount} startPage : ${startPage} endPage :
         ${endPage}</div>
   </div>
</body>
</html>