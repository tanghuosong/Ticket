package com.zy.ticket.service.impl;

import java.util.List;

import com.zy.ticket.bean.Order;
import com.zy.ticket.service.OrderService;
import com.zy.ticket.util.Message;

public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{
	
	@SuppressWarnings("unchecked")
	@Override
	public Message saveModel(Order order) {
		Message message  = new Message();
		if(baseDao.saveModel(order)!=null){
			message.result = true;
			message.content = "预定成功，请前往个人中心提交订单！";
		}else{
			message.result = false;
			message.content = "预定失败,请检查是否已经登录！";
		}
		return message;
	}

	@Override
	public Message sendTicket(Order order) {
		Message message  = new Message();
		// 出票，首先检查该订单状态，未付款或者已经出票则无法再次出票。
		int status = orderDao.checkOrderStatusById(order).getStatus();
		if(status==0){
			message.result = false;
			message.content = "该订单未付款,无法出票！";
		}else if(status==2){
			message.result = false;
			message.content = "该订单已经出票，无法重复出票！";
		}else{
			try{
				if(orderDao.sendTicket(order)>0){
					message.result = true;
					message.content = "出票成功";
				}else{
					message.result = false;
					message.content = "出票失败";
				}
			}catch (Exception e) {
				message.result = false;
				message.content = "出票失败"+e.getMessage();
			}
		}
		return message;
	}

	@Override
	public List<Order> queryOrderByUserId(Order model, String rows, String page) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return orderDao.queryOrderByUserId(model.getUser().getId(),model.getStatus(),startRows, _rows);
	}

	@Override
	public int getRowCountByUserIdAndStatus(Order model) {
		
		return orderDao.getRowCountByUserIdAndStatus(model);
	}
}
