<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="${root}/css/profile/bookmark.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Overpass:wght@800&display=swap"
	rel="stylesheet">

</head>
<body>
	<script type="text/javascript">
		function bookmark(root,nickname) {
			location.href=root+"/member/bookmark.do?nickname="+nickname;
		}
		
		function profileEdit(root,nickname) {
			location.href=root+"/member/profileEdit.do?nickname="+nickname;
		}
		
		function accountEdit(root,nickname) {
			location.href=root+"/member/accountEdit.do?nickname="+nickname;
		}
	</script>
	
	<c:if test="${m_num != memberDto.m_num}">
		<script type="text/javascript">
			alert("잘못된 접근 입니다.");
			location.href = "/novelreader";
		</script>
	</c:if>
	
	<div id="menu_bar">
		<ul id="menu_bar_ul">
			<li onclick="bookmark('${root}','${nickname}')" class="bookmark">
				<p>즐겨찾기</p>
			</li>
			
			<li onclick="profileEdit('${root}','${nickname}')">
				<p>프로필 수정</p>
			</li>
			
			<li onclick="accountEdit('${root}','${nickname}')">
				<p>계정 설정</p>
			</li>
		</ul>
	</div>
	
	<div id="content_box">
		<div class="content_inner">
			<%-- <c:forEach var="novel_home" items="${novel_home}"> --%>
				<div class="list">
					<img alt="이미지 불러오는중" src="./image/novel.jpg" class="novel_image">
					<div class="novel_inner">
						<div class="titleNdate" onclick="소설이동">
							<div class="title">모르는 만화에 빙의했다</div>
	
							<div class="date">2021.02.23</div>
						</div>
						<div class="like_box">
							<div class="like">
								<img alt="좋아요" src="./image/like.png"> <span>65536</span>
							</div>
	
							<div class="dislike">
								<img alt="싫어요" src="./image/dislike.png"> <span>256</span>
							</div>
							
							<img alt="x" src="./image/x_icon.png" class="bookmark_delete" onclick="삭제함수">
						</div>
					</div>
				</div>
			<%-- </c:forEach> --%>
		</div>
	</div>
</body>
</html>