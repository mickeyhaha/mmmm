/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmlog.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 售货机日志Entity
 * @author Jason Dong
 * @version 2017-12-18
 */
public class VMLog extends DataEntity<VMLog> {
	
	private static final long serialVersionUID = 1L;
	private String vmId;		// 售货机id
	private String vmName;		// 售货机名称
	private String mobile;		// 手机号码
	private String type;		// 日志类型（购物开门，补货开门）
	private String openTime;		// 开门时间
	private String closeTime;		// 关门时间
	
	public VMLog() {
		super();
	}

	public VMLog(String id){
		super(id);
	}

	@ExcelField(title="售货机id", align=2, sort=7)
	public String getVmId() {
		return vmId;
	}

	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
	
	@ExcelField(title="售货机名称", align=2, sort=8)
	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	
	@ExcelField(title="手机号码", align=2, sort=9)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@ExcelField(title="日志类型（购物开门，补货开门）", align=2, sort=10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="开门时间", align=2, sort=11)
	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
	@ExcelField(title="关门时间", align=2, sort=12)
	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
}