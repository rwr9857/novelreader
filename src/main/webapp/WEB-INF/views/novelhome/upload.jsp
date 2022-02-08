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
					<font><b>소설표지</b></font>
					<div class="img_box">
						<div class="image_container"></div>
					</div>
						<input type="file" id="image" accept="image/*" name="file" size="40" style="margin-top: 8px;"
							onchange="setThumbnail(event);"/>
				</div>
				
				<!-- 소설 -->
			<div class="box">
					<font><b>소설투고</b></font>
					<div class="blank"></div>
					
					<div class="title2">
						<textarea rows="2" cols="80" name="n_title" placeholder="소설 제목(필수)"></textarea>
					</div>

					<div class="blank"></div>

					<div class="content">
						<textarea rows="6" cols="80" name="n_summary"
							placeholder="소설 줄거리(선택)"></textarea>
					</div>

                    <div class="blank"></div>
					
					<div>
						<font><b>카테고리 선택</b></font>
					</div>
					<div class="categoryAdd">
						<c:forEach var="categoryDto" items="${categoryList}" varStatus="status">
								<div class="container" style=" position: absolute; margin-left: ${(status.index % 14)*80}px; margin-top:${Math.floor(status.index / 14)*100}px">
					                <div class="front_card">
					                    <label for="${categoryDto.c_category_id}">${categoryDto.c_category_name}</label>
					                    <input type="radio" id="${categoryDto.c_category_id}" name="c_category_id" value="${categoryDto.c_category_id}">  
					                </div>
					        	</div>
						</c:forEach>
					</div>
					
					<div>
						<button class="uploadButton">소설투고</button>
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