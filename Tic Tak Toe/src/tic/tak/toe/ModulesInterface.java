/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

/**
 *
 * @author Ziad
 */
interface ModulesInterface 
{ 
    final int id = 10; 
    //int move(); 
    String test();
    void set_player2_pos(String pos);
    String get_player2_pos();
    boolean other_player_can_play();
    public String emptySpots(String [] board);

    public String getmove(String[] board);

    public String getbestmove(String[] board);
    
} 

