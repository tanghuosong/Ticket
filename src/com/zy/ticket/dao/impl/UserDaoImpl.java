package com.zy.ticket.dao.impl;

import com.zy.ticket.bean.User;
import com.zy.ticket.dao.UserDao;
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public void updateUserStatus(User user) {
		String sql = "update User u set u.status = "+user.getStatus()+" where u.id = "+user.getId();
		session().createQuery(sql).executeUpdate();
	}
}
