package com.zy.ticket.action;

import com.zy.ticket.bean.Address;

public class AddressAction extends BaseAction<Address>{
	private static final long serialVersionUID = 1L;
	
	//添加地点信息
	public String saveAddress(){
		model.setFullname(model.getProvince()+model.getCity()+model.getCounty()+model.getStation());
		jsonMap.put("msg", addressService.saveModel(model));
		return "jsonMap";
	}
	
	//根据id删除地点信息
	public String deleteAddressById(){
		jsonMap.put("msg", addressService.deleteModelById(model.getId()));
		return "jsonMap";
	}
	
	//根据id s批量删除地点信息
	public String deleteAddressByIds(){
		jsonMap.put("msg", addressService.deleteModelByIds(ids));
		return "jsonMap";
	}
	
	//更新地点信息
	public String updateAddress(){
		jsonMap.put("msg", addressService.updateModel(model));
		return "jsonMap";
	}
	
	//分页排序查询所有的地点
	public String queryAddressByPage(){
		jsonMap.put("total", addressService.getRowCount(type,key));
		jsonMap.put("rows",addressService.queryModelByPage(type, key, rows, page, sort, order));
		return "jsonMap";
	}
	
	public String queryAddressList(){
		jsonList = addressService.query();
		return "jsonList";
	}
}
