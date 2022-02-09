<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${root}/css/notice/notice.css">
<title>Insert title here</title>
</head>
<body>
    <div class="wrap"> <!-- 전제-->
        <div class="head"> <!-- 상단 탭버튼 -->
            <a href="${root}/notice/notice.do"><button style="background-color:#9fc5f8">공지사항</button></a> 
            <a href="${root}/notice/faq.do"><button>자주묻는질문</button></a>
            <a href="${root}/notice/question.do"><button>문의하기</button></a>
        </div>
        
        <div style="border: white; width: 1200px; height: 8px;"></div><!-- 한칸띄우기-->
        <div class="board">
			<div>제목: ${noticeDto.not_title}</div>
			<div>
				날짜:<fmt:formatDate value="${noticeDto.not_time}" pattern="YYYY-MM-dd HH:mm:ss"/>
			</div>
			<div>ID : ${noticeDto.not_num}</div>
			<div>조회수: ${noticeDto.not_viewcount}</div>

			<hr />
			<div style="height: 200px">내용: ${noticeDto.not_content}</div>
			<hr />
			
			<c:if test="${permissionSess == 'MA'}">
				<button>수정</button>
				<button>삭제</button>
			</c:if>
			

			<button onclick="location.href='${root}/notice/notice.do?pageNumber=${pageNumber}'">목록</button>
        </div>
        

        
  		
        
        
    
     </div>     
</body>
</html>