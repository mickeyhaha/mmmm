/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.productput.entity;

import com.jeeplus.modules.product.entity.Product;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 补货单管理Entity
 * @author Jason Dong
 * @version 2017-12-20
 */
public class ProductPut extends DataEntity<ProductPut> {
	
	private static final long serialVersionUID = 1L;
	private Product product;		// 货物ID
	private Double productAmount;		// 货物数量
	private String repositoryNo;		// 仓库编号
	private Date inTime;		// 入库时间，用create_date
	private String state;		// 补货状态
	private VendingMachine vendingMachine;		// 售货机ID
	private User user;		// 补货员ID
	
	public ProductPut() {
		super();
	}

	public ProductPut(String id){
		super(id);
	}

	@ExcelField(title="货物ID", align=2, sort=7)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ExcelField(title="货物数量", align=2, sort=8)
	public Double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
	
	@ExcelField(title="仓库编号", align=2, sort=9)
	public String getRepositoryNo() {
		return repositoryNo;
	}

	public void setRepositoryNo(String repositoryNo) {
		this.repositoryNo = repositoryNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="入库时间，用create_date", align=2, sort=10)
	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	
	@ExcelField(title="补货状态", dictType="ProductPutState", align=2, sort=11)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@ExcelField(title="售货机ID", align=2, sort=12)
	public VendingMachine getVendingMachine() {
		return vendingMachine;
	}

	public void setVendingMachine(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	
	@ExcelField(title="补货员ID", align=2, sort=13)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}