<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/public.jspf" %>
	<title>长途汽车售票系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/customer/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/customer/custom.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/customer/reg.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/customer/login.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/JS/customer/formValidator_min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/JS/customer/formValidatorRegex.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/JS/customer/custom.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/JS/customer/reg.js"></script>
</head>
<body onload="ready();">
<div class="general feature_tour">
	<div class="middle">
		<div class="wrapper">
			<p class="pageTitle">长途汽车在线售票系统</p>
			<div class="tab">
				<a href="#" class="current">车票查询</a>
				<a href="#">已购车票</a>
				<a href="#">未完成订单</a>
				<a href="#">用户注册</a>
				<a href="#">用户登录</a>
			</div>
			<div class="mask">
				<div class="maskCon">
					<div id="con1" class="innerCon">车票查询</div>
					<div id="con2" class="innerCon">已购车票</div>
					<div id="con3" class="innerCon">未完成订单</div>
					<div id="con4" class="innerCon">
						<div class="reg">
					        <form action="" method="post" name="form1" id="form1">
					             <dl>
					                <dt class="f14 b">帐户基本信息</dt>
					                <dd><span class="title">登录账号：</span><input class="reg_input" name="name" id="t_UserName" onblur="checkusername(this.value);" type="text" /><span id="t_UserNameTip" class="onshow"></span></dd>
					                <dd><span class="title">性　　别：</span><input type="radio" id="Sex_Man" name="sex" value="男" checked="CHECKED" /><label for="Sex_Man"> 帅哥</label>
					                                                    <input type="radio" id="Sex_Woman" name="sex" value="女" /><label for="Sex_Woman"> 美女</label>　
					                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span  class="onshow"></span>
					              	</dd>
					                <dd><span class="title">登录密码：</span><input class="reg_input" onblur="return checkpasswd(this);" id="t_UserPass" name="password" type="password"/><span id="t_UserPassTip" class="onshow"></span></dd>
					                <dd><span class="title">确认密码：</span><input onblur="checkdoublepassword();" class="reg_input" type="password" id="t_RePass" name="repassword"/><span id="t_RePassTip" class="onshow"></span></dd>
					                <dd><span class="title">身份证号：</span><input class="reg_input" name='idcard' type='text' id='iptCard' onblur="return checktheform();" /><span id="iptCardTip" class="onshow"></span></dd>
					                <dd><span class="title">邮箱地址：</span><input class="reg_input" name="email" type="text" id="t_Email" onblur="checkemail(this.value)" /><span id="t_EmailTip" class="onshow"></span></dd>
					                <dd><span class="title">手  机  号：</span><input name="phone" id="phone" class="reg_input" type="text" onblur="return checkphone(this.value)" /><span id="phoneTip" class="onshow"></span></dd>
					                <dd><span class="title">验  证  码：</span><input id="t_CheckCode" class="reg_input_pic" name="t_CheckCode" type="text" maxlength="4" />
					                <img id="checkImg" class="img" src="checkImageAction"  title="点击更换验证码" /><span id="t_CheckCodeTip" class="reg_m onError in_pic_s"></span></dd>
					            </dl>
					            <div class="f_reg_but"><input id="button" name="button" type="submit" value="免费注册" class="r_button"/></div>
					        </form>                              
					    </div>
					</div>
					<div id="con5" class="innerCon">
						<div class="login">
						      <h1>用户登录</h1>
						      <form id="loginForm" method="post" action="">
						        <p><input type="text" name="login" value="" placeholder="用户名"></p>
						        <p><input type="password" name="password" value="" placeholder="密码"></p>
						        <p class="submit"><input type="submit" name="commit" value="登录"></p>
						      </form>
					    </div>
					</div>
				</div>
			</div>
			<!-- 
			<div class="nav">
				<p><a href="#" class="prev">&nbsp;</a><a href="#" class="next">&nbsp;</a></p>
			</div>
			 -->
		</div>
	</div>
</div>
</body>
</html>
