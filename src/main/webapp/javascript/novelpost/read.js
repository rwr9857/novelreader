/**
 * 
 */
// 다음화 보기
function nextViewCheck(root, n_post_num) {
	var url = root + "/novelpost/read.do?n_post_num=" + n_post_num;
	//	alert(url);

	location.href = url;

}
// 메인 페이지
function novelHomeCheck(root){
	var url = root ;
	//	alert(url);

	location.href = url;
}

// 목록 페이지
function postListCheck(root, n_num){
	var url = root + "/novelhome/list.do?n_num=" + n_num;
	//	alert(url);
	
	window.location.reload(); // 새로고침
	location.href = url;
}
// 수정 페이지
function updateCheck(n_POST_NUM, root, n_num) {
	var url = root + "/novelpost/update.do?n_post_num=" + n_POST_NUM + "&n_num=" + n_num;
	//	alert(url);

	location.href = url;
}

// 삭제 페이지
function deleteCheck(comment_num, root, n_POST_NUM, m_num, numSess) {
	if(m_num == numSess){
		var url = root + "/novelpost/commentdelete.do?comment_num=" + comment_num + "&n_post_num=" + n_POST_NUM;
		//	alert(url);
	
		var value = confirm("정말로 삭제 하겠습니까?");
		if (value == true) {
			location.href = url;
		} else {
			alert("삭제 되지 않았습니다.");
		}
	}else{
		alert("잘못된 접근입니다");
	}
}