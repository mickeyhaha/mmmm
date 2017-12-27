package com.holo.enums;

/**
 * 促销活动类型
 * @author jason.dong
 *
 */
public enum CampaignType {
	FULL_CUT			(0, "满减"),  
	RANDOM_CUT			(1, "随机减"),  
	FIRST_ORDER			(2, "收单优惠");  
	
	int id;
	String type;
	
	CampaignType(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}

}
