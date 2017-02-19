<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
  <head>
    <title>订票系统</title>
   	<c:import url="/public/header.jsp"/>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/customer/personal.css">
	<script type="text/javascript" src="${ticket }/JS/customer/personal.js"></script>
  </head>
  <body>
		<div class="tab2">
			<ul id="test3_li_now_">
				<li class="now">个人信息</li>
				<li>已完成订单</li>
				<li>未完成订单</li>
			</ul>
		</div>
		<div>
			<div id="test3_1" class="tablist block">
				<div id="personalInfo" class="personalInfo"></div>
			</div>
			<div id="test3_2" class="tablist">
				<div id="finishOrder" class="orderClass"></div>
			</div>
			<div id="test3_3" class="tablist">
				<div id="unfinishedOrder" class="orderClass"></div>
			</div>
		</div>
  </body>
</html>
