package com.holo.enums;

/**
 * 售货机中产品状态： 正常可售，不可销售
 * @author jason.dong
 *
 */
public enum ProductOutState {
	SELLABLE 		(0, "正常"),
	SOLD			(1, "已售出"),
	EXPIRED			(2, "已过期"),
	EXPIRED_SOLD  	(3, "过期且售出"),
	UN_SELLABLE 	(4, "无效");
	
	
	int id;
	String state;
	
	ProductOutState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
