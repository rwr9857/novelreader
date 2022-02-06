<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${root}/css/notice/notice.css">
</head>
<body>
<div class="zentaiwaku">
			<!-- 전체 와꾸 다 합친 와꾸-->
			<div class="head">
				<!-- 상단 탭버튼 와꾸-->
				<a href="${root}/notice/notice.do">
					<button style="background-color: #9fc5f8">공지사항</button>
				</a>
				<a href="${root}/notice/faq.do">
					<button>자주묻는질문</button>
				</a>
				<a href="${root}/notice/question.do">
					<button>문의하기</button>
				</a>
			</div>
			<div style="border: white; width: 1200px; height: 8px;"></div>
			<!-- 한칸띄우기-->

			<form action="${root}/notice/noticeWriteOk.do" method="post">
				<div class="line2">
					<!-- 빈칸, 카테고리 와꾸-->

					<input type="text" name="not_title" placeholder="제목을 입력하세요" />
					<!-- 제목입력칸-->

				</div>

				<div style="border: white; width: 1200px; height: 8px;"></div>
				<!-- 한칸띄우기-->
				<div class="textsty">
					<!-- 글꼴굵기 글꼴기울기 글꼴....-->
					<button type="button">
						<img src="${root}/images/notice/bold.png" width="15px" height="15px">
					</button>
					<button type="button">
						<img src="${root}/images/notice/italic-text.png" width="15px" height="15px">
					</button>
					<button type="button">
						<img src="${root}/images/notice/underline.png" width="15px" height="18px">
					</button>
				</div>
				<div style="border: white; width: 1200px; height: 8px;"></div>
				<!-- 한칸띄우기-->
				<div class="blenk">
					<!-- 텍스트박스 와꾸-->
					<textarea name="not_content" class="writingbox" placeholder="내용을 입력하세요"></textarea>
				</div>
				<div style="border: white; width: 1200px; height: 16px;"></div>
				<!-- 한칸띄우기-->
				<div class="footer">
					<!-- 하단 와꾸-->
					<button type="submit">작성완료</button>
				</div>
				<input type="hidden" name="m_num" value="${numSess}" />
			</form>
		</div>
</body>
</html>