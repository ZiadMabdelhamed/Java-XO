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
import javax.swing.JOptionPane;

/**
 *
 * @author Ziad
 */
public class GameHandler extends Thread {
    
    ObjectOutputStream s1_OutputStream;
    ObjectInputStream s1_InputStream;
    
    ObjectOutputStream s2_OutputStream;
    ObjectInputStream s2_InputStream;
    
    Object object;
    String[] str;
    Socket soc;
    
    int Turn = 1 ;
    
    public GameHandler(Socket s1,Socket s2) throws IOException
    {
                                        
                                        System.out.println("Game handler 2 sokect");
                                        //new NetworkgameHandler(s1);
                                        
                                        s1_OutputStream = new ObjectOutputStream(s1.getOutputStream());
                                        s1_InputStream = new ObjectInputStream(s1.getInputStream());
                                        
                                        s2_OutputStream = new ObjectOutputStream(s2.getOutputStream());
                                        s2_InputStream = new ObjectInputStream(s2.getInputStream());
                                        
                                        
                                          start();
			
    }
    
    @Override
    public void run()
		{
			while(true)
			{
				try
				{
                                    
                                    if(Turn == 1)
                                    {
                                        System.out.println("before from s1 ");
                                        Object objects1 = s1_InputStream.readObject();
                                        System.out.println("after from s1 ");
                                        
                                        String[] str1 = (String[])objects1;                                        
                                        String[] str2 = (String[])objects1;                                        
                                        
                                        String[] str1_mod = new String[4];
                                        str1_mod[0]=str1[0];
                                        str1_mod[1]="notturn";
                                        str1_mod[2]=str1[2];
                                        str1_mod[3]=str1[3];
                                        
                                        //str1[1] = "notturn";
                                        //str1[1] = "turn";
                                        str2[1] = "turn";
                                        
                                        System.out.println("pos from s1 "+str1[0]);
                                        s2_OutputStream.writeObject(str2);
                                        s1_OutputStream.writeObject(str1_mod);
                                        Turn = 2;
                                    }
                                    else if(Turn == 2)
                                    {
                                        System.out.println("pos before from s2 ");
                                        Object objects2 = s2_InputStream.readObject();
                                        System.out.println("pos after from s2 ");
                                        String[] str1 = (String[])objects2;
                                        String[] str2 = (String[])objects2;                                        
                                        
                                        String[] str2_mod = new String[4];
                                        str2_mod[0]=str2[0];
                                        str2_mod[1]="notturn";
                                        str2_mod[2]=str2[2];
                                        str2_mod[3]=str2[3];
                                        //str1[1] = "turn";
                                        //str2[1] = "notturn";
                                        str1[1] = "turn";
                                        JOptionPane.showMessageDialog(null,"Server notifiction str2 :"+ str2_mod[1]);
                                        System.out.println("pos from s2 "+str1[0]);
                                        s2_OutputStream.writeObject(str2_mod);
                                        s1_OutputStream.writeObject(str1);
                                        Turn = 1;
                                    }
                                    
                                                                                                                                                                                    
				}
				catch(IOException ex)
				{
                                    
				} catch (ClassNotFoundException ex) { 
                                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
                            } 
			}
		
		}
    
    
    
}
