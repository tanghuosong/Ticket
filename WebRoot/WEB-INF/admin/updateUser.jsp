<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
	<title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/public.css">
	<script type="text/javascript" src="${ticket }/JS/admin/updateUser.js"></script>
</head>
<body>
	<form id="ff" method="post">   
	    <div class="eachItems">   
	        <label for="id">&nbsp;&nbsp;编号：</label>   
	        <input class="easyui-validatebox" type="text" name="id" readonly="readonly"  />   
	    </div>   
	    <div class="eachItems">   
	        <label for="name">&nbsp;&nbsp;姓名：</label>   
	        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
	    </div>   
	    <div class="eachItems">   
	        <label for="sex">&nbsp;&nbsp;性别：</label>   
	        <input class="easyui-validatebox" type="text" name="sex" data-options="required:true" />
	    </div>
	    <div class="eachItems">   
	        <label for="idcard">身份证号：</label>   
	        <input class="easyui-validatebox" type="text" name="idcard" data-options="required:true,validType:'identifyCard'" />   
	    </div>    
	    <div class="eachItems">   
	        <label for="email">&nbsp;&nbsp;邮箱：</label>   
	        <input class="easyui-validatebox" type="text" name="email" data-options="required:true,validType:'age'" />   
	    </div>
		<div class="eachItems">   
	        <label for="phone">&nbsp;手机号：</label>   
	        <input class="easyui-validatebox" type="text" name="phone" data-options="required:true,validType:'phone'" />   
	    </div>
	    <div class="eachItems">   
	        <label for="stasus">&nbsp;&nbsp;状态：</label>   
	        <input class="easyui-validatebox" type="radio" name="status" value="1"/>正常   
	        <input class="easyui-validatebox" type="radio" name="status" value="0"/>禁用  
	    </div>
	    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认添加</a>  
	</form>  
</body>
</html>
