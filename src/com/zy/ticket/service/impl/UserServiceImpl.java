package com.zy.ticket.service.impl;

import com.zy.ticket.bean.User;
import com.zy.ticket.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Override
	public void updateUserStatus(User user) {
		userDao.updateUserStatus(user);
	}

	@Override
	public boolean checkUserLogin(User user) {
		boolean result = false;
		if(userDao.checkUserLogin(user)!=null){
			result = true;
		}
		return result;
	}



}
