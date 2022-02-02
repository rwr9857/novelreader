<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check>0}">
		<c:remove var="numSess" scope="session" />
		<c:remove var="permissionSess" scope="session" />
		<c:remove var="platformSess" scope="session" />
		<c:remove var="nicknameSess" scope="session" />
		<script type="text/javascript">
			alert("탈퇴가 완료되었습니다.");
			location.href = "${root}";
		</script>
	</c:if>
	
	<c:if test="${check==0}">
		<script type="text/javascript">
			alert("탈퇴를 실패하였습니다");
			location.href = "${root}";
		</script>
	</c:if>
</body>
</html>