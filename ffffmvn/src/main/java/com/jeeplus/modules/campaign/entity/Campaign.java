/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.campaign.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 促销Entity
 * @author Jason Dong
 * @version 2017-12-20
 */
public class Campaign extends DataEntity<Campaign> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 活动名称
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private String type;		// 活动类型：满减，随机减，首单优惠
	private String discount;		// 减免细节，以json格式存储。 满减：10-2,20-5,30-7 随机减：1-10 首单优惠：5
	private VendingMachine vendingMachine;		// 活动参与售货机Id，逗号分隔，0表示所有售货机
	private String campaignNo;		// 活动编号
	private String state;		// 活动状态: 开启，结束
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="开始时间", align=2, sort=8)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="结束时间", align=2, sort=9)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@ExcelField(title="活动类型：满减，随机减，首单优惠", align=2, sort=10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
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
	
	@ExcelField(title="活动状态: 开启，结束", dictType="CampaignState", align=2, sort=14)
	public String getState() {
		return state;
	}

	public void setState(String state) {
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