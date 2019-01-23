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
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Ziad
 */
public class GUIEDIT extends GUI{
    
    protected String  curr_pane ;
    public Scene scene;

    public Image x_img = new Image(getClass().getResourceAsStream("/images/X_img.png"));
    public Image o_img = new Image(getClass().getResourceAsStream("/images/O_img.png"));

    public Socket net_socket;
    public GUIEDIT() 
    {
        ObservableList<String> ModeList = FXCollections.observableArrayList("Play against a friend","Easy","Medium","Impossible","Network");
        
        comboBox.setValue("Play against a friend");
        comboBox.setItems(ModeList);
        
        button0.setId("0");
        imageView.setId("0_img");
        
        button1.setId("1");
        imageView0.setId("1_img");
        
        button2.setId("2");
        imageView1.setId("2_img");
        
        button3.setId("3");
        imageView2.setId("3_img");
        
        button4.setId("4");
        imageView3.setId("4_img");
        
        button5.setId("5");
        imageView4.setId("5_img");
        
        button6.setId("6");
        imageView5.setId("6_img");
        
        button7.setId("7");
        imageView6.setId("7_img");
        
        button8.setId("8");
        imageView7.setId("8_img");
        
        
        textField.setId("game_status");
        
        button9.setId("x_score");
        text.setId("x_txt_score");
                
        button10.setId("o_score");
        text0.setId("o_txt_score");
        
        
        pane.setVisible(false);
        pane2.setVisible(false);
        /*pane.setId("win_pane");
        
        imageView8.setId("win_image");
        textField0.setId("win_txt");*/
    }
    
    public Socket get_network_s()
    {
        return net_socket;
    }
    
    public void show_hide_request_msg(boolean show)
    {
        pane2.setVisible(show);
    }
    
    public void refresh_list(EventHandler<ActionEvent> eventHandler) throws IOException, ClassNotFoundException
    {
        vBox0.getChildren().clear();
        PrintStream ps;
        
        OutputStream outputStream ;
        ObjectOutputStream objectOutputStream ;
        
        //DataInputStream dis ;
        //ResultSet rs;
        String msg;
        ArrayList<String[]> myList = null;
        try
            {//InetAddress.getLocalHost()
                    //Socket mySocket = new Socket("172.16.0.150", 5009);
                    Socket mySocket = new Socket(InetAddress.getLocalHost(), 5009);
                    //net_socket = new Socket(InetAddress.getLocalHost(), 5007);
                    
                    /// send object 
                    outputStream = mySocket.getOutputStream();
                    objectOutputStream = new ObjectOutputStream(outputStream);
                    
                    String queryString = new String ("SELECT * FROM contacts");
                    String ip = mySocket.getLocalAddress().getHostAddress();
                    String[] data_obj = new String[3];
                    data_obj[0] ="query";
                    data_obj[1] = queryString;
                    data_obj[2] = ip;
                    //dis = new DataInputStream(mySocket.getInputStream ());
                    //ps = new PrintStream(mySocket.getOutputStream ());
                    objectOutputStream.writeObject(data_obj);
                    
                    ObjectInputStream objectInputStream = new ObjectInputStream(mySocket.getInputStream());

                    
                    
                    //ps.println(queryString);
                    
                    
                    //msg =  dis.readLine();
                    Object object = objectInputStream.readObject();
                    
                    //System.out.println(msg);
                    
                    myList = (ArrayList<String[]>)object;
                    
                        
                    //dis.close();
                    objectOutputStream.close();
                    objectInputStream.close();
//                    ps.close();
                    mySocket.close();
               
            }
            catch(IOException ex)
            {
                    ex.printStackTrace();
            }
        System.out.print(myList);
        
        for (String[] array : myList){
           
            System.out.println(array[0] + ":" + array[1]);
                
            Button empty_btn = new Button();
            ImageView empty_img = new ImageView();
            
            
            empty_btn.setMnemonicParsing(false);
            empty_btn.setPrefHeight(32.0);
            empty_btn.setPrefWidth(168.0);
            // name of user from database 
            empty_btn.setText(array[2]);
            
            empty_img.setFitHeight(30.0);
            empty_img.setFitWidth(41.0);
            empty_img.setPickOnBounds(true);
            empty_img.setPreserveRatio(true);
            empty_img.setTranslateX(-29.0);
            empty_btn.setGraphic(empty_img);
            
            /// set ip from database
            empty_btn.setId(array[1]);
            empty_btn.setOnAction( eventHandler );
            
            vBox0.getChildren().add(empty_btn);
        }
        
        
    }
    
    
    public void hide_win()
    {
        pane.setVisible(false);
    }
    public void generate_win(String sym)
    {
        pane.setVisible(true);
        
        
        if("x".equals(sym))
        {
             imageView8.setImage(x_img);
             text1.setText("WINNER X !");
        }
        else if("o".equals(sym))
        {
            imageView8.setImage(o_img);
            text1.setText("WINNER O !");
        }
        else
        {
            imageView8.setImage(null);
            text1.setText("DRAW !");
        }
    }
    
