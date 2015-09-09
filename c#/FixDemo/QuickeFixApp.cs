using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickFix;
using QuickFix.Fields;
namespace FixDemo
{
    public class MyQuickFixApp : IApplication
    {
        public void OnMessage(Message message, SessionID sessionID) {
            Console.WriteLine(sessionID + "------client onMessage-------业务逻辑----"
               + message.ToString());
	}

	public void FromAdmin(Message msg, SessionID sessionID){
        Console.WriteLine(sessionID + "------client fromAdmin-------业务逻辑----"
             + msg.ToString());
		
	}

	public void FromApp(Message msg, SessionID sessionID) {
        Console.WriteLine(sessionID + "------client fromApp-------业务逻辑----"
                + msg.ToString());
	}

	public void OnCreate(SessionID sessionID) {
		Console.WriteLine(sessionID + "------client onCreate 创建Session-------"
				+ sessionID);
	}

	public void OnLogon( SessionID sessionID) {
	   
		Session session = Session.LookupSession(sessionID);
        Message message =  null;
	    
	    //行情订阅
        message = OKMarketDataRequest.create24HTickerRequest();
	    
        //深度订阅
        //message = OKMarketDataRequest.createOrderBookRequest();
		
        //用户信息请求
		//message = OKTradingRequest.createUserAccountRequest();
		 
        //创建订单
        // try{
		//     message = OKTradingRequest.createOrderBookRequest();
		// } catch (Exception e) {
        //     Console.WriteLine(e.Message);
        // }
		
		 //取消订单请求
	     // message = OKTradingRequest.createOrderCancelRequest();
		 
         //订单状态请求
		 // message = OKTradingRequest.createOrderStatusRequest();
        session.Send(message);
        
	
	}

	public void OnLogout(SessionID sessionID) {
		Console.WriteLine(sessionID + "------client onLogout 退出-------"
				+ sessionID);
		// System.exit(0);
	}

	public void ToAdmin(Message msg, SessionID sessionID) {
		
     	msg.SetField(new StringField(553, AccountUtil.apiKey));
	    msg.SetField(new StringField(554, AccountUtil.sercretKey));
		
	}

	public void ToApp(Message msg, SessionID sessionID){
		Console.WriteLine(sessionID + "------client toApp-------业务逻辑----"
				+ msg.ToString());

	}
  
    }
}
