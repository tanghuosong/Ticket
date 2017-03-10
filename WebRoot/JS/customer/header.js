$(function(){
	
	$("#exit").click(function(){
		$.post("user_customer_exit.action",function(msg){
			refresh();
		});
	});
	//登录按钮点击弹出登录框！
	$(".userLogin").on('click',function(){
		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").fadeIn("slow");
		$("#LoginBox").fadeIn("slow");
	});
	//文本框不允许为空---按钮触发
	$("#loginbtn").on('click', function () {
		var txtName = $("#txtName").val();
		var txtPwd = $("#txtPwd").val();
		if(txtName == "" || txtName == undefined || txtName == null) {
			if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
					$(".warning").css({ display: 'block' });
			}else {
					$("#warn").css({ display: 'block' });
					$("#warn2").css({ display: 'none' });
			}
			return false;
		}else{
			if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
				$("#warn").css({ display: 'none' });
				$(".warn2").css({ display: 'block' });
				return false;
			}
			else {
				$(".warning").css({ display: 'none' });
			}
		}
		
		$.post("user_customer_userLogin.action", 
				{ 
					'name':$("#txtName").val(),
					'password':$("#txtPwd").val()
				},
				function(data){
					if(data.msg.result){
						$("#LoginBox input").val("");
						refresh();
					}else{
						alert(data.msg.content);
					}
			},"json");
	});
	//文本框不允许为空---单个文本触发
	$("#txtName").on('blur', function () {
		var txtName = $("#txtName").val();
		if (txtName == "" || txtName == undefined || txtName == null) {
			$("#warn").css({ display: 'block' });
		}
		else {
			$("#warn").css({ display: 'none' });
		}
	});
	$("#txtName").on('focus', function () {
		$("#warn").css({ display: 'none' });
	});
	//
	$("#txtPwd").on('blur', function () {
		var txtPwd = $("#txtPwd").val();
		if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
			$("#warn2").css({ display: 'block' });
		} else {
			$("#warn2").css({ display: 'none' });
		}
	});
	$("#txtPwd").on('focus', function () {
		$("#warn2").css({ display: 'none' });
	});
	//关闭
	$(".close_btn").hover(function () { 
		$(this).css({ color: 'black' }); }, function () { $(this).css({ color: '#999' }); }).on('click', function () {
		$("#LoginBox").fadeOut("fast");
		$("#mask").css({ display: 'none' });
	});
});
function refresh(){
    window.location.reload();//刷新当前页面.
}
