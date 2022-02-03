<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${root}/css/notice/style1.css">
<title>Insert title here</title>
</head>
<body>
   <div class="zentaiwaku"> <!-- 전체 와꾸 다 합친 와꾸-->
        <div class="head"> <!-- 상단 탭버튼 와꾸-->
            <a href="${root}/notice/notice.do"><button style="background-color:#9fc5f8">공지사항</button></a> 
            <a href="${root}/notice/faq.do"><button>자주묻는질문</button></a>
            <a href="${root}/notice/question.do?m_num=${numSess}"><button>문의하기</button></a>
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
                <tr>
                    <td>번호</td>
                    <td>안녕하세요 나는 안태균이라고 해</td>
                    <td>작성자</td>
                    <td>조회수</td>
                    <td>시간</td>
                </tr>
            </table>
        </div>
        <div style="border: white; width: 1200px; height: 8px;"></div><!-- 한칸띄우기-->
        <div class="footer"> <!-- 하단 와꾸-->
        </div>
    </div>
</body>
</html> 