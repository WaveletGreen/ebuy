package entity;

/**
 * TTag entity. @author MyEclipse Persistence Tools
 */

public class TTag implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String url;

	// Constructors

	/** default constructor */
	public TTag() {
	}

	/** full constructor */
	public TTag(String name, String url) {
		this.name = name;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}