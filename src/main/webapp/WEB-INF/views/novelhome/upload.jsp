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
					<!-- for문 -->
					${categorieList}
					<c:forEach var="categorieDto" items="${categorieList}">
						<input type="checkbox" name="C_CATEGORIE_NAME" value="${categorieDto.C_CATEGORIE_ID}"> 
						${categorieDto.C_CATEGORIE_NAME}
					</c:forEach>
					
				</div>
				<div class="nh_f21">
					<input type="submit" value="소설투고" />
				</div>
			</div>
		</div>

	</form>
</body>
</html>