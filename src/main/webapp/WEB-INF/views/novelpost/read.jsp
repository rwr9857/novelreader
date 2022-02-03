<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회차읽기</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<div id="npAll">
		<div class="npTitle">${novelPostDto.n_POST_TITLE}</div>
		<div class="npContent">${novelPostDto.n_POST_CONTENT}</div>
		<div class="npFoot">좋아요 싫어요</div>
	</div>
</body>
</html>