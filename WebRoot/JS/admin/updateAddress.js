$(function(){
	var dg = parent.$("iframe[title='地点管理']").get(0).contentWindow.$("#dg");
	var rows = dg.datagrid("getSelections");
	$('#ff').form('load',{
		id:rows[0].id,
		province:rows[0].province,
		city:rows[0].city,
		county:rows[0].county,
		station:rows[0].station
	});
	 $('#btn').click(function(){    
		 $('#ff').form('submit', {
			    url:'address_admin_updateAddress.action',   
			    success:function(data){ 
			    	var data = eval('(' + data + ')');
			    	if(data.msg.result){
			    		parent.$('#win').window('close');
			    		dg.datagrid("reload");
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
});
