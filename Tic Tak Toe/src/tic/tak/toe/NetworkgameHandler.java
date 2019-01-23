/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ziad
 */
public class NetworkgameHandler extends Thread{
    
                DataInputStream dis ;
		PrintStream ps;
                Socket soc;
                
                OutputStream outputStream;
                ObjectOutputStream objectOutputStream;
                ObjectInputStream objectInputStream;
                Object object;
                
                String[] str;
		static	List<NetworkgameHandler> myList = new ArrayList<NetworkgameHandler>();
                
                
    public NetworkgameHandler(Socket s)
		{
			
			try
			{
                                        soc = s;
                                        outputStream = s.getOutputStream();
                                        objectOutputStream = new ObjectOutputStream(outputStream);
                                        objectInputStream = new ObjectInputStream(s.getInputStream());
                                        
					//dis = new DataInputStream(s.getInputStream ());
					//ps = new PrintStream(s.getOutputStream ());                                        
					myList.add(this);
                                        start();
                                        
					//start();										
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			//th.start();
		
		}
    
    
    //--------------------------------------------------------------------------
    //Thread th = new Thread()
    //{
    @Override
    public void run()
		{
                    
			while(true)
			{
				try
				{			
                                        object = objectInputStream.readObject();
					str = (String[])object;
                                        
                                        //String msg = dis.readLine();
                                        System.out.println(str[0] +" herere ew eq e----------------------");
                                        
					if(str[0] == null)
					{
							
							break;
					}
                                        if("request_p".equals(str[0]))
                                        {
                                            printAll(str[2]);
                                        }
                                        if("confirm_p".equals(str[0]))
                                        {
                                            //printAll(str[2]);
                                            System.out.println("Sender : "+str[1]+" resever :"+str[2] );
                                            find_sockets(str);
                                        }
                                        if("refuse_p".equals(str[0]))
                                        {
                                            //printAll(str[2]);
                                            System.out.println("Sender : "+str[1]+" resever :"+str[2] );
                                            printAll_refuse(str[1]);
                                        }
					
					
					
				}
				catch(IOException ex)
				{
					//ex.printStackTrace();
					    
					
					//System.exit(0);	 	
										
				} catch (ClassNotFoundException ex) { 
                                Logger.getLogger(NetworkgameHandler.class.getName()).log(Level.SEVERE, null, ex);
                            } 
			}
		
		}
    //};
		
		


		public synchronized void printAll(String msg) throws IOException
		{
			for(NetworkgameHandler ch : myList)
			{
                            
                             InetAddress inetAddress = ((InetSocketAddress)ch.soc.getRemoteSocketAddress()).getAddress();
                             System.out.println(inetAddress.toString().replace("/", "") +"  equal ?  "+msg);
                             String ip = inetAddress.toString().replace("/", "");
                            // System.err.println(" soc ip "+soc.getRemoteSocketAddress().toString());
                                if( ip.equals(msg))
                                {
                                    str[0] = "request_p";
                                    
                                    ch.objectOutputStream.writeObject(str);
//                                    ch.ps.println(msg);
                                    System.out.println("print "+msg);
                                    System.out.println("socket  "+ch.soc);
                                    System.out.println("sender : "+str[1]+"resever :"+str[2]);
                                }
				
			}
		}
                
                ///-------------------------------------
                public synchronized void printAll_refuse(String msg) throws IOException
		{
			for(NetworkgameHandler ch : myList)
			{
                            
                             InetAddress inetAddress = ((InetSocketAddress)ch.soc.getRemoteSocketAddress()).getAddress();
                             //System.out.println(inetAddress.toString().replace("/", "") +"  equal ?  "+msg);
                             String ip = inetAddress.toString().replace("/", "");
                            // System.err.println(" soc ip "+soc.getRemoteSocketAddress().toString());
                                if( ip.equals(msg))
                                {
                                    str[0] = "refuse_p";
                                    
                                    ch.objectOutputStream.writeObject(str);
//                                    ch.ps.println(msg);
                                    System.out.println("print "+msg);
                                    System.out.println("socket  "+ch.soc);
                                    System.out.println("sender : "+str[1]+"resever :"+str[2]);
                                }
				
			}
		}
                //--------------------------------------
                //find sockets
                public synchronized void find_sockets(String[] ips) throws IOException
		{
                    Socket soc_p1 = null;
                    Socket soc_p2 = null;   
			for(NetworkgameHandler ch : myList)
			{
                            System.out.println("ips[1]  "+ips[1]);
                            System.out.println("ips[2]  "+ips[2]);                                    
                             InetAddress inetAddress = ((InetSocketAddress)ch.soc.getRemoteSocketAddress()).getAddress();
                             //System.out.println(inetAddress.toString().replace("/", "") +"  equal ?  "+msg);
                             String ip = inetAddress.toString().replace("/", "");
                            // System.err.println(" soc ip "+soc.getRemoteSocketAddress().toString());
                                if( ip.equals(ips[1]))
                                {
                                    str[0] = "create_socket";
                                    str[3] ="turn";
                                    ch.objectOutputStream.writeObject(str);
                                    
                                    soc_p1 = ch.soc;                                    
                                    System.out.println("soc_p1  "+soc_p1);                                    
                                }
                                if( ip.equals(ips[2]))
                                {
                                    str[0] = "create_socket";                                    
                                    str[3] ="notturn";
                                    ch.objectOutputStream.writeObject(str);
                                    
                                    soc_p2 = ch.soc;                                    
                                    System.out.println("soc_2  "+soc_p2);                                    
                                }
                                
				
			}
                        
//                        if(soc_p1 != null && soc_p2 != null)
//                        {5009 5010
//                            new GameHandler(soc_p1, soc_p2);
//                        }
		}
    
}
