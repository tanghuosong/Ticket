package com.zy.ticket.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.zy.ticket.bean.User;
import com.zy.ticket.service.UserService;
import com.zy.ticket.util.Message;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	Message message = new Message();
	@Override
	public Message registerUser(User user, String vcode) {
		String checkcode = (String)ActionContext.getContext().getSession().get("checkcode");
		// 检查用户名是否存在
		if(!checkcode.equalsIgnoreCase(vcode)){
			message.result = false;
			message.content = "验证码不正确！";
		}else{
			if(userDao.checkUsername(user.getName())){
				try{
					userDao.saveModel(user);
					message.result = true;
					message.content = "恭喜您，注册成功！";
				}catch (Exception e) {
					message.result = false;
					message.content = "注册失败，"+e.getMessage();
				}
			}else{
				message.result = false;
				message.content = "用户名已经被注册";
			}
		}
		return message;
	}
	
	@Override
	public Message updateUserStatus(User user) {
		try{
			userDao.updateUserStatus(user);
			message.result = true;
			message.content = "更新成功！";
		}catch (Exception e) {
			message.result = false;
			message.content = "更新失败！"+e.getMessage();
		}
		return message;
	}

	@Override
	public Message checkUserLogin(User user) {
		if(userDao.checkUserLogin(user).size()!=0){
			message.result = true;
			message.content = "登录成功！";
			// 将用户存入session中，以便后面取值
			ActionContext.getContext().getSession().put("user",userDao.checkUserLogin(user).get(0));
		}else{
			message.result = false;
			message.content = "用户名或密码错误，请重新登录！";
		}
		return message;
	}



}
