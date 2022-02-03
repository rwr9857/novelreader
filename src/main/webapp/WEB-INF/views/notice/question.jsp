<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${root}/css/notice/style1.css">
</head>
<body>
    <div class="zentaiwaku"> <!-- 전체 와꾸 다 합친 와꾸-->
        <div class="head"> <!-- 상단 탭버튼 와꾸-->
            <a href="${root}/notice/notice.do"><button>공지사항</button></a> 
            <a href="${root}/notice/faq.do"><button>자주묻는질문</button></a>
            <a href="${root}/notice/question.do?m_num=${numSess}"><button style="background-color:#9fc5f8">문의하기</button></a>
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
                    <th>카테고리</th>
                </tr>
                
                <c:forEach var="questionDto" items="${questionList}">
	                <tr>
	                    <td>${questionDto.q_num}</td>
	                    <td onclick="location.href='${root}/notice/questionView.do?q_num=${questionDto.q_num}'" style="cursor: pointer;">${questionDto.q_title}</td>
	                    <td>${questionDto.m_num}</td>
	                    <td>${questionDto.q_viewcount}</td>
	                    <td><fmt:formatDate value="${questionDto.q_time}" pattern="YYYY년 MM월 DD일 hh:mm"/></td>
	                    <td>${questionDto.q_category}</td>
	                </tr>
	            </c:forEach>
            </table>
            
            <%-- 페이지 --%>
				<div class="page">
					
					<%-- 총 페이지 수 : 모든 jstl은 문자열이니까 정수로 바꿔주는 작업.--%>
					<fmt:parseNumber var="pageCount" value="${questionCount/listSize + (questionCount % listSize == 0 ? 0:1)}" integerOnly="true"/>
					
					<%-- 페이지 블럭 --%>
					<c:set var="pageBlock" value="${10}"/>
					
					<%-- 요청 페이지의 시작페이지 / 끝페이지 번호 --%>
					<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
					<c:set var="startPage" value="${result*pageBlock+1}"/>
					<c:set var="endPage" value="${startPage+pageBlock-1}"/>
					
					
					<c:if test="${endPage > pageCount}">  <%-- 끝번호보다 총 페이지 수가 더 적을경우 --%>
						<c:set var="endPage" value="${pageCount}"/>
					</c:if>
					
					<c:if test="${startPage > pageBlock}"> <%-- 시작이11페이지인데 페이지 블록이 10이하일 경우 --%>
						<a href="${root}/notice/question.do?m_num=${m_num}&pageNumber=${startPage-pageBlock}">[이전]</a>
					</c:if>
					
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
						<a href="${root}/notice/question.do?m_num=${m_num}&pageNumber=${i}" style="cursor:pointer; color:#001076; font-weight:800; font-size:18px;">[${i}]</a>
						</c:if>
						<c:if test="${i != currentPage}">
						<a href="${root}/notice/question.do?m_num=${m_num}&pageNumber=${i}" style="cursor:pointer; color:#83aaff; font-weight:600; font-size:18px;">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<c:if test="${endPage < pageCount}">   <%-- 끝이10페이지인데 총 페이지수가 11이상일경우--%>
						<a href="${root}/notice/question.do?m_num=${m_num}&pageNumber=${startPage+pageBlock}">[다음]</a>
					</c:if>
					
					
					
					<br/><br/>
					<%-- 
					<div>
						총 페이지 수 : ${pageCount}
						시작 페이지 번호 : ${startPage}
						끝 페이지 번호 : ${endPage}
					</div>
					--%>
				</div>
            
        </div>
        <div style="border: white; width: 1200px; height: 8px;"></div><!-- 한칸띄우기-->
        <div class="footer"> <!-- 하단 와꾸-->
            <a href="${root}/notice/questionWrite.do"><button>문의하기</button></a>
        </div>
    </div>
</body>
</html>