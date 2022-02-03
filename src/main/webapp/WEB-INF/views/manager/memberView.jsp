<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<link rel="stylesheet" href="${root}/css/manager/memberView.css">

<title>Document</title>
</head>
<body>
	<div style="margin-left: 265px; margin-top: 0px; border: 1px solid black; height: 1100px; background: rgb(234, 240, 253);">
		<div class="menuText">
			<h1>회원 조회</h1>
			<h3>
				관리자 모드 -> <span style="color: gray;">회원정보</span> -> 회원 조회
			</h3>
		</div>
		<div class="serchbar">
			<h3>회원 닉네임</h3>
			<form>
				<input class="serchbox" type="text" placeholder="search">
			</form>
		</div>
		<div class="resultTextbox">
			<h3>검색결과 :</h3>
		</div>
		<div class="resultTextpage">
			<h3 style="margin-right: 100px;">번호</h3>
			<h3 style="margin-right: 150px;">ID</h3>
			<h3 style="margin-right: 150px;">닉네임</h3>
			<h3 style="margin-right: 200px;">가입일</h3>
			<h3 style="margin-right: 200px;">E-mail</h3>
			<h3 style="margin-right: 100px;">이메일 수신여부</h3>
		</div>

		<c:if test="${count==0}">
			<div align="center">회원이 없습니다.</div>
		</c:if>

		<c:if test="${count > 0}">
			<c:forEach var="memberDto" items="${memberList}">
				<div class="resultTextpage">
					<h3 style="margin-right: 100px;">${memberDto.m_num}</h3>
					<h3 style="margin-right: 150px;">${memberDto.m_id}</h3>
					<h3 style="margin-right: 150px;">${memberDto.m_nickname}</h3>
					<h3 style="margin-right: 200px;">
						<fmt:formatDate value="${memberDto.m_register_date}" pattern="yyyy-MM-dd HH:mm:ss" />
					</h3>
					<h3 style="margin-right: 200px;">${memberDto.m_email}</h3>
					<c:if test="${memberDto.m_email_agree == 1}">
						<h3 style="margin-right: 100px;">yes</h3>
					</c:if>
					<c:if test="${memberDto.m_email_agree == 0}">
						<h3 style="margin-right: 100px;">no</h3>
					</c:if>
				</div>
			</c:forEach>
		</c:if>


		<!-- 페이지 번호 -->
		<%-- 1. 총페이지 수 = 전체레코드 / 한페이지당 게시물 수.. 200/10=10page, 201/10=21page 
	        2. 페이지 블럭 정하기 : 10
	           2-1) 블럭 strat 번호, end 번호 구하기
	           2-2) 계산방법
	                 - 요청페이지 : 5page,    총페이지수 : 200/10=20page,   페이지블럭:10
	                 - int startPage=(int) ((currentPage-1)/pageBlock) * pageBlock +1
	                                               ((5-1=4)/10=0.4)=0*10=0+1=1page
	                                               ((25-1=24)/10=2.4)=2*10=20+1=21page
	                 - int endPage=startPage+pageBlock-1         
	                                                1+10-1=10, 21+10=31-1=30                                              
	       3. 이전, 다음  
	       		3-1) 이전 : startPage 11  >  pageBlock 10  / startPage 11 - pageBlock 10 = 1page
	       		3-2) 다음 : endPage 10 < pageCount 200  /  startPage+pageBlock = 11 
	 	--%>

		<div align="center">
			<%-- 총페이지 수 --%>
			<fmt:parseNumber var="pageCount" value="${count/boardSize+(count%boardSize==0? 0:1)}" integerOnly="true" />
			<%-- 페이지 블럭 --%>
			<c:set var="pageBlock" value="${3}" />

			<%-- 블럭의 시작번호, 끝번호 --%>
			<fmt:parseNumber var="rs" value="${(currentPage-1)/pageBlock}" integerOnly="true" />
			<c:set var="startPage" value="${rs * pageBlock + 1}" />
			<c:set var="endPage" value="${startPage+ pageBlock - 1}" />

			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > pageBlock}">
				<a href="${root}/manager/memberView.do?pageNumber=${startPage - pageBlock}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${root}/manager/memberView.do?pageNumber=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="${root}/manager/memberView.do?pageNumber=${startPage + pageBlock}">[다음]</a>
			</c:if>
		</div>

	</div>
</body>
</html>