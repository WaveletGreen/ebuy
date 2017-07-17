package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;
import entity.Page;
import entity.TProduct;
import impl.ProductDaoImpl;

/**
 * 根据商品的类别(tags)选取商品列表，应该重新到一个页面中而不是product-list.jap
 * 
 * @author Administrator
 * 
 */
public class ProductFromTags extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3713490376578251511L;
	// 明确是查询TProduct
	private ProductDao<TProduct> dao = new ProductDaoImpl<TProduct>();
	private TProduct product;
	private List<TProduct> products;
	private Page page;
	private int maxResult;

	public List<TProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TProduct> products) {
		this.products = products;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public TProduct getProduct() {
		return product;
	}

	public void setProduct(TProduct product) {
		this.product = product;
	}

	public String getByTags() {
		System.out.println(this.product.getTBigtype().getId());
		products = dao.getByTags(this.product, page.getPageIndex(),
				page.getMaxResult());
		maxResult = products.size();
		System.out.println("-----------" + maxResult);
		int maxPage = maxResult % page.getMaxResult() == 0 ? maxResult
				/ page.getMaxResult() : maxResult / page.getMaxResult() + 1;
		// 在这里设置page的属性是为了方便在页面上控制分页查询
		page.autoSetter(page.getPageIndex(), maxPage);
		return SUCCESS;
	}

}
