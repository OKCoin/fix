package com.okcoin.fix;

import quickfix.Message;
import quickfix.field.Account;
/**
 * OKCOIN自定义
 * @author OKCOIN
 */
public class AccountInfoRequest extends Message{
	private static final long serialVersionUID = -5401256081212055457L;
	public static final String MSGTYPE = "Z1000";
	
	 public AccountInfoRequest()
	 {
	    getHeader().setField(new quickfix.field.MsgType("Z1000"));
	 }
	 
	 public void set(Account field){
		 setField(field);
	 }
	 
	 public void set(AccReqID field){
		 setField(field);
	 }
}
