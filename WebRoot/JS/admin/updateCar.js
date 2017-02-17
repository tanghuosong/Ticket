$(function(){
	var dg = parent.$("iframe[title='汽车管理']").get(0).contentWindow.$("#dg");
	$('#cc').combobox({    
	    url:'carType_admin_queryCarTypeList.action',    
	    valueField:'id',    
	    textField:'typeName',
	    panelHeight:'auto',
	    editable:false
	});  
	var rows = dg.datagrid("getSelections");
	$('#ff').form('load',{
		id:rows[0].id,
		carName:rows[0].carName,
		'carType.id':rows[0].carType.id,
		seatNum:rows[0].seatNum,
		carCard:rows[0].carCard,
		buyTime:rows[0].buyTime,
		status:rows[0].status
	});
	
	$("#btn").click(function(){
		$('#ff').form('submit', {    
		    url:'car_admin_updateCar.action',    
		    success:function(data){
		    	var data = eval('(' + data + ')');
		    	if(data.msg.result){
		    		parent.$('#win').window('close');
				     parent.$("iframe[title='汽车管理']").get(0).contentWindow.$("#dg").datagrid("reload");
		    	}else{
		    		$.messager.show({
		    			title:'错误提示',
		    			msg:data.msg.content,
		    			timeout:0,
		    			showType:'slide'
		    		});
		    	}
		    }    
		});
	});
	$(".easyui-validatebox").validatebox({    
	    required: true, 
	    missingMessage:'请填写完整信息！'
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
	    		return value;
	    	},
	    	message:'购买日期必须在今天之前！！'
	    }
	});  
});
