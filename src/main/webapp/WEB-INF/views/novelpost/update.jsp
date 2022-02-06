<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회차수정</title>
<link rel="stylesheet" type="text/css" href="${root}/css/novelpost/register.css">
</head>
<body>
	
	<form action="${root}/novelpost/updateOk.do" method="post">
		<div class="zentaiwaku">
		<div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
            <div class="line2"> <!-- 빈칸, 카테고리 와꾸-->
             <font>회차수정</font>
                <input type="text" name="N_POST_TITLE" placeholder="회차 제목을 입력하세요" value="${novelPostDto.n_POST_TITLE}"/><!-- 제목입력칸-->
           </div>
            <div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
        <div class="textsty"> <!-- 글꼴굵기 글꼴기울기 글꼴....-->
        </div>
        <div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
        <div class="blenk"> <!-- 텍스트박스 와꾸-->
            <textarea class="writingbox" name="N_POST_CONTENT" placeholder="내용을 입력하세요">${novelPostDto.n_POST_CONTENT}</textarea>
        </div>
        <div style="border: white; width: 1100px; height: 10px;"></div>
		<div class="footer">
			<input type="submit" value="확인"></input>
			<input type="reset" value="취소"></input>
			<input type="hidden" name="n_num" value="${nNumSess}" />
			<input type="hidden" name="n_post_num" value="${novelPostDto.n_POST_NUM}" />
		</div>
	</div>
	</form>
</body>
</html>