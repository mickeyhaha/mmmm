/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.customer.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.modules.vmgroup.entity.VmGroup;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 客户管理Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Customer extends DataEntity<Customer> {
	
	private static final long serialVersionUID = 1L;
	private String customerNo;		// 客户编号
	private String mobile;		// 手机号码
	private String type;		// 客户类型：普通会员，VIP会员
	private String name;		// 客户姓名
	private String shortName;		// 客户简称
	private String email;		// 电子邮箱
	private String fax;		// 传真号码
	private String address;		// 地址
	private String alipay;		// 是否开通alipay
	private String wechatPay;		// 是否开通微信支付
	private String lastOrderState;		// 上次交易状态：完成，未完成
	private Date regTime;		// 注册时间
	private String state;		// 客户状态：启用，停用，黑名单
	private VmGroup vmGroup;		// 售货机编号
	
	public Customer() {
		super();
	}

	public Customer(String id){
		super(id);
	}

	@ExcelField(title="客户编号", align=2, sort=1)
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	@ExcelField(title="手机号码", align=2, sort=2)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@ExcelField(title="客户类型：普通会员，VIP会员", align=2, sort=3)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="客户姓名", align=2, sort=10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="客户简称", align=2, sort=11)
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@ExcelField(title="电子邮箱", align=2, sort=12)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ExcelField(title="传真号码", align=2, sort=13)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@ExcelField(title="地址", align=2, sort=14)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@ExcelField(title="是否开通alipay", align=2, sort=15)
	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	
	@ExcelField(title="是否开通微信支付", align=2, sort=16)
	public String getWechatPay() {
		return wechatPay;
	}

	public void setWechatPay(String wechatPay) {
		this.wechatPay = wechatPay;
	}
	
	@ExcelField(title="上次交易状态：完成，未完成", align=2, sort=17)
	public String getLastOrderState() {
		return lastOrderState;
	}

	public void setLastOrderState(String lastOrderState) {
		this.lastOrderState = lastOrderState;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="注册时间", align=2, sort=18)
	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
	@ExcelField(title="客户状态：启用，停用，黑名单", align=2, sort=19)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@ExcelField(title="售货机编号", align=2, sort=20)
	public VmGroup getVmGroup() {
		return vmGroup;
	}

	public void setVmGroup(VmGroup vmGroup) {
		this.vmGroup = vmGroup;
	}
	
}