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
<link rel="stylesheet" href="${root}/css/profile/profileEdit.css">

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
			<li onclick="profileEdit('${root}','${nicknameSess}')" class="profile_edit">
				<p>프로필 수정</p>
			</li>
			
			<li onclick="accountEdit('${root}','${nicknameSess}')" >
				<p>계정 설정</p>
			</li>
		</ul>
	</div>

	<div id="content_box">
		<div class="content_outer">
			<div class="content_inner">
				<form action="${root}/member/profileEditOk.do" method="post" onsubmit="return nicknameCheck('${memberDto.m_nickname}')">
					<span class="menu">프로필 수정</span>
					<div class="table">
						<div class="tr">
							<div class="td1" style="border-radius: 25px 0px 0px 0px;">
								프로필 이미지
							</div>
							
							<div class="td2">
								<c:if test="${memberDto.m_photo_path == null}">
								<img class="profile_image" alt="기본값" src="${root}/images/profile_default.png"
									onclick="">
								</c:if>
								<c:if test="${memberDto.m_photo_path != null}">
									<img class="profile_image" alt="프로필사진" src="${root}/images/????"
										onclick="">
								</c:if>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1">
								닉네임
							</div>
							
							<div class="td2">
								<input type="text" name="m_nickname" value="${memberDto.m_nickname}" class="nickname" id="nickname" style="width:180px;" onkeyup="nicknameCheck('${memberDto.m_nickname}')">
								<p id="nicknameCount">(0 / 10)</p>
								<div class="nicknameErr" style="color:red; float:left; line-height:43px; margin-left:20px;">이미 사용중인 닉네임입니다.</div>
								<div class="nicknameEmpty" style="color:red; float:left; line-height:43px; margin-left:20px;">닉네임을 입력하세요</div>
								<div class="nicknameSuccess" style="color:blue; float:left; line-height:43px; margin-left:20px;">사용 가능한 닉네임입니다.</div>
							</div>
						</div>
						
						<script type="text/javascript">
							//닉네임 중복체크 ajax함수
							$(".nicknameErr").hide();
							$(".nicknameEmpty").hide();
							$(".nicknameSuccess").hide();
							
							function nicknameCheck(nickname){
								$(".nicknameErr").hide();
								$(".nicknameEmpty").hide();
								$(".nicknameSuccess").hide();
								
								var check=false;
								
								if($("#nickname").val().length!=0){
									if($("#nickname").val()!=nickname){
										$.ajax({
											url:"${root}/member/nicknameCheck.do",
											type: "post",
											async: false, 
											data: {
												"nickname":$("#nickname").val(),
											},
											
											success: function(result){
												if($.trim(result)  >  0){ //닉네임 중복시
													$(".nicknameErr").show();
													
													check=false;
													
												}else if($.trim(result)  !=  1){ //중복이 아닐 시 (사용가능)
													$(".nicknameErr").hide();
													$(".nicknameSuccess").show();
													
													check=true;
												}
											}
										});
									}else if ($("#nickname").val()==nickname){
										check=true;
										$(".nicknameErr").hide();
									}
								}else if($("#nickname").val().length==0){
									check=false;
									$(".nicknameEmpty").show();
								}
								
								return check;
							}
						</script>
						
						
						
						<div class="tr">
							<div class="td1">
								홈페이지 주소
							</div>
							
							<div class="td2">
								<input type="text" name="m_homepage_address" value="${memberDto.m_homepage_address}" class="homepage_address" id="homepage_address" style="width:300px;">
								<p id="homepageCount">(0 / 100)</p>
								<select name="m_homepage_public" class="homepage_public" id="homepage_public">
									<c:if test="${memberDto.m_homepage_public==0}">
										<option value="0" selected>비공개</option>
										<option value="1">공개</option>
									</c:if>
									<c:if test="${memberDto.m_homepage_public==1}">
										<option value="0">비공개</option>
										<option value="1" selected>공개</option>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1">
								성별
							</div>
							
							<div class="td2">
								<label>남성</label>
								<input type="radio" name="m_sex" value="1" class="sexM" id="sexM">
								<label style="margin-left:30px;">여성</label>
								<input type="radio" name="m_sex" value="2" class="sexW" id="sexW">
								
								<select name="m_sex_public" class="sex_public" id="sex_public">
									<c:if test="${memberDto.m_sex_public==0}">
										<option value="0" selected>비공개</option>
										<option value="1">공개</option>
									</c:if>
									<c:if test="${memberDto.m_sex_public==1}">
										<option value="0">비공개</option>
										<option value="1" selected>공개</option>
									</c:if>
								</select>
							</div>
						</div>
						
						<c:if test="${memberDto.m_sex==1}">
							<script type="text/javascript">
								document.getElementById('sexM').checked=true;
							</script>
						</c:if>
						
						<c:if test="${memberDto.m_sex==2}">
							<script type="text/javascript">
								document.getElementById('sexW').checked=true;
							</script>
						</c:if>
						
						
						<div class="tr">
							<div class="td1">
								거주지
							</div>
							
							<div class="td2">
								<input type="text" name="m_city" value="${memberDto.m_city}" class="city" id="city" style="width:300px;">
								<p id="cityCount">(0 / 50)</p>
								<select name="m_city_public" class="city_public" id="city_public">
									<c:if test="${memberDto.m_city_public==0}">
										<option value="0" selected>비공개</option>
										<option value="1">공개</option>
									</c:if>
									<c:if test="${memberDto.m_city_public==1}">
										<option value="0">비공개</option>
										<option value="1" selected>공개</option>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1">
								생일
							</div>
							
							<div class="td2">
								<input type="date" name="birthday" value="<fmt:formatDate value="${memberDto.m_birthday}" pattern="YYYY-MM-dd"/>" class="birthday" id="birthday">
								<select name="m_birthday_public" class="birthday_public" id="birthday_public">
									<c:if test="${memberDto.m_birthday_public==0}">
										<option value="0" selected>비공개</option>
										<option value="1">공개</option>
									</c:if>
									<c:if test="${memberDto.m_birthday_public==1}">
										<option value="0">비공개</option>
										<option value="1" selected>공개</option>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="tr">
							<div class="td1" style="border-radius: 0px 0px 0px 25px; border:0px;">
								내 소개
							</div>
							
							<div class="td2" style="border:0px;">
								<textarea cols="50" rows="4" name="m_info" class="info" id="info" style="resize:none; margin:10px; width:370px; height:80px">${memberDto.m_info}</textarea>
								<p id="textCount" style="margin-top:40px;">(0 / 60)</p>
								<select name="m_info_public" class="info_public" id="info_public" style="margin-top:40px;">
									<c:if test="${memberDto.m_info_public==0}">
										<option value="0" selected>비공개</option>
										<option value="1">공개</option>
									</c:if>
									<c:if test="${memberDto.m_info_public==1}">
										<option value="0">비공개</option>
										<option value="1" selected>공개</option>
									</c:if>
								</select>
							</div>
						</div>
						
						<script type="text/javascript">
						
							//닉네임
							$(document).ready(function() {
							    $('#nicknameCount').html("("+$('#nickname').val().length+" / 10)");
							});
							
							$(document).ready(function() {
							    $('#nickname').on('keyup', function() {
							        $('#nicknameCount').html("("+$('#nickname').val().length+" / 10)");
							 
							        if($(this).val().length > 10) {
							            $(this).val($(this).val().substring(0, 10));
							            $('#nicknameCount').html("(10 / 10)");
							        }
							    })
							});
							
							
							//홈페이지 주소
							$(document).ready(function() {
						        $('#homepageCount').html("("+$('#homepage_address').val().length+" / 100)");
							});
							
							$(document).ready(function() {
							    $('#homepage_address').on('keyup', function() {
							        $('#homepageCount').html("("+$('#homepage_address').val().length+" / 100)");
							 
							        if($(this).val().length > 100) {
							            $(this).val($(this).val().substring(0, 100));
							            $('#homepageCount').html("(100 / 100)");
							        }
							    })
							});
							
							//거주지
							$(document).ready(function() {
						        $('#cityCount').html("("+$('#city').val().length+" / 50)");
							});
							
							$(document).ready(function() {
							    $('#city').on('keyup', function() {
							        $('#cityCount').html("("+$('#city').val().length+" / 50)");
							 
							        if($(this).val().length > 50) {
							            $(this).val($(this).val().substring(0, 50));
							            $('#cityCount').html("(50 / 50)");
							        }
							    })
							});
							
							//내 소개
							$(document).ready(function() {
						        $('#textCount').html("("+$('#info').val().length+" / 60)");
							});
							
							$(document).ready(function() {
							    $('#info').on('keyup', function() {
							        $('#textCount').html("("+$('#info').val().length+" / 60)");
							 
							        if($(this).val().length > 60) {
							            $(this).val($(this).val().substring(0, 60));
							            $('#textCount').html("(60 / 60)");
							        }
							    })
							});
						</script>
						
						
					</div>
					<input type="hidden" name="m_num" value="${numSess}">
					<input type="hidden" name="nicknameSess" value="${nicknameSess}">
					<input type="submit" value="저장">
				</form>
			</div>
		</div>
	</div>
</body>
</html>