<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
	<title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/public.css">
	<script type="text/javascript" src="${ticket }/JS/admin/updateCar.js"></script>
</head>
<body>
	<div class="container">
		<form id="ff" method="post">   
		    <div class="eachItems">   
		        <label for="id">汽车编号：</label>   
		        <input class="easyui-validatebox" type="text" name="id" readonly="readonly"  />   
		    </div>   
		    <div class="eachItems">   
		        <label for="carName">汽车名称：</label>   
		        <input class="easyui-validatebox" type="text" name="carName" data-options="required:true" />   
		    </div>   
		    <div class="eachItems">   
		        <label for="carType.id">汽车种类：</label>   
		        <input id="cc" name="carType.id"> 
		    </div>
		    <div class="eachItems">   
		        <label for="seatNum">荷载人数：</label>   
		        <input class="easyui-numberbox" type="text" name="seatNum" data-options="required:true" />   
		    </div>
		    <div class="eachItems">   
		        <label for="carCard">车牌号码：</label>   
		        <input class="easyui-validatebox" type="text" name="carCard" data-options="required:true,validType:'carCard'" />   
		    </div>    
			<div class="eachItems">   
		        <label for="buyTime">购买时间：</label>   
		        <input id="dt" type="text" name="buyTime" readonly="readonly"/>     
		    </div>
		    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确认更新</a>  
		</form>
	</div>  
</body>
</html>
