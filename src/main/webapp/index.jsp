<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노벨리더</title>
</head>
<body>
	<a href="${root}/member/login.do">로그인</a>
	<br/>
	<a href="${root}/member/register.do">회원가입</a>
	<br/>
	<a href="${root}/member/logout.do">로그아웃</a>
	<br/>
	<a href="${root}/novel/top10.do">TOP10</a>
	<br/>
	<a href="${root}/member/ranking.do">인기작가</a>
	<br/>
	<a href="${root}/notice/notice.do">공지사항</a>
	<a href="${root}/notice/faq.do">자주하는질문</a>
	<a href="${root}/notice/question.do">공지사항</a>
	<br/>
	<a href="${root}/novel/search.do">검색</a>
	<br/>
	<a href="${root}/novel/upload.do">투고</a>
	<br/>
	<a href="${root}/member/profile.do">프로필</a>
	<br/>
	<a href="${root}/member/favorite.do">즐겨찾기 목록</a>
	<br/>
	<a href="${root}/member/recent.do">최근 기록</a>
	<br/>
	<a href="${root}/admin/menu.do">관리자 메뉴</a>
</body>
</html>