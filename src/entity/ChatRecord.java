package entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 聊天记录的对象，后续将该对象序列化成JSON对象加入到数据库记录中
 * 
 * @author Administrator
 *
 */
public class ChatRecord implements Serializable {
	private String talker;// 发言人
	private Timestamp createTime;// 发言时间
	private String content;// 发言内容

	public ChatRecord() {
	}

	public ChatRecord(String talker, Timestamp createTime, String content) {
		super();
		this.talker = talker;
		this.createTime = createTime;
		this.content = content;
	}

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
