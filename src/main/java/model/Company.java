package model;

import org.springframework.stereotype.Component;

@Component
public class Company {
	private String companyNo;		//회사번호
	private String companyName;		//회사명
	private String address;			//주소
	
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
