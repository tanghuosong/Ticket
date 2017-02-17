$(function(){
	var page = 1;
	var total=0 ;
	var pageTotal;
	postUrl(page);// 进入请求车票数据
	
	// 上一页
	$(".prev").click(function(){
		if(page>1){
			page = page-1;
			postUrl(page);
		}
	});
	
	// 下一页
	$(".next").click(function(){
		if(page<pageTotal){
			page = page+1;
			postUrl(page);
		}
	});
	// 从服务器请求数据
	function postUrl(){
		$.ajax({
		   type: "POST",
		   url:"route_customer_queryRouteByPage.action",
		   data: {"type":"id","key":"","rows":10,"page":page},
		   success: function(data){
			   total = data.total;
			   showData(data);
			   updatePage();
		   }
		});
	}
	// 显示数据
	function showData(data){
	    var title = '<div class="tableTitle"><span class="carNum">车次</span><span class="startAddress">出发地</span><span class="endAddress">目的地</span><span class="startTime">发车时间</span><span class="price">票价</span><span class="ticketNum">剩余车票</span><span class="buy">购票</span></div>'
		var content = "";
    	for(var index in data.rows){
    		content = content+'<div class="eachItems">'
    		+'<span class="carNum">'+"C"+data.rows[index].id+'</span>'
    		+'<span class="startAddress">'+"蚌埠"+'</span>'
    		+'<span class="endAddress">'+data.rows[index].address.fullname+'</span>'
    		+'<span class="startTime">'+data.rows[index].starttime+'</span>'
    		+'<span class="price">'+data.rows[index].price+'</span>'
    		+'<span class="ticketNum">'+data.rows[index].car.seatNum+'</span>'
    		+'<span class="buyBtn"><a class="buyTicket" onclick="buyTicket(this.title)" href="javascript:void(0);"  title='+data.rows[index].id+'>购票</a>'
    		+'</div>';
	   }
    	$("#dataContent").html(title+content);
	}
	// 更新页码显示
	function updatePage(){
		pageTotal = (parseInt(total/10))+(total%10>0?1:0);// 分页总数
		$("#pageInfo").html("当前第"+page+"页,共"+pageTotal+"页");
	}
});
// 买票函数
function buyTicket(title){
	alert(title);
}
