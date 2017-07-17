package action;

import impl.ProductDaoImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;

import entity.Page;
import entity.TComment;

/**
 * 评论Action处理方法
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
public class CommentCommon extends ActionSupport {
	private static final long serialVersionUID = -3080157913290045286L;
	ProductDao dao = new ProductDaoImpl();
	private List<TComment> comments;
	private TComment comment;
	private Page page;
	private int maxResult;

	public TComment getComment() {
		return comment;
	}

	public void setComment(TComment comment) {
		this.comment = comment;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<TComment> getComments() {
		return comments;
	}

	public void setComments(List<TComment> comments) {
		this.comments = comments;
	}

	@SuppressWarnings("unchecked")
	public String getUserComment() {
		maxResult = dao.findAllItem("TComment").size();
		comments = dao.getByPage("TComment", page.getPageIndex(),
				page.getMaxResult());
		page.autoSetter(
				page.getPageIndex(),
				maxResult % page.getMaxResult() == 0 ? maxResult
						/ page.getMaxResult() : maxResult / page.getMaxResult()
						+ 1);
		return SUCCESS;
	}

	public String publishComment() {
		comment.setCreateTime(new Timestamp(new Date().getTime()));
		String result = (String) dao.save(comment);
		getUserComment();
		return result;
	}
}
