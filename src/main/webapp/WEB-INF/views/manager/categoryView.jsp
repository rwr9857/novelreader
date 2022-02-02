<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${root}/css/manager/category.css">

    <script type="text/javascript" src="${root}/javascript/xhr/xhr.js"></script>
    <script type="text/javascript" src="${root}/javascript/manager/categoryWrite.js"></script>
    <script type="text/javascript" src="${root}/javascript/manager/categoryUpdate.js"></script>
    <title>Insert title here</title>
</head>
<body>
<div style="margin-left: 265px; margin-top: 0px; border: 1px solid black; height: 1100px; background: rgb(234, 240, 253);overflow: scroll;">
    <div class="menuText">
        <h1>소설 카테고리 관리</h1>
        <h3>
            관리자 모드 -> <span style="color: gray;">소설 카테고리 관리</span> -> 카테고리 조회
        </h3>
    </div>


    <div id="listAllDiv">
        <!-- 기존 카테고리 리스트 -->
        <c:forEach var="categoryDto" items="${categoryList}" varStatus="status">
            <div class="container" style="position: absolute; margin-left: ${(status.index % 4)*300}px; margin-top:${Math.floor(status.index / 4)*100}px">
                <div class="front card">
                    <div class="categoryDiv" id="${categoryDto.c_category_id}">
                        <span class="cssCategory">${categoryDto.c_category_name}</span>
                    </div>
                </div>
                <div class="back card">
					<span class="cssUp">
					    <a href="">수정</a>
				    </span>
                </div>
            </div>
        </c:forEach>
        <c:set var="lastIndex" value="${fn:length(categoryList)}"/>
        <!-- 새로운 카테고리 ajax -->
        
        <div class="container" style="position: absolute; margin-left: ${(lastIndex % 4)*300}px; margin-top:${Math.floor(lastIndex / 4)*100}px">
        	<div class="front card">
            	<p>추가</p>
        	</div>
        	<div class="back card">
            	<input style="width:90px;" id="writeCategory" type="text" size="45" name="writer"
                   onkeydown="javascript:if(event.keyCode==13) {writeToServer('${root}');}"/>
        	</div>
    	</div>
    	
    </div>
    
    
</div>
</body>
</html>