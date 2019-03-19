package com.neo.a_field.bean.business;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Account {

	@JSONField
	private Integer accountID;
	@JSONField
	private String accountName;
	@JSONField
	private String password;
	@JSONField
	private String nickName;
	@JSONField
	private Integer sex;
	@JSONField
	private String email;
	@JSONField
	private String mobile;
	@JSONField
	private Date registDate;
	@JSONField
	private Long lastActiveTime;
	@JSONField
	private Integer accountStatus;

	
	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Long getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(Long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + accountName + ", password=" + password
				+ ", nickName=" + nickName + ", sex=" + sex + ", email=" + email + ", mobile=" + mobile
				+ ", registDate=" + registDate + ", lastActiveTime=" + lastActiveTime + ", accountStatus="
				+ accountStatus + "]";
	}

	
}
