package com.zy.ticket.service;

import com.zy.ticket.bean.Message;
import com.zy.ticket.bean.User;

public interface UserService extends BaseService<User>{

	public Message updateUserStatus(User user);

	public Message checkUserLogin(User user);
	
}
