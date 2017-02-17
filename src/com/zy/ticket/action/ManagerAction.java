package com.zy.ticket.action;

import com.zy.ticket.bean.Manager;

public class ManagerAction extends BaseAction<Manager>{
	private static final long serialVersionUID = 1L;
	
	//添加管理员信息
	public String saveManager(){
		jsonMap.put("msg", managerService.saveModel(model));
		return "jsonMap";
	}
	
	//根据id删除管理员信息
	public String deleteManagerById(){
		jsonMap.put("msg", managerService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除管理员信息
	public String deleteManagerByIds(){
		jsonMap.put("msg", managerService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新管理员信息
	public String updateManager(){
		
		jsonMap.put("msg", managerService.updateModel(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的管理员
	public String queryManagerByPage(){
		jsonMap.put("total", managerService.getRowCount(type,key));
		jsonMap.put("rows",managerService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
