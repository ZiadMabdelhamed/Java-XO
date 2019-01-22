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
public class GameHandler extends Thread {
    
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    Object object;
    String[] str;
    Socket soc;
    //ObjectOutputStream soc2_ps;
    static	List<GameHandler> myList = new ArrayList<GameHandler>();
    public GameHandler(Socket s1) throws IOException
    {
                                        soc = s1;
                                        System.out.println("Game handler 2 sokect");
                                        //new NetworkgameHandler(s1);
                                        
					objectOutputStream = new ObjectOutputStream(s1.getOutputStream());
                                        objectInputStream = new ObjectInputStream(s1.getInputStream());
                                                                                
                                          myList.add(this);
                                          start();
			
    }
    
    
    public void run()
		{
			while(true)
			{
				try
				{			
                                        object = objectInputStream.readObject();
					str = (String[])object;
                                        
					if(str == null)
					{
							
							break;
					}
					printAll(str[2]);
					
										
				}
				catch(IOException ex)
				{
					//ex.printStackTrace();
					    
					
					//System.exit(0);	 	
					
					


				} catch (ClassNotFoundException ex) {
                                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		
		}
    
    
    public void printAll(String msg1) throws IOException
		{                    
                    System.out.println("msg1"+msg1);                        
			for(GameHandler ch : myList)
			{
                             InetAddress inetAddress = ((InetSocketAddress)ch.soc.getRemoteSocketAddress()).getAddress();
                             //System.out.println(inetAddress.toString().replace("/", "") +"  equal ?  "+msg);
                             String ip = inetAddress.toString().replace("/", "");
                            
                             if( ip.equals(str[0]) || ip.equals(str[1]))
                                {
                                    //str[0] = "refuse_p";
                                    
                                    ch.objectOutputStream.writeObject(str[2]);				
//                                    ch.ps.println(msg);
                                    
                                    System.out.println("sender : "+str[0]+"resever :"+str[1]);
                                }
                             
                             
			}
		}
    
    
}
