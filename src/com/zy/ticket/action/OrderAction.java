package com.zy.ticket.action;

import com.zy.ticket.bean.Order;

public class OrderAction extends BaseAction<Order>{
	private static final long serialVersionUID = 1L;
	
	//添加订单信息
	public void saveOrder(){
		orderService.saveModel(model);
	}
	
	//根据id删除订单信息
	public void deleteOrderById(){
		orderService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除订单信息
	public void deleteOrderByIds(){
		orderService.deleteModelByIds(ids);
	}
	
	//更新订单信息
	public void updateOrder(){
		orderService.updateModel(model);
	}
	
	//分页排序查询所有的订单
	public String queryOrderByPage(){
		jsonMap.put("total", orderService.getRowCount(type,key));
		jsonMap.put("rows",orderService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
