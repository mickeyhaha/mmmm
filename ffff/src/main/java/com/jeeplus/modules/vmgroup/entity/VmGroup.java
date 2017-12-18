/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmgroup.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 售货机分组Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class VmGroup extends DataEntity<VmGroup> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 分组名称
	
	public VmGroup() {
		super();
	}

	public VmGroup(String id){
		super(id);
	}

	@ExcelField(title="分组名称", align=2, sort=1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}