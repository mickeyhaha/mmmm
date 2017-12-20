package com.holo.enums;

/**
 * 运营商状态: 启用，停用
 * @author jason.dong
 *
 */
public enum OperatorState {
	STARTED (0, "启用"),
	STOPED 	(1, "停用");
	
	int id;
	String state;
	
	OperatorState(int id, String state) {
		this.id = id;
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}
