<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
  <head>
    <title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/carType.css">
	<script type="text/javascript" src="${ticket }/JS/admin/carType.js"></script>
  </head>
  <body>
  	<div id="addCarType" class="addCarType">
  		<form id="ff" method="post">
  			<div class="ff1"></div>   
	    	<div>   
		        <label for="typeName">种类名称：</label>   
		        <input class="easyui-validatebox" type="text" name="typeName" data-options="required:true" />   
	    		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加分类</a>
	    	</div>
		</form>
    </div>
    <div id="updateCarType" class="updateCarType">
  		<form id="ff1" method="post">
  			<div>
  				<label for="id">种类&nbsp;ID：</label>
  				<input class="easyui-validatebox" type="text" name="id" readonly="readonly"/>
  			</div>   
	    	<div>   
		        <label for="typeName">种类名称：</label>   
		        <input class="easyui-validatebox" type="text" name="typeName" data-options="required:true" />   
	    		<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新分类</a>
	    	</div>
		</form>
    </div>
    <table id="dg"></table>
  </body>
</html>
