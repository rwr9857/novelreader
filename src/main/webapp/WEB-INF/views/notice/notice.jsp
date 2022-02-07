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
   <div class="zentaiwaku"> <!-- 전체 와꾸 다 합친 와꾸-->
        <div class="head"> <!-- 상단 탭버튼 와꾸-->
            <a href="${root}/notice/notice.do"><button style="background-color:#9fc5f8">공지사항</button></a> 
            <a href="${root}/notice/faq.do"><button>자주묻는질문</button></a>
            <a href="${root}/notice/question.do"><button>문의하기</button></a>
        </div>
        <div style="border: white; width: 1200px; height: 8px;"></div><!-- 한칸띄우기-->
        <div class="board"> <!-- 공지사항 와꾸-->
            <table>
                <tr>
                    <th>번호</th>
                    <th style="width:45%">글 제목</th>
                    <th>작성자</th>
                    <th>조회</th>
                    <th>시간</th>
                </tr>
                
                <c:forEach var="noticeDto" items="${noticeList}">	
	                <tr>
	                    <td>${noticeDto.not_num}</td>
	                   	<td onclick="location.href='${root}/notice/noticeView.do?not_num=${noticeDto.not_num}&pageNumber=${currentPage}'" style="cursor: pointer;">
	                   		${noticeDto.not_title}
	                   	</td>
	                    <td>관리자</td>
	                    <td>${noticeDto.not_viewcount}</td>
	                    <td><fmt:formatDate value="${noticeDto.not_time}" pattern="YYYY년 MM월 DD일 hh:mm"/></td>
	                </tr>
	            </c:forEach>
            </table>
            
             <%-- 페이지 --%>
            <div class="page">
				<%-- 총페이지 수 --%>
				<fmt:parseNumber var="pageCount" value="${count/boardSize+(count%boardSize==0? 0:1)}" integerOnly="true" />
				<%-- 페이지 블럭 --%>
				<c:set var="pageBlock" value="${10}" />

				<%-- 블럭의 시작번호, 끝번호 --%>
				<fmt:parseNumber var="rs" value="${(currentPage-1)/pageBlock}" integerOnly="true" />
				<c:set var="startPage" value="${rs * pageBlock + 1}" />
				<c:set var="endPage" value="${startPage+ pageBlock - 1}" />

				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>

				<c:if test="${startPage > pageBlock}">
					<a href="${root}/notice/notice.do?pageNumber=${startPage - pageBlock}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == currentPage}">
						<a href="${root}/notice/question.do?pageNumber=${i}" style="cursor:pointer; color:#001076; font-weight:800; font-size:18px;">[${i}]</a>
					</c:if>
					<c:if test="${i != currentPage}">
						<a href="${root}/notice/question.do?pageNumber=${i}" style="cursor:pointer; color:#83aaff; font-weight:600; font-size:18px;">[${i}]</a>
					</c:if>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="${root}/notice/notice.do?pageNumber=${startPage + pageBlock}">[다음]</a>
				</c:if>				
			</div>
            
        </div>
        
        <div style="border: white; width: 1200px; height: 8px;"></div><!-- 한칸띄우기-->
        <div class="footer"> <!-- 하단 와꾸-->
        	<c:if test="${permissionSess=='MA'}">
        		<a href="${root}/notice/noticeWrite.do"><button>공지하기</button></a>
        	</c:if>
        </div>
    </div>
</body>
</html> 