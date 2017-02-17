$(function(){
	$('#dg').datagrid({
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
	    url:'driver_admin_queryDriverByPage.action?type=id'+'&&key=', 
	    columns:[[    
	        {field:'ck',title:'选择',width:50,checkbox:true},    
	        {field:'id',title:'编号',width:50,sortable:true,algin:'center'},    
	        {field:'drivername',title:'姓名',width:100,algin:'center'},    
	        {field:'sex',title:'性别',width:50,algin:'center'},    
	        {field:'age',title:'年龄',width:50,align:'center',sortable:true},    
	        {field:'identitycard',title:'身份证号',width:150,align:'center'},   
	        {field:'phone',title:'联系电话',width:100,align:'center'},
	        {field:'status',title:'当前状态',width:80, align:'center',
	        	formatter: function(value,row,index){
	        		if (row.status==0){
	        			return "待分配";
	        		} else {
	        			return "已分配";
	        		}
	        	}
	        }
	    ]],
	    toolbar: [{
			iconCls: 'icon-add',
			text:"添加司机信息",
			handler: function(){
				parent.$('#win').window({ 
            		title:'添加司机信息',
            	    width:420,    
            	    height:330,  
            	    content:"<iframe src='send_admin_saveDriver.action' frameborder='0' width='100%' height='100%'/>",
            	    modal:true
            	}); 
			}
		},'-',{
			iconCls: 'icon-edit',
			text:"更新司机信息",
			handler: function(){
				var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
	            	parent.$('#win').window({ 
	            		title:'更新司机信息',
	            	    width:470,    
	            	    height:390,  
	            	    content:"<iframe src='send_admin_updateDriver.action' frameborder='0' width='100%' height='100%'/>",
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
			text:"删除司机信息",
			handler: function(){
				 var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '确定删除吗？', function(r){
		        			if (r){
		        				$.post("driver_admin_deleteDriverByIds.action", { ids: ids },
		        					function(data){
		        					if(data.msg.result){
		        						$.messager.show({
					            			title:'温馨提示',
					            			msg:'删除成功！',
					            			timeout:3000,
					            			showType:'slide'
						            	});
						            	 $('#dg').datagrid('reload');
						            	 $('#dg').datagrid('uncheckAll');
		        					}else{
		        						$.messager.show({
					            			title:'错误提示',
					            			msg:data.msg.content,
					            			timeout:0,
					            			showType:'slide'
						            	});
		        					}
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
