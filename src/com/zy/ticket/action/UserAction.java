package com.zy.ticket.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.zy.ticket.bean.User;

public class UserAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	private String result;
	public void setResult(String result) {
		this.result = result;
	}	
	private String vdcode;
	public void setVdcode(String vdcode) {
		this.vdcode = vdcode;
	}
	//验证验证码是否正确
	public String checkCode() throws IOException{
		String checkcode = (String)ActionContext.getContext().getSession().get("checkcode");
		if(vdcode.equalsIgnoreCase(checkcode)){
			//验证码正确
			result = "true";
		}else{
			//验证码错误
			result = "false";
		}
		inputStream = new ByteArrayInputStream(result.getBytes());
		return "stream";
	}
	
	
	//用户注册
	public String saveUser(){
//		System.out.println(model);
		jsonMap.put("msg", userService.saveModel(model));
		return "jsonMap";
	}

	public String userLogin(){
		jsonMap.put("msg", userService.checkUserLogin(model));
		return "jsonMap";
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
