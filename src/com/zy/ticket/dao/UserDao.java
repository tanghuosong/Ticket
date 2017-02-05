package com.zy.ticket.dao;

import com.zy.ticket.bean.User;

public interface UserDao extends BaseDao<User>{

	public void updateUserStatus(User user);

	public Object checkUserLogin(User user);

}
