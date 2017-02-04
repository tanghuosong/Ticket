<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
	<title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/public.css">
	<script type="text/javascript" src="${ticket }/JS/admin/updateAddress.js"></script>
</head>
<body>
	<form id="ff" method="post">   
		<div class="eachItems">   
	        <label for="id">编号：</label>   
	        <input class="easyui-validatebox" type="text" name="id" readonly="readonly"  />   
	    </div>   
	    <div class="eachItems">   
	        <label for="province">省份：</label>   
	        <input class="easyui-validatebox" type="text" name="province" data-options="required:true" />   
	    </div>   
	    <div class="eachItems">   
	        <label for="city">　市：</label>   
	        <input class="easyui-validatebox" type="text" name="city" data-options="required:true" />
	    </div>
	    <div class="eachItems">   
	        <label for="county">　县：</label>   
	        <input class="easyui-validatebox" type="text" name="county" data-options="required:true" />   
	    </div>
	    <div class="eachItems">   
	        <label for="station">车站：</label>   
	        <input class="easyui-validatebox" type="text" name="station" data-options="required:true" />   
	    </div>    
	    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认更新</a>  
	</form>  
</body>
</html>
