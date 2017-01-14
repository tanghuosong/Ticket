package com.zy.ticket.dao.impl;

import java.util.List;

import com.zy.ticket.bean.Address;
import com.zy.ticket.dao.AddressDao;
@SuppressWarnings("unchecked")
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao {
	
	@Override
	public List<Address> queryAddressByPage(String type, String key,
			int startRows, int _rows, String sort, String order) {
		String hql = "From Address a  WHERE a."+type+" like :key order by c."+sort+" "+order;
		return session().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}

}
