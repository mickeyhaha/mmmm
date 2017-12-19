package com.jeeplus.biz.enums;

/**
 * 退款审核状态
 * @author jason.dong
 *
 */
public enum RefundState {
	SUBMITED		(0, "待审核"),		// 待审核：退款订单未处理状态； 
	APPROVED		(1, "审核通过"),	// 审核通过：退款订单已通过审核，可进行下一步退款确认 
	DECLINED		(2, "审核未通过");	// 审核未通过 
	
	int id;
	String state;
	
	RefundState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
