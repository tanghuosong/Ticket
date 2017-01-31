$(function(){
	$('#dg').datagrid({    
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
	    url:'user_admin_queryUserByPage.action?type=id'+'&&key=', 
	    columns:[[    
	        {field:'ck',title:'选择',checkbox:true,width:50},    
	        {field:'id',title:'用户编号',width:80,align:'center'},    
	        {field:'name',title:'姓名',width:160,align:'center'},   
	        {field:'sex',title:'性别',width:160,align:'center'},   
	        {field:'idcard',title:'身份证',width:160,align:'center'},   
	        {field:'email',title:'邮箱',width:160,align:'center'},   
	        {field:'phone',title:'手机',width:160,align:'center'}
	    ]],
	    toolbar: [{
			iconCls: 'icon-edit',
			text:"更新用户信息",
			handler: function(){
				var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
	            	parent.$('#win').window({ 
	            		title:'更新用户信息',
	            	    width:400,    
	            	    height:350,  
	            	    content:"<iframe src='send_admin_updateUser.action' frameborder='0' width='100%' height='100%'/>",
	            	    modal:true
	            	});
            	}else {
            		$.messager.show({
            			title:'温馨提示',
            			msg:'请选择一条信息进行修改！',
            			timeout:3000,
            			showType:'slide'
            		});
            	}
			}
		},'-',{
			iconCls: 'icon-remove',
			text:"删除用户信息",
			handler: function(){
				 var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '确定删除吗？', function(r){
		        			if (r){
		        				$.post("user_admin_deleteUserByIds.action", { ids: ids },
		        					function(data){
		        					 $.messager.show({
				            			title:'温馨提示',
				            			msg:'删除成功！',
				            			timeout:3000,
				            			showType:'slide'
					            	});
					            	 $('#dg').datagrid('reload');
					            	 $('#dg').datagrid('uncheckAll');
		        				});
		        			}
		        		});
		         }else{
		        	 $.messager.show({
            			title:'温馨提示',
            			msg:'请选择要删除的数据！',
            			timeout:3000,
            			showType:'slide'
		            });
		         }
			}
		}]
  
	});
	var p = $('#dg').datagrid('getPager');  
	$(p).pagination({  
		pageNumber:1,
		beforePageText: '第',//页数文本框前显示的汉字  
		afterPageText: '页    共 {pages} 页',  
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});    
});
