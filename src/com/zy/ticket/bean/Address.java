package com.zy.ticket.bean;
// default package


/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String province;
     private String city;
     private String county;
     private String station;
//     private Set<?> routes = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Address() {
    }

	/** minimal constructor */
    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }
    
    /** full constructor */
//    public Address(String province, String city, String county, String station, Set<?> routes) {
//        this.province = province;
//        this.city = city;
//        this.county = county;
//        this.station = station;
//        this.routes = routes;
//    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return this.county;
    }
    
    public void setCounty(String county) {
        this.county = county;
    }

    public String getStation() {
        return this.station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }

//    public Set<?> getRoutes() {
//        return this.routes;
//    }
//    
//    public void setRoutes(Set<?> routes) {
//        this.routes = routes;
//    }

}