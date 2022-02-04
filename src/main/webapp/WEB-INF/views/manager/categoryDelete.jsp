<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <link rel="stylesheet" href="${root}/css/manager/body.css">
    <link rel="stylesheet" href="${root}/css/manager/category.css">

    <title>Document</title>
</head>
<body>
<div class="field">
    <div class="menuText">
        <h1>소설 카테고리 관리</h1>
        <h3>
            관리자 모드 -> <span style="color: gray;">소설 카테고리 관리</span> -> 카테고리 삭제
        </h3>
    </div>
    
    <c:forEach var="categoryDto" items="${categoryList}" varStatus="status">
            <div class="container" style="position: absolute; margin-left: ${(status.index % 4)*300}px; margin-top:${Math.floor(status.index / 4)*100}px">
                <div class="front card">
                    <div class="categoryDiv" id="${categoryDto.c_category_id}">
                        <span class="cssCategory">${categoryDto.c_category_name}</span>
                    </div>
                </div>
                <div class="back card">
					<span class="cssDel">
					    <a href="${root}/manager/categoryDeleteOk.do?id=${categoryDto.c_category_id}">삭제</a>
				    </span>
                </div>
            </div>
        </c:forEach>
</div>
</body>
</html>