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
		method="post">
		<div id="nh_all">
			<!-- 표지 -->
			<div class="nh_f1">
				<div class="nh_f2">
					<div class="image_container"></div>
					<input type="file" id="image" accept="image/*"
						onchange="setThumbnail(event);" />
					
				</div>
			</div>
			<!-- 소설 -->
			<div class="nh_f2">
				<div class="nh_f21">
					<textarea rows="4" cols="80" name="content" placeholder="소설 제목(필수)"></textarea>
				</div>
				<div class="nh_f21">
					<textarea rows="10" cols="80" name="content"
						placeholder="소설 줄거리(선택)"></textarea>
				</div>
				<div class="nh_f21">
					
					<input type="checkbox" id="kategorie1" name="kategorie1" value="Mystery">
  					<label for="kategorie1">추리/미스터리</label>
  					<input type="checkbox" id="kategorie2" name="kategorie2" value="Mystery">
  					<label for="kategorie1">라이트노벨</label>
  					<input type="checkbox" id="kategorie3" name="kategorie3" value="Mystery">
  					<label for="kategorie1">판타지</label>
  					<input type="checkbox" id="kategorie4" name="kategorie4" value="Mystery">
  					<label for="kategorie1">SF과학소설</label>
  					<input type="checkbox" id="kategorie5" name="kategorie5" value="Mystery">
  					<label for="kategorie1">무협</label><br>
  					<input type="checkbox" id="kategorie6" name="kategorie6" value="Mystery">
  					<label for="kategorie1">액션</label>
  					<input type="checkbox" id="kategorie7" name="kategorie7" value="Mystery">
  					<label for="kategorie1">공포/스릴러</label>
  					<input type="checkbox" id="kategorie8" name="kategorie8" value="Mystery">
  					<label for="kategorie1">로맨스</label>
  					<input type="checkbox" id="kategorie9" name="kategorie9" value="Mystery">
  					<label for="kategorie1">고전문학</label>
					
				</div>
				<div class="nh_f21">
					<input type="submit" value="소설투고" />
				</div>
			</div>
		</div>

	</form>
</body>
</html>