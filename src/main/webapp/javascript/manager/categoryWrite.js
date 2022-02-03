var root = null;
var lastIndex = null;
var inc_num = null;

function writeToServer(requestRoot,index, increase) {
	root = requestRoot;
	lastIndex = Number(index);
	inc_num = increase;

	// console.log(lastIndex);
	// console.log(number);
	console.log(lastIndex + inc_num);

	var writeCategory = document.getElementById("writeCategory").value;

	// alert(root + "," + writeCategory);

	if (writeCategory != ""){
		var url = root + "/manager/categoryWrite.do";
		var params = "writeCategory=" + writeCategory;
		sendRequest("POST", url, params, writeFromServer);
	}
}

function writeFromServer() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		// alert(xhr.responseText);

		var obj = JSON.parse(xhr.responseText);
		var categoryId = obj.categoryId;
		var categoryName = obj.writeCategory;
		
		// id=writeCategory의 값을 빈 값으로 만든다.
		document.getElementById("writeCategory").value = "";

		var listAllDiv = document.getElementById("listAllDiv");

		/*애니메이션 용 카드 생성*/
		var container = document.createElement("div");
		container.className = "container";
		container.style.cssText =  "position: absolute; margin-left: "+ (lastIndex % 4)*300 +"px;"+  "margin-top: "+ Math.floor(lastIndex / 4)*100 +"px";

		var front = document.createElement("div");
		front.className = "front card";

		var back = document.createElement("div");
		back.className = "back card";



		var categoryDiv = document.createElement("div");
		categoryDiv.className = "categoryDiv";
		categoryDiv.id = categoryId;

		var spancategory = document.createElement("span");
		spancategory.className = "csscategory";
		spancategory.innerHTML = categoryName;

		var spanUp = document.createElement("span");
		spanUp.className = "cssUp";


		var aUpdate = document.createElement("a");
		aUpdate.href = "javascript:upSelectToServer(" + categoryId + ", \'" + root + "\')";
		aUpdate.innerHTML = "수정";

		spanUp.appendChild(aUpdate);
		categoryDiv.appendChild(spancategory);


		front.appendChild(categoryDiv);
		back.appendChild(spanUp);

		container.appendChild(front);
		container.appendChild(back);

		listAllDiv.insertBefore(container, null);
		document.getElementById("add").style.cssText =  "position: absolute; margin-left: "+ ((lastIndex+1) % 4)*300 +"px;" + "margin-top: "+ Math.floor(lastIndex / 4)*100 +"px";

	}
}
