<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회차등록</title>
</head>
<body>
	<form action="${root}/novelpost/registerOk.do" method="post" >
		<table border="1">
			<tr>
				<td>회차제목</td>
				<td><textarea rows="1" cols="80" name="N_POST_TITLE"
						placeholder="회차 제목을 입력하세요"></textarea></td>
			</tr>
			<tr>
				<td>폰트설정</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="4" cols="80" name="N_POST_CONTENT"
						placeholder="회차 내용을 입력하세요"></textarea></td>
			</tr>

		</table>
		<input type="submit" value="확인" /> <input type="reset" value="취소" />
		<input type="hidden" name="n_num" value="${nNumSess}" />
	</form>
	
</body>
</html>