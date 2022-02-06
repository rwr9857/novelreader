
// 유효성 검사
function checkAll() {
	
}

// 이미지 미리보기
function setThumbnail(event) {
	var reader = new FileReader();
	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		document.querySelector("div.image_container").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}



