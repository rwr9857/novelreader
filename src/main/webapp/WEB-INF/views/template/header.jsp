<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${root}/css/template/upbar.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<div class="wrap">
    <div class="img">
        <!--로고-->
        <a href=""><img src ="${root}/images/upbar/rogo.png"></a>
    </div>
    <div class="span">
        <span onclick="location.href='${root}/novel/top10.do'">TOP10</span>
        <span onclick="location.href='${root}/member/ranking.do'">인기작가</span>
        <span style="margin-right:50px;"  onclick="location.href='${root}/notice/notice.do'">공지사항</span>
    </div>
    <div class="serchbar">
        <select>
            <option value="title">제목</option>
            <option value="writer">작가명</option>
        </select>
        <input type="text" placeholder="제목을입력하세요">
    </div>
    <div class="icon">
        <!--투고-->
        <a href="${root}/novelhome/upload.do"><img src ="${root}/images/upbar/write.jpg" style="width:35px; height:30px; margin-right:20px;"></a>
        <!--프로필-->
        <div class="dropdown">
                <span class="dropbtn"><img src="${root}/images/upbar/profile.jpg"
                                           style="width:25px; height:25px; margin-left:-2px;"></span>
            <div class="dropdown-content">
                <a href="#">즐겨찾기 목록</a>
                <a href="#">열람 이력</a>
                <a href="#">문의하기</a>
                <c:if test="${numSess==null}">
                    <a href="${root}/member/login.do">로그인</a>
                    <a href="${root}/member/register.do">회원가입</a>
                </c:if>
                <c:if test="${numSess!=null}">
                    <a href="${root}/member/profile.do?nickname=${nicknameSess}">프로필관리</a>
                    <a href="${root}/member/logout.do">로그아웃</a>
                </c:if>

                <c:if test="${permissionSess=='MA'}">
                    <a href="${root}/manager/menu.do">관리자 메뉴</a>
                </c:if>

            </div>
        </div>
    </div>
</div>


</body>
</html>