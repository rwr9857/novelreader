<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
F
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />

	<c:if test="${m_num !=null}">
		<c:set var="m_num" value="${m_num}" scope="session" />
		<c:set var="m_premission" value="${m_premission}" scope="session" />
		<c:set var="m_platform" value="${m_platform}" scope="session" />


		<script type="text/javascript">
			alert("로그인 성공");
			location.href = "/novelreader/index.jsp";
		</script>
	</c:if>

	<c:if test="${m_num == null}">
		<script type="text/javascript">
			alert("입력하신 정보가 존재하지 않습니다.");
			location.href = "${root}/member/login.do";
		</script>
	</c:if>
</body>
</html>