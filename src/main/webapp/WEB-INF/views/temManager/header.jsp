<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root}/css/manager/menu.css">
<title>Document</title>
</head>
<body>
	<div id="wrap">
		<div class="adminBox">
			<div class="adminLogo">
				<a href="${root}/">NOVELREADER</a>
				<a href="${root}/manager/menu.do">ADMINMODE</a>
			</div>
			<div class="adminmenu">
				<details id="details">
					<summary class="summary">회원정보</summary>
					<ul class="summary_ul" style="margin-top: 10px;">
						<a href="${root}/manager/memberView.do">회원조회</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/memberModify.do">회원수정</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/memberDelete.do">회원삭제</a>
					</ul>

				</details>
				<details id="details">
					<summary class="summary">신고관리</summary>
					<ul class="summary_ul" style="margin-top: 10px;">
						<a href="${root}/manager/reportPost.do">신고된 게시글</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/reportComment.do">신고된 댓글</a>
					</ul>

				</details>
				<details id="details">
					<summary class="summary">게시물관리</summary>
					<ul class="summary_ul" style="margin-top: 10px;">
						<a href="${root}/manager/memberPost">회원 게시물</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/Notice.do">공지사항</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/question.do">자주 묻는 질문</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/questionInformation.do">문의정보</a>
					</ul>


				</details>
				<details id="details">
					<summary class="summary">소설카테고리관리</summary>
					<ul class="summary_ul" style="margin-top: 10px;">
						<a href="${root}/manager/categoryCheck.do">카테고리 조회</a>
					</ul>
					<ul class="summary_ul">
						<a href="${root}/manager/categoryDelete.do">카테고리 삭제</a>
					</ul>

				</details>
				<details id="details">
					<summary class="summary">알림</summary>
					<details>
						<summary class="summary_1">알림 보내기</summary>
						<ul class="summary_ul2" style="margin-top: 10px;">
							<a href="${root}/manager/indiAlarm.do">개별 알림 보내기</a>
						</ul>
						<ul class="summary_ul2">
							<a href="${root}/manager/entireAlarm.do">전체 알림 보내기</a>
						</ul>
					</details>
					<details>
						<summary class="summary_1">알림 조회</summary>
						<ul class="summary_ul2" style="margin-top: 5px;">
							<a href="${root}/manager/AlarmCheck.do">보낸 알림 조회</a>
						</ul>
						<ul class="summary_ul2">
							<a href="${root}/manager/savedAlarm.do">보관된 알림</a>
						</ul>
					</details>
				</details>
				<details id="details">
					<summary class="summary">인기작가</summary>
					<ul class="summary_ul" style="margin-top: 10px;">
						<a href="${root}/manager/authorManage.do">인기작가 관리</a>
					</ul>
				</details>

			</div>
		</div>
	</div>
</body>
</html>