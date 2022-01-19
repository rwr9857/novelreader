function setThumbnail(event) {
	var reader = new FileReader();
	reader.onload = function (event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		document.querySelector("div.image_container").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}

// 유효성 검사
function novelHomeForm(obj) {

	var check = false;
	var str = "";
	for (var i = 0; i < obj.categorieValue.length; i++) {
		if (obj.categorieValue[i].checked == true) {
			str += obj.categorieValue[i].value + ",";
			check = true;
		}
	}

	if (check == false) {
		alert("하나이상 체크하세요.");
		return false;
	}

	if ( check > 2){
		alert("최대 장르 선택 개수는 2개입니다.");
		return false;
	}
	
	
	// alert(str);

	obj.C_CATEGORIE.value = str;
}



