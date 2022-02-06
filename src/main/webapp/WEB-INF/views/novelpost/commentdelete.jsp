<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 삭제</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<c:if test="${check > 0}">
		<script type="text/javascript">
			location.href = "${root}/novelpost/read.do?n_post_num=${n_post_num}";
		</script>
	</c:if>
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("삭제 되지않았습니다.");
			location.href = "${root}/novelpost/read.do?n_post_num=${n_post_num}";
		</script>
	</c:if>

</body>
</html>