package com.zy.ticket.action;

import com.zy.ticket.bean.Address;

public class AddressAction extends BaseAction<Address>{
	private static final long serialVersionUID = 1L;
	
	//添加地点信息
	public void saveAddress(){
		model.setFullname(model.getProvince()+model.getCity()+model.getCounty()+model.getStation());
		addressService.saveModel(model);
	}
	
	//根据id删除地点信息
	public void deleteAddressById(){
		addressService.deleteModelById(model.getId());
	}
	
	//根据id s批量删除地点信息
	public void deleteAddressByIds(){
		addressService.deleteModelByIds(ids);
	}
	
	//更新地点信息
	public void updateAddress(){
		System.out.println(model);
		addressService.updateModel(model);
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
