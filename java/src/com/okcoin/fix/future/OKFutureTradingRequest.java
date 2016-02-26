package com.okcoin.fix.future;

import java.io.IOException;
import java.util.Date;

import quickfix.Message;
import quickfix.field.Account;
import quickfix.field.ClOrdID;
import quickfix.field.Currency;
import quickfix.field.MarginRatio;
import quickfix.field.MassStatusReqID;
import quickfix.field.MassStatusReqType;
import quickfix.field.OrdStatus;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.OrigClOrdID;
import quickfix.field.PositionEffect;
import quickfix.field.Price;
import quickfix.field.SecurityType;
import quickfix.field.Side;
import quickfix.field.StrikeCurrency;
import quickfix.field.Symbol;
import quickfix.field.TransactTime;


/**
 * 
* @ClassName: OKFutureTradingRequest 
* @Description: 交易数据请求 
* @author OKCOIN 
* @date 2016-2-3 上午10:40:38 
*
 */
public class OKFutureTradingRequest {
	
	private static final String NEXT_WEEK = "next_week";
	private static final String THIS_WEEK = "this_week";
	private static final String QUARTER = "quarter";
	
	private static final String BTC_USD = "btc_usd";
	private static final String LTC_USD = "ltc_usd";
	
	
	/**
	 * 新订单请求
	 * @throws IOException 
	 */
	public static Message createOrderBookRequest() throws IOException {
		
		quickfix.fix44.NewOrderSingle newOrderSingleRequest = new quickfix.fix44.NewOrderSingle();
		
		newOrderSingleRequest.set(new Account("apiKey,SECRET_KEY"));
		newOrderSingleRequest.set(new ClOrdID("qsd"));
		newOrderSingleRequest.set(new OrderQty(1));
		newOrderSingleRequest.set(new OrdType(OrdType.LIMIT));
		newOrderSingleRequest.set(new Price(430));
		newOrderSingleRequest.set(new Side('1')); 
		newOrderSingleRequest.set(new Symbol("next_week"));
		newOrderSingleRequest.set(new Currency("btc_usd"));
		newOrderSingleRequest.set(new PositionEffect(PositionEffect.OPEN)); 
		newOrderSingleRequest.set(new SecurityType(SecurityType.FUTURE));//证券类型
		newOrderSingleRequest.set(new MarginRatio(20));
		newOrderSingleRequest.set(new TransactTime());
		return newOrderSingleRequest;
    }
	
	/**
	 * 取消订单请求
	 */
	public static Message OrderCancelRequest() {
		quickfix.fix44.OrderCancelRequest OrderCancelRequest = new quickfix.fix44.OrderCancelRequest();
	
		OrderCancelRequest.set(new ClOrdID("qsd"));
		OrderCancelRequest.set(new OrigClOrdID("323799"));
		OrderCancelRequest.set(new Symbol(OKFutureTradingRequest.NEXT_WEEK));
		OrderCancelRequest.set(new StrikeCurrency(OKFutureTradingRequest.BTC_USD));
		OrderCancelRequest.set(new Side('1'));
		OrderCancelRequest.set(new SecurityType(SecurityType.FUTURE));//证券类型
		OrderCancelRequest.set(new TransactTime(new Date()));
	    return OrderCancelRequest;
    }
	
	/**
	 * 订单状态请求
	 */
	public static Message gainOrderStatusRequest() {
		quickfix.fix44.OrderMassStatusRequest orderMassStatusRequest = new quickfix.fix44.OrderMassStatusRequest();
		orderMassStatusRequest.set(new SecurityType(SecurityType.FUTURE));//证券类型
		orderMassStatusRequest.set(new Account("apiKey,SECRET_KEY"));
		orderMassStatusRequest.set(new MassStatusReqID("1567066298"));
		orderMassStatusRequest.set(new MassStatusReqType(1));
		orderMassStatusRequest.set(new StrikeCurrency("btc_usd"));
		orderMassStatusRequest.set(new Symbol("next_week"));
		return orderMassStatusRequest;
	}
	
	//获取用户订单数据
	public static Message gainFutureOrders(){
		Z200Request or = new Z200Request();	
		or.set(new PageNO(2));
		or.set(new SecurityType("FUT"));
		or.set(new Symbol("next_weel"));
		or.set(new StrikeCurrency("btc_usd"));
		or.set(new OrdStatus('2'));
		return   or;
		
	}
	
	/**
	* @Description: 订阅用户数据推送 
	* @author OKCOIN 
	* @return
	* @date 2016-2-26 上午9:54:51 
	* @throws
	 */
	public static Message subLiveNews(String type){
		FutureSubNews or = new FutureSubNews(); 
		or.set(new SecurityType("FUT"));
		or.set(new NewsType(type));
		return   or;
	}	
}
