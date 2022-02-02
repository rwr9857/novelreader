<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="${root}/css/profile/accountEdit.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Overpass:wght@800&display=swap"
	rel="stylesheet">
</head>
<body>
	<!-- cdn for modernizr, if you haven't included it already -->
	<script src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
	<!-- polyfiller file to detect and load polyfills -->
	<script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
	<script>
	  webshims.setOptions('waitReady', false);
	  webshims.setOptions('forms-ext', {types: 'date'});
	  webshims.polyfill('forms forms-ext');
	</script>
	
	<script type="text/javascript">		
		function profileEdit(root,nickname) {
			location.href=root+"/member/profileEdit.do?nickname="+nickname;
		}
		
		function accountEdit(root,nickname) {
			location.href=root+"/member/accountEdit.do?nickname="+nickname;
		}
	</script>
	
	<c:if test="${numSess != memberDto.m_num}">
		<script type="text/javascript">
			alert("잘못된 접근 입니다.");
			location.href = "/novelreader";
		</script>
	</c:if>
	
	<div id="menu_bar">
		<ul id="menu_bar_ul">
			<li onclick="profileEdit('${root}','${nicknameSess}')" >
				<p>프로필 수정</p>
			</li>
			
			<li onclick="accountEdit('${root}','${nicknameSess}')" class="account_edit">
				<p>계정 설정</p>
			</li>
		</ul>
	</div>

	<div id="content_box">
		<div class="content_outer">
			<div class="content_inner">
				<form action="${root}/member/accountEditOk.do" method="post" onsubmit="return emailCheck()">
					<span class="menu">계정 설정</span>
					<div class="table">
						
						<div class="tr">
							<div class="td1" style="border-radius: 25px 0px 0px 0px;">
								ID
							</div>
							
							<div class="td2">
								<p class="id">${memberDto.m_id}</p>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1">
								가입 일자
							</div>
							
							<div class="td2">
								<p class="register_date"><fmt:formatDate value="${memberDto.m_register_date}" pattern="YYYY년 MM월 dd일"/></p>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1">
								이메일
							</div>
							
							<div class="td2">
								<input type="email" name="m_email" value="${memberDto.m_email}" class="email" id="email" style="width:300px;" onkeyup="emailCheck()">
								<p id="emailCount">(0 / 64)</p>
								<div class="emailErr" style="color:red; float:left; line-height:43px; margin-left:20px;">이미 사용중인 이메일입니다.</div>
								<div class="emailEmpty" style="color:red; float:left; line-height:43px; margin-left:20px;">이메일을 입력하세요</div>
								<div class="emailSuccess" style="color:blue; float:left; line-height:43px; margin-left:20px;">사용 가능한 이메일입니다.</div>
							</div>
						</div>
						
						<script type="text/javascript">
							//닉네임 중복체크 ajax함수
							$(".emailErr").hide();
							$(".emailEmpty").hide();
							$(".emailSuccess").hide();
							
							function emailCheck(){
								email=$(".email").val();
								$(".emailErr").hide();
								$(".emailEmpty").hide();
								$(".emailSuccess").hide();
								
								var check=false;
								
								if($("#email").val().length!=0){
									if($("#email").val()!='${memberDto.m_email}'){ //자기 원래 이메일이 아니라면
										$.ajax({
											url:"${root}/member/emailCheck.do",
											type: "post",
											async: false, 
											data: {
												"email":$("#email").val(),
											},
											
											success: function(result){
												if($.trim(result)  >  0){ //닉네임 중복시
													$(".emailErr").show();
													
													check=false;
													
												}else if($.trim(result)  !=  1){ //중복이 아닐 시 (사용가능)
													$(".emailErr").hide();
													$(".emailSuccess").show();
													
													check=true;
													
													if(pwCheck()==true){
														check=true;
													}else if(pwCheck()==false){
														check=false;
													}
												}
											}
										});
									}else if ($("#email").val()=='${memberDto.m_email}'){ //자기 원래 이메일이라면
										check=true;
										$(".emailErr").hide();
										
										if(pwCheck()==true){
											check=true;
										}else if(pwCheck()==false){
											check=false;
										}
									}
								}else if($("#email").val().length==0){
									check=false;
									$(".emailEmpty").show();
								}
								
								
								
								return check;
							}
						</script>
						
						
						
						
						
						
						
						<div class="tr">
							<div class="td1">
								이메일 수신
							</div>
							
							<div class="td2">
								<label>거부</label>
								<input type="radio" name="m_email_agree" value="0" class="email_decline" id="email_decline">
								<label style="margin-left:30px;">동의</label>
								<input type="radio" name="m_email_agree" value="1" class="email_agree" id="email_agree">
							</div>
						</div>
						
						<c:if test="${memberDto.m_email_agree==0}">
							<script type="text/javascript">
								document.getElementById('email_decline').checked=true;
							</script>
						</c:if>
						
						<c:if test="${memberDto.m_email_agree==1}">
							<script type="text/javascript">
								document.getElementById('email_agree').checked=true;
							</script>
						</c:if>
						
						<div class="tr">
							<div class="td1">
								비밀번호 변경<br/>
								<span style="font-size:14px; display:block; margin-top:-3px;">(변경시 입력)</span>
							</div>
							
							<div class="td2">
								<input type="password" name="m_pw" class="pw" id="pw" style="width:200px;" onkeyup="pwCheck()">
								<p id="pwCount">(0 / 16)</p>
								<div style="color:red; float:left; line-height:43px; margin-left:20px;" id="pwErr1">숫자, 영문자, 특수문자 조합으로 8~20자리를 사용해야 합니다.</div>
								<div style="color:red; float:left; line-height:43px; margin-left:20px;" id="pwErr2">비밀번호는 공백 없이 입력해주세요.</div>
							</div>
						</div>
						
						<div class="tr" >
							<div class="td1" style="border-radius: 0px 0px 0px 25px; border:0px;">
								비밀번호 변경 확인<br/>
								<span style="font-size:14px; display:block; margin-top:-3px;">(변경시 입력)</span>
							</div>
							
							<div class="td2" style="border:0px;">
								<input type="password" class="pwRe" id="pwRe" style="width:200px;" onkeyup="pwReCheck()">
								<p id="pwReCount">(0 / 16)</p>
								<div style="color:red; float:left; line-height:43px; margin-left:20px;" id="pwReErr">비밀번호가 일치하지 않습니다</div>
							</div>
						</div>
						
						<script type="text/javascript">
							$("#pwReErr").hide();
							$("#pwErr1").hide();
							$("#pwErr2").hide();
							
							function pwCheck(){
								password=$("#pw").val();
								var num = password.search(/[0-9]/g); // 숫자사용
								var eng = password.search(/[a-z]/ig); // 영문사용
								var spe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
								
								if(password.length>0){								//빈칸이 아니라면
									if(password.length < 8 || password.length > 20){	//8~20자가 아닐때
										$("#pwErr1").show();
										$("#pwErr2").hide();
										pwReCheck();
									    return false;
									    
									}else if(num < 0 || eng < 0 || spe < 0 ){	//숫자와 영문자 기호 한쪽이라도 없을때
										$("#pwErr1").show();
										$("#pwErr2").hide();
										pwReCheck();
										return false;
										
									}else if(password.search(/\s/) != -1){			//공백이 있을때
										$("#pwErr1").hide();
										$("#pwErr2").show();
										pwReCheck();
										return false;
										
									}else{										//제대로 입력 했을때
										$("#pwErr1").hide();
										$("#pwErr2").hide();
										
										if(pwReCheck()==true){					//비밀번호 변경 확인도 제대로 됐다면
											return true;
										
										}else{									//비밀번호 변경 확인이 이상하다면
											return false;
										}
									}
								}else{												//빈칸이라면
									$("#pwErr1").hide();
									$("#pwErr2").hide();
									pwReCheck();
									return true;
								}
								
							}
						
							
							
							
							
							function pwReCheck(){
								check=false;
								
								if($("#pw").val().length==0 && $("#pwRe").val().length==0){ //둘다 빈칸이라면
									$("#pwReErr").hide();
									check=true;
								}else if($("#pw").val()==$("#pwRe").val()){	//둘의 값이 같다면
									$("#pwReErr").hide();
									check=true;
								}else{
									$("#pwReErr").show();
									check=false;
								}
								
								return check;
							}
							
						</script>
						
						
						
						
						
						
						
						
						<script type="text/javascript">
							
							
							//이메일
							$(document).ready(function() {
							    $('#emailCount').html("("+$('#email').val().length+" / 64)");
							});
							
							$(document).ready(function() {
							    $('#email').on('keyup', function() {
							        $('#emailCount').html("("+$('#email').val().length+" / 64)");
							 
							        if($(this).val().length > 64) {
							            $(this).val($(this).val().substring(0, 64));
							            $('#emailCount').html("(64 / 64)");
							        }
							    })
							});
							
							//비밀번호
							$(document).ready(function() {
							    $('#pwCount').html("("+$('#pw').val().length+" / 16)");
							});
							
							$(document).ready(function() {
							    $('#pw').on('keyup', function() {
							        $('#pwCount').html("("+$('#pw').val().length+" / 16)");
							 
							        if($(this).val().length > 16) {
							            $(this).val($(this).val().substring(0, 16));
							            $('#pwCount').html("(16 / 16)");
							        }
							    })
							});
							
							//비밀번호 확인
							$(document).ready(function() {
							    $('#pwReCount').html("("+$('#pwRe').val().length+" / 16)");
							});
							
							$(document).ready(function() {
							    $('#pwRe').on('keyup', function() {
							        $('#pwReCount').html("("+$('#pwRe').val().length+" / 16)");
							 
							        if($(this).val().length > 16) {
							            $(this).val($(this).val().substring(0, 16));
							            $('#pwReCount').html("(16 / 16)");
							        }
							    })
							});
							
							
						</script>
						
						
					</div>
					
					<div id="resign" class="resign" onclick="resign()">탈퇴</div>
					<script type="text/javascript">
						function resign(){
							method = "post";
							path = "${root}/member/resign.do"
							params = {'m_num':'${memberDto.m_num}'}	//여러개 넣을 수도 있으니 혹시몰라서 키밸류로함
							
							if (confirm("정말 탈퇴하시겠습니까?") == true){    //확인
								var form = document.createElement("form");
								   form.setAttribute("method", method);
								   form.setAttribute("action", path);
								   for(var key in params) {
								       var hiddenField = document.createElement("input");
								       hiddenField.setAttribute("type", "hidden");
								       hiddenField.setAttribute("name", key);
								       hiddenField.setAttribute("value", params[key]);
								       
								       form.appendChild(hiddenField);
								   }
								   document.body.appendChild(form);
								   form.submit();

							}else{   //취소
								return false;
							}
						}
					</script>
					
					<input type="hidden" name="m_num" value="${numSess}">
					<input type="hidden" name="nicknameSess" value="${nicknameSess}">
					<input type="submit" value="저장">
				</form>
			</div>
		</div>
	</div>
</body>
</html>