package com.zy.ticket.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zy.ticket.bean.Order;
import com.zy.ticket.bean.Route;
import com.zy.ticket.service.OrderService;
import com.zy.ticket.util.Message;

public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{
	Message message  = new Message();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 买票
	@Override
	public Message buyTicket(Order order){
		order.setCreatetime(df.format(new Date()));
		order.setUpdatetime(df.format(new Date()));
		order.setStatus(1);
		//1.首先判断该票是否有
		if(routeDao.get(order.getRoute().getId()).getSold()>0){
			// 有余票，买票
			Order order2 = orderDao.buyTicket(order);
			System.out.println(order2);
			Route route = routeDao.get(order2.getRoute().getId());
			System.out.println(route);
			try{
				// 查找相应的route，修改剩余票数
				routeDao.subOrAddOneSoldNum(route.getId(),route.getSold()-1);
				message.result = true;
				message.content = "购票成功！";
			}catch (Exception e) {
				e.printStackTrace();
				orderDao.deleteById(order2.getId());
				message .result = false;
				message.content = "购票失败！";
				System.out.println(e.getMessage());
			}
		}else{
			message.result = false;
			message.content = "剩余票数不足，请选择其他车次！";
		}
		return 	message;
	}
	
	// 出票
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
				if(orderDao.updateTicket(order)>0){
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
	public Message returnTicket(Order order) {
		// 
		order.setStatus(3);
		order.setUpdatetime(df.format(new Date()));
		try{
			orderDao.updateTicket(order);
			Order order2 = orderDao.get(order.getId());
			routeDao.subOrAddOneSoldNum(order2.getRoute().getId(),order2.getRoute().getSold()+1);
			message.result = true;
			message.content = "退票成功！";
		}catch (Exception e) {
			e.printStackTrace();
			message.result = false;
			message.content = "退票失败！";
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
