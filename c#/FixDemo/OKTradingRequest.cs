using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickFix;
using QuickFix.Fields;
namespace FixDemo
{
    public class OKTradingRequest {
	
	/**
	 * new Order request
	 * @throws IOException 
	 */
	public static Message createOrderBookRequest()  {
		
		//this new Order request type (D)
        QuickFix.FIX44.NewOrderSingle newOrderSingleRequest = new QuickFix.FIX44.NewOrderSingle();
		//In there you should Set your partner and securitykey must contain a comma
		newOrderSingleRequest.Set(new Account(AccountUtil.apiKey+","+AccountUtil.sercretKey));
		//this is your unique id you can fill any string
		newOrderSingleRequest.Set(new ClOrdID("123"));
		//the amount you want to operate (buy or sell)
		newOrderSingleRequest.Set(new OrderQty(1));
		//There is operate type. "1" means marker price order,"2" means limit price order
		newOrderSingleRequest.Set(new OrdType('1'));
		
		newOrderSingleRequest.Set(new Price(10));
		//1 means buy;2 means sell
		newOrderSingleRequest.Set(new Side('1'));
		//type BTC/CNY or LTC/CNY other formart not supported
		newOrderSingleRequest.Set(new Symbol("LTC/CNY"));
		//time
		newOrderSingleRequest.Set(new TransactTime());
	        return newOrderSingleRequest;
        }
	
	
	/**
	 * 取消订单请求
	 */
	public static Message createOrderCancelRequest() {
		QuickFix.FIX44.OrderCancelRequest OrderCancelRequest = new QuickFix.FIX44.OrderCancelRequest();
		OrderCancelRequest.Set(new ClOrdID("QQAAAA"));
		OrderCancelRequest.Set(new OrigClOrdID("110296341"));//订单编号
		OrderCancelRequest.Set(new Side('1'));				//1买入;2卖出
		OrderCancelRequest.Set(new Symbol("LTC/CNY"));		//BTC/CNY or LTC/CNY
        OrderCancelRequest.Set(new TransactTime(DateTime.Now));
	    return OrderCancelRequest;
       }
	
	/**
	 * 订单状态请求
	 */
	public static Message createOrderStatusRequest() {
		QuickFix.FIX44.OrderMassStatusRequest orderMassStatusRequest = new QuickFix.FIX44.OrderMassStatusRequest();
		orderMassStatusRequest.Set(new MassStatusReqID("2123413"));//查询的订单ID
		orderMassStatusRequest.Set(new MassStatusReqType(MassStatusReqType.STATUS_FOR_ALL_ORDERS));
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
		QuickFix.FIX44.TradeCaptureReportRequest tradeCaptureReportRequest = new QuickFix.FIX44.TradeCaptureReportRequest();
		tradeCaptureReportRequest.Set(new Symbol("BTC/CNY"));
		tradeCaptureReportRequest.Set(new TradeRequestID("order_id"));
		tradeCaptureReportRequest.Set(new TradeRequestType(1));//这里必须是1
		return tradeCaptureReportRequest;
	}
	public static Message createTradeOrdersBySomeID() {
		OrdersAfterSomeIDRequest request = new OrdersAfterSomeIDRequest();
		request.set(new OrderID("1"));
        request.set(new Symbol("BTC/USD"));
        request.set(new OrdStatus('1'));
        request.set(new TradeRequestID("liushuihao_001"));
//		request.Set(new TradeRequestType(1));
		return request;
	}
	
}
}
