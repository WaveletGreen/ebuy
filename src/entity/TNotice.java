package entity;

import java.sql.Timestamp;

/**
 * TNotice entity. @author MyEclipse Persistence Tools
 */

public class TNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private Timestamp createTime;
	private String title;

	// Constructors

	/** default constructor */
	public TNotice() {
	}

	/** full constructor */
	public TNotice(String content, Timestamp createTime, String title) {
		this.content = content;
		this.createTime = createTime;
		this.title = title;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}