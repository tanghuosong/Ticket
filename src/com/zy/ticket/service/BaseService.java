package com.zy.ticket.service;

import java.util.List;

public interface BaseService<T> {
	
	//保存模型 信息
	public void saveModel(T t);

	//根据id删除模型信息
	public void deleteModelById(Integer id);
	
	//根据id s批量删除模型信息
	public void deleteModelByIds(String ids);
	
	//获取记录总数
	public Integer getRowCount(String type, String key);
	
	public List<T> query();
	
	//更新模型信息
	public void updateModel(T t);
	
	// 排序分页返回
	public List<T> queryModelByPage(String type, String key, String rows,
			String page, String sort, String order);
}
