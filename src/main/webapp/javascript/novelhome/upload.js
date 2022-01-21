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
function registerForm(obj) {
	

	var check = false;
	var str = "";
	for (var i = 0; i < obj.categorieValue.length; i++) {
		if (obj.categorieValue[i].checked == true) {
			str += obj.categorieValue[i].id + ",";
			check = true;
		}
	}

	if (check == false) {
		alert("하나이상 체크하세요.");
		return false;
	}

	// alert(str);

	obj.interest.id = str;
}


