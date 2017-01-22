package com.zy.ticket.action;

import com.zy.ticket.bean.Manager;

public class ManagerAction extends BaseAction<Manager>{
	private static final long serialVersionUID = 1L;
	
	//添加管理员信息
	public void saveManager(){
		managerService.saveModel(model);
	}
	
	//根据id删除管理员信息
	public void deleteManagerById(){
		managerService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除管理员信息
	public void deleteManagerByIds(){
		managerService.deleteModelByIds(ids);
	}
	
	//更新管理员信息
	public void updateManager(){
		System.out.println(model);
		managerService.updateModel(model);
	}
	
	//分页排序查询所有的管理员
	public String queryManagerByPage(){
		jsonMap.put("total", managerService.getRowCount(type,key));
		jsonMap.put("rows",managerService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
