package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.Car;

public interface CarDao extends BaseDao<Car>{

	public List<Car> queryCarByPage(String type, String key, int startRows,
			int _rows, String sort, String order);
}
