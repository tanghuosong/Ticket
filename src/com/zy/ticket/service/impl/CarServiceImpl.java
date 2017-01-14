package com.zy.ticket.service.impl;

import java.util.List;

import com.zy.ticket.bean.Car;
import com.zy.ticket.service.CarService;

public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService{

	@Override
	public List<Car> queryCarByPage(String type, String key, String rows,
			String page, String sort, String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return carDao.queryCarByPage(type, key, startRows, _rows, sort, order);
	}

}
