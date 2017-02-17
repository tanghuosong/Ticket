package com.zy.ticket.action;

import com.zy.ticket.bean.Driver;

public class DriverAction extends BaseAction<Driver>{
	private static final long serialVersionUID = 1L;
	
	//添加司机信息
	public String saveDriver(){
		model.setStatus(0);
		jsonMap.put("msg", driverService.saveModel(model));
		return "jsonMap";
	}
	
	//根据id删除司机信息
	public String deleteDriverById(){
		jsonMap.put("msg", driverService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除司机信息
	public String deleteDriverByIds(){
		jsonMap.put("msg",driverService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新司机信息
	public String updateDriver(){
		jsonMap.put("msg", driverService.updateModel(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的司机
	public String queryDriverByPage(){
		jsonMap.put("total", driverService.getRowCount(type,key));
		jsonMap.put("rows",driverService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
	
	//根据状态查询司机，返回list
	public String findDriverByStatus(){
		jsonList = driverService.findModelListByState(Integer.parseInt(state));
		return "jsonList";
	}
	
	public String findDriverByStatusAndId(){
		jsonList = driverService.findModelListByStateAndId(Integer.parseInt(state),Integer.parseInt(key));
		return "jsonList";
	}
}
