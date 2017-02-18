<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="public/public.jspf"%>
	<title>长途汽车售票系统</title>
	<c:import url="/public/header.jsp"/>
	<link rel="stylesheet" href="${ticket}/CSS/customer/index.css"/>
	<script type="text/javascript" src="${ticket}/JS/customer/index.js"></script>
</head>
<body>
	<div id="dataContent" class="tableContent"></div>
	<div class="nav">
		<p><a href="#" class="prev">&nbsp;</a><a href="#" class="next">&nbsp;</a></p>
		<span id="pageInfo" class="pageInfo"></span>
	</div>
</body>
</html>
