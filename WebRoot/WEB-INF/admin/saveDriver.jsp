<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
	<title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/public.css">
	<script type="text/javascript" src="${ticket }/JS/admin/saveDriver.js"></script>
</head>
<body>
	<form id="ff" method="post">   
	    <div class="eachItems">   
	        <label for="drivername">姓&nbsp;&nbsp;名：</label>   
	        <input class="easyui-validatebox" type="text" name="drivername" data-options="required:true" />   
	    </div>   
	    <div class="eachItems">   
	        <label for="sex">性&nbsp;&nbsp;别：</label>   
	        <input class="easyui-validatebox" type="radio" name="sex" value="男" />男   
	        <input class="easyui-validatebox" type="radio" name="sex" value="女"  />女   
	    </div>
	    <div class="eachItems">   
	        <label for="age">年&nbsp;&nbsp;龄：</label>   
	        <input class="easyui-validatebox" type="text" name="age" data-options="required:true,validType:'age'" />   
	    </div>
	    <div class="eachItems">   
	        <label for="identitycard">身份证号：</label>   
	        <input class="easyui-validatebox" type="text" name="identitycard" data-options="required:true,validType:'identifyCard'" />   
	    </div>    
		<div class="eachItems">   
	        <label for="phone">&nbsp;手机号：</label>   
	        <input class="easyui-validatebox" type="text" name="phone" data-options="required:true,validType:'phone'" />   
	    </div>
	    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认添加</a>  
	</form>  
</body>
</html>
