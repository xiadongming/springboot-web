package com.example.demo.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("amount_change")
public class AmountChange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableField(exist = true)
	private Integer id;
	@TableField(exist = true)
	private String userId;
	@TableField(exist = true)
	private String userName;
	@TableField(exist = true)
	private String amountNum;
	@TableField(exist = true)
	private String telNum;
	@TableField(exist = true)
	private String isDel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAmountNum() {
		return amountNum;
	}

	public void setAmountNum(String amountNum) {
		this.amountNum = amountNum;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "AmountChange [id=" + id + ", userId=" + userId + ", userName=" + userName + ", amountNum=" + amountNum
				+ ", telNum=" + telNum + ", isDel=" + isDel + "]";
	}

}
