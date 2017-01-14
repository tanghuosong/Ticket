package com.zy.ticket.bean;

public class Address {
	private Integer id;
	private String province;
	private String city;
	private String county;
	private String station;
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address( String province, String city, String county,
			String station) {
		super();
		this.province = province;
		this.city = city;
		this.county = county;
		this.station = station;
	}

	
	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city="
				+ city + ", county=" + county + ", station=" + station + "]";
	}

	public Integer getId() {
		return id;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getCounty() {
		return county;
	}
	public String getStation() {
		return station;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	
}
