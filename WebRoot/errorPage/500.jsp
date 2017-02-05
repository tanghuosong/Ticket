﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>500 - 对不起，服务器内部错误！- 医疗系统</title>
<link rel="stylesheet" type="text/css" href="${ticket}/errorPage/css/main.css">
</head>
<body>
<div id="wrapper"><a class="logo" href="/"></a>
  <div id="main">
    <div id="header">
      <h1><span class="icon">!</span>500<span class="sub">Internal Server Error</span></h1>
    </div>
    <div id="content">
      <h2>服务器内部错误！</h2>
      <p>当您看到这个页面,表示服务器内部错误,此网站可能遇到技术问题,无法执行您的请求,请稍后重试,感谢您的支持!</p>
      <div class="utilities">
          <div class="input-container" style="font: 13px 'TeXGyreScholaRegular', Arial, sans-serif;color: #696969; text-shadow: 0 1px white;text-decoration: none;">
            <span id="totalSecond" style="color:red">5</span>秒后自动跳转…
          </div>
        <a class="button right" href="#" onClick="history.go(-1);return true;">返回...</a><a class="button right" href="http://www.baidu.com">联系站长</a>
        <div class="clear"></div>
      </div>
    </div>
    <div id="footer">
      <ul>
        <li><a href="/">网站首页</a></li>
      	<li><a href='/list-58.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-5.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-56.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-100.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-20.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-4.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-59.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-81.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-57.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-60.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-55.html' title='友情链接'>友情链接</a></li>
      	<li><a href='/list-54.html' title='友情链接'>友情链接</a></li>
      </ul>
    </div>
  </div>
</div>


 <!--定义js变量及方法-->
	<script language="javascript" type="text/javascript">
var second = document.getElementById('totalSecond').textContent;


if (navigator.appName.indexOf("Explorer") > -1)
{
second = document.getElementById('totalSecond').innerText; 
} else
{
second = document.getElementById('totalSecond').textContent; 
}




setInterval("redirect()", 1000); 
function redirect()
{
if (second < 0)
{

/* 定义倒计时后跳转页面 */
location.href = 'http://www.baidu.com'; 
} else
{
if (navigator.appName.indexOf("Explorer") > -1)
{
document.getElementById('totalSecond').innerText = second--; 
} else
{
document.getElementById('totalSecond').textContent = second--; 
}
}
}
</script>
</html>