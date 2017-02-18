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
	public User checkUserLogin(User user) {
		String sql = "FROM User u where u.name =:name and u.password=:password";
		return (User) session().createQuery(sql).setString("name", user.getName()).setString("password", user.getPassword()).uniqueResult();
	}
	
	@Override
	public boolean checkUsername(String username) {
		String sqlString = "FROM User u WHERE u.name =:name";
		if(session().createQuery(sqlString).setString("name", username).list().size()!=0){
			return false;
		}
		return true;
	}
}
