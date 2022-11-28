<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="${root}/css/template/upbar.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<div class="Upwrap">
		<div class="Upimg">
			<!--로고-->
			<a href="${root}/index.do"><h1
					style="margin-top: 15px; color: #0096fa; cursor: pointer">NOVELREADER</h1></a>
		</div>
		<div class="Upspan">
			<span onclick="location.href='${root}/novel/top10.do'">TOP10</span> <span
				onclick="location.href='${root}/novel/ranking.do'">인기작가</span> <span
				style="margin-right: 50px;"
				onclick="location.href='${root}/notice/notice.do'">공지사항</span>
		</div>
		<div class="Upserchbar">
			<form action="${root}/novelhome/search.do" method="get">
				<select name="search_method" style="background:#ffffff;  margin-right:5px;">
					<option value="title">제목</option>
					<c:if test="${search_method!='writer'}">
						<option value="writer">작가명</option>
					</c:if>
					<c:if test="${search_method=='writer'}">
						<option value="writer" selected="selected">작가명</option>
					</c:if>
				</select> 
				<input type="text" name="keyword" placeholder="검색어" style="background:#ffffff;">
					
				<input type="submit" value="검색" style="display:none;">
			</form>
		</div>
		<div class="Upicon">
			<!--투고-->
			<a href="${root}/novelhome/upload.do"><img
				src="${root}/images/upbar/write.jpg"
				style="width: 48px; height: 40px; margin-left:40px; margin-right: 20px;"></a>
			<!--프로필-->
			<div class="Updropdown">
				<span class="Updropbtn">
					<c:if test="${photoAddressSess == null}">
						<img class="profile_image" alt="기본값" src="${root}/images/profile/profile_default.png" style="width: 50px; height: 50px; margin-left: 20px; border: 1px solid #261ca0; border-radius: 25px; background:#ffffff;">
					</c:if>
					<c:if test="${photoAddressSess != null}">
						<img class="profile_image" alt="프로필사진" src="${photoAddressSess}" style="width: 50px; height: 50px; margin-left: 20px; border: 1px solid #261ca0; border-radius: 25px; background:#ffffff;">
					</c:if>
				</span>
				<div class="Updropdown-content">
					<c:if test="${numSess!=null}">
						<a href="${root}/member/profile.do?nickname=${nicknameSess}">프로필</a>
					</c:if>
					
					<c:if test="${numSess!=null}">
						<a href="${root}/notice/question.do">문의하기</a>
					</c:if>
					
					<c:if test="${numSess==null}">
						<a href="${root}/member/login.do">로그인</a>
					</c:if>
					<c:if test="${numSess==null}">
						<a href="${root}/member/register.do">회원가입</a>
					</c:if>
					<c:if test="${numSess!=null}">
						<a href="${root}/member/profileEdit.do?nickname=${nicknameSess}">설정</a>
					</c:if>
					<c:if test="${numSess!=null}">
						<a href="${root}/member/logout.do" style="color:#b20000;">로그아웃</a>
					</c:if>

					<c:if test="${permissionSess=='MA'}">
						<a href="${root}/manager/menu.do">관리자 메뉴</a>
					</c:if>

				</div>
			</div>
		</div>
	</div>


</body>
</html>






