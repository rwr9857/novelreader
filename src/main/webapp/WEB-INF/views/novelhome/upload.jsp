<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품투고</title>
<link rel="stylesheet" href="${root}/css/novelhome/uploadStyle.css">
<script type="text/javascript" src="${root}/javascript/novelhome/upload.js"></script>
</head>
<body>
	<form name="novelhomeForm" action="${root}/novelhome/uploadOk.do"
		method="post" enctype="multipart/form-data" onsubmit="return novelHomeForm(this)">
		<div id="nh_all">
			<!-- 표지 -->
			<div class="nh_f1">
				<div class="nh_f2">
					<div class="image_container"></div>
					<input type="file" id="image" accept="image/*" name="file" size="40"
						onchange="setThumbnail(event);" />
					
				</div>
			</div>
			<!-- 소설 -->
			<div class="nh_f2">
				<div class="nh_f21">
					<textarea rows="4" cols="80" name="N_TITLE" placeholder="소설 제목(필수)"></textarea>
				</div>
				<div class="nh_f21">
					<textarea rows="10" cols="80" name="N_SUMMARY"
						placeholder="소설 줄거리(선택)"></textarea>
				</div>
				<div class="nh_f21">
					<!-- 관리자 - 소설카테고리 CRUD 필요 -->
					<input type="checkbox" id="categorie1" name="categorieValue" value="CM">
  					<label for="categorie1">추리/미스터리</label>
  					<input type="checkbox" id="categorie2" name="categorieValue" value="LN">
  					<label for="categorie2">라이트노벨</label>
  					<input type="checkbox" id="categorie3" name="categorieValue" value="FT">
  					<label for="categorie3">판타지</label>
  					<input type="checkbox" id="categorie4" name="categorieValue" value="SF">
  					<label for="categorie4">SF과학소설</label>
  					<input type="checkbox" id="categorie5" name="categorieValue" value="MH">
  					<label for="categorie5">무협</label><br>
  					<input type="checkbox" id="categorie6" name="categorieValue" value="AC">
  					<label for="categorie6">액션</label>
  					<input type="checkbox" id="categorie7" name="categorieValue" value="GS">
  					<label for="categorie7">공포/스릴러</label>
  					<input type="checkbox" id="categorie8" name="categorieValue" value="RM">
  					<label for="categorie8">로맨스</label>
  					<input type="checkbox" id="categorie9" name="categorieValue" value="GM">
  					<label for="categorie9">고전문학</label>
					
					<input type="hidden" name="C_CATEGORIE"/>
				</div>
				<div class="nh_f21">
					<input type="submit" value="소설투고" />
				</div>
			</div>
		</div>

	</form>
</body>
</html>