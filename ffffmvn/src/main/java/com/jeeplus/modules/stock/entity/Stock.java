/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.stock.entity;

import com.jeeplus.modules.product.entity.Product;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 仓库库存Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Stock extends DataEntity<Stock> {
	
	private static final long serialVersionUID = 1L;
	private String goodsNo;		// 物品编号
	private String goodsName;		// 物品名称
	private Integer goodsType;		// 物品类型
	private String repositoryNo;		// 仓库编号
	private Double amount;		// 库存量
	private String packingUnit;		// 包装单位
	private Product product;		// 产品ID
	
	public Stock() {
		super();
	}

	public Stock(String id){
		super(id);
	}

	@ExcelField(title="物品编号", align=2, sort=7)
	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	
	@ExcelField(title="物品名称", align=2, sort=8)
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	@ExcelField(title="物品类型", align=2, sort=9)
	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	
	@ExcelField(title="仓库编号", align=2, sort=10)
	public String getRepositoryNo() {
		return repositoryNo;
	}

	public void setRepositoryNo(String repositoryNo) {
		this.repositoryNo = repositoryNo;
	}
	
	@ExcelField(title="库存量", align=2, sort=11)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@ExcelField(title="包装单位", align=2, sort=12)
	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	
	@ExcelField(title="产品ID", align=2, sort=13)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}