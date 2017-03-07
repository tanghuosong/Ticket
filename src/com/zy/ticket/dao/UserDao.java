package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.User;

public interface UserDao extends BaseDao<User>{

	public void updateUserStatus(User user);

	public List<User> checkUserLogin(User user);
	
	public boolean checkUsername(String username);

	public void updateUserPassword(User user,String newPassword);
}
