package com.zy.ticket.bean;

import java.sql.Timestamp;

/**
 * Route entity. @author MyEclipse Persistence Tools
 */

public class Route implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Address address;
	private Car car;
	private Driver driver;
	private Timestamp starttime;
	private Double price;
	private Integer sold;
//	private Set<?> orders = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public Route() {
	}

	/** minimal constructor */
	public Route(Address address, Car car, Driver driver, Timestamp starttime,
			Double price, Integer sold) {
		this.address = address;
		this.car = car;
		this.driver = driver;
		this.starttime = starttime;
		this.price = price;
		this.sold = sold;
	}

	/** full constructor */
//	public Route(Address address, Car car, Driver driver, Timestamp starttime,
//			Double price, Integer sold, Set<?> orders) {
//		this.address = address;
//		this.car = car;
//		this.driver = driver;
//		this.starttime = starttime;
//		this.price = price;
//		this.sold = sold;
//		this.orders = orders;
//	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSold() {
		return this.sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}
//
//	public Set<?> getOrders() {
//		return this.orders;
//	}
//
//	public void setOrders(Set<?> orders) {
//		this.orders = orders;
//	}

}