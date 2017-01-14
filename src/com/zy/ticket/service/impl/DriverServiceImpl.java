package com.zy.ticket.service.impl;

import java.util.List;
import com.zy.ticket.bean.Driver;
import com.zy.ticket.service.DriverService;

public class DriverServiceImpl extends BaseServiceImpl<Driver> implements DriverService{


	@Override
	public List<Driver> queryDriverByPage(String type, String key, String rows,
			String page, String sort, String order) {
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return driverDao.queryDriverByPage(type, key, startRows, _rows, sort, order);
	}


}
