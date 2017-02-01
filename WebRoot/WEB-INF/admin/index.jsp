<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/public.jspf" %>
	<link rel="icon" href="${ticket}/images/logo.jpg">
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/admin/index.css">
	<script type="text/javascript" src="${ticket}/JS/admin/index.js"></script>
</head>
<body>
   	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">  
	    <div id="header_title" data-options="region:'north',title:'欢迎来到宇哥售票后台管理系统',split:false,collapsible:false" style="height:140px;">
	    	<div id="title">长途汽车售票系统</div>
	    	<div id="admin">管理员：${admin.adminName}</div>
	    </div>   
	    <div data-options="region:'west',title:'系统操作',split:false,collapsible:false" style="width:200px;">
	    	<!--以下是左菜单选项 -->
			<div id="aa" class="easyui-accordion"   style="width:190px;">  
				<div title="司机管理" data-options="iconCls:'icon-post',selected:true"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_driverManage.action">司机管理</a></li>
					</ul>
			    </div> 
				<div title="汽车管理"  data-options="iconCls:'icon-tip'"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_carType.action">汽车种类</a></li>
						<li><a href="#" title="send_admin_carManage.action">汽车管理</a></li>
					</ul>
			    </div>  
			    <div title="线路管理"  data-options="iconCls:'icon-filter'"  style="padding:5px;">
			    	<ul>
						<li><a href="#" title="send_admin_addressManage.action">地点管理</a></li>
						<li><a href="#" title="send_admin_routeManage.action">线路管理</a></li>
					</ul>
			    </div> 
			    <div title="用户管理" data-options="iconCls:'icon-man'"  style="padding:5px;">
					<ul>
						<li><a href="#" title="send_admin_userManage.action">用户管理</a></li>
						<li><a href="#" title="send_admin_orderManage.action">订单管理</a></li>
					</ul>
			    </div>    
			</div>  
	    </div>   
	    <div data-options="region:'center',title:'系统展示'"  style="padding:1px;background:#fff;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
			    <div title="系统缺省页面" style="padding:20px;">   
			       	欢迎来到宇哥售票后台管理系统
			    </div>   
			</div>  
	    </div>  
	</div>  
	<div id="win" data-options="draggable:false,collapsible:false,minimizable:false,maximizable:false,modal:true"></div> 
</body>
</html>
