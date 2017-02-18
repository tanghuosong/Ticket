$(document).ready(function(){
	$("#checkImg").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/checkImageAction.action?flag="+new Date().getTime());
	});
	$.formValidator.initConfig({
		formid:"form1",
		debug:false,
		submitonce:true,
		onerror:function(msg,obj,errorlist){
		}
	});
	$("#t_UserName").formValidator({onshow:"字母、数字、下划线",onfocus:"5-16个字符",oncorrect:"该用户名可以注册"}).inputValidator({min:5,max:16,onerror:"输入有误"}).regexValidator({regexp:"username",datatype:"enum",onerror:"格式有误"});
	$("#iptNickName").formValidator({onshow:"至少4个字符",onfocus:"至少4个字符",oncorrect:"通过"}).inputValidator({min:4,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"});
	$("#t_UserPass").formValidator({onshow:"至少6个字符",onfocus:"至少6个字符",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"});
	$("#t_RePass").formValidator({onshow:"请再次输入密码",onfocus:"请再次输入密码",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"}).compareValidator({desid:"t_UserPass",operateor:"=",onerror:"密码不一致"});	
	$("#iptName").formValidator({onshow:"至少4个字符",onfocus:"至少4个字符",oncorrect:"通过"}).inputValidator({min:4,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"});
	$("#iptCard").formValidator({onshow:"15或18位的身份证",onfocus:"15或18位的身份证",oncorrect:"输入正确"}).functionValidator({fun:isCardID});
	$("#t_Email").formValidator({onshow:"6-100个字符",onfocus:"6-100个字符",oncorrect:"通过"}).inputValidator({min:6,max:100,onerror:"长度非法"}).regexValidator({regexp:"email",datatype:"enum",onerror:"格式不正确"});
	$("#phone").formValidator({onshow:"11个字符",onfocus:"11个字符",oncorrect:"通过"}).inputValidator({min:11,max:11,onerror:"长度非法"}).regexValidator({regexp:"mobile",datatype:"enum",onerror:"格式不正确"});
	// 注册
	$("form:first").submit(function(){
		$.post("user_custom_saveUser.action", 
			{ 
				'name':$("#t_UserName").val(),
				'sex':$("input[name='sex']").val(),
				'email':$("#t_Email").val(),
				'idcard':$("#iptCard").val(),
				'phone':$("#phone").val(),
				'password':$("#t_UserPass").val(),
				'status':'1',
				'vcode':$("#t_CheckCode").val()
			},
			function(data){
				if(data.msg.result){
					$("#reg_msg").html(data.msg.content).addClass("reg_success");
					$("input").val("");
				}else{
					$("#reg_msg").html(data.msg.content).addClass("reg_error");;
				}
		},"json");
	});
	// 登录
	$("form:last").submit(function(){
		$.post("user_custom_userLogin.action", 
			{ 
				'name':$("#loginName").val(),
				'password':$("#loginPwd").val()
			},
			function(data){
				if(data.result=="true"){
					alert("登录成功！");
				}else{
					alert("登录失败！");
				}
			},"json");
	});
});

function test1(obj)
{
	if(obj.value=="全角字符当做1个长度")
	{
		$.formValidator.getInitConfig("1").wideword = false;
		obj.value = "全角字符当做2个长度";
	}
	else
	{
		$.formValidator.getInitConfig("1").wideword = true;
		obj.value = "全角字符当做1个长度";
	}
	
}