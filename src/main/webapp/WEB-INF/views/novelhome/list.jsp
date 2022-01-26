<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소설로고 리스트</title>
</head>
<body>
	<div id="nhAll">
		<!-- 표지 -->
		<div class="nhF1">
			<div class="nhF2">
				<!-- 이미지불러오기 -->
				<div class="image_container">
					<img src="${root}/images/${novelHomeDto.n_image_name}"></div>
				<button>첫화보기</button>
			</div>
		</div>
		<!-- 소설 -->
		<div class="nhF2">
			<div class="nhF21">소설제목:${novelHomeDto.n_title}</div>
			<div class="nhF21"><button>게시글 신고</button></div>
			<div class="nhF21"><button>전체 삭제</button></div>
		</div>
		<div class="nhF2">
			<div class="nhF21">
				작가:
				<button>작가이름</button>
				<button>팔로우</button>
			</div>
			<div class="nhF21">조회수,좋아요,싫어요,즐겨찾기</div>
		</div>
		<div class="nhF2">소설 줄거리:${novelHomeDto.n_summary}</div>
		<div class="nhF2">
			<!-- 장르값 != null 이면 장르 리스트 -->
			<button>장르선택</button>
		</div>
	</div>

	<div id="nhAll2">
		<div>
			<div>회차리스트</div>
			<div>등록버튼</div>
		</div>
		<!-- 회차리스트 -->

	</div>
	<input type="hidden" name="m_num" value="${numSess}" />

</body>
</html>