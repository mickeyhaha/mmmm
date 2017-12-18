/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.product.entity;

import com.jeeplus.modules.batch.entity.Batch;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 产品列表Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Product extends DataEntity<Product> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 货物名称
	private String productNo;		// 货物编号
	private String barCode;		// 条形码
	private Batch batch;		// 批次id
	private String specification;		// 规格
	private String packingUnit;		// 包装单位
	private String costPrice;		// 成本价
	private String description;		// 商品描述
	private String salePrice;		// 销售价
	private Date expireDate;		// 保质期
	private Integer type;		// 货物类别
	private Date createTime;		// 创建时间
	
	public Product() {
		super();
	}

	public Product(String id){
		super(id);
	}

	@ExcelField(title="货物名称", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="货物编号", align=2, sort=8)
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
	@ExcelField(title="条形码", align=2, sort=9)
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	@ExcelField(title="批次id", align=2, sort=10)
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	@ExcelField(title="规格", align=2, sort=11)
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@ExcelField(title="包装单位", align=2, sort=12)
	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	
	@ExcelField(title="成本价", align=2, sort=13)
	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	
	@ExcelField(title="商品描述", align=2, sort=14)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ExcelField(title="销售价", align=2, sort=15)
	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="保质期", align=2, sort=16)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	@ExcelField(title="货物类别", align=2, sort=17)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="创建时间", align=2, sort=18)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}