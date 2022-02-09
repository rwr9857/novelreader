<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${root}/css/novelpost/read.css">
<script type="text/javascript"
	src="${root}/javascript/novelpost/read.js"></script>
<title>회차읽기</title>
</head>
<body>	
	<!--상단바-->
	<div align="center" class="header_bar">
		<table style="width: 100%; height: 60px; max-width: 900px;">
			<tbody>
				<tr>
					<td style="text-align: center; font-size: 20px; width: 2.5%;"></td>
				</tr>
			</tbody>

			<!-- 버튼1 : 홈버튼 -->
			<td style="text-align: center; font-size: 12px; width: 40px; cursor: pointer;">
				<img src="${root}/images/novelpost/home.png" width="25px" height="25px" onclick="javascript:novelHomeCheck('${root}')"/>
			</td>

			<td style="text-align: center; font-size: 20px; width: 2.5%;"></td>

			<td style="text-align: left; font-size: 14px; line-height: 25px; padding: 5px 0px;">
				<b style="height: 1.3em;">${novelPostDto.n_POST_TITLE}</b>
			</td>

			<!-- 버튼2 : 목차, 설정 -->
			<td style="text-align: center; font-size: 12px; width: 63px; z-index: 10000;">
				<img src="${root}/images/novelpost/btn_list.png" style="height: 20px; cursor: pointer;" onclick="javascript:postListCheck('${root}','${nNumSess}')">
			</td>
			<td style="text-align: center; font-size: 12px; width: 63px; z-index: 10000;">
				<c:if test="${numSess == m_num}">
					<img src="${root}/images/novelpost/btn_theme.png" style="height: 20px; cursor: pointer;" onclick="javascript:updateCheck('${novelPostDto.n_POST_NUM}', '${root}','${nNumSess}')">
				</c:if>
			</td>
			<td style="position: relative;"></td>
		</table>
	</div>
	
	 <!--본문영역-->
     <div class="novel_box" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" ondrop="return false">
        <div class="no-drag" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" ondrop="return false">              
        	<ol style="padding:0px;margin:0px;" class="no-drag" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" ondrop="return false">
           		${novelPostDto.n_POST_CONTENT}
			</ol>
           <!-- 다음화 보기 -->
           <div class="next_epi_btn_bottom" onclick="javascript:nextViewCheck('${root}','${novelPostDto.n_POST_NUM + 1}')">다음화 보기</div><br>
           

           <ol onclick="" style="padding:0px;margin:0px;overflow-x:hidden;max-width:900px;height:100%;margin:0px 0px;scrollbar-width: none;" class="no-drag" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" ondrop="return false">
           		<span style="padding:0px;margin:0px;"></span>
           		<ol class="no-drag" style="padding:0px;margin:0px;" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" ondrop="return false"></ol>
          </ol>         
         </div>
    </div>

	
	<!-- 댓글 -->
	<div align="center">
		<form class="form_style" action="${root}/novelpost/commentOk.do"
			method="post">
			<div class="commentHeader" style="text-align: left;">
				<h5 style="text-align: left; margin-left:10px; display: inline-block; padding-left: 20px;">댓글 작성(${commentAllCount})</h5>
				<input type="submit" value="등록" style="background-color: rgba(155, 155, 155, 0.1); border: 1px solid rgba(155, 155, 155, 0.2); border-radius: 10px; text-align: center; cursor: pointer; margin-left: 694px;"/>
			</div>
			<div class="content">
				<textarea rows="3" cols="115" name="comment_content" style="resize: none;  border-radius: 10px;"></textarea>
			</div>
			<div class="title" style="text-align: right;">
				 
				<input type="hidden" name="m_num" value="${numSess}" />
				<input type="hidden" name="n_post_num" value="${novelPostDto.n_POST_NUM}" />
				<input type="hidden" name="n_num" value="${nNumSess}" />
			</div>
		</form>
		
		<c:if test="${commentList.size() > 0 }">
			<c:forEach var="commentDto" items="${commentList}">
				<div class="commentHeader" style="border:0px solid black; width:879px; height: 25px; margin-top:3px;">
					<h5 style="text-align: left; margin-left:10px; display: inline-block; float:left;">${commentDto.m_num}</h5>
					<h5 style="text-align: left; margin-left:10px; display: inline-block; float:left;">작성날짜 :</h5>
					<h5 style="text-align: left; margin-left:10px; display: inline-block; float:left;">
					<fmt:formatDate value="${commentDto.comment_time}" pattern="yyyy-MM-DD HH:mm:ss"/>
					</h5>
					<button
						style="margin-left: 500px; background-color: rgba(155, 155, 155, 0.1); border: 1px solid rgba(155, 155, 155, 0.2); border-radius: 10px; text-align: center; cursor: pointer;"
						onclick="javascript:deleteCheck('${commentDto.comment_num}', '${root}','${novelPostDto.n_POST_NUM}')">삭제</button>
				</div>
					
				<div class="form_style"  style="height: 130px; border:1px solid gray;  border-radius: 10px; text-align: left; margin-top: 6px;">
				<div style="text-align: left;">${commentDto.comment_content}</div>
				</div>
			</c:forEach>
		</c:if>
	</div><br/><br/>
	
	<div align="center">
		<c:if test="${count>0}">
			<%-- 총  페이지 수  --%>
			<fmt:parseNumber var="pageCount"
				value="${count/boardSize +  (count%boardSize == 0 ? 0:1)}"
				integerOnly="true" />
		
			<%-- 페이지 블럭 --%>
			<c:set var="pageBlock" value="${2}" />
			
			<%-- 블럭의 시작번호, 끝번호 --%>
			<fmt:parseNumber var="rs" value="${(currentPage - 1)/pageBlock}" integerOnly="true"/> 
			<c:set var="startPage" value="${rs * pageBlock + 1}"/>
			<c:set var="endPage" value="${startPage + pageBlock - 1}"/>
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}"/>
			</c:if>
			
			<c:if test="${startPage > pageBlock}">
				<a href="${root}/novelpost/read.do?pageNumber=${startPage-pageBlock}&n_post_num=${n_post_num}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${root}/novelpost/read.do?pageNumber=${i}&n_post_num=${n_post_num}">[${i}]</a>
			</c:forEach>
			
			<c:if test="${endPage < pageCount}">
				<a href="${root}/novelpost/read.do?pageNumber=${startPage+pageBlock}&n_post_num=${n_post_num}">[다음]</a>
			</c:if>
			
		</c:if>
	</div>
	
</body>
</html>