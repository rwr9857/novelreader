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
<link rel="stylesheet" type="text/css" href="${root}/css/novelpost/register.css">
</head>
<body>
	<form action="${root}/novelpost/registerOk.do" method="post" >
		<div class="zentaiwaku">
		<div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
            <div class="line2"> <!-- 빈칸, 카테고리 와꾸-->
             <font>회차등록</font>
                <input type="text" name="title" placeholder="회차 제목을 입력하세요"></input><!-- 제목입력칸-->
           </div>
            <div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
        <div class="textsty"> <!-- 글꼴굵기 글꼴기울기 글꼴....-->
            <button type="button"><img src="${root}/images/notice/bold.png" width="15px" height="15px"></button>
            <button type="button"><img src="${root}/images/notice/italic-text.png" width="15px" height="15px"></button>
            <button type="button"><img src="${root}/images/notice/underline.png" width="15px" height="18px"></button>
        </div>
        <div style="border: white; width: 1100px; height: 10px;"></div><!-- 한칸띄우기-->
        <div class="blenk"> <!-- 텍스트박스 와꾸-->
            <textarea class="writingbox" placeholder="내용을 입력하세요"></textarea>
        </div>
        <div style="border: white; width: 1100px; height: 10px;"></div>
		<div class="footer">
			<input type="submit" value="확인"></input>
			<input type="reset" value="취소"></input>
			<input type="hidden" name="n_num" value="${nNumSess}" />
		</div>
	</div>
	</form>
	
</body>
</html>