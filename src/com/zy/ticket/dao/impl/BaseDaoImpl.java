package com.zy.ticket.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zy.ticket.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<?> clazz;
	public BaseDaoImpl(){
		ParameterizedType type= (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class<?>)type.getActualTypeArguments()[0];
	}
	private SessionFactory sessionFactory;
		
	protected Session session() {
		//获得session
		return sessionFactory.getCurrentSession();
	}
		
	public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
	}
	
	//根据id查询单条记录
	@Override
	public T get(Integer id) {
		return (T) session().get(clazz, id);
	}
	
	//查询所有记录
	@Override
	public List<T> query() {
		String hqlString = "From "+clazz.getSimpleName();
		return session().createQuery(hqlString).list();
	}
	
	//根据id删除一条记录
	@Override
	public void deleteById(Integer id) {
		String hqlString = "Delete "+clazz.getSimpleName()+"Where id =:id"; 
		session().createQuery(hqlString).setInteger("id", id).executeUpdate();
	}
	
	//根据id s删除多条记录
	@Override
	public void deleteByIds(String ids) {
		String hqlString = "Delete "+clazz.getSimpleName()+" where id in("+ids+")";
		session().createQuery(hqlString).executeUpdate();
	}
	
	//更新一条记录
	@Override
	public void updateModel(T t) {
		session().update(t);
	}
	
	//保存一条记录
	@Override
	public void saveModel(T t) {
		session().merge(t);
	}
	
	//查询记录总数
	@Override
	public int getRowCount(String type, String key) {
		String hql = "select count(k) from "+clazz.getSimpleName()+" k where k."+type+" like :key";
		Number number = (Number)session().createQuery(hql).setString("key", "%"+key+"%").uniqueResult();
		return number.intValue();
	}
	
	// 排序返回
	@Override
	public List<T> queryModelByPage(String type, String key,
			int startRows, int _rows, String sort, String order) {
		String hql = "From "+clazz.getSimpleName()+" t  WHERE t."+type+" like :key order by t."+sort+" "+order;
		return session().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
}
