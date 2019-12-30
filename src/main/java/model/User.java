package model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component
//@Alias("User")
public class User {
	private String userId;		//회원번호
	private String loginStatus;	//로그인상태
	private String password;	//비밀번호
	private String deleted;	//삭제여부
	private String phone;	//전화번호
	private String userName;//이름
	private Timestamp rgstDate;	//등록일
	
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
