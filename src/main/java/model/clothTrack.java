package model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class clothTrack {
	
	private String userId;	//회원번호
	private String itemNo;	//품번
	private String trackNo;	//추적시스템등록일련번호
	private Timestamp rsgtDate;	//등록일시
	private String deleted;	//삭제여부
	private int priority;	//우선순위
	private int cycle;		//주기
	
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