    public void increase_x_score()
    {    
        int score = 0;
        Text x_text = (Text) scene.lookup("#x_txt_score");
         
        if(x_text.getText() == "-")
        {
            score = 1;
        }
        else
        {
            score+=Integer.parseInt(x_text.getText())+1;
        }
        
        x_text.setText(Integer.toString(score));
    }
    
    public void increase_o_score()
    {    
        int score = 0;
        Text o_text = (Text) scene.lookup("#o_txt_score");         
        if(o_text.getText() == "-")
        {
            score = 1;
        }
        else
        {
            
            score=Integer.parseInt(o_text.getText())+1;
        }
        
        o_text.setText(Integer.toString(score));
    }
    
    public void reset_all_score()
    {
        Text o_text = (Text) scene.lookup("#o_txt_score");
        Text x_text = (Text) scene.lookup("#x_txt_score");
        
        o_text.setText("-");
        x_text.setText("-");
    }
    
    public String get_id()
    {      
        return curr_pane;
    }
    
    public Scene create_scene(GUI root)
    {
        //GUI root = new GUI();
        scene = new Scene(root);
        
        return scene;
    }
    
    public void DrawOnBoard(String id,String symbol)
    {
        Button slc_btn = (Button) scene.lookup("#"+id);
        
        
        ImageView imgv = (ImageView) scene.lookup("#"+id+"_img");
        
        
        if(symbol == "x")
        {       
            imgv.setImage(x_img);            
        }
        else
        {
            imgv.setImage(o_img);           
        }
        
    }
    
    public void change_status(String status)
    {
        textField.setText(status);
    }
    
    
    public void GridButtonXO( EventHandler<ActionEvent> eventHandler )
    {
        
        button0.setOnAction( eventHandler );
        button1.setOnAction( eventHandler );
        button2.setOnAction( eventHandler );
        button3.setOnAction( eventHandler );
        button4.setOnAction( eventHandler );
        button5.setOnAction( eventHandler );
        button6.setOnAction( eventHandler );
        button7.setOnAction( eventHandler );
        button8.setOnAction( eventHandler );
    }
    
    
    public void confirmbutton( EventHandler<ActionEvent> eventHandler )
    {
        
        button14.setOnAction( eventHandler );
    }
    
    public void refusebutton( EventHandler<ActionEvent> eventHandler )
    {
        
        button15.setOnAction( eventHandler );
    }
    
    
    public void Restartbutton( EventHandler<ActionEvent> eventHandler )
    {
        
        button.setOnAction( eventHandler );
    }
    
    public void Records_btn( EventHandler<ActionEvent> eventHandler )
    {
        
        button12.setOnAction( eventHandler );
    }
    
    public void ComboBoxListener( EventHandler<ActionEvent> eventHandler )
    {
     
        comboBox.setOnAction(eventHandler);
        
    }
    /*public void PanetabListener( ChangeListener<Number> number)
    {
        tabPane.getSelectionModel().selectedIndexProperty().addListener(number);
        
    }*/
    
    public void reset_gui()
    {
        for(int i = 0;i<9;i++)
        {
            ImageView imgv = (ImageView) scene.lookup("#"+i+"_img");
            imgv.setImage(null);
        }
    }
    
    public void hide_network_list(boolean hide)
    {
        if(hide)
        {
            scrollPane.setVisible(false);
        }
        else
        {
            scrollPane.setVisible(true);
        }
    }
    
    /// blocker screen 
    public void active_block()
    {                
        pane1.setVisible(true);
        pane1.setScaleX(1);
        pane1.setScaleY(1);        
    }
    
    public void hide_block()
    {     
        pane1.setVisible(false);
        pane1.setScaleX(0);
        pane1.setScaleY(0);        
    }
}
