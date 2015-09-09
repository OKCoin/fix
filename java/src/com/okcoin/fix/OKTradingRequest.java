package com.okcoin.fix;

import java.io.IOException;
import java.util.Date;

import quickfix.Message;
import quickfix.field.Account;
import quickfix.field.ClOrdID;
import quickfix.field.MassStatusReqID;
import quickfix.field.MassStatusReqType;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.OrigClOrdID;
import quickfix.field.Price;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.field.TradeRequestID;
import quickfix.field.TradeRequestType;
import quickfix.field.TransactTime;

/**
 * Trading Request
 * @author OKCOIN
 *
 */
public class OKTradingRequest {
	
	/**
	 * new Order request
	 * @throws IOException 
	 */
	public static Message createOrderBookRequest() throws IOException {
		
		//this new Order request type (D)
		quickfix.fix44.NewOrderSingle newOrderSingleRequest = new quickfix.fix44.NewOrderSingle();
		//In there you should set your partner and securitykey must contain a comma
		newOrderSingleRequest.set(new Account(AccountUtil.apiKey+","+AccountUtil.sercretKey));
		//this is your unique id you can fill any string
		newOrderSingleRequest.set(new ClOrdID("QQAAAA"));
		//the amount you want to operate (buy or sell)
		newOrderSingleRequest.set(new OrderQty(1));
		//There is operate type. "1" means marker price order,"2" means limit price order
		newOrderSingleRequest.set(new OrdType('1'));
		//if buy OrdType=1 price means buy BTC or LTC spend 30 RMB by market price OrderQty useless
		//如果买入 ,OrdType 为1 price 意思为市价单 买30块钱的币  OrderQty无意义
		//if buy OrdType=2 price means buy BTC or LTC 30RMB/per OrderQty means amount
		//如果买入, OrdType 为2 price 意思 买币单价为30  OrderQty表示购买数量
		//if sell OrdType=1 price useless,OrderQty means amount you want to sell
		//如果卖出, OrdType 为1 price 无含义,意思为市价卖,OrderQty为卖出数量
		//if sell OrdType=2 price means BTC or LTC/per price ,OrderQty means amount
		//如果卖出, OrdType 为2 price 为卖出单价 OrderQty为卖出数量
		newOrderSingleRequest.set(new Price(30D));
		//1 means buy;2 means sell
		newOrderSingleRequest.set(new Side('1'));
		//type BTC/CNY or LTC/CNY other formart not supported
		newOrderSingleRequest.set(new Symbol("LTC/CNY"));
		//time
		newOrderSingleRequest.set(new TransactTime());
	        return newOrderSingleRequest;
        }
	
	
	/**
	 * 取消订单请求
	 */
	public static Message createOrderCancelRequest() {
		quickfix.fix44.OrderCancelRequest OrderCancelRequest = new quickfix.fix44.OrderCancelRequest();
		OrderCancelRequest.set(new ClOrdID("2"));
		OrderCancelRequest.set(new OrigClOrdID("1231234"));//订单编号
		OrderCancelRequest.set(new Side('1'));				//1买入;2卖出
		OrderCancelRequest.set(new Symbol("BTC/CNY"));		//BTC/CNY or LTC/CNY
		OrderCancelRequest.set(new TransactTime(new Date()));
	    return OrderCancelRequest;
       }
	
	/**
	 * 订单状态请求
	 */
	public static Message createOrderStatusRequest() {
		quickfix.fix44.OrderMassStatusRequest orderMassStatusRequest = new quickfix.fix44.OrderMassStatusRequest();
		orderMassStatusRequest.set(new MassStatusReqID("2123413"));//查询的订单ID
		orderMassStatusRequest.set(new MassStatusReqType(MassStatusReqType.STATUS_FOR_ALL_ORDERS));
		return orderMassStatusRequest;
	}
	
	/**
	 * 账户信息请求 
	 */
	public static Message createUserAccountRequest() {
		AccountInfoRequest accountInfoRequest = new AccountInfoRequest();
		accountInfoRequest.set(new Account(AccountUtil.apiKey+","+AccountUtil.sercretKey));//这里可以设置可以省略
		accountInfoRequest.set(new AccReqID("123"));
	        return accountInfoRequest;
        }
	/**
	 * 请求历史交易
	 */
	public static Message createTradeHistoryRequest() {
		quickfix.fix44.TradeCaptureReportRequest tradeCaptureReportRequest = new quickfix.fix44.TradeCaptureReportRequest();
		tradeCaptureReportRequest.set(new Symbol("BTC/CNY"));
		tradeCaptureReportRequest.set(new TradeRequestID("order_id"));
		tradeCaptureReportRequest.set(new TradeRequestType(1));//这里必须是1
		return tradeCaptureReportRequest;
	}
	
	
}
