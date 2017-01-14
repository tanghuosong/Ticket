package com.zy.ticket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import com.zy.ticket.dao.BaseDao;
import com.zy.ticket.dao.CarDao;
import com.zy.ticket.dao.CarTypeDao;
import com.zy.ticket.dao.DriverDao;
import com.zy.ticket.service.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	//注入当前模型
	private Class<?> clazz;
	public BaseServiceImpl(){
		ParameterizedType type= (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class<?>)type.getActualTypeArguments()[0];
	}
	//执行构造函数以后执行的初始化方法，将dao层注入进来实现动态改变
	@PostConstruct
	public void init(){
		String className = clazz.getSimpleName();//获得类的名称
		String daoName = className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao";//拼接成为dao名称
		try {
			Field classField = this.getClass().getSuperclass().getDeclaredField(daoName);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, classField.get(this));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@SuppressWarnings("rawtypes")
	protected BaseDao baseDao;
	
	protected DriverDao driverDao;
	
	protected CarTypeDao carTypeDao;
	
	protected CarDao carDao;
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	
	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
	
	public void setCarTypeDao(CarTypeDao carTypeDao) {
		this.carTypeDao = carTypeDao;
	}
	
	@Override
	public void saveModel(T t) {
		baseDao.saveModel(t);
	}

	@Override
	public void deleteModelById(Integer id) {
		baseDao.deleteById(id);
	}

	@Override
	public void deleteModelByIds(String ids) {
		baseDao.deleteByIds(ids);
	}

	@Override
	public Integer getRowCount(String type, String key) {
		return baseDao.getRowCount(type, key);
	}

	@Override
	public void updateModel(T t) {
		baseDao.updateModel(t);
	}
}
