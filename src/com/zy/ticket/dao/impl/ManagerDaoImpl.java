package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Manager;
import com.zy.ticket.dao.ManagerDao;
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> checkLogin(Manager manager) {
		String sql = "FROM Manager m where m.email =:email and m.password=:password";
		return session().createQuery(sql).setString("email", manager.getEmail()).setString("password", manager.getPassword()).list();
	}
	
}
