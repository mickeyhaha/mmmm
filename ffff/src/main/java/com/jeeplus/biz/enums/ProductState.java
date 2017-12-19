package com.jeeplus.biz.enums;

/**
 * 出库单状态
 * @author jason.dong
 *
 */
public enum ProductState {
	UN_PUBLISHED	(0, "待发布"),		// 出库单创建后的初始状态，可进行发布或撤销操作； 
	PUBLISHED		(1, "已发布"),		// 出库单处于有效进行状态(发布后通知补货员补货)
	CANCELLED		(2, "已取消");		// 出库单处于无效状态
	
	int id;
	String state;
	
	ProductState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
