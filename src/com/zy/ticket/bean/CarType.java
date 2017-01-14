package com.zy.ticket.bean;

import java.io.Serializable;

public class CarType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  typeName;
	
	public CarType() {
	}

	public CarType(Integer id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
