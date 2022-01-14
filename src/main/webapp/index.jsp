<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<a href="{root}/">로그인</a>
	<a href="{root}/">회원가입</a>
	<a href="{root}/">로그아웃</a>
	<a href="{root}/">TOP10</a>
	<a href="{root}/">인기작가</a>
	<a href="{root}/">공지사항</a>
	<a href="{root}/">검색</a>
	<a href="{root}/">투고</a>
	<a href="{root}/">프로필</a>
	<a href="{root}/">즐겨찾기 목록</a>
	<a href="{root}/">최근 기록</a>
	<a href="{root}/">문의하기</a>
</body>
</html>