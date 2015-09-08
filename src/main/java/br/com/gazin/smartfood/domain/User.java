package br.com.gazin.smartfood.domain;

import java.util.Date;

/**
 * @author luangazin
 *
 */
public class User {
	private Long id;
	private String username;
	private String password;
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String toString() {
		return "Id: " + this.id + " | Username: " + this.username + " | Password: " + this.password;
	}

}
