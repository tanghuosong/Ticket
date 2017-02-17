$(function(){
	$(".easyui-validatebox").validatebox({    
	    required: true, 
	    missingMessage:'请填写完整信息！'
	}); 
	$("#btn").click(function(){
		$('#ff').form('submit', {   
		    url:'address_admin_saveAddress.action',    
		    success:function(data){
		    	var data = eval('(' + data + ')');
		    	if(data.msg.result){
		    		parent.$('#win').window('close');
		    		parent.$("iframe[title='地点管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
