<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="${root}/css/login/login.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
        <div class = "loginbox">
            <h1 style = "margin-top : 30px; color : #0096fa;">NOVELREADER</h1>
            <h3 style = "color : #757c80; font-size : 14px; font-weight : bold;">소설의 모든것</h3>
            <div class = "buttonclass">
                <div><button class = register onclick = "location.href = 'register.html'">회원가입</button></div>
                <div><button class = login onclick = "location.href = 'loginpage.html'">로그인</button></div>
            </div>
            <h3 style = "color : #757c80; margin-top : 40px;">가지고 있는 계정으로 시작하기</h3>
            <div class = social>
                <img src="${root}/images/kakao.png" a href =""> <img src="${root}/images/naver.jpg" a href ="">
                <img src="${root}/images/google.jpg" a href ="">
            </div>
            <h3 class = "footer">Copyright ⓒ 2022 by GTEC Kmove JP-A All Pictures cannot be copied without permission.</h3>
        </div>

</body>
</html>