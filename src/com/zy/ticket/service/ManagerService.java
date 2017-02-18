package com.zy.ticket.service;

import com.zy.ticket.bean.Manager;
import com.zy.ticket.util.Message;

public interface ManagerService extends BaseService<Manager>{

	public Message checkLogin(Manager model);
	
}
