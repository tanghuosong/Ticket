package com.zy.ticket.action;

import com.zy.ticket.bean.Car;

public class CarAction extends BaseAction<Car>{
	private static final long serialVersionUID = 1L;
	
	//添加汽车信息
	public String saveCar(){
		jsonMap.put("msg", carService.saveModel(model));
		return "jsonMap";
		
	}
	
	//根据id删除汽车信息
	public String deleteCarById(){
		jsonMap.put("msg", carService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除汽车信息
	public String deleteCarByIds(){
		jsonMap.put("msg", carService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新汽车信息
	public String updateCar(){
		jsonMap.put("msg", carService.updateModel(model));
		return "jsonMap";
		
	}
	//分页查询所有的汽车
	public String queryCarByPage(){
		jsonMap.put("total", carService.getRowCount(type,key));
		jsonMap.put("rows",carService.queryCarByPage(type, key ,rows,page,sort,order));
		return "jsonMap";
	}
	
	public String findCarByStatus(){
//		mapList= carService.findModelListByState(Integer.parseInt(state));
		mapList.addAll(carService.findModelListByState(Integer.parseInt(state)));
		return "mapList";
	}
	
	public String findCarByStatusAndId(){
		mapList.addAll(carService.findModelListByStateAndId(Integer.parseInt(state),Integer.parseInt(key)));
		return "mapList";
	}
}
