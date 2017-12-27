package com.holo.enums;

/**
 * 客户状态
 * @author jason.dong
 *
 */
public enum CustomerState {
	NORMAL			(0, "正常"),
	BLACKLIST 		(1, "黑名单");
	
	int id;
	String state;
	
	CustomerState(int id, String state) {
		this.id = id;
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}
