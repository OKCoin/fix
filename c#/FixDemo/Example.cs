using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuickFix;
namespace FixDemo
{
    class Example
    {
        static void Main(string[] args)
        {

            try
            {
               
                QuickFix.SessionSettings settings = new QuickFix.SessionSettings("config/quickfix-client.cfg");
                MyQuickFixApp application = new MyQuickFixApp();
                QuickFix.IMessageStoreFactory storeFactory = new QuickFix.FileStoreFactory(settings);
                QuickFix.ILogFactory logFactory = new QuickFix.ScreenLogFactory(settings);
                QuickFix.Transport.SocketInitiator initiator = new QuickFix.Transport.SocketInitiator(application, storeFactory, settings, logFactory);
                initiator.Start();
                Console.ReadKey();
                initiator.Stop();
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.StackTrace);
                Console.ReadKey();
            }
            Environment.Exit(1);
        }
    }
}
