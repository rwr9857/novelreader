<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${root}/css/bestwriter/bestwriter.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="wrap">
    	<div class="wrap_inner">
	        <h1 style="text-align:center; margin-top:30px; font-weight:bold; color:rgb(58, 52, 52);">인기작가</h1>
	        <div class="profile">
	        	<c:forEach var="memberDto" items="${rankingList}">
		            <div class="profile2">
		            	<c:if test="${memberDto.m_photo_path == null}">
							<img class="sajin" alt="프로필사진" src="${root}/images/profile/profile_default.png"
								onclick="goToProfile('${root}','${memberDto.m_nickname}')">
						</c:if>
						<c:if test="${memberDto.m_photo_path != null}">
							<img class="sajin" alt="프로필사진" src="${root}/memberfile/${memberDto.m_photo_name}"
								onclick="goToProfile('${root}','${memberDto.m_nickname}')">
						</c:if>
		                <h2 onclick="goToProfile('${root}','${memberDto.m_nickname}')">${memberDto.m_nickname}</h2>
		            </div>
	            </c:forEach>
	        </div>
	        
	        <script type="text/javascript">
		        function goToProfile(root,nickname){
					location.href=root+"/member/profile.do?nickname="+nickname;
				}
	        </script>
	        
	        <div class="textbox">
	        	<c:forEach var="memberDto" items="${rankingList}">
		            <div class="textbox2">
		                <h3>소개</h3>
		                <p style="min-height: 120px;">${memberDto.m_info}</p>
		                
		                <!-- <h3 style="margin-top:50px;">최신작</h3>
		                <p>(미구현)</p>-->
		                 
		            </div>
		        </c:forEach>
	        </div> 
		</div>
    </div>


</body>
</html>