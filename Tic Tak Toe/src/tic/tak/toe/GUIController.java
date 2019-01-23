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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
//import sun.swing.BakedArrayList;

/**
 *
 * @author Ziad
 */
public class GUIController extends Thread {

    //private GUI theView;
    private GUIEDIT theView;
    private ModulesInterface theModel;

    public String btn_id;
    protected GamePlay game;
    protected static String Win = null;
    public boolean can_paly = true;

    public int player_turn = 1;
    public boolean palyer_one_can_play = true;

    public boolean can_play_this_pos;
    public int moves_num;

    public String p2_status;

    public String[] reseved_array_of_data;
    Socket net;

    PrintStream ps;
    DataInputStream dis;

    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    BaketData baket_reseved;
    String[] Data_btn;

    String[] two_players_ip = new String[4];

    Socket GamePlay_socket = null;
    ObjectOutputStream GP_printstream;
    ObjectInputStream GP_inputstream;

    String net_player_can_play;
    boolean show_refuse_msg = true;
    //public GUIController(GUI theView) {

    public GUIController(GUIEDIT theView) {
        this.theView = theView;
        this.theModel = theModel;

        // Tell the View that when ever the calculate button
        // is clicked to execute the actionPerformed method
        // in the CalculateListener inner class
        this.theView.GridButtonXO(new XOListener());
        this.theView.ComboBoxListener(new ComBoListener());
        //this.theView.PanetabListener(new PaneTab());
        this.theView.Restartbutton(new Restartbtn());
        game = new GamePlay();
        theModel = new NormalPlayer();
        p2_status = "h";
        this.theView.change_status("Start game or select player");
        this.theView.hide_network_list(true);
        this.theView.Records_btn(new RecordBtn());
        this.theView.confirmbutton(new confirmbtn());
        this.theView.refusebutton(new refusebtn());
        this.theView.hide_block();

        //--------------------------------------------
        // network
        try {
            //Socket net = theView.get_network_s();
            net = new Socket(InetAddress.getLocalHost(), 5007);
            //net = new Socket("172.16.0.150", 5007);

            outputStream = net.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(net.getInputStream());

            //dis = new DataInputStream(net.getInputStream());
            //ps = new PrintStream(net.getOutputStream ());                    
            //------------------------------------------------------------------
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        start();

    }

    /// gameplay button
    public class XOListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (can_paly) {
                Button node = (Button) event.getSource();

                if ("n".equals(p2_status)) {
                    btn_id = node.getId();
                    can_play_this_pos = game.can_put_here(btn_id);
                    //JOptionPane.showMessageDialog(null, net_player_can_play);
                    if (can_play_this_pos && "turn".equals(net_player_can_play)) {
                        JOptionPane.showMessageDialog(null, "here call server : ");
                        try {

                            System.out.println("----------------------------------------------------");
                            System.out.println("palyer click pos : " + btn_id);

                            String[] str = new String[4];
                            str[0] = btn_id;
                            str[3] = "pos";
                            //str[1] = symbol;
                            GP_printstream.writeObject(str);

//                            player_turn = 2;
//                            
//                            theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");
//                            palyer_one_can_play = false;
//                            System.out.println("player 1 pos :" + btn_id);
//                            
//                            game.set_toboard(btn_id);
//                            
//                            // get turn from gameplay
//                            String symbol = game.get_turn();
//                            
//                            theView.DrawOnBoard(btn_id, symbol);
                        } catch (IOException ex) {
                            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } // not network--------------------------------------------------------------
                else {
                    if (player_turn == 1 && palyer_one_can_play) {
                        btn_id = node.getId();
                        can_play_this_pos = game.can_put_here(btn_id);

                        if (can_play_this_pos) {
                            player_turn = 2;
                            //theView.change_status("Player : "+player_turn+" Turn");
                            theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");
                            palyer_one_can_play = false;
                            System.out.println("player 1 pos :" + btn_id);

                            game.set_toboard(btn_id);

                            // get turn from gameplay
                            String symbol = game.get_turn();

                            theView.DrawOnBoard(btn_id, symbol);

                        }
                        ///------------------------------------------
                        /// easy ai player
                        if (p2_status == "e") {

                            String[] board = game.ret_board();
                            btn_id = theModel.emptySpots(board);

                            System.out.println("Ai pos : " + btn_id);
                            if (btn_id != null && btn_id != "12") {
                                can_play_this_pos = game.can_put_here(btn_id);
                            } else {
                                can_play_this_pos = false;
                            }

                            palyer_one_can_play = theModel.other_player_can_play();

                            Win = game.checkWinner();
                            boolean game_e = game.get_game_end();
                            System.out.println("game end : " + game_e);

                            if (palyer_one_can_play && can_play_this_pos && player_turn == 2 && game_e == false) {

                                player_turn = 1;
                                theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");
                                game.set_toboard(btn_id);

                                String symbol = game.get_turn();
                                theView.DrawOnBoard(btn_id, symbol);

                            }
                        }

                        ///------------------------------------------
                        /// hard ai player
                        if (p2_status == "im") {

                            String[] board = game.ret_board();
                            btn_id = theModel.getmove(board);

                            System.out.println("Ai pos : " + btn_id);
                            if (btn_id != null && btn_id != "12") {
                                can_play_this_pos = game.can_put_here(btn_id);
                            } else {
                                can_play_this_pos = false;
                            }

                            palyer_one_can_play = theModel.other_player_can_play();

                            Win = game.checkWinner();
                            boolean game_e = game.get_game_end();
                            System.out.println("game end : " + game_e);
//                        System.out.println(palyer_one_can_play );
//                        System.out.println(can_play_this_pos );
//                        System.out.println(player_turn );
//                        System.out.println( game_e);
                            if (palyer_one_can_play && can_play_this_pos && player_turn == 2 && game_e == false) {

                                player_turn = 1;
                                theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");
                                game.set_toboard(btn_id);

                                String symbol = game.get_turn();
                                theView.DrawOnBoard(btn_id, symbol);

                            }
                        }

                        //============== Med ====================
                        if (p2_status == "med") {

                            String[] board = game.ret_board();
                            btn_id = theModel.getbestmove(board);

                            System.out.println("Ai pos : " + btn_id);
                            if (btn_id != null && btn_id != "12") {
                                can_play_this_pos = game.can_put_here(btn_id);
                            } else {
                                can_play_this_pos = false;
                            }

                            palyer_one_can_play = theModel.other_player_can_play();

                            Win = game.checkWinner();
                            boolean game_e = game.get_game_end();
                            System.out.println("game end : " + game_e);
//                        System.out.println(palyer_one_can_play );
//                        System.out.println(can_play_this_pos );
//                        System.out.println(player_turn );
//                        System.out.println( game_e);
                            if (palyer_one_can_play && can_play_this_pos && player_turn == 2 && game_e == false) {

                                player_turn = 1;
                                theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");
                                game.set_toboard(btn_id);

                                String symbol = game.get_turn();
                                theView.DrawOnBoard(btn_id, symbol);

                            }
                        }

                        //-----------------------------------------
                        //human player
                    } else if (p2_status == "h") {
                        if (player_turn == 2) {

                            theModel.set_player2_pos(node.getId());
                            btn_id = theModel.get_player2_pos();
                            can_play_this_pos = game.can_put_here(btn_id);

                            palyer_one_can_play = theModel.other_player_can_play();

                            if (palyer_one_can_play && can_play_this_pos) {
                                System.out.println("player 2 pos :" + btn_id);
                                player_turn = 1;
                                theView.change_status("Player " + player_turn + " :  " + game.get_symbol() + " Turn");

                                game.set_toboard(btn_id);

                                // get turn from gameplay
                                String symbol = game.get_turn();

                                theView.DrawOnBoard(btn_id, symbol);
                            }
                        }
                    }

                    moves_num = game.get_play_num();
                    System.out.println("moves_num :" + moves_num);
                    Win = game.checkWinner();

                    if (Win != null && can_paly && moves_num <= 9) {

                        System.out.println("Winner is " + Win);
                        if (Win == "x") {
                            theView.increase_x_score();
                        } else if (Win == "o") {
                            theView.increase_o_score();
                        }
                        theView.generate_win(Win);
                        can_paly = false;
                        game.set_game_end(true);
                        //JOptionPane.showMessageDialog(null,"Winner is :"+Win);
                    } else if (Win != "o" && moves_num == 9 && Win != "x") {
                        System.out.println("Draw");
                        theView.generate_win("d");
                        game.set_game_end(true);
                    }
                }
            }
        }
    }

    // Easy Medium Impossible Play against a friend
    public class ComBoListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            ComboBox node = (ComboBox) event.getSource();

            //JOptionPane.showMessageDialog(null,node.getSelectionModel().getSelectedItem());
            if (node.getSelectionModel().getSelectedItem() == "Easy") {
                reset_board();
                theModel = new AImodel();
                p2_status = "e";
                theView.hide_network_list(true);

            } else if (node.getSelectionModel().getSelectedItem() == "Medium") {
                reset_board();
                theView.hide_network_list(true);
                theModel = new AiMedium();
                p2_status = "med";

            } else if (node.getSelectionModel().getSelectedItem() == "Impossible") {
                reset_board();
                theModel = new AiHard();
                p2_status = "im";
                theView.hide_network_list(true);

            } else if (node.getSelectionModel().getSelectedItem() == "Play against a friend") {
                reset_board();
                theView.hide_network_list(true);
                p2_status = "h";
                theModel = new NormalPlayer();

            } else if (node.getSelectionModel().getSelectedItem() == "Network") {
                reset_board();
                theView.hide_network_list(false);
                System.out.println("sdsd");
                try {
                    theView.refresh_list(new Net_btn());
                } catch (IOException ex) {
                    Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /// Tab Local Online 
    public class PaneTab implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            JOptionPane.showMessageDialog(null, newValue);
        }
    }

    // restart button 
    public class Restartbtn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if("n".equals(p2_status))
            {
                    moves_num = game.get_play_num();
                    System.out.println("moves_num :" + moves_num);
                    Win = game.checkWinner();
                    System.out.println("Win :" + Win);

                    if (Win != null &&  moves_num <= 9 || Win != "o" && moves_num == 9 && Win != "x") {
                                                
                        try {                            
                            String[] str = new String[4];
                            str[3] = "reset";
                            JOptionPane.showMessageDialog(null,"restart");
                            //str[1] = symbol;
                            GP_printstream.writeObject(str);
                        } catch (IOException ex) {
                            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
            }
            else{reset_board();}
        }
    }

    // network list buttons 
    public class Net_btn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Button node = (Button) event.getSource();

            String ip = net.getLocalAddress().getHostAddress();
            Data_btn = new String[4];
            Data_btn[0] = "request_p";
            Data_btn[1] = ip;
            Data_btn[2] = node.getId();

            try {
                objectOutputStream.writeObject(Data_btn);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //------------------------
    //run function
    @Override
    public void run() {
        while (true) {
            try {
                //String replyMsg = dis.readLine();
                if (!"n".equals(p2_status)) {
                    Object object = objectInputStream.readObject();

                    reseved_array_of_data = (String[]) object;
                    String p1ip = reseved_array_of_data[1];
                    String p2ip = reseved_array_of_data[2];

                    //System.out.println("reseved_array_of_data :"+reseved_array_of_data[2]);
                    if ("request_p".equals(reseved_array_of_data[0])) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("show msg");
                                theView.show_hide_request_msg(true);
                            }
                        });

                    }
                    if ("refuse_p".equals(reseved_array_of_data[0])) 
                    {
                        if(show_refuse_msg)
                        {
                            JOptionPane.showMessageDialog(null, "Your Request Refused");
                        }
                        
                        show_refuse_msg = true;
                        Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            theView.show_hide_request_msg(false);

                            }
                        });
                    }
                    if ("create_socket".equals(reseved_array_of_data[0]) && !"n".equals(p2_status)) {

                        Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            theView.show_hide_request_msg(false);

                            }
                        });

                        
                        p2_status = "n";
                        two_players_ip[0] = p1ip;
                        two_players_ip[1] = p2ip;
                        net_player_can_play = reseved_array_of_data[3];
                        JOptionPane.showMessageDialog(null, "first turns " + net_player_can_play);
                        //GamePlay_socket = new Socket("172.16.0.150", 5010);
                        GamePlay_socket = new Socket(InetAddress.getLocalHost(), 5010);

                        GP_printstream = new ObjectOutputStream(GamePlay_socket.getOutputStream());
                        GP_inputstream = new ObjectInputStream(GamePlay_socket.getInputStream());

                        System.out.println(reseved_array_of_data[0]);
                        System.out.println("p2_status :" + p2_status);
                        System.out.println("first player ip :" + two_players_ip[0]);
                        System.out.println("second player ip :" + two_players_ip[1]);
                    }
                }

                if (GamePlay_socket != null) {
                    System.out.println("inside return ");
                    Object obj = GP_inputstream.readObject();
                    String[] str = (String[]) obj;
                    
                    if("pos".equals(str[3]))
                    {
                        System.out.println("pos sent from net : " + str[0]);
                    
                    game.set_toboard(str[0]);
                    net_player_can_play = str[1];
                    JOptionPane.showMessageDialog(null, "inside net :" + net_player_can_play);
                    // get turn from gameplay
                    String symbol = game.get_turn();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            theView.DrawOnBoard(str[0], symbol);

                        }
                    });

                    moves_num = game.get_play_num();
                    System.out.println("moves_num :" + moves_num);
                    Win = game.checkWinner();

                    if (Win != null && can_paly && moves_num <= 9) {

                        System.out.println("Winner is " + Win);
                        if (Win == "x") {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    theView.increase_x_score();

                                }
                            });
                            
                        } else if (Win == "o") {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    theView.increase_o_score();

                                }
                            });
                            
                        }
                        Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    theView.generate_win(Win);

                                }
                            });
                        
                        can_paly = false;
                        game.set_game_end(true);
                        //JOptionPane.showMessageDialog(null,"Winner is :"+Win);
                    } else if (Win != "o" && moves_num == 9 && Win != "x") {
                        System.out.println("Draw");
                        Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    theView.generate_win("d");

                                }
                            });                        
                        game.set_game_end(true);
                    }

                    }
                    if("reset".equals(str[3]))
                    {
                        JOptionPane.showMessageDialog(null,"restart");
                        Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    reset_board();

                                }
                            });                        
                        
                    }
                    
                }

                //System.out.println("message :"+ baket_reseved.request_type);
                //System.out.println("message client :"+ reseved_array_of_data[0]);
            } catch (IOException ex) {
                //JOptionPane.showMessageDialog(null, "Server Down");
                System.out.println("ex " + ex);
                System.exit(0);
                break;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //record button 
    public class RecordBtn extends Thread implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //JOptionPane.showMessageDialog(null,"record btn");
            boolean game_e = game.get_game_end();
            Button btn = (Button) event.getSource();

            Thread th2 = new Thread() {
                @Override
                public void run() {

                    ArrayList<String[]> Records = game.get_records();
                    System.out.println("Record");
                    System.out.println(Records.toString());
                    for (String[] array : Records) {

                        try {

                            TimeUnit.SECONDS.sleep(1);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    theView.DrawOnBoard(array[0], array[1]);

                                }
                            });

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                        System.out.println(array[0] + ":" + array[1]);

                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            btn.setDisable(false);
                            theView.hide_block();

                        }
                    });

                    System.out.println("end of thread");

                }
            ;

            };

                    

                
            if (game_e) {
                if (reset_onrecord()) {
                    btn.setDisable(true);
                    theView.active_block();
                    th2.start();
                }

                //theView.hide_block();
                //btn.setDisable(false);
            }

        }
    }

    ///reset function 
    public void reset_board() {

        game.reset_board();
        theView.reset_gui();
        can_paly = true;
        can_play_this_pos = true;
        palyer_one_can_play = true;
        game.set_who_start("x");
        player_turn = 1;
        theView.change_status("Start game or select player");
        theView.hide_win();
        game.set_game_end(false);
        net_player_can_play = "turn";
    }

    //public rest on record
    public boolean reset_onrecord() {

        theView.reset_gui();

        theView.change_status("Start game or select player");
        theView.hide_win();

        return true;
    }

    // confirm btn
    public class confirmbtn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("confirm ");
            //String ip = net.getLocalAddress().getHostAddress();

            reseved_array_of_data[0] = "confirm_p";
            

            try {
                objectOutputStream.writeObject(reseved_array_of_data);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    // refuse btn
    public class refusebtn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("refuse ");
            reseved_array_of_data[0] = "refuse_p";
            show_refuse_msg = false;
            //theView.show_hide_request_msg(false);
            try {
                objectOutputStream.writeObject(reseved_array_of_data);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
