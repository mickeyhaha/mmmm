package com.holo.enums;

/**
 * 补货单状态
 * @author jason.dong
 *
 */
public enum ProductPutState {
	VALID		(0, "有效"),		// 补货单有效 
	INVALID		(1, "无效");		// 补货单无效
	
	int id;
	String state;
	
	ProductPutState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
