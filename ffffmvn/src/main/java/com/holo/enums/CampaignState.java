package com.holo.enums;

/**
 * 促销活动状态
 * @author jason.dong
 *
 */
public enum CampaignState {
	DRAFT			(0, "草稿"),		// 草稿：促销活劢未生效，可进行编辑以及开启；  
	STARTED			(1, "已开启"),		// 开启：促销活劢处于开启状态且丌可编辑，可停止该促销活劢；  
	STOPED			(2, "已关闭");		// 关闭：促销活劢处于关闭状态，无法对其编辑以及开启  
	
	int id;
	String state;
	
	CampaignState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
