<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품투고완료</title>
</head>
<body>
	<%-- <c:set var="C_CATEGORIE_ID" value="${C_CATEGORIE_ID}" scope="session" />
	<c:set var="m_num" value="${m_num}" scope="session" />
		${C_CATEGORIE_ID}
		${m_num}--%>
		
	<input type="hidden" name="C_CATEGORIE_ID" value="${C_CATEGORIE_ID}">
	<input type="hidden" name="N_NUM" value="${N_NUM}">
	<c:if test="${check>0}">
		<script type="text/javascript">
			alert("소설 투고가 완료 되었습니다.");
			location.href = "${root}/novelhome/index.jsp"; 
		</script>
	</c:if>

	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("소설 투고가 실패 하였습니다.");
			location.href = "${root}/novelhome/upload.do";
		</script>
	</c:if>
</body>
</html>