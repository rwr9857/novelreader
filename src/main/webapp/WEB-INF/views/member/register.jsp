<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
<script type="text/javascript" src="${root}/javascript/xhr/xhr.js"></script>

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	// SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('4113a385559d634d4d781dc26f04e432');

	// SDK 초기화 여부를 판단합니다.
	console.log(Kakao.isInitialized());
</script>
<script type="text/javascript">
	function loginFormWithKakao() {
		Kakao.Auth
				.loginForm({
					success : function(authObj) {
						//alert(JSON.stringify(authObj));
						var params = "token=" + JSON.stringify(authObj);
						sendRequest(
								"POST",
								"http://localhost:8181/novelreader/member/kakaologin.do",
								params, fromServer);

						function fromServer() {
							if (xhr.readyState == 4 && xhr.status == 200) {
								//alert(xhr.responseText);
							}
						}
					},
					fail : function(err) {
						console.log(JSON.stringify(err));
					},
				})
	}
	
	function naverlogin() {
		window.open('https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=k7RIM1ejpagn8MbzDO3E&redirect_uri=http://localhost:8181/novelreader/member/naverlogin.do&state=dc1bf16a5614dbb206e9b9629154c1ef','naver','width=490,height=500,status=no,toolbar=no,resizable=yes,scrollbars=no')		
	}
</script>


</head>
<body>
<c:if test="${premission !=null}">
		<script type="text/javascript">
			location.href = "/novelreader/index.jsp";
		</script>
	</c:if>

	<c:if test="${premission == null}">
	<form name="memberForm" action="${root}/member/registerOk.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="M_ID" />
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="M_PW" />
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type="password" name="passwordCheck" />
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="M_EMAIL" size="20" />
				</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>
					<input type="text" name="M_NICKNAME" />
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="M_SEX" value="1" />
					<input type="radio" name="M_SEX" value="0" />
				</td>
			</tr>
			<tr>
				<td>이메일 수신 동의</td>
				<td>
					<input type="checkbox" name="M_EMAIL_AGREE" value="1" />
				</td>
			</tr>
			<input type="hidden" name="M_PLATFORM" value="local" />
		</table>
		<div>
			<input type="submit" value="가입" />
			<input type="reset" value="취소" />
		</div>
	</form>

	<a id="reauthenticate-popup-btn" href="javascript:loginFormWithKakao()"> 
		<img src="${root}/images/kakao_login_medium_narrow.png" width="200" alt="카카오 로그인 버튼" />
	</a>
	<a  href="javascript:naverlogin()">
		<img src="${root}/images/naver_login.png" width="200" alt="네이버 로그인 버튼" />
	</a>
	</c:if>

</body>
</html>