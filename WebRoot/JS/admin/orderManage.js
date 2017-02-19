$(function(){
	$('#dg').datagrid({    
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
	    url:'order_admin_queryOrderByPage.action?type=id'+'&&key=', 
	    columns:[[    
	        {field:'ck',title:'选择',checkbox:true,width:50},    
	        {field:'id',title:'订单编号',width:80,align:'center'},    
	        {field:'user.name',title:'用户',width:160,align:'center',
	        	formatter: function(value,row,index){
					if(row.user!=null && row.user.name!=null){
						return row.user.name;
					}
	        	}	
	        },   
	        {field:'route.address.fullname',title:'目的地',width:160,align:'center',
	        	formatter: function(value,row,index){
					if(row.route.address!=null && row.route.address.fullname!=null){
						return row.route.address.fullname;
					}
	        	}	
	        },   
	        {field:'createtime',title:'预定时间',width:160,align:'center'},   
	        {field:'updatetime',title:'修改时间',width:160,align:'center'},
	        {field:'status',title:'状态',width:160,align:'center',
	        	formatter: function(value,row,index){
					if (row.status==0){
						return "未付款";
					} else if(row.status==1){
						return "未取票";
					}else if(row.status==2){
						return "已取票";
					}
	        	}}
	    ]],
	    toolbar: [{
			iconCls: 'icon-edit',
			text:"出票",
			handler: function(){
				var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
            		$.post("order_customer_sendTicket.action",
        				{
            				'id':rows[0].id
        				},function(data){
        					$.messager.show({
                    			title:'温馨提示',
                    			msg:data.msg.content,
                    			timeout:3000,
                    			showType:'slide'
                    		});
        					if(data.msg.result){
        						$('#dg').datagrid('reload');
				            	$('#dg').datagrid('uncheckAll');
        					}
    				});
            	}else {
            		$.messager.show({
            			title:'温馨提示',
            			msg:'请选择出票订单！',
            			timeout:3000,
            			showType:'slide'
            		});
            	}
			}
		},'-',{
			iconCls: 'icon-remove',
			text:"删除订单信息",
			handler: function(){
				 var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '确定删除吗？', function(r){
		        			if (r){
		        				$.post("order_admin_deleteOrderByIds.action", { ids: ids },
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
