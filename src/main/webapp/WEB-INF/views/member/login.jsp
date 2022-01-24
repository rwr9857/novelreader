<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<c:if test="${numSess !=null}">
		<script type="text/javascript">
			location.href = "/novelreader/index.jsp";
		</script>
	</c:if>

	<c:if test="${numSess == null}">
		<div align="center">
			<h3>로그인</h3>
			<form action="${root}/member/loginOk.do" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="m_id" /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="m_id" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="로그인" /></td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
</body>
</html>