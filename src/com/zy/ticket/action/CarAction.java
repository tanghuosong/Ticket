package com.zy.ticket.action;

import com.zy.ticket.bean.Car;

public class CarAction extends BaseAction<Car>{
	private static final long serialVersionUID = 1L;
	
	//添加汽车信息
	public void saveCar(){
		System.out.println(model);
		carService.saveModel(model);
		
	}
	
	//根据id删除汽车信息
	public void deleteCarById(){
		carService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除汽车信息
	public void deleteCarByIds(){
		carService.deleteModelByIds(ids);
	}
	
	//更新汽车信息
	public void updateCar(){
		carService.updateModel(model);
	}
	//分页查询所有的汽车
	public String queryCarByPage(){
		jsonMap.put("total", carService.getRowCount(type,key));
		jsonMap.put("rows",carService.queryCarByPage(type, key ,rows,page,sort,order));
		return "jsonMap";
	}
}
