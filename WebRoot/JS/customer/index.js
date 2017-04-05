$(function(){
	var page = 1;
	var total=0 ;
	var pageTotal;
	var type="id";
	var key = "";
	postUrl();// 进入请求车票数据
	
	// 上一页
	$(".prev").click(function(){
		if(page>1){
			page = page-1;
			postUrl();
		}
	});
	
	// 下一页
	$(".next").click(function(){
		if(page<pageTotal){
			page = page+1;
			postUrl();
		}
	});
	
	$("#searchBtn").click(function(){
		type="address.fullname";
		key = $("#destination").val();
		postUrl();
	});
	// 从服务器请求数据
	function postUrl(){
		$.ajax({
		   type: "POST",
		   url:"route_customer_queryRouteByPage.action",
		   data: {"type":type,"key":key,"rows":10,"page":page},
		   success: function(data){
			   total = data.total;
			   showData(data);
			   updatePage();
		   }
		});
	}
	// 显示数据
	function showData(data){
	    var title = '<div class="tableTitle"><span class="carNum">车次</span><span class="startAddress">出发地</span><span class="endAddress">目的地</span><span class="startTime">发车时间</span><span class="price">票价</span><span class="ticketNum">剩余车票</span><span class="buyBtn">购票</span></div>'
		var content = "";
    	for(var index in data.rows){
    		content = content+'<div class="eachItems">'
    		+'<span class="carNum">'+"C"+data.rows[index].id+'</span>'
    		+'<span class="startAddress">'+"蚌埠"+'</span>'
    		+'<span class="endAddress">'+data.rows[index].address.fullname+'</span>'
    		+'<span class="startTime">'+data.rows[index].starttime+'</span>'
    		+'<span class="price">'+data.rows[index].price+'</span>'
    		+'<span class="ticketNum">'+data.rows[index].sold+'</span>'
    		+'<span class="buyBtn"><a class="buyTicket" href="javascript:void(0);"  title='+data.rows[index].id+'>预订</a>'
    		+'</div>';
	   }
    	$("#dataContent").html(title+content);
    	// 点击买票
    	$(".buyTicket").click(function(){
    		if($("#userId").val()==""||$("#userId").val()==null){
    			alert("您还未登录，请先登录再购票！");
    		}else{
    			$.post("order_customer_buyTicket.action",
					{
    					'route.id':this.title,
    					'user.id':$("#userId").val(),
    					status:0,
    					ticketnum:1
    				},function(data){
    					if(data.msg.result){
    						postUrl();
    					}
    					alert(data.msg.content);
    			});
    		}
    	});
	}
	// 更新页码显示
	function updatePage(){
		pageTotal = (parseInt(total/10))+(total%10>0?1:0);// 分页总数
		$("#pageInfo").html("当前第"+page+"页,共"+pageTotal+"页");
	}
});
