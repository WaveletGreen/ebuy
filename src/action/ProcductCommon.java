package action;

import java.util.List;

import impl.ProductDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;
import entity.Page;
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
	private Page page;
	// 用于计算查询所有记录的最大记录数，方便分页查询
	private int maxResult;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

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

	public String viewByPage() {
		int maxPage = 0;
		SimpleFactory();
		maxPage = maxResult % page.getMaxResult() == 0 ? maxResult / page.getMaxResult()
				: maxResult / page.getMaxResult() + 1;
		// 在这里设置page的属性是为了方便在页面上控制分页查询
		page.autoSetter(page.getPageIndex(), maxPage);
		SimpleFactoryByPage(type, page.getPageIndex(), page.getMaxResult());
		return SUCCESS;
	}

	/**
	 * 根据查询页数进行分页查询
	 * 
	 * @param type2
	 *            需要查询的类型，如TProduct、TNews、TNotice
	 * @param pageIndex
	 *            查询页数的起始
	 * @param maxResult2
	 *            每页显示最大记录数
	 */
	private void SimpleFactoryByPage(String type2, int pageIndex, int maxResult2) {
		switch (type) {
		case "TProduct":
			products = dao.getByPage("TProduct", pageIndex, maxResult2);
			maxResult = products.size();
			break;
		case "TNews":
			news = dao.getByPage("TNews", pageIndex, maxResult2);
			maxResult = news.size();
			break;
		case "TNotice":
			notices = dao.getByPage("TNotice", pageIndex, maxResult2);
			maxResult = notices.size();
			break;
		}
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
			maxResult = products.size();
			break;
		case "TNews":
			news = dao.findAllItem("TNews");
			maxResult = news.size();
			break;
		case "TNotice":
			notices = dao.findAllItem("TNotice");
			maxResult = notices.size();
			break;
		}
	}

}
