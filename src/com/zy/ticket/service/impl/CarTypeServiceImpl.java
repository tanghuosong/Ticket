package com.zy.ticket.service.impl;

import java.util.List;

import com.zy.ticket.bean.CarType;
import com.zy.ticket.service.CarTypeService;

public class CarTypeServiceImpl extends BaseServiceImpl<CarType> implements CarTypeService{


	@Override
	public List<CarType> queryCarTypeByPage(String type, String key, String rows,
			String page, String sort, String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return carTypeDao.queryCarTypeByPage(type, key, startRows, _rows, sort, order);
	}

	@Override
	public List<CarType> queryCarTypeList() {
		return carTypeDao.query();
	}

}
