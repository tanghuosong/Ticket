package com.zy.ticket.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  carName;
	private String  carCard;
	private Timestamp buyTime;
	private Integer seatNum;
	private CarType  carType;
	
	public Car(){}

	public Car(Integer id, String carName, String carCard, Timestamp buyTime,
			Integer seatNum, CarType carType) {
		super();
		this.id = id;
		this.carName = carName;
		this.carCard = carCard;
		this.buyTime = buyTime;
		this.seatNum = seatNum;
		this.carType = carType;
	}
	
	public Integer getId() {
		return id;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarCard() {
		return carCard;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setCarType(CarType carType) {
		this.carType = carType;
	}
}
