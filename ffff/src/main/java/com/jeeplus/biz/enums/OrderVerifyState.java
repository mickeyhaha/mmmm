package com.jeeplus.biz.enums;

/**
 * 订单审核状态
 * @author jason.dong
 *
 */
public enum OrderVerifyState {
	SUBMITED		(0, "待处理"),		// 待处理：订单生成且未经处理；  
	CHARGED			(1, "已处理"),		// 已处理：订单已手劢发起扣款； 
	IGNORE			(2, "已取消");		// 忽略：丌再对此订单发起扣费 
	
	int id;
	String state;
	
	OrderVerifyState(int id, String state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}

}
