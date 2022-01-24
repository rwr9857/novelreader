<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			location.href=root + "/profile/follower.do" + "?nickname=" + nickname ;
		}
		
		function following(root, nickname) {
			location.href=root + "/profile/following.do" + "?nickname=" + nickname ;
		}
		
		function novel(root, nickname) {
			location.href=root + "/profile/novel.do" + "?nickname=" + nickname ;
		}
	</script>
	<div id="profile">
		<div id="profile_shadow">
			<a
				href="${root}/member/setting.do?memberNum="
				class="profile_setting"> 프로필 설정</a>
		</div>

		<div id="profile_background">
			<div id="inner_box">
				<div class="profile_info">
					<div class="profile_left_box">
						<img class="profile_image" alt="프로필사진" src="${root}/image/kms.jpg"
							onclick="">
						<!-- 프로필 사진도 ${memberDto.m_}뭐시기로 경로 받아야함 -->
						<div class="profile_follow_btn" onclick="">
							<div class="btn_plus">+</div>
							팔로우
						</div>
						<div class="profile_nickname">Dongmool1999${memberDto.m_nickname}</div>
						<div class="profile_intro">
							<p class="info_label">소개</p>
							<span class="info_content">
							<c:if test="${memberDto.m_info_public == 1}">
										${memberDto.m_info}
							</c:if>

							<c:if test="${memberDto.m_info_public != 1}">
										비공개
							</c:if>
							안녕하세요 저는 소설가를 꿈꾸고 있는 밍뚜입니다. 제 소설 재미있게 읽어주셨으면 좋겠습니다. ㅎㅎㅎ감사합니다
							</span>
						</div>
						<div class="profile_follow_box">
							<div class="follower_box" onclick="follower('${root}','${memberDto.m_nickname}')">
								10023${follower_count}<br />팔로워
							</div>
							<div class="following_box" onclick="following('${root}','${memberDto.m_nickname}')">
								13${following_count}<br />팔로잉
							</div>
							<div class="following_box" onclick="novel('${root}','${memberDto.m_nickname}')">
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
										${memberDto.m_sex}
									</c:if>
									<c:if test="${memberDto.m_homepage_public != 1}">
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
									<c:if test="${memberDto.m_homepage_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
							<div class="tr">
								<div class="td1">생일</div>
								<div class="td2">
									<c:if test="${memberDto.m_birthday_public == 1}">
										${memberDto.m_birthday}
									</c:if>

									<c:if test="${memberDto.m_homepage_public != 1}">
										비공개
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="content">			
					<%-- <c:forEach var="novel_homeDto" items="${novel_home}"> --%>
						<div class="follow_list" id="following_list">
							<span class="menu">팔로잉</span>
							<!-- while/for문 추가 -->
							<div class="list" onclick="팔로잉프로필바로가기함수">
								<img alt="icon" src="./image/kms.jpg" class="profile_img">
								<div class="follow_nickname">Dongmool9876</div>
								
								<c:if test="${numSess != null}">
									<img alt="x" src="./image/x_icon.png" class="follow_delete" onclick="삭제함수">
								</c:if>
							</div>
						</div>
					<%-- </c:forEach> --%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>