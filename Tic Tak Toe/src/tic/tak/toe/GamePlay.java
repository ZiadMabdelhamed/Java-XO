/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.util.ArrayList;

/**
 *
 * @author Ziad
 */

public class GamePlay {
    public String Turn;
    public static String[] board;
    public int play_numbers = 0;
    boolean can_play_pos = true;
    boolean board_empty = true;
    String old_turn_symbol ;
    private boolean game_end;
  
    ArrayList<String[]> Records =  new ArrayList<String[]>();
    
    
    public GamePlay()
    {
        Turn = "x";        
        board = new String[9];
        game_end = false;
    }
    public GamePlay(String T)
    {
        Turn = T;        
        board = new String[9];
        game_end = false;
    }
   
    // set game end value
    public void set_game_end(boolean end)
    {
        game_end = end;
    }
    
    //get game end value
    public boolean get_game_end()
    {
        return game_end;
    }
    
    // record list 
    public ArrayList<String[]> get_records()
    {
        return Records;
    }
    
    public int get_play_num()
    {
        return play_numbers;
    }
    
    public String[] ret_board()
    {
        return board;
    }
    
    /// check if board empty or not 
    public boolean board_empty()
    {
        play_numbers = 0;
        board_empty = true;
        for(int i=0;i<9;i++)
        {
            if(board[i] != null)
            {
                board_empty = false;
            }
        }
        return board_empty ;
    }
    
    /// check if this place already taken or not 
    public boolean can_put_here(String id_btn )
    {                    
        //System.out.println("can put here id "+ id_btn);
        //System.out.println("can put here board id "+ board[Integer.parseInt(id_btn)]);
            if(board[Integer.parseInt(id_btn)] != null)
            {
                System.out.println("can't put here ------------------------------------");
                can_play_pos = false;
            }
            else if (id_btn == "12")
            {can_play_pos = false;}
            
            else{can_play_pos = true;}
        //System.out.println("can put here "+ can_play_pos);
        return can_play_pos;
    }
    
    /// set the first player symbol X or O
    public void set_who_start(String symbol)
    {
        Turn = symbol;
    }
    
    // insert move to board array 
    public void set_toboard(String pos)
    {
       
      board[Integer.parseInt(pos)] = Turn; 
      String[] row_record = new String[2];
      row_record[0]= pos;
      row_record[1]= Turn;
      Records.add(row_record);
    }
    
    // empty the board to start new game 
    public void reset_board()
    {
        board = new String[9];
        play_numbers = 0;
        Records =  new ArrayList<String[]>();
    }
    
    // return the player turn X or O
    public String get_turn()
    {
        play_numbers++;
        String old_turn = Turn; 
        old_turn_symbol = Turn;
        if("x".equals(Turn))
            {
                Turn = "o";
            }
            else{
                Turn = "x";
            }
        return old_turn;
    }
    
    public String get_symbol()
    {
        if(Turn == "x")
        {
            old_turn_symbol = "O";
        }
        else
        {
            old_turn_symbol = "X";
        }
        return old_turn_symbol;
    }
    
    /// check if the game ended or not 
    public  String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("xxx")) {
                                game_end = true;
				return "x";
			} else if (line.equals("ooo")) {
                                game_end = true;
				return "o";
			}
                        
		}
                return null;

               }
}
