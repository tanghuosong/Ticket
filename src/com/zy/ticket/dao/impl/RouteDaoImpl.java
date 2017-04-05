package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Route;
import com.zy.ticket.dao.RouteDao;
public class RouteDaoImpl extends BaseDaoImpl<Route> implements RouteDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Route> queryModelByPage(String type, String key, int startRows,
			int _rows, String sort, String order) {
		String sql = "From Route r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.driver LEFT JOIN FETCH r.car c LEFT JOIN FETCH c.carType WHERE r."+type+" like :key order by r."+sort+" "+order;

		return session().createQuery(sql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
	
	
	@Override
	public int updateSeatNum(Route route) {
		String sql = "UPDATE Route r set r.sold = :sold WHERE r.id = :id";
		return session().createQuery(sql).setInteger("sold", route.getSold())
			.setInteger("id", route.getId()).executeUpdate();
	}
	
	// 剩余票数改变
	@Override
	public int subOrAddOneSoldNum(int id,int num) {
		String sql = "UPDATE Route r set r.sold = :sold WHERE r.id = :id";
		return session().createQuery(sql).setInteger("sold",num)
			.setInteger("id", id).executeUpdate();
	}
	
	@Override
	public Route get(Integer id) {
		String sql = "FROM Route r LEFT JOIN FETCH r.car c LEFT " +
				"JOIN FETCH c.carType LEFT JOIN FETCH r.address LEFT JOIN FETCH r.driver WHERE r.id = :id";
		return (Route)session().createQuery(sql).setInteger("id", id).uniqueResult();
	}
}
