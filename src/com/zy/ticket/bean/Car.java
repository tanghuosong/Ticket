package com.zy.ticket.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private CarType carType;
	private String carName;
	private String carCard;
	private Timestamp buyTime;
	private Integer seatNum;
	private Set<?> routes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public Car() {
	}
	
	

	public Car(Integer id, CarType carType, String carName, String carCard,
			Timestamp buyTime, Integer seatNum) {
		super();
		this.id = id;
		this.carType = carType;
		this.carName = carName;
		this.carCard = carCard;
		this.buyTime = buyTime;
		this.seatNum = seatNum;
	}



	public Car(Integer id, CarType carType, String carName, String carCard,
			Timestamp buyTime, Integer seatNum, Set<?> routes) {
		super();
		this.id = id;
		this.carType = carType;
		this.carName = carName;
		this.carCard = carCard;
		this.buyTime = buyTime;
		this.seatNum = seatNum;
		this.routes = routes;
	}
	


	public Integer getId() {
		return id;
	}

	public CarType getCarType() {
		return carType;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarCard() {
		return carCard;
	}

	public Timestamp getBuyTime() {
		return buyTime;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public Set<?> getRoutes() {
		return routes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setCarCard(String carCard) {
		this.carCard = carCard;
	}

	public void setBuyTime(Timestamp buyTime) {
		this.buyTime = buyTime;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public void setRoutes(Set<?> routes) {
		this.routes = routes;
	}
	

}