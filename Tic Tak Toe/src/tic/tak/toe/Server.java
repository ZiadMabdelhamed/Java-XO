package tic.tak.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ArrayList;
//import java.util.List;


public class Server extends Thread
{
	ServerSocket myServerSocket;
        ServerSocket databaseSocket;
        ServerSocket gamep;
	
        /// database thread
        Thread th1 = new Thread()
        {
            @Override
            public void run()
            {
                try
		{
			
                        databaseSocket = new ServerSocket(5009);
                        
				while(true)
				{
					//Socket s = myServerSocket.accept ();
                                        Socket s2 = databaseSocket.accept ();
					//new ChatHandler(s);
                                        new ChatHandler(s2);
				}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			
		} catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        //-------------------------------------
        
        
        
        /// game board thread
        Thread th3 = new Thread()
        {
            @Override
            public void run()
            {
                try
		{
			
                        gamep = new ServerSocket(5010);
                        
				while(true)
				{
					//Socket s = myServerSocket.accept ();
                                        Socket s1 = gamep.accept ();
                                        Socket s2 = gamep.accept ();

                                        ///Socket s2 = gamep.accept ();
					//new ChatHandler(s);
                                        //new GameHandler(s1,s2);
                                        new GameHandler(s1);
                                        //new GameHandler2(s1,s2);
				}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			
		}
                
            }
        };
        
        
        
        
        /// play newwork thread
        Thread th2 = new Thread()
        {
            @Override
            public void run()
            {
                try
		{
			myServerSocket = new ServerSocket(5007); 
                        
				while(true)
				{
					Socket s = myServerSocket.accept ();
                                        //new ChatHandler(s);
                                        new NetworkgameHandler(s);
                                        //new ChatHandler(s2);
				}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			
		}
            }
        };


	public static void main(String[] args)
	{
		new Server();
				
	}
        
       
        
	public Server()
	{
            th1.start();
            th2.start();
            th3.start();
//		try
//		{
//			myServerSocket = new ServerSocket(5007);
//                        databaseSocket = new ServerSocket(5009);
//                        
//				while(true)
//				{
//					//Socket s = myServerSocket.accept ();
//                                        Socket s2 = databaseSocket.accept ();
//					//new ChatHandler(s);
//                                        new ChatHandler(s2);
//				}
//		}
//		catch(IOException ex)
//		{
//			ex.printStackTrace();
//			
//		} catch (SQLException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            }

	}

	

}
