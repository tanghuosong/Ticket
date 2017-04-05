package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.Order;

public interface OrderDao extends BaseDao<Order>{

	public int updateTicket(Order order);
	
	public Order buyTicket(Order order);
	
	public Order checkOrderStatusById(Order order);

	public List<Order> queryOrderByUserId(Integer userId,Integer status, int startRows, int _rows);

	public int getRowCountByUserIdAndStatus(Order model);

}
