$(function(){
	$('#cc1').combobox({    
	    url:'address_admin_queryAddressList.action',    
	    valueField:'id',    
	    textField:'fullname',
	    panelHeight:'auto',
	    editable:false
	});  
	$('#cc2').combobox({    
	    url:'car_admin_findCarByStatus.action?state=0',    
	    valueField:'id',    
	    textField:'carName',
	    panelHeight:'auto',
	    editable:false
	});  
	$('#cc3').combobox({    
	    url:'driver_admin_findDriverByStatus.action?state=0',    
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
		    url:'route_admin_saveRoute.action',    
		    success:function(data){    
		    	 parent.$('#win').window('close');
			     parent.$("iframe[title='线路管理']").get(0).contentWindow.$("#dg").datagrid("reload");
		    }    
		});
	});
});
