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
 * @version 2017-12-12
 */
public class VendingMachine extends DataEntity<VendingMachine> {
	
	private static final long serialVersionUID = 1L;
	private String vmNo;		// 售货机编号
	private String name;		// 售货机名称
	private VmGroup vmGroupId;		// 分组id
	
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
	
	@ExcelField(title="分组id", align=2, sort=9)
	public VmGroup getVmGroupId() {
		return vmGroupId;
	}

	public void setVmGroupId(VmGroup vmGroupId) {
		this.vmGroupId = vmGroupId;
	}
	
}