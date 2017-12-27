package com.holo.enums;

/**
 * 售货机状态: 在线，离线，故障
 * @author jason.dong
 *
 */
public enum VmState {
	ONLINE 		(0, "在线"),
	OFFLINE 	(1, "离线"),
	ERROR		(2, "故障");
	
	
	int id;
	String state;
	
	VmState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}
	
	public int getId() {
		return id;
	}
}
