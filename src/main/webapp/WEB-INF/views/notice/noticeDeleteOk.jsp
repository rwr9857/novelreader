<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check > 0}">
		<script type="text/javascript">
			alert("입력이 완료 되었습니다.");
			location.href = "${root}/notice/notice.do";
		</script>
	</c:if>

	<c:if test="${check==0}">
		<script type="text/javascript">
			alert("입력에 실패 하였습니다.")
			location.href = "${root}/novelreader/notice/notice.do";
		</script>
	</c:if>
</body>
</html>