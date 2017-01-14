package com.zy.ticket.service;

public interface BaseService<T> {
	
	//保存模型 信息
	public void saveModel(T t);

	//根据id删除模型信息
	public void deleteModelById(Integer id);
	
	//根据id s批量删除模型信息
	public void deleteModelByIds(String ids);
	
	//获取记录总数
	public Integer getRowCount(String type, String key);
	
	//更新模型信息
	public void updateModel(T t);
}
