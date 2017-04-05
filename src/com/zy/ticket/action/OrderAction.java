package com.zy.ticket.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zy.ticket.bean.Order;

public class OrderAction extends BaseAction<Order>{
	private static final long serialVersionUID = 1L;
	
	//买票
	public String buyTicket(){
		jsonMap.put("msg", orderService.buyTicket(model));
		return "jsonMap";
	}
	
	// 出票（修改订单状态）
	public String sendTicket(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.setUpdatetime(df.format(new Date()));
		model.setStatus(2);
		jsonMap.put("msg", orderService.sendTicket(model));
		return "jsonMap";
	}
	
	// 退票
	public String returnTicket(){
		System.out.println(model);
		jsonMap.put("msg", orderService.returnTicket(model));
		return "jsonMap";
	}
	
	//根据id删除订单信息
	public String deleteOrderById(){
		jsonMap.put("msg", orderService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除订单信息
	public String deleteOrderByIds(){
		jsonMap.put("msg", orderService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新订单信息
	public String updateOrder(){
		jsonMap.put("msg", orderService.updateModel(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的订单
	public String queryOrderByPage(){
		jsonMap.put("total", orderService.getRowCount(type,key));
		jsonMap.put("rows",orderService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
	// 查询所有已完成订单
	public String queryOrderByUserId(){
		jsonMap.put("total", orderService.getRowCountByUserIdAndStatus(model));
		jsonMap.put("rows", orderService.queryOrderByUserId(model,rows, page));
		return "jsonMap";
	}
	
}
