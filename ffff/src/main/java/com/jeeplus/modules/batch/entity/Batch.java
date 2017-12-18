/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.batch.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 批次管理Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class Batch extends DataEntity<Batch> {
	
	private static final long serialVersionUID = 1L;
	private String batchNo;		// 批次号
	
	public Batch() {
		super();
	}

	public Batch(String id){
		super(id);
	}

	@ExcelField(title="批次号", align=2, sort=1)
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
}