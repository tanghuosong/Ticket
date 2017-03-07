package com.zy.ticket.service;

import com.zy.ticket.bean.User;
import com.zy.ticket.util.Message;

public interface UserService extends BaseService<User>{

	
	public Message registerUser(User user,String vcode);
	
	public Message updateUserStatus(User user);

	public Message checkUserLogin(User user);
	
	public Message updateUserPassword(String newPassword,String oldPassword);
}
