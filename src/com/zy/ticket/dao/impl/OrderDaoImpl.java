package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Order;
import com.zy.ticket.dao.OrderDao;
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryModelByPage(String type, String key, int startRows,
			int _rows, String sort, String order) {
		String sql = "FROM Order o LEFT JOIN FETCH o.route r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.car c LEFT JOIN FETCH c.carType LEFT JOIN FETCH r.driver LEFT JOIN FETCH o.user WHERE o."+type+" like :key order by o."+sort+" "+order;
		return session().createQuery(sql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
	@Override
	public Order buyTicket(Order order) {
		session().save(order);
		return order;
	}
	
	@Override
	public int updateTicket(Order order) {
		String sqlString = "UPDATE Order o SET o.status =:status,o.updatetime =:updatetime WHERE o.id=:id";
		return session().createQuery(sqlString).setInteger("status", order.getStatus()).setString("updatetime", order.getUpdatetime()).setInteger("id", order.getId()).executeUpdate();
	}

	@Override
	public Order checkOrderStatusById(Order order) {
		String sqlString = "FROM Order o WHERE o.id=:id";
		return (Order)session().createQuery(sqlString).setInteger("id", order.getId()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryOrderByUserId(Integer userId,Integer status ,int startRows, int _rows) {
		String sql = "FROM Order o LEFT JOIN FETCH o.route r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.car c LEFT JOIN FETCH c.carType LEFT JOIN FETCH r.driver LEFT JOIN FETCH o.user WHERE o.user.id=:userId and o.status=:status order by o.id desc";
		return session().createQuery(sql).setInteger("userId", userId).setInteger("status", status).setFirstResult(startRows).setMaxResults(_rows).list();
	}
	
	@Override
	public Order get(Integer id) {
		String sql = "FROM Order o LEFT JOIN FETCH o.route r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.car c LEFT JOIN FETCH c.carType LEFT JOIN FETCH r.driver LEFT JOIN FETCH o.user WHERE o.id=:id";
		return (Order)session().createQuery(sql).setInteger("id", id).uniqueResult();
	}
	
	@Override
	public int getRowCountByUserIdAndStatus(Order model) {
		String sqlString = "FROM Order o LEFT JOIN FETCH o.route r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.car c LEFT JOIN FETCH c.carType LEFT JOIN FETCH r.driver LEFT JOIN FETCH o.user WHERE o.user.id=:userId and o.status=:status";
		return session().createQuery(sqlString).setInteger("userId", model.getUser().getId()).setInteger("status", model.getStatus()).list().size();
	}
}	
