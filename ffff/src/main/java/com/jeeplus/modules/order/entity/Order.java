/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.order.entity;

import com.jeeplus.modules.customer.entity.Customer;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.modules.vm.entity.VendingMachine;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 订单管理Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Order extends DataEntity<Order> {
	
	private static final long serialVersionUID = 1L;
	private String orderNo;		// 订单编号
	private String outOrderNo;		// 外部订单编号
	private String type;		// 订单类型  1:原材料采购, 2 :产品销售
	private String state;		// 订单状态:  支付成功 ，支付失败，异常待处理，异常已处理，异常忽略
	private Customer customer;		// 下订单用户
	private Date purchaseTime;		// 交易时间
	private String source;		// 订单来源：支付宝，微信
	private VendingMachine vendingMachine;		// 售货机id
	private String reader_no;		// 读写器序列号
	private Double originTotalPrice;		// 原总价
	private Double cut;		// 促销减免金额
	private Double voucher;		// 优惠券抵扣
	private Double payPrice;		// 实际支付
	private Double unitPrice;		// 单价
	private Double amount;		// 数量
	private Integer rfidState;		// RFID状态
	
	public Order() {
		super();
	}

	public Order(String id){
		super(id);
	}

	@ExcelField(title="订单编号", align=2, sort=7)
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	@ExcelField(title="外部订单编号", align=2, sort=8)
	public String getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	
	@ExcelField(title="订单类型  1:原材料采购, 2 :产品销售", align=2, sort=9)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="订单状态:  支付成功 ，支付失败，异常待处理，异常已处理，异常忽略", align=2, sort=10)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@ExcelField(title="下订单用户", align=2, sort=11)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="交易时间", align=2, sort=12)
	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	
	@ExcelField(title="订单来源：支付宝，微信", align=2, sort=13)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@ExcelField(title="售货机id", align=2, sort=14)
	public VendingMachine getVendingMachine() {
		return vendingMachine;
	}

	public void setVendingMachine(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	
	@ExcelField(title="读写器序列号", align=2, sort=15)
	public String getReader_no() {
		return reader_no;
	}

	public void setReader_no(String reader_no) {
		this.reader_no = reader_no;
	}
	
	@ExcelField(title="原总价", align=2, sort=16)
	public Double getOriginTotalPrice() {
		return originTotalPrice;
	}

	public void setOriginTotalPrice(Double originTotalPrice) {
		this.originTotalPrice = originTotalPrice;
	}
	
	@ExcelField(title="促销减免金额", align=2, sort=17)
	public Double getCut() {
		return cut;
	}

	public void setCut(Double cut) {
		this.cut = cut;
	}
	
	@ExcelField(title="优惠券抵扣", align=2, sort=18)
	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}
	
	@ExcelField(title="实际支付", align=2, sort=19)
	public Double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(Double payPrice) {
		this.payPrice = payPrice;
	}
	
	@ExcelField(title="单价", align=2, sort=20)
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@ExcelField(title="数量", align=2, sort=21)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@ExcelField(title="RFID状态", align=2, sort=22)
	public Integer getRfidState() {
		return rfidState;
	}

	public void setRfidState(Integer rfidState) {
		this.rfidState = rfidState;
	}
	
}