package model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class clothTrack {
	
	private String userId;	//ȸ����ȣ
	private String itemNo;	//ǰ��
	private String trackNo;	//�����ý��۵���Ϸù�ȣ
	private Timestamp rsgtDate;	//����Ͻ�
	private String deleted;	//��������
	private int priority;	//�켱����
	private int cycle;		//�ֱ�
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}
	public Timestamp getRsgtDate() {
		return rsgtDate;
	}
	public void setRsgtDate(Timestamp rsgtDate) {
		this.rsgtDate = rsgtDate;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

}
