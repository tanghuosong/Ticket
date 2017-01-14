package com.zy.ticket.service;

import java.util.List;

import com.zy.ticket.bean.CarType;

public interface CarTypeService extends BaseService<CarType>{
	
	//查询该页记录
	public List<CarType> queryCarTypeByPage(String type, String key, String rows,
			String page, String sort, String order);
	

	//获取汽车分类列表
	public List<CarType> queryCarTypeList();


}
