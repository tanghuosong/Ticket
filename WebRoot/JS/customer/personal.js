$(function(){
	var flag= "1";
	new tab('test1_li_now_', '_', null, 'onmouseover');
	new tab('test2_li_now_');
	new tab('test3_li_now_', '_', function(){
		switch (this['Index']) {
		case 1:
			break;
		case 2:
			flag="2";
			getHasFinishOrder();
			break;
		case 3:
			flag="3";
			pickTicket();
			break;
		}
	});
	
	// 点击修改密码，出现密码修改框
	$("#updatePassword").click(function(){
		$("#updatePass").removeClass("updatePass").addClass("updatePassVisible");
	});
	
	// 确认修改密码按钮
	$("#submitUpdate").click(function(){
		var oldPass = $("input[name='oldPassword']").val();
		var newPass = $("input[name='newPassword']").val();
		$.post("user_customer_updateUserPassword.action",{
			'oldPassword':oldPass,
			'newPassword':newPass
		},function(data){
			alert(data.msg.content);
			if(data.msg.result){
				refresh();
			}
		});
	});
	
	// 已完成订单
	function getHasFinishOrder(){
		$.post("order_customer_queryOrderByUserId.action",
			{
				"user.id":$("#userId").val(),
				"rows":10,
				"page":1,
				"status":1
			},
			function(data){
				show(data);
		});
	}
	// 已取票订单
	function pickTicket(){
		$.post("order_customer_queryOrderByUserId.action",
			{
				"user.id":$("#userId").val(),
				"rows":10,
				"page":1,
				"status":2
			},
			function(data){
				show(data);
		});
	}
	
	function show(data){
		var content = '<div class="orderTitle"><span class="orderId">订单编号</span><span class="orderTime">订单日期</span><span class="carNum">车次</span><span class="des">目的地</span><span class="ticketCount">车票数量</span><span class="orderStatus">退票</span></div>';
		for(var index in data.rows){
			content = content+'<div class="orderContent">'
				+'<span class="orderId">'+data.rows[index].id+'</span>'
				+'<span class="orderTime">'+data.rows[index].createtime+'</span>'
				+'<span class="carNum">'+'C'+data.rows[index].route.id+'</span>'
				+'<span class="des">'+data.rows[index].route.address.fullname+'</span>'
				+'<span class="ticketCount">'+data.rows[index].ticketnum+'</span>'
				+'<span class="orderStatus"><a class="returnTicket" href="javascript:void(0)" title='+data.rows[index].id+'>退票</a>'
			 	+'</span></div>';
		}
		if(flag == "2"){
			$("#finishedOrder").html(content);
			$(".returnTicket").click(function(){
				 if (confirm("您确定要退票吗？")) {  
					 $.post("order_customer_returnTicket.action",
						{
							"id":this.title,
							"status":3
						},
						function(data){
							if(data.msg.result){
								getHasFinishOrder();
							}
							alert(data.msg.content);
					}); 
		        }  
			});
		}else if(flag=="3"){
			$("#pickTicket").html(content);
			$(".orderStatus").html("");
		}
	}
});
function refresh(){
    window.location.reload();//刷新当前页面.
}

function tab(o, s, cb, ev){ //tab切换类
	var $ = function(o){return document.getElementById(o)};
	var css = o.split((s||'_'));
	if(css.length!=4)
		return;
	this.event = ev || 'onclick';
	o = $(o);
	if(o){
		this.ITEM = [];
		o.id = css[0];
		var item = o.getElementsByTagName(css[1]);
		var j=1;
		for(var i=0;i<item.length;i++){
			if(item[i].className.indexOf(css[2])>=0 || item[i].className.indexOf(css[3])>=0){
				if(item[i].className == css[2])o['cur'] = item[i];
				item[i].callBack = cb||function(){};
				item[i]['css'] = css;
				item[i]['link'] = o;
				this.ITEM[j] = item[i];
				item[i]['Index'] = j++;
				item[i][this.event] = this.ACTIVE;
			}
		}
		return o;
		}
	}
	tab.prototype = {
			ACTIVE:function(){
				var $ = function(o){return document.getElementById(o)};
				this['link']['cur'].className = this['css'][3];
				this.className = this['css'][2];
				try{
					$(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
					$(this['link']['id']+'_'+this['Index']).style.display = 'block';
				}catch(e){}
				this.callBack.call(this);
				this['link']['cur'] = this;
			}
		}

