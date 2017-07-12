package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUser TUser;
	private Float cost;
	private Timestamp createTime;
	private String orderNo;
	private Integer status;
	private Set TOrderProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(Float cost, Integer status) {
		this.cost = cost;
		this.status = status;
	}

	/** full constructor */
	public TOrder(TUser TUser, Float cost, Timestamp createTime,
			String orderNo, Integer status, Set TOrderProducts) {
		this.TUser = TUser;
		this.cost = cost;
		this.createTime = createTime;
		this.orderNo = orderNo;
		this.status = status;
		this.TOrderProducts = TOrderProducts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getTOrderProducts() {
		return this.TOrderProducts;
	}

	public void setTOrderProducts(Set TOrderProducts) {
		this.TOrderProducts = TOrderProducts;
	}

}