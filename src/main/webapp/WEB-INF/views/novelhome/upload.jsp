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
	<c:if test="${numSess !=null}">
		<form name="novelhomeForm" action="${root}/novelhome/uploadOk.do"
			method="post" enctype="multipart/form-data">
		
			<div class="wrap">
				<!-- 표지 -->
				<div class="img">
					<div class="img_box">
						<div class="image_container"></div>
					</div>
						<input type="file" id="image" accept="image/*" name="file" size="40"
							onchange="setThumbnail(event);" />
						
					
				</div>
				<!-- 소설 -->
				<div class="box">
					<div class="title2">
						<textarea rows="2" cols="80" name="n_title" placeholder="소설 제목(필수)"></textarea>
					</div>
					<div class="content">
						<textarea rows="6" cols="80" name="n_summary"
							placeholder="소설 줄거리(선택)"></textarea>
					</div>
					<div class="submit">
						<input type="submit" value="소설투고" />
					</div>
				</div>
			</div>
			<input type="hidden" name="m_num" value="${numSess}"/>
		</form>
	</c:if>
	<c:if test="${numSess == null}">
		<script type="text/javascript">
			alert("로그인이 필요합니다.");
			location.href = "${root}/member/login.do";
		</script>
	</c:if>
</body>
</html>