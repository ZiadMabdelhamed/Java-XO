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
public class NormalPlayer implements ModulesInterface {
    
    protected String move;
    
    @Override
    public String test() {
            return "Normal player";
    }

    @Override
    public void set_player2_pos(String pos) {
        move = pos;
    }

    @Override
    public String get_player2_pos() {
        return move;
    }

    @Override
    public boolean other_player_can_play() {
        if(move != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public String emptySpots(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getmove(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getbestmove(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   
    
    
}
