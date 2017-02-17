$(function(){
	$('#dg').datagrid({    
		pagination:true,
		pageSize: 10,//每页显示的记录条数，默认为5  
		pageList: [10, 15, 20],//可以设置每页记录条数的列表  
		rownumbers:true,
		loadMsg: "数据加载中...",
		idField:"id",
	    url:'carType_admin_queryCarTypeByPage.action?type=id'+'&&key=', 
	    columns:[[    
	        {field:'ck',title:'选择',checkbox:true,width:50},    
	        {field:'id',title:'编号',width:50,align:'center'},    
	        {field:'typeName',title:'种类名称',width:120,align:'center'},
	    ]],
	    toolbar: [{
			iconCls: 'icon-add',
			text:'添加汽车种类',
			handler: function(){
				$('#updateCarType').removeClass('updateCarType1').addClass('updateCarType');
				$('#addCarType').removeClass('addCarType').addClass('addCarType1');
			}
		},'-',{
			iconCls: 'icon-edit',
			text:"更新汽车种类",
			handler: function(){
				var rows = $('#dg').datagrid('getSelections');
            	if(rows.length==1){
            		$('#addCarType').removeClass('addCarType1').addClass('addCarType');
            		$('#updateCarType').removeClass('updateCarType').addClass('updateCarType1');
            		$('#ff1').form('load',{
            			id:rows[0].id,
            			typeName:rows[0].typeName,
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
			text:"删除汽车种类",
			handler: function(){
				 var rows = $('#dg').datagrid('getSelections');
		         if(rows.length!=0){
		        	 var ids=rows[0].id;
		        	 for(var key=1 ;key<rows.length;key++){
		        		 ids=ids+","+rows[key].id;
		        	 }
		        	 $.messager.confirm('温馨提示', '删除该分类会将该分类下的汽车删除，确定删除吗？', function(r){
		        			if (r){
		        				$.post("carType_admin_deleteCarTypeByIds.action", { ids: ids },
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
	$("#btn").click(function(){
		$('#ff').form('submit', {    
		    url:'carType_admin_saveCarType.action',       
		    success:function(data){
		    	$("#addCarType").removeClass("addCarType1").addClass("addCarType");
		    	$('#dg').datagrid('reload');
		    }    
		});  
	});
	$("#btn1").click(function(){
		$('#ff1').form('submit', {    
		    url:'carType_admin_updateCarType.action',       
		    success:function(data){
		    	$("#updateCarType").removeClass("updateCarType1").addClass("updateCarType");
		    	$('#dg').datagrid('reload');
		    }    
		});  
	});
});
