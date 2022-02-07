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
<script type="text/javascript"
	src="${root}/javascript/novelpost/list.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>소설로고 리스트</title>
</head>
<body>
	<c:if test="${nNumSess !=null}">
		<c:set var="nNumSess" value="${nNumSess}" scope="session" />
	</c:if>
		<div class="wrap" style="margin-top:100px;">
			<!-- 표지 -->
			<div class="upbox">
				<div class="leftbox">
					<!-- 이미지불러오기 -->
					<div class="image_container">
						<c:if test="${novelHomeDto.n_image_name != null}">
						<img src="${root}/file/${novelHomeDto.n_image_name}" style ="border-radius : 15px;"/>
						</c:if>
						<c:if test="${novelHomeDto.n_image_name == null}">
							<img src="${root}/images/novelLabel/defalutImage.png">
						</c:if>
					</div>
						<button style="margin-left: 0px; color: rgb(209, 206, 206);"
						onclick="javascript:readFirstCheck('${firstView}','${root}')">첫화보기</button>
					
				</div>
			
				<!-- 소설 -->
				<div class="rightbox">
					 <div class="right_up">
	                    <h1 style ="margin-top : 10px;">${novelHomeDto.n_title}</h1>
	                    <div style="border:0px solid red; width:550px;">
		                    <button type="button" style="border: 0px;" class="btm_image" id="img_btn" onclick="questionWrite('${novelHomeDto.n_num}', '${root}','${novelHomeDto.n_title}')">
		                    	<img src="https://img2.quasarzone.co.kr/img/data/img/editor/1906/1906___1791183465.jpg">
		                    </button>
		                </div>
	                    <!-- 회원만 삭제 -->
	                    <c:if test="${numSess == novelHomeDto.m_num}">
		                    <span class = "right_up_span" onclick="javascript:novelHomeDeleteCheck('${root}','${novelHomeDto.n_num}')">전체 삭제</span>
						</c:if>
	                </div>
					<div class="right_up2">
						<h3 onclick="javascript:goProfile('${root}','${nickname}')"
							style="cursor: pointer">
							작가 : <span style="color: rgb(148, 21, 127); font-weight: bold;">${nickname}</span>
						</h3>
					</div>
					<div class="right_middle">
						<img src="${root}/images/novelpost/viewimg.png"
							style="margin-top: 2px; margin-right: 2px;">
						<c:choose>
							<c:when test="${allViewCount != null}">
								<h3>${allViewCount}</h3>
							</c:when>
							<c:otherwise>
								<h3>0</h3>
							</c:otherwise>
						</c:choose>
						<img src="https://novelpia.com/img/new/icon/count_book.png"
							style="margin-top: 2px; margin-right: 2px;">
						<c:choose>
							<c:when test="${allPostCount != null}">
								<h3>${allPostCount}</h3>
							</c:when>
							<c:otherwise>
								<h3>0</h3>
							</c:otherwise>
						</c:choose>
					<img src="${root}/images/novelpost/bubble-chat.png"
						style="margin-top: 2px; margin-right: 2px;">
						<c:choose>
							<c:when test="${allCommentCount != null}">
								<h3>${allCommentCount}</h3>
							</c:when>
							<c:otherwise>
								<h3>0</h3>
							</c:otherwise>
						</c:choose>
					</div>
					<div class=right_bottom>
						<p style="font-size: 15px;"><span style="font-size:18px; font-weight: 600; line-height:22px;">소설 줄거리</span><br/><br/>${novelHomeDto.n_summary}</p>
					</div>
					<div class="right_bottom2">
                     	<span>${c_category_name}</span>
				</div>
			</div>
		</div>
		<div class="bottombox">
			<div class="bottom_up">
				<h3>회차리스트</h3>
				<c:if test="${numSess == novelHomeDto.m_num}">
					<span onClick="location.href='${root}/novelpost/register.do'">등록</span>
				</c:if>
			</div>
			<!-- 회차리스트 -->
			<c:if test="${novelPostList.size() > 0 }">
				<c:forEach var="novelPostDto" items="${novelPostList}"
					varStatus="status">
					<div class="bottom_down">
						<div class="bottom_down1">
							<h3 onclick="javascript:readCheck('${novelPostDto.n_POST_NUM}', '${root}')" style="cursor: pointer; font-weight:bold; font-size:17px;">
								Ep.${status.count} ${novelPostDto.n_POST_TITLE}</h3> 
							<c:if test="${numSess == novelHomeDto.m_num}">
								<span onclick="javascript:updateCheck('${novelPostDto.n_POST_NUM}', '${root}','${novelPostDto.n_num}')" >수정</span>
								<span onclick="javascript:deleteCheck('${novelPostDto.n_POST_NUM}', '${root}','${novelPostDto.n_num}')" >삭제</span>
							</c:if>
						</div>
						<div class="bottom_down2">
							<h3><fmt:formatDate value="${novelPostDto.n_POST_TIME}" pattern="yyyy-MM-DD HH:mm:ss" /></h3>
							<h3 style="margin-left : 10px;"><img src="${root}/images/novelpost/viewimg.png" style="width:18px; height:18px; margin-top:-3px;">${novelPostDto.n_POST_VIEWCOUNT}</h3>
                		</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<div align="center">
			<c:if test="${count>0}">
				<%-- 총  페이지 수  --%>
				<fmt:parseNumber var="pageCount"
					value="${count/boardSize +  (count%boardSize == 0 ? 0:1)}"
					integerOnly="true" />
			
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
					<a href="${root}/novelhome/list.do?pageNumber=${startPage-pageBlock}&n_num=${n_num}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="${root}/novelhome/list.do?pageNumber=${i}&n_num=${n_num}">[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="${root}/novelhome/list.do?pageNumber=${startPage+pageBlock}&n_num=${n_num}">[다음]</a>
				</c:if>
				
			</c:if>
		</div>

</div>
</body>
</html>