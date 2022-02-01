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
	<c:if test="${nNumSess !=null}">
			<c:set var="nNumSess" value="${nNumSess}" scope="session" />
	</c:if>
	<form>
		<div id="nhAll">
			<!-- 표지 -->
			<div class="nhF1">
				<div class="nhF2">
					<!-- 이미지불러오기 -->
					<div class="image_container">
						<img src="${root}/images/novelLabel/${novelHomeDto.n_image_name}" />
					</div>
					<button>첫화보기</button>
				</div>
			</div>
			<!-- 소설 -->
			<div class="nhF2">
				<div class="nhF21">소설제목:${novelHomeDto.n_title}</div>
				<div class="nhF21">
					<button>게시글 신고</button>
				</div>
				<div class="nhF21">
					<button>전체 삭제</button>
				</div>
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
				<input type="button" value="장르선택" onclick="categoryRead('${root}')" />
				<script type="text/javascript">
					function categoryRead(root) {
						var url = root + "/novelCategory/novelCategoryAdd.do";
						//alert(url);

						window.open(url, "", "width=400, height=400");
					}
				</script>
			</div>
		</div>
	</form>
		<div id="nhAll2">
			<div>
				<div>회차리스트</div>
				<a href="${root}/novelpost/register.do">등록</a>

			</div>
			<!-- 회차리스트 -->
			<c:if test="${novelPostList.size() > 0 }">
			<c:forEach var="novelPostDto" items="${novelPostList}">
				<div class="form_style"  style="height: 130px; border:1px solid black;">
					<div class="disp" style="border-width: 1px;">
						${novelPostDto.n_POST_TITLE}
						<a href="javascript:updateCheck('${novelPostDto.n_POST_NUM}', '${root}')">수정</a>
						<a href="javascript:deleteCheck('${novelPostDto.n_POST_NUM}', '${root}')">삭제</a>
						<fmt:formatDate value="${novelPostDto.n_POST_TIME}" pattern="yyyy-MM-DD HH:mm:ss"/>
					</div>
					
				</div>
			</c:forEach>
		</c:if>
		</div>
		
	
	
		<div align="center">
			<c:if test="${count>0}">
				<%-- 총  페이지 수  --%>
				<fmt:parseNumber var="pageCount"
					value="${count/boardSize +  (count%boardSize == 0 ? 0:1)}"
					integerOnly="true" />
			</c:if>
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
				<a href="${root}/guest/write.do?pageNumber=${startPage-pageBlock}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${root}/guest/write.do?pageNumber=${i}">[${i}]</a>
			</c:forEach>
			
			<c:if test="${endPage < pageCount}">
				<a href="${root}/guest/write.do?pageNumber=${startPage+pageBlock}">[다음]</a>
			</c:if>
			
			<div> 
				pageCount : ${pageCount}
				startPage : ${startPage}
				endPage : ${endPage} 
			</div>
		</div>
</body>
</html>