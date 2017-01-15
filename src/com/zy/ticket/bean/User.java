package com.zy.ticket.bean;

// default package

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String sex;
	private String password;
	private String idcard;
	private String email;
	private String phone;

	public User() {
	}

	/** full constructor */
	public User(String name, String sex, String password, String idcard,
			String email, String phone) {
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.idcard = idcard;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
