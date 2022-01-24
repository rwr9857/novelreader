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
	<c:if test="${numSess==null}">
		<a href="${root}/member/login.do">로그인</a>	<!-- 김준기 -->
		<br/>
		<a href="${root}/member/register.do">회원가입</a>	<!-- 김준기 -->
		<br/>	
	</c:if>
	
	<c:if test="${numSess!=null}">
		<a href="${root}/member/logout.do">로그아웃</a>	<!-- 김준기 -->
		<br/>
	</c:if>
	
	<c:if test="${permissionSess=='MA'}">
		<h3>관리자</h3>
	</c:if>
	
	<a href="${root}/novel/top10.do">TOP10</a>	<!-- 류익현 -->
	<br/>
	<a href="${root}/member/ranking.do">인기작가</a>	<!-- 박웅종 -->
	<br/>
	<a href="${root}/notice/notice.do">공지사항</a>	<!-- 안태균 -->
	<a href="${root}/notice/faq.do">자주하는질문</a>	<!-- 안태균 -->
	<a href="${root}/notice/question.do">문의하기</a> <!-- 안태균 -->
	<br/>
	<a href="${root}/novel/search.do">검색</a>	<!-- 박현우 -->
	<br/>
	<a href="${root}/novel/upload.do">투고</a>	<!-- 류익현 -->
	<br/>
	<a href="${root}/member/profile.do?nickname=Dongmool">프로필</a>	<!-- 강민수 -->
	<br/>
	<a href="${root}/member/favorite.do">즐겨찾기 목록</a>	<!-- 박웅종 -->
	<br/>
	<a href="${root}/manager/menu.do">관리자 메뉴</a>	<!-- 박승은 -->
</body>
</html>