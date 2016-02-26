package com.okcoin.fix.future;

import quickfix.Message;
import quickfix.field.SecurityType;

/**
 * 
* @ClassName: FutureSubNews
* @Description: 订阅用户实时数据
* @author A18ccms a18ccms_gmail_com
* @date 2016-2-25 下午8:37:07
*
 */
public class FutureSubNews extends Message {

	private static final long serialVersionUID = 7922839466982400795L;
	public static final String MSGTYPE = "Z2001";
	
	
	public FutureSubNews() {
		getHeader().setField(new quickfix.field.MsgType("Z2001"));
	}

	public void set(NewsType field) {
		setField(field);
	}

	public void set(SecurityType field) {
		setField(field);
	}

}
