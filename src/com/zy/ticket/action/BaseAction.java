package com.zy.ticket.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.ticket.service.AddressService;
import com.zy.ticket.service.CarService;
import com.zy.ticket.service.CarTypeService;
import com.zy.ticket.service.DriverService;
import com.zy.ticket.service.ManagerService;
import com.zy.ticket.service.OrderService;
import com.zy.ticket.service.RouteService;
import com.zy.ticket.service.UserService;
@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements ApplicationAware,
	SessionAware,RequestAware, ModelDriven<T>{

	private static final long serialVersionUID = 1L;
	//获取当前模型
	protected T model;
	
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		Class<T> clazz = (Class<T>)type.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return model;
	}
	
	//注入application session request域
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	//json形式数据返回
	protected Map<String, Object> jsonMap = new HashMap<String, Object>();
	protected List<T> jsonList = new ArrayList<T>();
	protected InputStream inputStream;
	
	//前台传入参数
	protected String ids;
	protected String page;
	protected String rows;
	protected String sort = "id";
	protected String order = "desc";
	protected String type;
	protected String key;
	//注入service
	protected DriverService driverService;
	
	protected CarTypeService carTypeService;
	
	protected CarService carService;

	protected AddressService addressService;
	
	protected UserService userService;
	
	protected ManagerService managerService;
	
	protected OrderService orderService;
	
	protected RouteService routeService;
	
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}
	
	public void setCarTypeService(CarTypeService carTypeService) {
		this.carTypeService = carTypeService;
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public Map<String, Object> getRequest() {
		return request;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public Map<String, Object> getApplication() {
		return application;
	}
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	
	public List<T> getJsonList() {
		return jsonList;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getPage() {
		return page;
	}
	
	public void setRows(String rows) {
		this.rows = rows;
	}
	
	public String getRows() {
		return rows;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
}
