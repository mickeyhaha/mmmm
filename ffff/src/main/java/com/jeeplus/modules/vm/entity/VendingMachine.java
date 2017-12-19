/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vm.entity;

import com.jeeplus.modules.vmgroup.entity.VmGroup;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 售货机管理Entity
 * @author Jason Dong
 * @version 2017-12-19
 */
public class VendingMachine extends DataEntity<VendingMachine> {
	
	private static final long serialVersionUID = 1L;
	private String vmNo;		// 售货机编号
	private String name;		// 售货机名称
	private String type;		// 售货机型号
	private String readerNo;		// RFID读写器序列号
	private String province;		// 投放省
	private String city;		// 投放城市
	private String area;		// 投放地区
	private String address;		// 投放详细地址
	private String platformState;		// 平台商状态
	private String supplierState;		// 运营商状态
	private String vmState;		// 售货机状态(在线，离线，停用)
	private String createTime;		// 创建时间
	private String barCode;		// 二维码
	private String standardStock;		// 标准库存
	private VmGroup vmGroup;		// 分组编号
	
	public VendingMachine() {
		super();
	}

	public VendingMachine(String id){
		super(id);
	}

	@ExcelField(title="售货机编号", align=2, sort=7)
	public String getVmNo() {
		return vmNo;
	}

	public void setVmNo(String vmNo) {
		this.vmNo = vmNo;
	}
	
	@ExcelField(title="售货机名称", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="售货机型号", align=2, sort=9)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="RFID读写器序列号", align=2, sort=10)
	public String getReaderNo() {
		return readerNo;
	}

	public void setReaderNo(String readerNo) {
		this.readerNo = readerNo;
	}
	
	@ExcelField(title="投放省", align=2, sort=11)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@ExcelField(title="投放城市", align=2, sort=12)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@ExcelField(title="投放地区", align=2, sort=13)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@ExcelField(title="投放详细地址", align=2, sort=14)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@ExcelField(title="平台商状态", align=2, sort=15)
	public String getPlatformState() {
		return platformState;
	}

	public void setPlatformState(String platformState) {
		this.platformState = platformState;
	}
	
	@ExcelField(title="运营商状态", align=2, sort=16)
	public String getSupplierState() {
		return supplierState;
	}

	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}
	
	@ExcelField(title="售货机状态(在线，离线，停用)", align=2, sort=17)
	public String getVmState() {
		return vmState;
	}

	public void setVmState(String vmState) {
		this.vmState = vmState;
	}
	
	@ExcelField(title="创建时间", align=2, sort=18)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@ExcelField(title="二维码", align=2, sort=19)
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	@ExcelField(title="标准库存", align=2, sort=20)
	public String getStandardStock() {
		return standardStock;
	}

	public void setStandardStock(String standardStock) {
		this.standardStock = standardStock;
	}
	
	@ExcelField(title="分组编号", align=2, sort=21)
	public VmGroup getVmGroup() {
		return vmGroup;
	}

	public void setVmGroup(VmGroup vmGroup) {
		this.vmGroup = vmGroup;
	}
	
}