package com.zy.ticket.action;

import com.zy.ticket.bean.Route;

public class RouteAction extends BaseAction<Route>{
	private static final long serialVersionUID = 1L;
	
	//添加线路信息
	public void saveRoute(){
		System.out.println(model.getStarttime().toString());
		routeService.saveModel(model);
	}
	
	//根据id删除线路信息
	public void deleteRouteById(){
		routeService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除线路信息
	public void deleteRouteByIds(){
		routeService.deleteModelByIds(ids);
	}
	
	//更新线路信息
	public void updateRoute(){
		routeService.updateModel(model);
	}
	
	//分页排序查询所有的线路
	public String queryRouteByPage(){
		jsonMap.put("total", routeService.getRowCount(type,key));
		jsonMap.put("rows",routeService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
}
