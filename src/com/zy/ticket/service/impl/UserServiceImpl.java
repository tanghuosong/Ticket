package com.zy.ticket.service.impl;

import com.zy.ticket.bean.Message;
import com.zy.ticket.bean.User;
import com.zy.ticket.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Override
	public Message updateUserStatus(User user) {
		Message message = new Message();
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
		Message message = new Message();
		if(userDao.checkUserLogin(user)!=null){
			message.result = true;
			message.content = "注册成功！";
		}else{
			message.result = false;
			message.content = "注册失败！";
		}
		return message;
	}



}
