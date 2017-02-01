function ready(){
	var conInnerConWidth = $(".innerCon").width();
	var conSize = $(".innerCon").size();
	var tabHeight = $(".tab a").height();
	if(!window.cur) window.cur=0;
	
	$(".tab a").click(function(){
		var index = $(".tab a").index(this);
	   slide(conInnerConWidth, tabHeight, index);
		return false;
	});
	
	$(".prev").click(function(){
	   if(window.cur>0) slide(conInnerConWidth, tabHeight, window.cur-1);
		return false;
	});
	
	$(".next").click(function(){
	   if(window.cur<conSize-1) slide(conInnerConWidth, tabHeight, window.cur+1);
		return false;
	});
	
	$(".faq ul a").click(function(){
		var index = $(".faq ul a").index($(this));
		$('html, body').animate({scrollTop: $(".details h1").eq(index).offset().top-15}, 1500);
		return false;
	});

	// tab的点击事件
	$("a[href=#]").click(function(event){
		var tabName = this.text;
//		alert(this.text);
		if(tabName == "车票查询"){
			
		}else if(tabName == "已购车票"){
			
		}else if(tabName == "未完成订单"){
			
		}else if(tabName == "用户注册"){
			
		}else if(tabName == "用户登录"){
			
		}
//		alert(tabName);
		return false;
	});

	$(".top a").click(function(){
		$('html, body').animate({scrollTop:0}, 1500);
	});
	
	
	$(".feature_tour .tab, .feature_tour .nav").addClass("vv");
}

//////////////////////////////////////
function slide(conInnerConWidth, tabHeight, index){
	$(".tab a").removeClass("current");
	$(".tab a").eq(index).addClass("current");
	$(".tab").css("background-position","0 -"+index*tabHeight+"px");
	$(".maskCon").animate({marginLeft:-index*conInnerConWidth+"px"});
	window.cur = index;
}

function scrl(id){
	$('html, body').animate({scrollTop: $("#"+id).offset().top-15}, 1500);
}

function check(fieldName,type,minChar,maxChar,fieldName2,customMsg){
	if(window.error==0){
		var field = $("[name="+fieldName+"]");
		var field2 = $("[name="+fieldName2+"]");
		if(field.val().length<minChar || field.val().length>maxChar){
			window.error=1;
		}
		else if(type=="num" && isNaN(field.val().split(" ").join("").split("-").join("").split("+").join(""))){
			window.error=1;
		}
		else if(type=="email" && (field.val().length<7 || field.val().indexOf("@")<1 || (field.val().indexOf("@")+2)>field.val().lastIndexOf(".") || field.val().lastIndexOf(".")>(field.val().length-2))){
			window.error=1;
		}
		else if(type=="ifSame" && (field.val() != field2.val())){
			window.error=1;
		}
		else if(type=="checkbox"){
			if(!$("['name="+field+"'][checked]").val()) window.error=1;
		}
		if(window.error==1){
			var label =field.prev().html().split("*").join("").split(" :").join("");
			if(customMsg) var msg=customMsg; else var msg="Please check '"+label+"' field!";
			alert(msg);
			field.focus();
		}
	}
}

function focusToSkypename(){
	$("[name=skypeName]").focus();
}
