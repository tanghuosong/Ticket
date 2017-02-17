package com.zy.ticket.service;

import java.util.List;

import com.zy.ticket.bean.Message;

public interface BaseService<T> {
	
	//保存模型 信息
	public Message saveModel(T t);
	
	//根据id删除模型信息
	public Message deleteModelById(Integer id);
	
	//根据id s批量删除模型信息
	public Message deleteModelByIds(String ids);
	
	//获取记录总数
	public Integer getRowCount(String type, String key);
	
	public List<T> query();
	
	//更新模型信息
	public Message updateModel(T t);
	
	// 排序分页返回
	public List<T> queryModelByPage(String type, String key, String rows,
			String page, String sort, String order);
	
	// 根据状态查询Model
	public List<T> findModelListByState(int state);
	
	// 根据状态和Id返回Model
	public List<T> findModelListByStateAndId(int state,int id);
}
