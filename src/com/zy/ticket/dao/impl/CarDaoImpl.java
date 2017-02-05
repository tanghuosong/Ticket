package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Car;
import com.zy.ticket.dao.CarDao;
@SuppressWarnings("unchecked")
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao {
	
	@Override
	public List<Car> queryCarByPage(String type, String key,
			int startRows, int _rows, String sort, String order) {
		String hql = "From Car c LEFT JOIN FETCH c.carType WHERE c."+type+" like :key order by c."+sort+" "+order;
		return session().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
	
	@Override
	public List<Car> findModelListByState(int state) {
		String hql = "From Car c LEFT JOIN FETCH c.carType WHERE c.status=:state";
		return session().createQuery(hql).setInteger("state", state).list();
	}
	
	@Override
	public List<Car> findModelListByStateAndId(int state, int id) {
		String hql = "From Car c LEFT JOIN FETCH c.carType WHERE c.status=:state OR c.id=:id";
		return session().createQuery(hql).setInteger("state", state).setInteger("id", id).list();
	}

}
