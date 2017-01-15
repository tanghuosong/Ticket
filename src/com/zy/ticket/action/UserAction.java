package com.zy.ticket.action;

import com.zy.ticket.bean.User;

public class UserAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	
	//添加司机信息
	public void saveUser(){
		userService.saveModel(model);
	}
	
	//根据id删除司机信息
	public void deleteUserById(){
		userService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除司机信息
	public void deleteUserByIds(){
		userService.deleteModelByIds(ids);
	}
	
	//更新司机信息
	public void updateUser(){
		System.out.println(model);
		userService.updateModel(model);
	}
	
	//分页排序查询所有的司机
	public String queryUserByPage(){
		jsonMap.put("total", userService.getRowCount(type,key));
		jsonMap.put("rows",userService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
