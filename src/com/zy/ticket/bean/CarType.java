package com.zy.ticket.bean;


/**
 * Cartype entity. @author MyEclipse Persistence Tools
 */

public class CarType  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
     private String typeName;
//     private Set<?> cars = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public CarType() {
    }

	/** minimal constructor */
    public CarType(String typeName) {
        this.typeName = typeName;
    }
    
    /** full constructor */
//    public CarType(String typeName, Set<?> cars) {
//        this.typeName = typeName;
//        this.cars = cars;
//    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

//    public Set<?> getCars() {
//        return this.cars;
//    }
//    
//    public void setCars(Set<?> cars) {
//        this.cars = cars;
//    }

}