/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.refund.entity;

import com.jeeplus.modules.customer.entity.Customer;
import com.jeeplus.modules.order.entity.Order;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 退款Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Refund extends DataEntity<Refund> {
	
	private static final long serialVersionUID = 1L;
	private String refundNo;		// 退款编号
	private Customer customer;		// 客户编号
	private Order order;		// 订单编号
	private Double orderAmount;		// 订单金额
	private Double applyAmount;		// 申请退款金额
	private Double refundAmount;		// 实际退款金额
	private String reason;		// 退款原因
	private String attachment;		// 图片说明
	private Integer state;		// 退款状态
	private Date applyTime;		// 申请时间
	
	public Refund() {
		super();
	}

	public Refund(String id){
		super(id);
	}

	@ExcelField(title="退款编号", align=2, sort=7)
	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	
	@ExcelField(title="客户编号", align=2, sort=8)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ExcelField(title="订单编号", align=2, sort=9)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	@ExcelField(title="订单金额", align=2, sort=10)
	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	@ExcelField(title="申请退款金额", align=2, sort=11)
	public Double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Double applyAmount) {
		this.applyAmount = applyAmount;
	}
	
	@ExcelField(title="实际退款金额", align=2, sort=12)
	public Double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	@ExcelField(title="退款原因", align=2, sort=13)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@ExcelField(title="图片说明", align=2, sort=14)
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	@ExcelField(title="退款状态", align=2, sort=15)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="申请时间", align=2, sort=16)
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
}