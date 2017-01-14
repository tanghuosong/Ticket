package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Driver;
import com.zy.ticket.dao.DriverDao;
@SuppressWarnings("unchecked")
public class DriverDaoImpl extends BaseDaoImpl<Driver> implements DriverDao {
	
	@Override
	public List<Driver> queryDriverByPage(String type, String key,
			int startRows, int _rows, String sort, String order) {
		String hql = "From Driver d  WHERE d."+type+" like :key order by d."+sort+" "+order;
		return session().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}

}
