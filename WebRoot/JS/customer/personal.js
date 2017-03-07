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
			getNotFinishOrder();
			break;
		case 3:
			flag="3";
			getHasFinishOrder();
			break;
		case 4:
			flag="4";
			pickTicket();
			break;
		}
	});
	new tab('test4-input-input_tab1-input_tab2', '-');
	
	$("#updatePassword").click(function(){
		alert("点击修改密码");
//		$("#updatePass").style.display="block";
	});
	
	function getNotFinishOrder(){
		$.post("order_customer_queryOrderByUserId.action",
			{
				"user.id":$("#userId").val(),
				"rows":10,
				"page":1,
				"status":0
			},
			function(data){
				show(data);
		});
	}
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
		var content = '<div class="orderTitle"><span class="orderId">订单编号</span><span class="orderTime">订单日期</span><span class="carNum">车次</span><span class="des">目的地</span><span class="ticketCount">车票数量</span><span class="orderStatus">我要支付</span></div>';
		for(var index in data.rows){
			content = content+'<div class="orderContent"><span class="orderId">'+data.rows[index].id+'</span><span class="orderTime">'+data.rows[index].createtime+'</span><span class="carNum">'+'C'+data.rows[index].route.id+'</span><span class="des">'+data.rows[index].route.address.fullname+'</span><span class="ticketCount">'+data.rows[index].ticketnum+'</span><span class="orderStatus"><a href="javascript:void(0)" title='+data.rows[index].id+'>支付</a></span></div>';
		}
		if(flag=="2"){
			$("#finishOrder").html(content);
		}else if(flag=="3"){
			$("#unfinishedOrder").html(content);
		}else if(flag=="4"){
			$("#pickTicket").html(content);
		}
	}
});

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

