package entity;

/**
 * TOrderProduct entity. @author MyEclipse Persistence Tools
 */

public class TOrderProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private TOrder TOrder;
	private TProduct TProduct;
	private Integer num;

	// Constructors

	/** default constructor */
	public TOrderProduct() {
	}

	/** minimal constructor */
	public TOrderProduct(Integer num) {
		this.num = num;
	}

	/** full constructor */
	public TOrderProduct(TOrder TOrder, TProduct TProduct, Integer num) {
		this.TOrder = TOrder;
		this.TProduct = TProduct;
		this.num = num;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}