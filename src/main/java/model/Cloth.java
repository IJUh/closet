package model;

import org.springframework.stereotype.Component;

@Component
public class Cloth {
	private String itemNo;		//ǰ��
	private String companyNo;	//ȸ���ȣ
	private String comItemNo;	//ȸ����üǰ��
	private long price;			//����
	private String category;	//�з�
	private String clothName;	//����ǰ��
	
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
