/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.batch.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Date produceDate;		// 生产日期
	
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="生产日期", align=2, sort=8)
	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}
	
}