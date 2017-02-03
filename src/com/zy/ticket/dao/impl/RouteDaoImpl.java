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
}
