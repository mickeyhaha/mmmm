/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmstock.entity;

import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.product.entity.Product;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 售货机库存Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class VmStock extends DataEntity<VmStock> {
	
	private static final long serialVersionUID = 1L;
	private VendingMachine vm;		// 售货机ID
	private Product product;		// 产品ID
	private Double stockAmount;		// 剩余库存
	
	public VmStock() {
		super();
	}

	public VmStock(String id){
		super(id);
	}

	@ExcelField(title="售货机ID", align=2, sort=7)
	public VendingMachine getVm() {
		return vm;
	}

	public void setVm(VendingMachine vm) {
		this.vm = vm;
	}
	
	@ExcelField(title="产品ID", align=2, sort=8)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ExcelField(title="剩余库存", align=2, sort=9)
	public Double getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(Double stockAmount) {
		this.stockAmount = stockAmount;
	}
	
}