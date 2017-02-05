package com.zy.ticket.dao.impl;

import com.zy.ticket.bean.User;
import com.zy.ticket.dao.UserDao;
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public void updateUserStatus(User user) {
		String sql = "update User u set u.status = "+user.getStatus()+" where u.id = "+user.getId();
		session().createQuery(sql).executeUpdate();
	}

	@Override
	public Object checkUserLogin(User user) {
		String sql = "FROM User u where u.name =:name and u.password=:password";
		return session().createQuery(sql).setString("name", user.getName()).setString("password", user.getPassword()).uniqueResult();
	}
}
