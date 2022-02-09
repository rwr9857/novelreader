<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${root}/css/notice/qusetionView.css">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<!-- 전제-->
		<div class="head">
			<!-- 상단 탭버튼 -->
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

		<div class="board">
			<div>제목: ${questionDto.q_title}</div>
			<div>카테고리: ${questionDto.q_category}</div>
			<div>
				날짜:
				<fmt:formatDate value="${questionDto.q_time}" pattern="YYYY-MM-dd HH:mm:ss" />
			</div>

			<div>ID : ${questionDto.q_num}</div>
			<div>조회수: ${questionDto.q_viewcount}</div>

			<hr />
			<div style="height: 200px">내용:${questionDto.q_content}</div>
			<hr />


			<c:if test="${permissionSess != 'MA'}">
				<button>수정</button>
			</c:if>
			<button>삭제</button>
			<c:if test="${permissionSess != 'MA'}">
				<button onclick="location.href='${root}/notice/questionWrite.do'">새글</button>
			</c:if>

			<button onclick="location.href='${root}/notice/question.do?pageNumber=${pageNumber}'">목록</button>


			<hr />
			<c:if test="${questionReplyDto != null}">
				${questionReplyDto.qr_content}
			</c:if>
		</div>
		
		
		<c:if test="${questionReplyDto == null}">
		<form action="${root}/notice/questionReplyWriteOk.do" method="post">
			<div class="blenk">
				<!-- 텍스트박스 와꾸-->
				<c:if test="${permissionSess=='MA'}">
					<textarea name="qr_content" class="writingbox" placeholder="내용을 입력하세요"></textarea>
				</c:if>
				<input type="hidden" name="qr_num" value="${questionDto.q_num}"/>
				<input type="hidden" name="m_num" value="${numSess}"/>
			</div>



			<div style="border: white; width: 1200px; height: 8px;"></div>
			<!-- 한칸띄우기-->
			<div class="footer">
				<!-- 하단 와꾸-->
				<c:if test="${permissionSess=='MA'}">
					<button type="submit">답변하기</button>
				</c:if>
			</div>
		</form>
		</c:if>
		
	</div>
</body>
</html>