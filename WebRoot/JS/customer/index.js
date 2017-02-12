$(function(){
	var page = 1;
	var total=0 ;
	postUrl(page);
	var pageToatl = ((total%10==0)&&(total/10!=0))?(total/10):((total/10)+1);
	alert(pageToatl);
//	if(total%10==0){
//		pageTotal = total/10;
//	}
	$("#pageInfo").html("当前第"+page+"页,共"+pageToatl+"页");
	/*
	 * 进入时加载首页数据
	 * **/
	
	// 上一页
	$(".prev").click(function(){
		if(page==1){
			page = page;
		}else{
			page = page-1;
		}
		postUrl(page);
		
	});
	
	// 下一页
	$(".next").click(function(){
		if((total/10)>=1&&(total%10)>0){
			page = total/10+1;
		}else if((total/10)==0&&(total%10)>0){
			page = 1;
		}
		postUrl(page);
		
	});
//	// tab的点击事件
//	$("a[href=#]").click(function(event){
//		var tabName = this.text;
//		if(tabName == "车票查询"){
//			
//		}else if(tabName == "已购车票"){
//			
//		}else if(tabName == "未完成订单"){
//			
//		}else if(tabName == "用户注册"){
//			
//		}else if(tabName == "用户登录"){
//			
//		}
//		alert(tabName);
//		return false;
//	});
	function postUrl(){
		$.ajax({
		   type: "POST",
		   url:"route_customer_queryRouteByPage.action",
		   data: {"type":"id","key":"","rows":10,"page":page},
		   success: function(data){
			   total = data.total;
			   showData(data);
		   }
		});
	}
	
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
});
function buyTicket(title){
	$.ajax({
		
	});
}
