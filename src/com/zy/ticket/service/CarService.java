package com.zy.ticket.service;

import java.util.List;

import com.zy.ticket.bean.Car;

public interface CarService extends BaseService<Car>{
	
	//查询该页记录
	public List<Car> queryCarByPage(String type, String key, String rows,
			String page, String sort, String order);

}
