function memberUpdate(root,memberNumber){
	url=root + "/manager/memberUpdate.do?m_num="+ memberNumber;
	//alert(url);
	
	window.open(url, "", "width=500,height=700");
}