package com.zy.ticket.bean;


/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Route route;
	private User user;
	private Integer status;
	private Integer ticketnum;
	private String createtime;
	private String updatetime;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Route route, User user, Integer status, Integer ticketnum,String createtime,
			String updatetime) {
		this.route = route;
		this.user = user;
		this.status = status;
		this.ticketnum = ticketnum;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(Integer ticketnum) {
		this.ticketnum = ticketnum;
	}


	@Override
	public String toString() {
		return "Order [route=" + route + ", user=" + user + ", status="
				+ status + ", ticketnum=" + ticketnum + ", createtime="
				+ createtime + ", updatetime=" + updatetime +  "]";
	}

}