package com.zy.ticket.dao.impl;

import com.zy.ticket.bean.Driver;
import com.zy.ticket.dao.DriverDao;
public class DriverDaoImpl extends BaseDaoImpl<Driver> implements DriverDao {
//	@Override
//	public void saveModel(Driver driver) {
//		String sql = "UPDATE Driver d SET d.drivername=:drivername,d.sex=:sex," +
//				"d.identitycard=:idcard,d.age=:age,d.phone=:phone WHERE d.id=:id";
//		session().createQuery(sql).setString("drivername", driver.getDrivername())
//			.setString("sex", driver.getSex()).setString("idcard", driver.getIdentitycard()).setInteger("age", driver.getAge())
//			.setString("phone", driver.getPhone()).setInteger("id", driver.getId()).executeUpdate();
// 	}
}
