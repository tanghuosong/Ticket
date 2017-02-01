$(function(){
	var dg = parent.$("iframe[title='用户管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#ff').form('load',{
		id:rows[0].id,
		name:rows[0].name,
		sex:rows[0].sex,
		idcard:rows[0].idcard,
		email:rows[0].email,
		phone:rows[0].phone,
		status:rows[0].status
	});
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'user_admin_updateUserStatus.action',   
			    success:function(data){    
			        parent.$('#win').window('close');
			        dg.datagrid("reload");
			    }    
		}); 
	  }); 
	 $(".easyui-validatebox").validatebox({    
		    required: true, 
		    missingMessage:'请填写完整信息！'
		});  
		$.extend($.fn.validatebox.defaults.rules, {    
			phone: {    
		        validator: function(value, param){ 
		        	var phoneVal=/^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
		            return value.match(phoneVal);    
		        },    
		        message: '手机号码格式不正确！'  
		    },
		    idcard: {
		    	validator:function(value , param){
		    		var identify = /^\d{18}$/;
		    		return value.match(identify);	
		    	},
		    	message:'请输入正确的身份证号'
		    },
//		    age:{
//		    	validator:function(value,param){
//		    		return (value>=18&&value<=65);
//		    	},
//		    	message:'司机年龄必须在18到65之间！'
//		    }
		});  
});
