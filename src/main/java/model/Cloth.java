package model;

import org.springframework.stereotype.Component;

@Component
public class Cloth {
	private String itemNo;		//품번
	private String companyNo;	//회사번호
	private String comItemNo;	//회사자체품번
	private long price;			//가격
	private String category;	//분류
	private String clothName;	//옷제품명
	
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getComItemNo() {
		return comItemNo;
	}
	public void setComItemNo(String comItemNo) {
		this.comItemNo = comItemNo;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getClothName() {
		return clothName;
	}
	public void setClothName(String clothName) {
		this.clothName = clothName;
	}
}
