package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;
import entity.TNews;
import entity.TNotice;
import entity.TProduct;
import impl.ProductDaoImpl;

@SuppressWarnings("unchecked")
public class ViewerCommon extends ActionSupport {
	private static final long serialVersionUID = -1748415403701909737L;
	@SuppressWarnings("rawtypes")
	private ProductDao dao = new ProductDaoImpl();
	public TProduct product;
	private String type;
	private int id;
	private TNews news;
	private TNotice notices;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TProduct getProduct() {
		return product;
	}

	public void setProduct(TProduct product) {
		this.product = product;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 浏览信息，不一定是商品，也可以是新闻，动态等
	 * 
	 * @return
	 */
	public String view() {
		SimpleFactory();
		return SUCCESS;
	}

	/**
	 * 简单工厂生产对应的对象，因为目前无法根据名字强制转换为对象，因此先用简单工厂
	 * 
	 * 如 product = (type) dao.getById(type, product.getId());
	 */
	private void SimpleFactory() {
		switch (type) {
		case "TProduct":
			product = (TProduct) dao.getById(type, product.getId());
			break;
		case "TNews":
			news = (TNews) dao.getById(type, news.getId());
			break;
		case "TNotice":
			notices = (TNotice) dao.getById(type, notices.getId());
			break;
		}
	}
}
