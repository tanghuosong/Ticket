package com.zy.ticket.service;

import java.util.List;

import com.zy.ticket.bean.Driver;

public interface DriverService extends BaseService<Driver>{
	
	//查询该页记录
	public List<Driver> queryDriverByPage(String type, String key, String rows,
			String page, String sort, String order);

}
