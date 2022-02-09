<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${root}/css/notice/notice.css">
<script type="text/javascript" src="${root}/javascript/notice/notice.js"></script>
</head>
<body>
	<c:if test="${numSess == null}">
		<script type="text/javascript">
	    alert("로그인이 필요합니다.");
	    location.href = "${root}/member/login.do";
	</script>
	</c:if>
	<c:if test="${numSess != null}">
		<div class="zentaiwaku">
			<!-- 전체 와꾸 다 합친 와꾸-->
			<div class="head">
				<!-- 상단 탭버튼 와꾸-->
				<a href="${root}/notice/notice.do">
					<button>공지사항</button>
				</a>
				<a href="${root}/notice/faq.do">
					<button>자주묻는질문</button>
				</a>
				<a href="${root}/notice/question.do">
					<button style="background-color: #9fc5f8">문의하기</button>
				</a>
			</div>
			<div style="border: white; width: 1200px; height: 8px;"></div>
			<!-- 한칸띄우기-->

			<form action="${root}/notice/questionWriteOk.do" method="post">
				<div class="line2">
					<!-- 빈칸, 카테고리 와꾸-->

					<input type="text" name="q_title" placeholder="제목을 입력하세요" />
					<!-- 제목입력칸-->
					<select name="q_category" id="q_category">
						<optgroup label="카테고리" >
							<option value="서비스문의">서비스문의</option>
							<option value="버그문의">버그문의</option>
							<c:if test="${n_title != null}">
								<option value="신고문의" selected="selected">신고문의</option>
							</c:if>
							<c:if test="${n_title == null}">
								<option value="신고문의" >신고문의</option>
							</c:if>
						</optgroup>
					</select>
					
				</div>

				<div style="border: white; width: 1200px; height: 8px;"></div>
				<!-- 한칸띄우기-->
				<div class="textsty">
				</div>
				<div style="border: white; width: 1200px; height: 8px;"></div>
				<!-- 한칸띄우기-->
				<div class="blenk">
					<!-- 텍스트박스 와꾸-->
					<textarea name="q_content" class="writingbox" placeholder="내용을 입력하세요">
						<c:if test="${n_title != null}">[게시글 제목] : ${n_title}z
							--------------------------------------------------
						</c:if>
					</textarea>
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
	</c:if>
</body>
</html>