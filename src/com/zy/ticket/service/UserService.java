package com.zy.ticket.service;

import com.zy.ticket.bean.User;

public interface UserService extends BaseService<User>{

	public void updateUserStatus(User user);

	public boolean checkUserLogin(User user);
	
}
