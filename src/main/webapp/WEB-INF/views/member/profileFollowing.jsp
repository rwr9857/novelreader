<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="${root}/css/profile/profile.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Overpass:wght@800&display=swap"
	rel="stylesheet">
</head>
<body>
	<c:if test="${memberDto.m_num==null}">
		<script type="text/javascript">
			alert("잘못된 접근입니다.");
			location.href="${root}"
		</script>
	</c:if>
	
	<script type="text/javascript">
		function follower(root, nickname) {
			location.href = root + "/member/profileFollower.do" + "?nickname=" + nickname;
		}

		function following(root, nickname) {
			location.href = root + "/member/profileFollowing.do" + "?nickname=" + nickname;
		}

		function novel(root, nickname) {
			location.href = root + "/member/profile.do" + "?nickname=" + nickname;
		}
	</script>
	<div id="profile">
		<div id="profile_shadow">
			<c:if test="${numSess==memberDto.m_num}">
			<a href="${root}/member/profileEdit.do?nickname=${memberDto.m_nickname}"
				class="profile_setting"> 프로필 설정</a>
			</c:if>
		</div>

		<div id="profile_background">
			<div id="inner_box">
				<div class="profile_info">
					<div class="profile_left_box">
						<c:if test="${memberDto.m_photo_path == null}">
							<img class="profile_image" alt="기본값" src="${root}/images/profile/profile_default.png"
								onclick="">
						</c:if>
						<c:if test="${memberDto.m_photo_path != null}">
							<img class="profile_image" alt="프로필사진" src="${root}/memberfile/${memberDto.m_photo_name}"
								onclick="">
						</c:if>
						
						<c:if test="${memberDto.m_num != numSess && numSess!=null}">
							<c:if test="${followCheck>0}">
								<form action="${root}/member/followDelete.do" method="post" id="followDelete">
									<input type="hidden" name="numSess" value="${numSess}">
									<input type="hidden" name="num" value="${memberDto.m_num}">
									<input type="hidden" name="nickname" value="${memberDto.m_nickname}">
									<div class="profile_follow_btn" style="background:#3fc92f;" onclick="document.getElementById('followDelete').submit();">
										<div class="btn_plus" style="font-size:36px">✔</div>
										팔로잉
									</div>
								</form>
							</c:if>
							<c:if test="${followCheck==0}">
								<form action="${root}/member/follow.do" method="post" id="doFollow">
									<input type="hidden" name="numSess" value="${numSess}">
									<input type="hidden" name="num" value="${memberDto.m_num}">
									<input type="hidden" name="nickname" value="${memberDto.m_nickname}">
									<div class="profile_follow_btn" onclick="document.getElementById('doFollow').submit();">
										<div class="btn_plus">+</div>
										팔로우
									</div>
								</form>
							</c:if>
							<div class="profile_nickname">${memberDto.m_nickname}</div>
						</c:if>
						
						<c:if test="${memberDto.m_num == numSess || numSess==null}">
							<div class="profile_nickname" style="margin-top:110px;">${memberDto.m_nickname}</div>
						</c:if>
						
						<div class="profile_intro">
							<p class="info_label">소개</p>
							<span class="info_content"> <c:if
									test="${memberDto.m_info_public == 1}">
										${memberDto.m_info}
							</c:if> <c:if test="${memberDto.m_info_public != 1}">
										비공개
							</c:if>
							</span>
						</div>
						<div class="profile_follow_box">
							<div class="follower_box"
								onclick="follower('${root}','${memberDto.m_nickname}')">
								${profileFollowerCount}<br />팔로워
							</div>
							<div class="following_box"
								onclick="following('${root}','${memberDto.m_nickname}')">
								${profileFollowingCount}<br />팔로잉
							</div>
							<div class="following_box"
								onclick="novel('${root}','${memberDto.m_nickname}')">
								${novelCount}<br />소설
							</div>
						</div>
					</div>

					<div class="profile_right_box">
						<div class="table">
							<div class="tr">
								<div class="td1">개인 홈페이지</div>
								<div class="td2">
									<c:if test="${memberDto.m_homepage_public == 1}">
										<a href="${memberDto.m_homepage_address}"
											style="color: blue; overflow: hidden; font-size: 16px;">
											${memberDto.m_homepage_address} </a>
									</c:if>

									<c:if test="${memberDto.m_homepage_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
								
							<div class="tr">
								<div class="td1">성별</div>
								<div class="td2">
									<c:if test="${memberDto.m_sex_public == 1}">
										<c:if test="${memberDto.m_sex == 1}">
											남성
										</c:if>
										<c:if test="${memberDto.m_sex == 2}">
											여성
										</c:if>
										<c:if test="${(memberDto.m_sex != 1) && (memberDto.m_sex != 2)}">
											기타
										</c:if>
									</c:if>
									<c:if test="${memberDto.m_sex_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
							<div class="tr">
								<div class="td1">거주지</div>
								<div class="td2">
									<c:if test="${memberDto.m_city_public == 1}">
										${memberDto.m_city}
									</c:if>
									<c:if test="${memberDto.m_city_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
							<div class="tr">
								<div class="td1">생일</div>
								<div class="td2">
									<c:if test="${memberDto.m_birthday_public == 1}">
										<fmt:formatDate value="${memberDto.m_birthday}" pattern="MM월 dd일"/>										
									</c:if>

									<c:if test="${memberDto.m_birthday_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>


				
				<%-- 팔로잉 리스트 --%>
				<div class="content">
					<div class="follow_list" id="following_list">
						<c:if test="${followingList.size() > 0}">
							<span class="menu">팔로잉</span>
						</c:if>
						<c:if test="${followingList.size() == null || followingList.size() == 0}">
							<span class="menu">팔로잉 목록이 없습니다</span>
						</c:if>
						
						<c:forEach var="profileFollowing" items="${followingList}">
							<form action="${root}/member/following_followDelete.do" method="post" id="following_followDelete">
								
								<input type="hidden" name="numSess" value="${numSess}">
								<input type="hidden" name="numDel" value="${profileFollowing.m_num}">
								<input type="hidden" name="nickname" value="${memberDto.m_nickname}">	
								<input type="hidden" name="pageNumber" value="${currentPage}">
							
								<div class="list">
									<c:if test="${profileFollowing.m_photo_path!=null}">
										<img alt="이미지 준비중" src="${root}/memberfile/${profileFollowing.m_photo_name}" class="profile_img" onclick="goToProfile('${root}','${profileFollowing.m_nickname}')">
									</c:if>
									<c:if test="${profileFollowing.m_photo_path==null}">
										<img alt="기본값" src="${root}/images/profile/profile_default.png" class="profile_img" onclick="goToProfile('${root}','${profileFollowing.m_nickname}')">
									</c:if>									
									<div class="follow_nickname" onclick="goToProfile('${root}','${profileFollowing.m_nickname}')">${profileFollowing.m_nickname}</div>
									
									<c:if test="${numSess == memberDto.m_num}">
										<img alt="x" src="${root}/images/profile/x_icon.png" class="follow_delete"
                                                onclick="deleteFollower('${root}/member/following_followDelete.do', {'numSess':'${memberDto.m_num}','nickname':'${memberDto.m_nickname}','pageNumber':'${currentPage}','numDel':'${profileFollowing.m_num}'})">
									</c:if>
								</div>
								

								
							</form>
						</c:forEach>
					</div>
				</div>
				
				<c:if test="${followingList.size()==0 && profileFollowingCount>0}">
					<script type="text/javascript">
						location.href="${root}/member/profileFollowing.do?nickname=${memberDto.m_nickname}&pageNumber=1";
					</script>
				</c:if>
				
				<script type="text/javascript">
					function goToProfile(root,nickname){
						location.href=root+"/member/profile.do?nickname="+nickname;
					}
					
					function deleteFollower(path,params){
						method = "post";
						
						if (confirm("팔로우를 취소 하시겠습니까?") == true){    //확인
							
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
				
				<%-- 페이지 --%>
				<div class="page">
					
					<%-- 총 페이지 수 : 모든 jstl은 문자열이니까 정수로 바꿔주는 작업.--%>
					<fmt:parseNumber var="pageCount" value="${profileFollowingCount/listSize + (profileFollowingCount % listSize == 0 ? 0:1)}" integerOnly="true"/>
					
					<%-- 페이지 블럭 --%>
					<c:set var="pageBlock" value="${10}"/>
					
					<%-- 요청 페이지의 시작페이지 / 끝페이지 번호 --%>
					<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
					<c:set var="startPage" value="${result*pageBlock+1}"/>
					<c:set var="endPage" value="${startPage+pageBlock-1}"/>
					
					
					<c:if test="${endPage > pageCount}">  <%-- 끝번호보다 총 페이지 수가 더 적을경우 --%>
						<c:set var="endPage" value="${pageCount}"/>
					</c:if>
					
					<c:if test="${startPage > pageBlock}"> <%-- 시작이11페이지인데 페이지 블록이 10이하일 경우 --%>
						<a href="${root}/member/profileFollowing.do?nickname=${memberDto.m_nickname}&pageNumber=${startPage-pageBlock}">[이전]</a>
					</c:if>
					
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
						<a href="${root}/member/profileFollowing.do?nickname=${memberDto.m_nickname}&pageNumber=${i}" style="cursor:pointer; color:#001076; font-weight:800; font-size:18px;">[${i}]</a>
						</c:if>
						<c:if test="${i != currentPage}">
						<a href="${root}/member/profileFollowing.do?nickname=${memberDto.m_nickname}&pageNumber=${i}" style="cursor:pointer; color:#83aaff; font-weight:600; font-size:18px;">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<c:if test="${endPage < pageCount}">   <%-- 끝이10페이지인데 총 페이지수가 11이상일경우--%>
						<a href="${root}/member/profileFollowing.do?nickname=${memberDto.m_nickname}&pageNumber=${startPage+pageBlock}">[다음]</a>
					</c:if>
					
					
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>