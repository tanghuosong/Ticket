package com.zy.ticket.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.zy.ticket.bean.Manager;
import com.zy.ticket.service.ManagerService;
import com.zy.ticket.util.Message;

public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService{

	@Override
	public Message checkLogin(Manager manager) {
		Message message = new Message();
		if(managerDao.checkLogin(manager).size()!=0){
			message.result = true;
			message.content = "send_admin_index.action";
			// 将管理员存入session中，以便后面取值
			ActionContext.getContext().getSession().put("manager",manager);
		}else{
			message.result = false;
			message.content = "邮箱或密码错误，请重新登录！";
		}
		return message;
	}

}
