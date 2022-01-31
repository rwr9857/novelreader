<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />

	<c:if test="${check > 0}">
		<c:set var="nicknameSess" value="${nicknameSess}" scope="session" />
		<script type="text/javascript">
			location.href = "${root}/member/profileEdit.do?nickname=${nicknameSess}";
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<c:set var="nicknameSess" value="${nicknameSess}" scope="session" />
		<script type="text/javascript">
			alert("오류");
			location.href = "${root}/member/profileEdit.do?nickname=${nicknameSess}";
		</script>
	</c:if>
	
</body>
</html>