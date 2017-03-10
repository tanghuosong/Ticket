<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="./public.jspf"%>
	<link rel="icon" href="${ticket}/images/logo.jpg">
    <link  rel="stylesheet" type="text/css" href="${ticket}/CSS/customer/header.css">
    <script type="text/javascript" src="${ticket}/JS/customer/header.js"></script>
</head>
<body>
    <div class="header">
        <span class="header_logo"><a id="returnIndex" href="${ticket}/index.jsp"><span>长途汽车售票系统</span></a>
        	
        </span>
        <div class="header_nav">
            <ul>
            	<c:choose>
	            	<c:when test="${user==null}">
		                <li>游客!您好</li>
		                <li>｜<a href="javascript:void(0)" class="userLogin">登录</a></li>
		                <li>｜<a href="send_customer_regist.action" target="_blank">注册</a></li>
	                </c:when>
	                <c:otherwise>
	                	<input name="userId" id="userId" type="hidden" value="${user.id}">
	                	<li><a href="send_customer_personal.action">${user.name}　</a>您好</li>
		                <li>｜<a href="javascript:void(0)" id="exit">安全退出</a></li>
	                </c:otherwise>
                </c:choose>
                <li>｜<a href="send_admin_login.action" target="_blank">进入后台</a></li>
            </ul>
        </div>
    </div>
    <div id="LoginBox">
        <div class="row1">
           	 用户登录<a href="javascript:void(0)"  class="close_btn" id="closeBtn">×</a>
        </div>
        <div class="row">
            	用户名: <span class="inputBox">
                	<input type="text" id="txtName" title="关闭窗口"  placeholder="用户名" />
            		</span>
            		<a href="javascript:void(0)" title="提示" class="warning" id="warn">*</a>
        </div>
        <div class="row">
            	密&nbsp;&nbsp;&nbsp;&nbsp;码: <span class="inputBox">
                <input type="password" id="txtPwd"  placeholder="密码" />
            </span><a href="javascript:void(0)" title="提示" class="warning" id="warn2">*</a>
        </div>
        <div class="row">
           	角&nbsp;&nbsp;&nbsp;&nbsp;色: 
               <label class="labelText1" for="user">用户</label><input type="radio" id="user" name="permisson" value="user" checked="checked" />
               <label class="labelText1" for="admin">管理员</label><input type="radio" id="admin" name="permisson" value="admin"/>
        </div>
        <div class="row">
            <a href="#" id="loginbtn">登录</a>
        </div>
        <div class="row2">
        	<span>没有账号？<a href="send_customer_regist.action">注册</a></span>&nbsp;&nbsp;
        </div>
    </div>
</body>
</html>
