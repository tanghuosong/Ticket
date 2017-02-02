package com.zy.ticket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import com.zy.ticket.dao.AddressDao;
import com.zy.ticket.dao.BaseDao;
import com.zy.ticket.dao.CarDao;
import com.zy.ticket.dao.CarTypeDao;
import com.zy.ticket.dao.DriverDao;
import com.zy.ticket.dao.ManagerDao;
import com.zy.ticket.dao.OrderDao;
import com.zy.ticket.dao.RouteDao;
import com.zy.ticket.dao.UserDao;
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
	
	protected AddressDao addressDao;
	
	protected UserDao userDao;
	
	protected ManagerDao managerDao;

	protected RouteDao routeDao;
	
	protected OrderDao orderDao;
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	
	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
	
	public void setCarTypeDao(CarTypeDao carTypeDao) {
		this.carTypeDao = carTypeDao;
	}
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
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
	
	@Override
	public List<T> query(){
		return baseDao.query();
	}
	
	@Override
	public List<T> queryModelByPage(String type, String key, String rows,
			String page, String sort, String order) {
//		System.out.println("page="+page+";"+"rows="+rows);
		int _page = Integer.parseInt(page);
		int _rows = Integer.parseInt(rows);
		int startRows = _rows *(_page-1);
		return baseDao.queryModelByPage(type, key, startRows, _rows, sort, order);
	}
	
	@Override
	public List<T> findModelListByState(int state) {
		return baseDao.findModelListByState(state);
	}
}
