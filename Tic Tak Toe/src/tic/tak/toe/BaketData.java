/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Ziad
 */
public class BaketData implements Serializable  {
    
   public String request_type;
   public Socket sender_socket;
   public Socket resever_socket;
   public String ip_sender;
   public String ip_destination;
   
   public BaketData()
   {
       
   }
}
