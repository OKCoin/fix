using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickFix;
using QuickFix.Fields;
namespace FixDemo
{
    class AccountInfoRequest:Message
    {
       public static  String MSGTYPE = "Z1000";

       public AccountInfoRequest()
	   {
          
         Header.SetField(new QuickFix.Fields.MsgType("Z1000"));
	   }

       public void set(QuickFix.Fields.Account field)
       {
		 SetField(field);
	  }

       public void set(AccReqID field)
       {
		  SetField(field);
	   }
    }
}