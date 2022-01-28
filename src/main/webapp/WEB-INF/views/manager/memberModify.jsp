<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${root}/css/manager/memberModify.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<div style="margin-left: 265px; margin-top: 0px; border: 1px solid black; height: 1100px; background: rgb(234, 240, 253);">
		<div class="menuText">
			<h1>회원 수정</h1>
			<h3>
				관리자 모드 -> <span style="color: gray;">회원정보</span> -> 회원 수정
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
	</div>
</body>
</html>