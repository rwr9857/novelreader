<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회차등록완료</title>
</head>
<body>
	<c:if test="${check>0}">
		<script type="text/javascript">
			alert("회차 수정이 완료 되었습니다.");
			location.href = "${root}/novelhome/list.do?n_num=${n_num}";
		</script>
		
	</c:if>

	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("회차 수정이 실패 하였습니다.");
			location.href = "${root}/novelhome/list.do?n_num=${n_num}";
		</script>
	</c:if>
</body>
</html>