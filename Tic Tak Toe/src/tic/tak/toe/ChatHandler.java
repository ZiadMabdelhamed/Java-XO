package tic.tak.toe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatHandler {

    DataInputStream dis;
    //PrintStream ps;
    Connection con;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;

    ObjectInputStream objectInputStream;

    Statement stmt;
    ResultSet rs;
    String queryString;

    String[] data_obj;
    Socket soc;
    static List<ChatHandler> myList = new ArrayList<ChatHandler>();

    public ChatHandler(Socket s) throws SQLException, ClassNotFoundException {

        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictak", "root", "");
            stmt = con.createStatement();
            soc = s;
            outputStream = s.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectInputStream = new ObjectInputStream(s.getInputStream());
					//dis = new DataInputStream(s.getInputStream ());
            //ps = new PrintStream(s.getOutputStream ());		
            //myList.add(this);
            Object object = objectInputStream.readObject();
            data_obj = (String[]) object;

            queryString = data_obj[1];

            rs = stmt.executeQuery(queryString);

            if("query".equals(data_obj[0]))
            {
                th_query.start();
            }
            if("update_isplayin".equals(data_obj[0]))
            {
                //th_query.start();
            }
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    Thread th_query = new Thread()
    {
    public void run() {

        try {
            //-------------------------
            // update status
            Thread th2 = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("inside update");
                        //con.setAutoCommit(false);
                        PreparedStatement pst = null;
                        try {
                            pst = con.prepareStatement("UPDATE `contacts` SET `isactive` = 'active' WHERE `contacts`.`IP` =?");
                        } catch (SQLException ex) {
                            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pst.setString(1, data_obj[2]);
                        pst.addBatch();
                        System.out.println("pst" + pst);
                            //pst.addBatch();

                        pst.executeBatch();
                    } catch (SQLException ex) {
                        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            th2.start();
            //----------------------------------------    
            ArrayList<String[]> parent = new ArrayList<String[]>();

            while (rs.next()) {

                String[] myList = new String[5];
                //ArrayList<String> myList =  new ArrayList<String>();
                int cols = rs.getMetaData().getColumnCount();

                for (int i = 0; i < cols; i++) {
                    System.out.print(rs.getString(i + 1) + " ");
                    myList[i] = (rs.getString(i + 1) + "");
                }
                System.out.print("\n");
                parent.add(myList);
            }

            System.out.print(parent);
            objectOutputStream.writeObject(parent);

            dis.close();
            objectOutputStream.close();
            soc.close();

        } catch (Exception e) {
        }

    }
    };
    public void printAll(String msg) {
        for (ChatHandler ch : myList) {
//				ch.ps.println(msg);
        }
    }

}
