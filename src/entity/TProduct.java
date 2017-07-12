package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TProduct entity. @author MyEclipse Persistence Tools
 */

public class TProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private TBigtype TBigtype;
	private TSmalltype TSmalltype;
	private String description;
	private Integer hot;
	private Timestamp hotTime;
	private String name;
	private Float price;
	private String proPic;
	private Short specialPrice;
	private Timestamp specialPriceTime;
	private Integer stock;
	private Set TOrderProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProduct() {
	}

	/** minimal constructor */
	public TProduct(Integer hot, Float price, Short specialPrice, Integer stock) {
		this.hot = hot;
		this.price = price;
		this.specialPrice = specialPrice;
		this.stock = stock;
	}

	/** full constructor */
	public TProduct(TBigtype TBigtype, TSmalltype TSmalltype,
			String description, Integer hot, Timestamp hotTime, String name,
			Float price, String proPic, Short specialPrice,
			Timestamp specialPriceTime, Integer stock, Set TOrderProducts) {
		this.TBigtype = TBigtype;
		this.TSmalltype = TSmalltype;
		this.description = description;
		this.hot = hot;
		this.hotTime = hotTime;
		this.name = name;
		this.price = price;
		this.proPic = proPic;
		this.specialPrice = specialPrice;
		this.specialPriceTime = specialPriceTime;
		this.stock = stock;
		this.TOrderProducts = TOrderProducts;
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

	public TSmalltype getTSmalltype() {
		return this.TSmalltype;
	}

	public void setTSmalltype(TSmalltype TSmalltype) {
		this.TSmalltype = TSmalltype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Timestamp getHotTime() {
		return this.hotTime;
	}

	public void setHotTime(Timestamp hotTime) {
		this.hotTime = hotTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getProPic() {
		return this.proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	public Short getSpecialPrice() {
		return this.specialPrice;
	}

	public void setSpecialPrice(Short specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Timestamp getSpecialPriceTime() {
		return this.specialPriceTime;
	}

	public void setSpecialPriceTime(Timestamp specialPriceTime) {
		this.specialPriceTime = specialPriceTime;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Set getTOrderProducts() {
		return this.TOrderProducts;
	}

	public void setTOrderProducts(Set TOrderProducts) {
		this.TOrderProducts = TOrderProducts;
	}

}