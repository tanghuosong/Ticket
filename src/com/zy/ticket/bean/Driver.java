package com.zy.ticket.bean;

/**
 * Driver entity. @author MyEclipse Persistence Tools
 */

public class Driver implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String drivername;
	private Integer age;
	private String identitycard;
	private String phone;
	private String sex;
	private Integer status;
//	private Set<?> routes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public Driver() {
	}

	/** minimal constructor */
	public Driver(String drivername, Integer age, String identitycard,
			String phone, String sex, Integer status) {
		this.drivername = drivername;
		this.age = age;
		this.identitycard = identitycard;
		this.phone = phone;
		this.sex = sex;
		this.status = status;
	}
	
	public Driver(String drivername, Integer age, String identitycard,
			String phone, String sex) {
		this.drivername = drivername;
		this.age = age;
		this.identitycard = identitycard;
		this.phone = phone;
		this.sex = sex;
	}

	/** full constructor */
//	public Driver(String drivername, Integer age, String identitycard,
//			String phone, String sex, Set<?> routes) {
//		this.drivername = drivername;
//		this.age = age;
//		this.identitycard = identitycard;
//		this.phone = phone;
//		this.sex = sex;
//		this.routes = routes;
//	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrivername() {
		return this.drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdentitycard() {
		return this.identitycard;
	}

	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}

//	public Set<?> getRoutes() {
//		return this.routes;
//	}
//
//	public void setRoutes(Set<?> routes) {
//		this.routes = routes;
//	}

}