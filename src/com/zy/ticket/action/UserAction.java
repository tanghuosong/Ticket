package com.zy.ticket.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.zy.ticket.bean.User;

public class UserAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	//用户注册
	public String saveUser(){
		jsonMap.put("msg", userService.registerUser(model,vcode));
		return "jsonMap";
	}
	// 用户登录
	public String userLogin(){
		jsonMap.put("msg", userService.checkUserLogin(model));
		return "jsonMap";
	}
	
	// 退出登录
	public void exit() {
		model=(User)ServletActionContext.getContext().getSession().get("user");
		if(model!=null){
			ActionContext.getContext().getSession().remove("user");
		}
	}
	
	//根据id删除用户信息
	public String deleteUserById(){
		jsonMap.put("msg", userService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除用户信息
	public String deleteUserByIds(){
		jsonMap.put("msg", userService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新用户信息
	public String updateUser(){
//		System.out.println(model);
		jsonMap.put("msg", userService.updateModel(model));
		return "jsonMap";
	}
	
	public String updateUserStatus(){
		jsonMap.put("msg", userService.updateUserStatus(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的用户
	public String queryUserByPage(){
		jsonMap.put("total", userService.getRowCount(type,key));
		jsonMap.put("rows",userService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
	
	
	
}
