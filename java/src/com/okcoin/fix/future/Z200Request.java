package com.okcoin.fix.future;

import quickfix.Message;
import quickfix.field.OrdStatus;
import quickfix.field.OrderID;
import quickfix.field.SecurityType;
import quickfix.field.StrikeCurrency;
import quickfix.field.Symbol;
import quickfix.field.TradeRequestID;
import quickfix.field.TradeRequestType;


/**
 * @ClassName: OrdersRequest
 * @Description: 获取指定userid 指定 订单ID 之后的10 条数据
 * @author OKCOIN
 * @date 2015-5-19 上午11:19:34
 * 
 */
public class Z200Request extends Message {

	private static final long serialVersionUID = 7922839466982400795L;
	public static final String MSGTYPE = "Z2000";

	public Z200Request() {
		getHeader().setField(new quickfix.field.MsgType("Z2000"));
	}

	public void set(Symbol field) { // 55
		setField(field);
	}

	public void set(OrderID field) { // 37
		setField(field);
	}

	public void set(OrdStatus field) { // 39
		setField(field);
	}

	public void set(TradeRequestID field) { // 568
		setField(field);
	}

	public void set(TradeRequestType field) { // 569
		setField(field);
	}
	
	public void set(PageNO field) { // 8214 页码
		setField(field);
	}
	
	public void set(StrikeCurrency field) { // 947
		setField(field);
	}
	public void set(SecurityType field) { // 167
		setField(field);
	}
	
}
