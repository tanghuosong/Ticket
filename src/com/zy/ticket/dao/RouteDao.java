package com.zy.ticket.dao;

import com.zy.ticket.bean.Route;

public interface RouteDao extends BaseDao<Route>{
	
	public int updateSeatNum(Route route);
	public int subOrAddOneSoldNum(int id,int soldNum);
	
}
