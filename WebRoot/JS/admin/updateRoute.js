$(function(){
	var dg = parent.$("iframe[title='线路管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#ff').form('load',{
		id:rows[0].id,
		'address.id':rows[0].address.id,
		starttime:rows[0].starttime,
		'car.id':rows[0].car.id,
		'driver.id':rows[0].driver.id,
		price:rows[0].price,
		sold:rows[0].sold
	});
	$('#cc1').combobox({    
	    url:'address_admin_queryAddressList.action',    
	    valueField:'id',    
	    textField:'fullname',
	    panelHeight:'auto',
	    editable:false
	});  
	$('#cc2').combobox({    
	    url:'car_admin_findCarByStatusAndId.action?state=0&&key='+rows[0].car.id,    
	    valueField:'id',    
	    textField:'carName',
	    panelHeight:'auto',
	    editable:false
	}); 

	$('#cc3').combobox({    
	    url:'driver_admin_findDriverByStatusAndId.action?state=0&&key='+rows[0].driver.id,    
	    valueField:'id',    
	    textField:'drivername',
	    panelHeight:'auto',
	    editable:false
	});  
	$('#ss').timespinner({    
	    min: '08:00',    
	    required: true,    
	    showSeconds: true   
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
	    min:0,    
	    precision:0    
	});  
	$("#btn").click(function(){
		$('#ff').form('submit', {   
		    url:'route_admin_updateRoute.action',    
		    success:function(data){
		    	var data = eval('(' + data + ')');
		    	if(data.msg.result){
		    		parent.$('#win').window('close');
				     parent.$("iframe[title='线路管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
});
