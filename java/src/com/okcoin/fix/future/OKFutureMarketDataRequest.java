package com.okcoin.fix.future;

import quickfix.Message;
import quickfix.field.MDEntryType;
import quickfix.field.MDReqID;
import quickfix.field.MarketDepth;
import quickfix.field.SecurityType;
import quickfix.field.StrikeCurrency;
import quickfix.field.SubscriptionRequestType;
import quickfix.field.Symbol;

/**
 * 
* @ClassName: OKFutureMarketDataRequest 
* @Description: 期货市场数据响应 
* @author OKCOIN 
* @date 2016-2-1 上午11:29:00 
*
 */
public class OKFutureMarketDataRequest {
		
	/**
	 * 
	* @Description: 深度数据 
	* @author OKCOIN 
	* @return
	* @date 2016-2-3 上午10:33:26 
	* @throws
	 */
	public static Message OrderBookRequest() {
		quickfix.fix44.MarketDataRequest orderBookRequest = new quickfix.fix44.MarketDataRequest();
		
		quickfix.fix44.MarketDataRequest.NoRelatedSym noRelatedSym = new quickfix.fix44.MarketDataRequest.NoRelatedSym();
		noRelatedSym.set(new Symbol("this_week"));
		noRelatedSym.set(new SecurityType("FUT"));
		noRelatedSym.set(new StrikeCurrency("btc_usd"));
		orderBookRequest.addGroup(noRelatedSym);
		
		orderBookRequest.set(new MDReqID("123"));
		orderBookRequest.set(new SubscriptionRequestType('0')); 
		orderBookRequest.set(new MarketDepth(0));
		
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group1 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group1.set(new MDEntryType('0'));
	    orderBookRequest.addGroup(group1);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group2 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group2.set(new MDEntryType('1'));
	    orderBookRequest.addGroup(group2);
	    
	    return orderBookRequest;
    }

	
	/**
	* @Description:交易历史记录
	* @author OKCOIN 
	* @return
	* @date 2016-2-3 上午10:30:10 
	* @throws
	 */
	public static Message createLiveTradesRequest() {
		quickfix.fix44.MarketDataRequest liveTradesRequest = new quickfix.fix44.MarketDataRequest();
		quickfix.fix44.MarketDataRequest.NoRelatedSym noRelatedSym = new quickfix.fix44.MarketDataRequest.NoRelatedSym();
		noRelatedSym.set(new Symbol("next_week"));
		noRelatedSym.set(new SecurityType("FUT"));
		noRelatedSym.set(new StrikeCurrency("btc_usd"));
		
		liveTradesRequest.addGroup(noRelatedSym);
		liveTradesRequest.set(new MDReqID("888888"));
		liveTradesRequest.set(new SubscriptionRequestType('0'));
		liveTradesRequest.set(new MarketDepth(0));
		
		
		//特征值，交易记录
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group.set(new MDEntryType('2'));
	    liveTradesRequest.addGroup(group);
	    
	    return liveTradesRequest;
	}
	
	/**
	 * 
	* @Description: 24h行情请求，盘口数据
	* @author OKCOIN 
	* @return
	* @date 2016-2-1 上午11:36:56 
	* @throws
	 */
	public static Message create24HTickerRequest() {
		
		quickfix.fix44.MarketDataRequest tickerRequest = new quickfix.fix44.MarketDataRequest();
		quickfix.fix44.MarketDataRequest.NoRelatedSym noRelatedSym = new quickfix.fix44.MarketDataRequest.NoRelatedSym();
		/**
		 * symbol btc_usd:比特币    ltc_usd :莱特币
		 * contract_type  合约类型: this_week:当周   next_week:下周   quarter:季度
		 */	
		noRelatedSym.set(new Symbol("next_week"));
		noRelatedSym.set(new SecurityType("FUT"));
		noRelatedSym.set(new StrikeCurrency("btc_usd"));
		tickerRequest.addGroup(noRelatedSym);
		tickerRequest.set(new MDReqID("888888"));
		tickerRequest.set(new SubscriptionRequestType('0'));
		tickerRequest.set(new MarketDepth(0));
		
		//特征值
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group1 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group1.set(new MDEntryType('4'));
	    tickerRequest.addGroup(group1);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group2 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group2.set(new MDEntryType('5'));
	    tickerRequest.addGroup(group2);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group3 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group3.set(new MDEntryType('7'));
	    tickerRequest.addGroup(group3);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group4 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group4.set(new MDEntryType('8'));
	    tickerRequest.addGroup(group4);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group5 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group5.set(new MDEntryType('9'));
	    tickerRequest.addGroup(group5);
	    
	    quickfix.fix44.MarketDataRequest.NoMDEntryTypes group6 = new quickfix.fix44.MarketDataRequest.NoMDEntryTypes();
	    group6.set(new MDEntryType('B'));
	    tickerRequest.addGroup(group6);
	    
	    return tickerRequest;
	}



}
