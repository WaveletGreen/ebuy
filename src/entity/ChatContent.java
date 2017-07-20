package entity;

/**
 * ChatContent entity. @author MyEclipse Persistence Tools
 */

public class ChatContent implements java.io.Serializable {

	// Fields

	private Integer chatContentId;
	private String chatContents;

	// Constructors

	/** default constructor */
	public ChatContent() {
	}

	/** full constructor */
	public ChatContent(Integer chatContentId, String chatContents) {
		this.chatContentId = chatContentId;
		this.chatContents = chatContents;
	}

	// Property accessors

	public Integer getChatContentId() {
		return this.chatContentId;
	}

	public void setChatContentId(Integer chatContentId) {
		this.chatContentId = chatContentId;
	}

	public String getChatContents() {
		return this.chatContents;
	}

	public void setChatContents(String chatContents) {
		this.chatContents = chatContents;
	}

}