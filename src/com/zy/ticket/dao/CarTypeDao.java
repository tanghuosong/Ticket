package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.CarType;

public interface CarTypeDao extends BaseDao<CarType>{

	public List<CarType> queryCarTypeByPage(String type, String key, int startRows,
			int _rows, String sort, String order);
}
