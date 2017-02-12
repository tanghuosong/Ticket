$(function(){
	$('#cc1').combobox({    
	    url:'address_admin_queryAddressList.action',    
	    valueField:'id',    
	    textField:'fullname',
	    panelHeight:'auto',
	    required:true,
	    editable:false
	});  
	$('#cc2').combobox({    
	    url:'car_admin_findCarByStatus.action?state=0',    
	    valueField:'id',    
	    textField:'carName',
	    panelHeight:'auto',
	    required:true,
	    editable:false,
	    onSelect:function(record){
	    	$("#seatNum").val(record.seatNum);
		}
	});
	$('#cc3').combobox({    
	    url:'driver_admin_findDriverByStatus.action?state=0',    
	    valueField:'id',    
	    textField:'drivername',
	    panelHeight:'auto',
	    required:true,
	    editable:false
	});  
	$('#ss').timespinner({    
	    min: '08:00',    
	    showSeconds: true ,
	    required:true
	}); 
	$(".easyui-validatebox").validatebox({    
	    required: true, 
	    missingMessage:'请填写完整信息！'
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
