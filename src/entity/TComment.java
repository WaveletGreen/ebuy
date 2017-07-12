package entity;

import java.sql.Timestamp;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */

public class TComment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private Timestamp createTime;
	private String nickName;
	private String replyContent;
	private Timestamp replyTime;

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** full constructor */
	public TComment(String content, Timestamp createTime, String nickName,
			String replyContent, Timestamp replyTime) {
		this.content = content;
		this.createTime = createTime;
		this.nickName = nickName;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

}