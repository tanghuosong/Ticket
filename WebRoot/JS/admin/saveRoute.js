$(function(){
	$('#cc').combobox({    
	    url:'carType_admin_queryCarTypeList.action',    
	    valueField:'id',    
	    textField:'typeName',
	    panelHeight:'auto',
	    editable:false
	});  
	$(".easyui-validatebox").validatebox({    
	    required: true, 
	    missingMessage:'请填写完整信息！'
	}); 
	//日期框验证
	$('#dt').datebox({    
	    required: true   
	});  
	//设置数字输入框，即座位数最小是9
	$('#nn').numberbox({    
	    min:9,    
	    precision:0    
	});  
	$.extend($.fn.validatebox.defaults.rules, {    
	    carCard: {
	    	validator:function(value , param){
	    		var carCard = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
	    		return value.match(carCard);	
	    	},
	    	message:'请输入正确的车牌号！'
	    },
	    buyTime:{
	    	validator:function(value,param){
	    		return true;
	    	},
	    	message:'购买日期必须在今天之前！！'
	    }
	}); 
	$("#btn").click(function(){
		$('#ff').form('submit', {   
		    url:'car_admin_saveCar.action',    
		    success:function(data){    
		    	 parent.$('#win').window('close');
			     parent.$("iframe[title='汽车管理']").get(0).contentWindow.$("#dg").datagrid("reload");
		    }    
		});
	});
});