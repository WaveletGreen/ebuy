package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private Timestamp birthday;
	private String dentityCode;
	private String email;
	private String mobile;
	private String password;
	private String sex;
	private Integer status;
	private String trueName;
	private String username;
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer status) {
		this.status = status;
	}

	/** full constructor */
	public TUser(String address, Timestamp birthday, String dentityCode,
			String email, String mobile, String password, String sex,
			Integer status, String trueName, String username, Set TOrders) {
		this.address = address;
		this.birthday = birthday;
		this.dentityCode = dentityCode;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.sex = sex;
		this.status = status;
		this.trueName = trueName;
		this.username = username;
		this.TOrders = TOrders;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getDentityCode() {
		return this.dentityCode;
	}

	public void setDentityCode(String dentityCode) {
		this.dentityCode = dentityCode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

}