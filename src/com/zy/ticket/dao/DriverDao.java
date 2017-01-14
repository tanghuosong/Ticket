package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.Driver;

public interface DriverDao extends BaseDao<Driver>{

	public List<Driver> queryDriverByPage(String type, String key, int startRows,
			int _rows, String sort, String order);
}
