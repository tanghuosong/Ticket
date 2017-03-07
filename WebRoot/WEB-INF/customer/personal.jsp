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
				<li>未完成订单</li>
				<li>已完成订单</li>
				<li>已取票订单</li>
			</ul>
		</div>
		<div>
			<div id="test3_1" class="tablist block">
				<div class = "left_content">
					<div id="personalInfo" class="personalInfo">
						<div class="item"><span class="trTitle">用户账号：</span><span class="trContent">${user.name }</span></div>
						<div class="item"><span class="trTitle">用户性别：</span><span class="trContent">${user.sex }</span></div>
						<div class="item"><span class="trTitle">用户邮箱：</span><span class="trContent">${user.email }</span></div>
						<div class="item"><span class="trTitle">用户电话：</span><span class="trContent">${user.phone }</span></div>
						<div class="item"><a id="updatePassword" name="updatePassword" href="javascript:void(0)" title="修改密码">修改密码</a></div>
					</div>
					
					<div class = "updatePass" id="updatePass">
						<div class="item"><span class="trTitle">旧密码</span><input type="password" name = "oldPassword"></div>
						<div class="item"><span class="trTitle">新密码</span><input type="password" name = "newPassword"></div>
						<div class="item"><input type="button" class="submitUpdate" id="submitUpdate" name="submit" value="确认修改"/></div>
					</div>
				</div>
				<div class="notice">
					<dl>
						<dt>温馨提示</dt>
						<dd>为了保护广大旅客的合法权益，根据本网站服务条款的约定，对冒用他人信息的购票帐户停止线上购票和线上退票、改签服务。</dd>
						<dd> 请您直接登陆本站购票，不要通过第三方代购网站和手机客户端购票，避免因代购方冒用他人信息导致无法在网上办理退票、改签，影响您的出行。请您不要将个人信息提供给第三方网站和手机客户端，以免个人信息泄露带来风险。</dd>
					</dl>	
				</div>
			</div>
			<div id="test3_2" class="tablist">
				<div class="content">
					<div id="finishOrder" class="orderClass"></div>
				</div>
			</div>
			<div id="test3_3" class="tablist">
				<div id="unfinishedOrder" class="orderClass">
				</div>
			</div>
			<div id="test3_4" class="tablist">
				<div id="pickTicket" class="orderClass">
					
				</div>
			</div>
		</div>
  </body>
</html>
