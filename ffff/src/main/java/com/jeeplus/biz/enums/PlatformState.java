package com.jeeplus.biz.enums;

/**
 * 平台商状态
 * @author jason.dong
 */
public enum PlatformState {
	STARTED (0, "启用"),
	STOPED 	(1, "停用");
	
	int id;
	String state;
	
	PlatformState(int id, String state) {
		this.id = id;
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}
