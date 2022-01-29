<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팔로우</title>
</head>
<body>
	<c:if test="${check > 0}">
		<script type="text/javascript">
			location.href = "${root}/member/profile.do?nickname=${nickname}";
		</script>
	</c:if>

	<c:if test="${check==0}">
		<script type="text/javascript">
			alert("팔로우 취소 실패");
			location.href = "${root}/member/profile.do?nickname=${nickname}";
		</script>
	</c:if>
</body>
</html>