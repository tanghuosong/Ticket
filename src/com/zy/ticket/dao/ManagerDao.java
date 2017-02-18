package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.Manager;

public interface ManagerDao extends BaseDao<Manager>{

	public List<Manager> checkLogin(Manager manager);

}
