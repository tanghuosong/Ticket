package com.zy.ticket.action;

import com.zy.ticket.bean.Driver;

public class DriverAction extends BaseAction<Driver>{
	private static final long serialVersionUID = 1L;
	
	//添加司机信息
	public void saveDriver(){
		driverService.saveModel(model);
	}
	
	//根据id删除司机信息
	public void deleteDriverById(){
		driverService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除司机信息
	public void deleteDriverByIds(){
		driverService.deleteModelByIds(ids);
	}
	
	//更新司机信息
	public void updateDriver(){
		System.out.println(model);
		driverService.updateModel(model);
	}
	//分页查询所有的司机
	public String queryDriverByPage(){
		jsonMap.put("total", driverService.getRowCount(type,key));
		jsonMap.put("rows",driverService.queryDriverByPage(type, key ,rows,page,sort,order));
		return "jsonMap";
	}
}
