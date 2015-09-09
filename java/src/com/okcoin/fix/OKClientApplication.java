package com.okcoin.fix;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.StringField;
import quickfix.UnsupportedMessageType;

/**
 * 客户端请求实现
 * 
 * @author OKCOIN
 */
public class OKClientApplication implements quickfix.Application {

	private static final Logger log = Logger
			.getLogger(OKClientApplication.class);

	public void onMessage(Message message, SessionID sessionID)
			throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
		System.out.println("-----------onMessage-----------");
	}

	public void fromAdmin(quickfix.Message msg, SessionID sessionID)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			RejectLogon {
		System.out.println("receivedType:" + msg.getHeader().getString(35));
		if ("0".equals(msg.getHeader().getString(35))) {
			System.out.println(sessionID
					+ "------client fromAdmin----收到一个心跳消息 ----"
					+ msg.toString());
		} else
			System.out.println(sessionID
					+ "------client fromAdmin----收到一个认证消息 ----"
					+ msg.toString());
	}

	public void fromApp(quickfix.Message msg, SessionID sessionID)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			UnsupportedMessageType {
		System.out.println("receivedType:" + msg.getHeader().getString(35));
		System.out.println(sessionID + "------client fromApp-----消息接收----"
				+ new Date().toLocaleString() + "  " + msg.toString());
	}

	public void onCreate(SessionID sessionID) {
		System.out.println(sessionID + "------client onCreate 创建Session-------"
				+ sessionID);
	}

	public void onLogon(final SessionID sessionID) {

		// 请求深度
		Session session = Session.lookupSession(sessionID);
		Message message = OKMarketDataRequest.createOrderBookRequest();

		// 请求行情
		// message = OKMarketDataRequest.create24HTickerRequest();

		// 用户数据请求
		// message = OKTradingRequest.createUserAccountRequest();

		// 创建新订单
		// try {
		// message = OKTradingRequest.createOrderBookRequest();
		// } catch (IOException e) {}

		// 取消订单请求
		// message = OKTradingRequest.createOrderCancelRequest();

		// 订单状态请求
		// message = OKTradingRequest.createOrderStatusRequest();
		session.send(message);

	}

	public void onLogout(SessionID sessionID) {
		System.out.println(sessionID + "------client onLogout 退出-------"
				+ sessionID);
		// System.exit(0);
	}

	public void toAdmin(quickfix.Message msg, SessionID sessionID) {
		// msg.setField(new StringField(553, MessageValidation.PARTNER));
		msg.setField(new StringField(553, AccountUtil.apiKey));
		msg.setField(new StringField(554, AccountUtil.sercretKey));

	}

	public void toApp(quickfix.Message msg, SessionID sessionID)
			throws DoNotSend {
		System.out.println(sessionID + "------client toApp-------业务逻辑----"
				+ msg.toString());

	}

}
