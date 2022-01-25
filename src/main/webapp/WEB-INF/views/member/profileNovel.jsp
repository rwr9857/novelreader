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
			<a href="${root}/member/setting.do?memberNum=${memberDto.m_num}"
				class="profile_setting"> 프로필 설정</a>
		</div>

		<div id="profile_background">
			<div id="inner_box">
				<div class="profile_info">
					<div class="profile_left_box">
						<c:if test="${memberDto.m_photo_path == null}">
							<img class="profile_image" alt="기본값" src="${root}/images/profile_default.png"
								onclick="">
						</c:if>
						<c:if test="${memberDto.m_photo_path != null}">
							<img class="profile_image" alt="프로필사진" src="${root}/images/????"
								onclick="">
						</c:if>
						
						<c:if test="${memberDto.m_num != numSess}">
							<div class="profile_follow_btn" onclick="">
								<div class="btn_plus">+</div>
								팔로우
							</div>
							<div class="profile_nickname">${memberDto.m_nickname}</div>
						</c:if>
						
						<c:if test="${memberDto.m_num == numSess}">
						
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
								7${novel_count}<br />소설
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
										<c:if test="${memberDto.m_sex == 0}">
											여성
										</c:if>
										<c:if test="${(memberDto.m_sex != 0) && (memberDto.m_sex != 1)}">
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
			
				<div class="content">
					<%-- <c:forEach var="novel_homeDto" items="${novel_homeDto}"> --%>
					<div class="novel_list" id="novel_list">
						<span class="menu">소설</span>
						<!-- while/for문 추가 -->
						<div class="list" onclick="소설바로가기함수">
							<img alt="이미지 불러오는중" src="${root}/images/novelLabel/label1.jpg" class="novel_image">
							<div class="novel_inner">
								<div class="titleNdate">
									<div class="title">모르는 만화에 빙의했다</div>

									<div class="date">2021.02.23</div>
								</div>
								
								<div class="like_box">
									<div class="like">
										<img alt="좋아요" src="${root}/images/like.png"> <span>65536</span>
									</div>
								
									<div class="dislike">
										<img alt="싫어요" src="${root}/images/dislike.png"> <span>256</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%-- </c:forEach> --%>
					
					<!-- 페이지 작업 -->
				</div>

			</div>
		</div>
	</div>

</body>
</html>