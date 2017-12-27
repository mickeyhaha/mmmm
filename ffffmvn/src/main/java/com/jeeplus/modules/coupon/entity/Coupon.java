/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.coupon.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 优惠券Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Coupon extends DataEntity<Coupon> {
	
	private static final long serialVersionUID = 1L;
	private Integer type;		// 优惠券类型: 代金券，满减，满赠
	private String name;		// 优惠券名称
	private Double discountAmount;		// 优惠金额
	private Integer totalCount;		// 优惠券总数
	private Integer leftCount;		// 优惠券剩余数量
	private Double orderAmount;		// 订单金额需满。0表示任意金额
	private String vmIds;		// 设备ids，逗号分隔
	private Integer deliverPerDay;		// 每日分发数
	private Integer recvPerUser;		// 每用户限制领取数量
	private Integer customerType;		// 能领取的客户类型
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	private Integer expireDay;		// 有效天数
	private Double userOrderAmount;		// 消费满多少可用,0表示无门槛
	private String userVmIds;		// 可用券设备
	
	public Coupon() {
		super();
	}

	public Coupon(String id){
		super(id);
	}

	@ExcelField(title="优惠券类型: 代金券，满减，满赠", align=2, sort=7)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	@ExcelField(title="优惠券名称", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="优惠金额", align=2, sort=9)
	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	@ExcelField(title="优惠券总数", align=2, sort=10)
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	@ExcelField(title="优惠券剩余数量", align=2, sort=11)
	public Integer getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(Integer leftCount) {
		this.leftCount = leftCount;
	}
	
	@ExcelField(title="订单金额需满。0表示任意金额", align=2, sort=12)
	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	@ExcelField(title="设备ids，逗号分隔", align=2, sort=13)
	public String getVmIds() {
		return vmIds;
	}

	public void setVmIds(String vmIds) {
		this.vmIds = vmIds;
	}
	
	@ExcelField(title="每日分发数", align=2, sort=14)
	public Integer getDeliverPerDay() {
		return deliverPerDay;
	}

	public void setDeliverPerDay(Integer deliverPerDay) {
		this.deliverPerDay = deliverPerDay;
	}
	
	@ExcelField(title="每用户限制领取数量", align=2, sort=15)
	public Integer getRecvPerUser() {
		return recvPerUser;
	}

	public void setRecvPerUser(Integer recvPerUser) {
		this.recvPerUser = recvPerUser;
	}
	
	@ExcelField(title="能领取的客户类型", align=2, sort=16)
	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="开始时间", align=2, sort=17)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="结束时间", align=2, sort=18)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@ExcelField(title="有效天数", align=2, sort=19)
	public Integer getExpireDay() {
		return expireDay;
	}

	public void setExpireDay(Integer expireDay) {
		this.expireDay = expireDay;
	}
	
	@ExcelField(title="消费满多少可用,0表示无门槛", align=2, sort=20)
	public Double getUserOrderAmount() {
		return userOrderAmount;
	}

	public void setUserOrderAmount(Double userOrderAmount) {
		this.userOrderAmount = userOrderAmount;
	}
	
	@ExcelField(title="可用券设备", align=2, sort=21)
	public String getUserVmIds() {
		return userVmIds;
	}

	public void setUserVmIds(String userVmIds) {
		this.userVmIds = userVmIds;
	}
	
}