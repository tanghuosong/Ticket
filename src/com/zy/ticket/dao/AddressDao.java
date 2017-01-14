package com.zy.ticket.dao;

import java.util.List;

import com.zy.ticket.bean.Address;

public interface AddressDao extends BaseDao<Address>{

	public List<Address> queryAddressByPage(String type, String key, int startRows,
			int _rows, String sort, String order);
}
