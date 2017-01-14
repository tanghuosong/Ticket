package com.zy.ticket.dao;

import java.util.List;

public interface BaseDao<T> {
	
	//通过id查询单个记录
	public T get(Integer id);
	
	//查询所有记录
	public List<T> query();

	//根据id 删除单条记录
	public void deleteById(Integer id);
	
	//根据id s删除多条记录
	public void deleteByIds(String ids);
	
	//更新一条记录
	public void updateModel(T t);
	
	//增加一条记录
	public void saveModel(T t);
	
	//获取记录总数
	public int getRowCount(String type, String key);
}
