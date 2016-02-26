package com.okcoin.fix.future;


import quickfix.IntField;

/**
* @ClassName: PageNO
* @Description: 分页查询的表示页码
* @author OKCOIN
* @date 2016-2-24 下午4:26:50
*
 */
public class PageNO extends IntField {

	private static final long serialVersionUID = 1L;

	private static final int TAG = 8214;// 标志位

	public PageNO() {
		super(TAG);
	}

	public PageNO(int data) {
		super(TAG, data);
	}

	public static int getFieldTag() {
		return TAG;
	}

}
