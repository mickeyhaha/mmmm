/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.campaign.entity;

import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 促销Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Campaign extends DataEntity<Campaign> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 活动名称
	private String startTime;		// 开始时间
	private String endTime;		// 结束时间
	private Integer type;		// 活动类型：满减，随机减，首单优惠
	private String discount;		// 减免细节，以json格式存储。 满减：10-2,20-5,30-7 随机减：1-10 首单优惠：5
	private VendingMachine vendingMachine;		// 活动参与售货机Id，逗号分隔，0表示所有售货机
	private String campaignNo;		// 活动编号
	private Integer state;		// 活动状态: 开启，结束
	private User user;		// 操作员id (User.id)
	
	public Campaign() {
		super();
	}

	public Campaign(String id){
		super(id);
	}

	@ExcelField(title="活动名称", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="开始时间", align=2, sort=8)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@ExcelField(title="结束时间", align=2, sort=9)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@ExcelField(title="活动类型：满减，随机减，首单优惠", align=2, sort=10)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	@ExcelField(title="减免细节，以json格式存储。 满减：10-2,20-5,30-7 随机减：1-10 首单优惠：5", align=2, sort=11)
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	@ExcelField(title="活动参与售货机Id，逗号分隔，0表示所有售货机", align=2, sort=12)
	public VendingMachine getVendingMachine() {
		return vendingMachine;
	}

	public void setVendingMachine(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	
	@ExcelField(title="活动编号", align=2, sort=13)
	public String getCampaignNo() {
		return campaignNo;
	}

	public void setCampaignNo(String campaignNo) {
		this.campaignNo = campaignNo;
	}
	
	@ExcelField(title="活动状态: 开启，结束", align=2, sort=14)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@ExcelField(title="操作员id (User.id)", align=2, sort=15)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}