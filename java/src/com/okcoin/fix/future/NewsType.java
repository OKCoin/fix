package com.okcoin.fix.future;

import quickfix.StringField;

/**
 * @ClassName: PositionRealProfit
 * @Description: 用户订阅的消息类型
 * @date 2016-1-29 下午2:40:34
 * 
 */
public class NewsType extends StringField {

	private static final long serialVersionUID = -1;

	private static final int TAG = 8216;// 标志位

	public static final String USER_ACCOUNT = "A";// 订阅用户账户信息
	public static final String USER_ORDER_VIEW = "O";// 订阅用户订单信息
	public static final String USER_POSITION = "P"; // 订阅用户持仓
	public static final String CANCEL_USER_ACCOUNT = "CA";// 取消订阅用户账户信息
	public static final String CANCEL_USER_ORDER_VIEW = "CO";// 取消订阅用户订单信息
	public static final String CANCEL_USER_POSITION = "CP"; // 取消订阅用户持仓
	public NewsType() {
		super(TAG);
	}

	public NewsType(String data) {
		super(TAG, data);
	}

	public static int getFieldTag() {
		return TAG;
	}
}
