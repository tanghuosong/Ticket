<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/public/public.jspf" %>
<html>
  <head>
    <title>订票系统</title>
	<link rel="stylesheet" type="text/css" href="${ticket}/CSS/customer/regist.css">
	<c:import url="/public/header.jsp"/>
	<script type="text/javascript" src="${ticket}/JS/customer/formValidator_min.js"></script>
	<script type="text/javascript" src="${ticket}/JS/customer/formValidatorRegex.js"></script>
	<script type="text/javascript" src="${ticket }/JS/customer/regist.js"></script>
  </head>
 <body onload="ready();">
   	<div class="reg">
        <form action="" method="post" name="form" id="form">
             <dl>
                <dt class="f14 b">帐户基本信息</dt>
                <dd><span class="title">登录账号：</span><input class="reg_input" name="name" id="t_UserName" onblur="checkusername(this.value);" type="text" /><span id="t_UserNameTip" class="onshow"></span></dd>
                <dd><span class="title">性　　别：</span><input type="radio" id="Sex_Man" name="sex" value="男" checked="checked" /><label for="Sex_Man"> 帅哥</label>
                                   <input type="radio" id="Sex_Woman" name="sex" value="女" /><label for="Sex_Woman"> 美女</label><span  class="onshow"></span>
              	</dd>
                <dd><span class="title">登录密码：</span><input class="reg_input" name="password" type="password" id="t_UserPass" onblur="return checkpasswd(this);" /><span id="t_UserPassTip" class="onshow"></span></dd>
                <dd><span class="title">确认密码：</span><input class="reg_input" name="repassword" type="password" id="t_RePass" onblur="checkdoublepassword();"  /><span id="t_RePassTip" class="onshow"></span></dd>
                <dd><span class="title">身份证号：</span><input class="reg_input" name='idcard' type='text' id='iptCard' onblur="return checktheform();" /><span id="iptCardTip" class="onshow"></span></dd>
                <dd><span class="title">邮箱地址：</span><input class="reg_input" name="email" type="text" id="t_Email" onblur="checkemail(this.value)" /><span id="t_EmailTip" class="onshow"></span></dd>
                <dd><span class="title">手  机  号：</span><input class="reg_input" name="phone" type="text" id="phone" onblur="return checkphone(this.value)" /><span id="phoneTip" class="onshow"></span></dd>
                <dd><span class="title">验  证  码：</span><input class="reg_input" name="t_CheckCode"  type="text" id="t_CheckCode" maxlength="4" />
                	<img id="checkImg" class="img" src="checkImageAction"  title="点击更换验证码" /><span id="t_CheckCodeTip" class="onshow"></span>
               	</dd>
            	<dd><div class="reg_msg" id="reg_msg"></div></dd>
            </dl>
            <div class="f_reg_but"><input id="button" name="button" type="submit" value="免费注册" class="r_button"/></div>
        </form>                              
    </div>
  </body>
</html>
