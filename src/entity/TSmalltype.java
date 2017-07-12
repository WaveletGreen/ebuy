package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TSmalltype entity. @author MyEclipse Persistence Tools
 */

public class TSmalltype implements java.io.Serializable {

	// Fields

	private Integer id;
	private TBigtype TBigtype;
	private String name;
	private String remarks;
	private Set TProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TSmalltype() {
	}

	/** full constructor */
	public TSmalltype(TBigtype TBigtype, String name, String remarks,
			Set TProducts) {
		this.TBigtype = TBigtype;
		this.name = name;
		this.remarks = remarks;
		this.TProducts = TProducts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TBigtype getTBigtype() {
		return this.TBigtype;
	}

	public void setTBigtype(TBigtype TBigtype) {
		this.TBigtype = TBigtype;
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

}