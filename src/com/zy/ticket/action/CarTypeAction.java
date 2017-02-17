package com.zy.ticket.action;

import com.zy.ticket.bean.CarType;

public class CarTypeAction extends BaseAction<CarType>{
	private static final long serialVersionUID = 1L;
	
	//添加汽车分类信息
	public String saveCarType(){
		jsonMap.put("msg", carTypeService.saveModel(model));
		return "jsonMap";
		
	}
	
	//根据id删除汽车分类信息
	public String deleteCarTypeById(){
		jsonMap.put("msg", carTypeService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除汽车分类信息
	public String deleteCarTypeByIds(){
		jsonMap.put("msg", carTypeService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新汽车分类信息
	public String updateCarType(){
		jsonMap.put("msg", carTypeService.updateModel(model));
		return "jsonMap";
	}
	
	//查询汽车分类列表
	public String queryCarTypeList(){
		jsonList = carTypeService.query();
		return "jsonList";
	}
	
	//分页查询所有的汽车分类
	public String queryCarTypeByPage(){
		jsonMap.put("total", carTypeService.getRowCount(type,key));
		jsonMap.put("rows",carTypeService.queryModelByPage(type, key ,rows,page,sort,order));
		return "jsonMap";
	}
}
