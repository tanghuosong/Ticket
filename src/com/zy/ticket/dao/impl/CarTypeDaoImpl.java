package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.CarType;
import com.zy.ticket.dao.CarTypeDao;
@SuppressWarnings("unchecked")
public class CarTypeDaoImpl extends BaseDaoImpl<CarType> implements CarTypeDao {
	
	@Override
	public List<CarType> queryCarTypeByPage(String type, String key,
			int startRows, int _rows, String sort, String order) {
		String hql = "From CarType c  WHERE c."+type+" like :key order by c."+sort+" "+order;
		return session().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}

}
