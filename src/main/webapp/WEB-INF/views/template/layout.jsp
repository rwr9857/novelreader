<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노벨리더</title>
</head>
<body>
	<!-- header.jsp -->
	<tiles:insertAttribute name="header" />

	<!-- 
		content
		-- member.jsp
	 -->
	<tiles:insertAttribute name="content" />
	<hr color="black">
	<!-- foot.jsp -->
	<tiles:insertAttribute name="foot" />
</body>
</html>