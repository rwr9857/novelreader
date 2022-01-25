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
    <link rel="stylesheet" href="${root}/css/login/register.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
        <div class = "loginbox">
            <h1 style = "margin-top : 10px; color : #0096fa;">NOVELREADER</h1>
            <h3 style = "color : #757c80; font-size : 14px; font-weight : bold;">소설의 모든것</h3>
            <h2 style = "color : rgb(104, 109, 112); font-size:18px; font-weight : bold;
            margin-top : 30px; margin-bottom : -5px;">회원 가입</h2>
            <div class = "inputbox">
                <label for ="id">ID</label><input type="text" id = "id" placeholder ="ID를 입력하세요" required>
                <label for="nickname">닉네임</label><input type="text" id = "nickname" placeholder ="닉네임을 입력하세요">
                <label for="pw">비밀번호</label> <input type="text" id = "pw" placeholder ="비밀번호를 입력하세요">
                <label for="pwcheck">비밀번호 확인</label>  <input type="text" id = "pwcheck" placeholder ="비밀번호를 다시 입력하세요">
                <label for="E-mail">E-mail</label>   <input type="text" id = "E-mail" placeholder ="E-mail을 입력하세요">
            </div>
            <div class="inputradio">
                <label for="gender">성별</label>
                <label for="male">남자</label><input type="radio" id = "radio" name ="gender">
                <label for="female">여자</label><input type="radio" id = "radio" name ="gender">
                <label for="etc">기타</label><input type="radio" id = "radio" name ="gender">
            </div>     
            <div class = "E-mail_check" >  
                <label for="E-mail_check">이메일 수신 동의</label><input type="checkbox" id = "E-mail_check" name = "E-mail_check">           
            </div>
            <div class = "agree">    
                <label for ="agree">이용규약과 개인정보보호정책에 동의함</label><input type="checkbox" id ="checkbox" name = "agree">
            </div>
            <div class ="social">
                <h3>다음으로 로그인</h3>
                <img src="${root}/images/kakao.png" a href =""> <img src="${root}/images/naver.jpg" a href ="">
                <img src="${root}/images/google.jpg" a href ="">
            </div>
            <button class = "registerbutton">가입하기</button>
            <h3 class = "footer">Copyright ⓒ 2022 by GTEC Kmove JP-A All Pictures cannot be copied without permission.</h3>
        </div>

</body>
</html>