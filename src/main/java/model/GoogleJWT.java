package model;

import org.springframework.stereotype.Component;

@Component
public class GoogleJWT {
	private String iss;	 	//응답 결과를 발행한 대상-여기선 google auth
	private String azp;		//client_id
	private String aud;		//google api를 사용하는 앱의 사용자 그룹을 의미
	private String sub;		//사용자 식별자 
	private String at_hash;
	private String hd;
	private String email;	//email
	private String email_verifired;
	private String iat;
	private String exp;		//유효기간
	private String nonce;
	private String name;	//유저이름
	private String profile;	//유저 profile url
	
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getAzp() {
		return azp;
	}
	public void setAzp(String azp) {
		this.azp = azp;
	}
	public String getAud() {
		return aud;
	}
	public void setAud(String aud) {
		this.aud = aud;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getAt_hash() {
		return at_hash;
	}
	public void setAt_hash(String at_hash) {
		this.at_hash = at_hash;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verifired() {
		return email_verifired;
	}
	public void setEmail_verifired(String email_verifired) {
		this.email_verifired = email_verifired;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
