package model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component
//@Alias("User")
public class User {
	private String userId;		//ȸ����ȣ
	private String loginStatus;	//�α��λ���
	private String password;	//��й�ȣ
	private String deleted;	//��������
	private String phone;	//��ȭ��ȣ
	private String userName;//�̸�
	private Timestamp rgstDate;	//�����
	
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
