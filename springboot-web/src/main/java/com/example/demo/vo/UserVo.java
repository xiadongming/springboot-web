package com.example.demo.vo;

public class UserVo {
	
	
	
	private String userName;
	
	private String phoneNum;
	
	private String pwd;
	
	private Boolean isDel;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", phoneNum=" + phoneNum + ", pwd=" + pwd + ", isDel=" + isDel + "]";
	}

}
