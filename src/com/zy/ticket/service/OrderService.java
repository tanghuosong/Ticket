package com.zy.ticket.service;

import java.util.List;

import com.zy.ticket.bean.Order;
import com.zy.ticket.util.Message;

public interface OrderService extends BaseService<Order>{

	public Message buyTicket(Order order);

	public Message sendTicket(Order order);

	public Message returnTicket(Order order);
	
	public List<Order> queryOrderByUserId(Order model,String rows,String page);

	public int getRowCountByUserIdAndStatus(Order model);
	
}
