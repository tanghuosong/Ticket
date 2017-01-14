package com.zy.ticket.bean;

import java.io.Serializable;

public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  driverName;
	private Integer age;
	private String  sex;
	private String  identityCard;
	private String  phone;
	
	public Driver(){}
	
	public Driver(Integer id, String driverName, Integer age, String sex,
			String identityCard, String phone) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.age = age;
		this.sex = sex;
		this.identityCard = identityCard;
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", driverName=" + driverName + ", age="
				+ age + ", sex=" + sex + ", identityCard=" + identityCard
				+ ", phone=" + phone + "]";
	}

	public Integer getId() {
		return id;
	}
	public String getDriverName() {
		return driverName;
	}
	public Integer getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
