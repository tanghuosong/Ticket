$(function(){
	$('#dg').datagrid({    
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
	    url:'car_admin_queryCarByPage.action?type=id'+'&&key=', 
	    columns:[[    
	        {field:'ck',title:'选择',checkbox:true,width:50},    
	        {field:'id',title:'汽车编号',width:80,align:'center'},    
	        {field:'carName',title:'汽车名称',width:120,align:'center'},   
	        {field:'carType.typeName',title:'汽车种类',width:120,align:'center',
	        	formatter: function(value,row,index){
					if(row.carType!=null && row.carType.typeName!=null){
						return row.carType.typeName;
					}
	        	}	
	        },    
	        {field:'seatNum',title:'荷载人数',width:70,align:'center',sortable:true},    
	        {field:'carCard',title:'车牌号码',width:100,align:'center'},    
	        {field:'buyTime',title:'购买时间',width:150,align:'center',sortable:true},
	        {field:'status',title:'状态',width:80,aligin:'center',
	        	formatter: function(value,row,index){
					if (row.status==0){
						return "闲置";
					} else {
						return "使用中";
					}
	        	}
	        }   
	    ]],
	    toolbar: [{
			iconCls: 'icon-add',
			text:"添加汽车信息",
			handler: function(){
				parent.$('#win').window({ 
            		title:'添加汽车信息',
            	    width:400,    
            	    height:350,  
            	    content:"<iframe src='send_admin_saveCar.action' frameborder='0' width='100%' height='100%'/>",
            	    modal:true
            	}); 
			}
		},'-',{
			iconCls: 'icon-edit',
			text:"更新汽车信息",
			handler: function(){
				var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
	            	parent.$('#win').window({ 
	            		title:'更新汽车信息',
	            	    width:400,    
	            	    height:350,  
	            	    content:"<iframe src='send_admin_updateCar.action' frameborder='0' width='100%' height='100%'/>",
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
			text:"删除汽车信息",
			handler: function(){
				 var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '确定删除吗？', function(r){
		        			if (r){
		        				$.post("car_admin_deleteCarByIds.action", { ids: ids },
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
