package com.zy.ticket.action;

import com.zy.ticket.bean.Route;

public class RouteAction extends BaseAction<Route>{
	private static final long serialVersionUID = 1L;
	
	//添加线路信息
	public String saveRoute(){
		jsonMap.put("msg", routeService.saveModel(model));
		return "jsonMap";
	}
	
	//根据id删除线路信息
	public String deleteRouteById(){
		jsonMap.put("msg", routeService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除线路信息
	public String deleteRouteByIds(){
		jsonMap.put("msg", routeService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新线路信息
	public String updateRoute(){
		jsonMap.put("msg", routeService.updateModel(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的线路
	public String queryRouteByPage(){
		jsonMap.put("total", routeService.getRowCount(type,key));
		jsonMap.put("rows",routeService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
