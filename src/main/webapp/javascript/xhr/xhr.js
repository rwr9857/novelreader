/**
 * 
 */

var xhr=null;
var arr=new Array();

function sendRequest(method, url, params, callback){   
	var httpMethod=method.toUpperCase();
	var httpUrl=url;
	
	var httpParams=(params==null || params=="") ? null : params;
	if(httpMethod=="GET" && httpParams !=null){
			httpUrl +="?" + httpParams;
	}
	
	arr.push(httpMethod + "," + httpUrl + "," + httpParams + "," + callback);
	//alert(arr.join("\n"));
	
	xhr=new XMLHttpRequest();
	xhr.open(httpMethod, httpUrl, true);
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization", "KakaoAK ec3e75ad55ae0b1149f179f476569fa0");
	
	xhr.send(httpMethod=="POST" ? httpParams:null);

	xhr.onreadystatechange=callback;
}








