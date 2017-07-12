package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TBigtype entity. @author MyEclipse Persistence Tools
 */

public class TBigtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remarks;
	private Set TProducts = new HashSet(0);
	private Set TSmalltypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBigtype() {
	}

	/** full constructor */
	public TBigtype(String name, String remarks, Set TProducts, Set TSmalltypes) {
		this.name = name;
		this.remarks = remarks;
		this.TProducts = TProducts;
		this.TSmalltypes = TSmalltypes;
	}

	// Property accessors

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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getTProducts() {
		return this.TProducts;
	}

	public void setTProducts(Set TProducts) {
		this.TProducts = TProducts;
	}

	public Set getTSmalltypes() {
		return this.TSmalltypes;
	}

	public void setTSmalltypes(Set TSmalltypes) {
		this.TSmalltypes = TSmalltypes;
	}

}