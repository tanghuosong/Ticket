<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
	<title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/public.css">
	<script type="text/javascript" src="${ticket }/JS/admin/saveRoute.js"></script>
</head>
<body>
	<form id="ff" method="post"> 
		<div class="eachItems">   
	        <label for="startAddress">出发地点：</label>   
	        <input class="easyui-validatebox" type="text" name="" value="蚌埠" readonly="readonly" data-options="required:true" />   
	    </div>    
	    <div class="eachItems">   
	        <label for="address.id">　终点站：</label>   
	        <input id="cc1" name="address.id" data-options="required: true"> 
	    </div>
	    <div class="eachItems">   
	        <label for="starttime">出发时间：</label>   
	        <input id="ss" type="text" name="starttime"/>     
	    </div>
	    <div class="eachItems">   
	        <label for="driver.id">　　司机：</label>   
	        <input id="cc3"  name="driver.id" data-options="required: true" > 
	    </div>
	    <div class="eachItems">   
	        <label for="price">车票售价：</label>   
	        <input class="easyui-validatebox" type="text" name="price" />   
	    </div>   
	    <div class="eachItems">   
	        <label for="car.id">　　汽车：</label>   
	        <input id="cc2" name="car.id" data-options="required: true"> 
	    </div>
	    <div class="eachItems">   
	        <label for="sold">出售车票：</label>   
	        <input id="seatNum" type="text" name="sold" readonly="readonly"/>   
	    </div>
	    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认添加</a>  
	</form>  
</body>
</html>
