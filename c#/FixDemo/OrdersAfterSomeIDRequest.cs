using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickFix;
using QuickFix.Fields;
namespace FixDemo
{
    class OrdersAfterSomeIDRequest: Message {

	
	public static  String MSGTYPE = "Z2000";

	public OrdersAfterSomeIDRequest() {
		Header.SetField(new MsgType("Z2000"));
	}

	public void set(Symbol field) { // 55
		SetField(field);
	}

	public void set(OrderID field) { // 37
		SetField(field);
	}

	public void set(OrdStatus field) { // 39
		SetField(field);
	}

	public void set(TradeRequestID field) { // 568
		SetField(field);
	}

	public void set(TradeRequestType field) { // 569
		SetField(field);
	}
}

}