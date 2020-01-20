package model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
//@Alias("User")
public class User {
	private String userId; 
	private String loginStatus;
	private String password;
	private String deleted; 
	private String email; 
	private String phone; 
	private String userName;
	private Timestamp rgstDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getRgstDate() {
		return rgstDate;
	}

	public void setRgstDate(Timestamp rgstDate) {
		this.rgstDate = rgstDate;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
