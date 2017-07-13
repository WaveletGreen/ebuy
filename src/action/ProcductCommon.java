package action;

import java.util.List;

import impl.ProductDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;
import entity.TNews;
import entity.TNotice;
import entity.TProduct;

@SuppressWarnings({ "unchecked", "serial" })
public class ProcductCommon extends ActionSupport {
	@SuppressWarnings("rawtypes")
	private ProductDao dao = new ProductDaoImpl();

	private List<TNews> news;
	private List<TNotice> notices;
	private List<TProduct> products;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TNews> getNews() {
		return news;
	}

	public void setNews(List<TNews> news) {
		this.news = news;
	}

	public List<TNotice> getNotices() {
		return notices;
	}

	public void setNotices(List<TNotice> notices) {
		this.notices = notices;
	}

	public List<TProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TProduct> products) {
		this.products = products;
	}

	/**
	 * 初始化操作，动态添加数据到首页
	 * 
	 * @return
	 */
	public String init() {
		news = dao.findAllItem("TNews");
		notices = dao.findAllItem("TNotice");
		products = dao.findAllItem("TProduct");
		return SUCCESS;
	}

	public String viewAll() {
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
			products = dao.findAllItem("TProduct");
			break;
		case "TNews":
			news = dao.findAllItem("TNews");
			break;
		case "TNotice":
			notices = dao.findAllItem("TNotice");
			break;
		}
	}
}
